let inputJson = document.getElementById("inputJson")
const divUsuarios = document.getElementById("usuarios")
const divProductos = document.getElementById("productos")
const divFacturas = document.getElementById("facturas")
const divClientes = document.getElementById("clientes")
const divRestaurante = document.getElementById("restaurante")
const divTOP5 = document.getElementById("top5")
let tipo = ""

function jsonSelec() {
    for (let i = 0; i < inputJson.files.length; i++) {
        const fileReader = new FileReader()

        function myOnLoad() {
            const json = JSON.parse(fileReader.result)
            guardar(json)
        }

        tipo = inputJson.files[i].name
        fileReader.readAsText(inputJson.files[i])
        fileReader.onload = myOnLoad
    }
}

if (inputJson != null)
    inputJson.addEventListener('change', jsonSelec)

function guardar(json) {
    if (tipo == "users.json") {
        localStorage.setItem("users", JSON.stringify(json))
    } else if (tipo == "clients.json") {
        localStorage.setItem("clients", JSON.stringify(json))
    } else if (tipo == "invoices.json") {
        localStorage.setItem("invoices", JSON.stringify(json))
    } else if (tipo == "products.json") {
        localStorage.setItem("products", JSON.stringify(json))
    } else if (tipo == "config.json") {
        localStorage.setItem("config", JSON.stringify(json))
    }
}

crearTarjetas();
restaurante();

function restaurante() {
    let restaurant = JSON.parse(localStorage.getItem("config"))
    let htmlR = `
            <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="10000">
                <img src="img/nameRest.jpg" class="d-block w-100" height="400px" alt="...">
                <div class="carousel-caption d-none d-md-block">
                <h3>Nombre del Restaurante: </h3>
                <h4>${restaurant.name}</h4>
                </div>
            </div>
            <div class="carousel-item" data-bs-interval="2000">
                <img src="img/addressRest.jpg" class="d-block w-100" height="400px" alt="...">
                <div class="carousel-caption d-none d-md-block">
                <h3>Dirección del restaurante: </h3>
                <h4>${restaurant.address}</h4>
                </div>
            </div>
            <div class="carousel-item">
                <img src="img/phoneRest.jpg" class="d-block w-100" height="400px" alt="...">
                <div class="carousel-caption d-none d-md-block">
                <h3>Teléfono del restaurante: </h3>
                <h4>${restaurant.phone}</h4>
                </div>
            </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
            </button>
        </div>
    `
    divRestaurante.innerHTML = htmlR
}

function crearTarjetas() {
    let users = JSON.parse(localStorage.getItem("users"))
    let htmlU = ""
    for (const user of users) {
        htmlU += crearTarjetaU(user)
    }
    if (divUsuarios != null) {
        divUsuarios.innerHTML = htmlU
    }

    let clients = JSON.parse(localStorage.getItem("clients"))
    let htmlC = ""
    for (const client of clients) {
        htmlC += crearTarjetaC(client)
    }
    if (divClientes != null) {
        divClientes.innerHTML = htmlC
    }

    let invoices = JSON.parse(localStorage.getItem("invoices"))
    let htmlI = ""
    for (const invoice of invoices) {
        htmlI += crearTarjetaI(invoice)
    }
    if (divFacturas != null) {
        divFacturas.innerHTML = htmlI
    }

    let products = JSON.parse(localStorage.getItem("products"))
    let htmlP = ""
    for (const product of products) {
        htmlP += crearTarjetaP(product)
    }
    if (divProductos != null) {
        divProductos.innerHTML = htmlP
    }

}

function crearTarjetaU(user) {
    let html = `
        <div class="card mt-5" style="width: 18rem;">
            <img src="img/userF1.png" class="card-img-top" height="250px" alt="...">
            <div class="card-body">
            <h5 class="card-title">Usuario: ${user.username}</h5>
            <p class="card-text">Contraseña: ${user.password}</p>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#verU" data-bs-whatever="@mdo">Ver</button>
            </div>
        </div>
        <!-- MODAL -->
        <div class="modal fade" id="verU" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                
            <div class="card mt-5" style="width: 18rem;">
            <img src="img/userF1.png" class="card-img-top" height="250px" alt="...">
            <div class="card-body">
            <h5 class="card-title">Usuario: ${user.username}</h5>
            <p class="card-text">Contraseña: ${user.password}</p>
            </div>
            </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
            </div>
        </div>
        </div>
        `
    return html
}

function crearTarjetaC(client) {
    let html = `
        <div class="card mt-5" style="width: 18rem;">
            <img src="img/clientF.png" class="card-img-top" alt="...">
            <div class="card-body">
            <h5 class="card-title">Nombre: ${client.name}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item">Id: ${client.id}</li>
            <li class="list-group-item">Dirección: ${client.address}</li>
            <li class="list-group-item">Teléfono: ${client.phone}</li>
            <li class="list-group-item">NIT: ${client.nit}</li>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#verC" data-bs-whatever="@mdo">Ver</button>
            </ul>
        </div>
        <!-- MODAL -->
        <div class="modal fade" id="verC" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                
            <div class="card mt-5" style="width: 18rem;">
            <img src="img/clientF.png" class="card-img-top" alt="...">
            <div class="card-body">
            <h5 class="card-title">Nombre: ${client.name}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item">Id: ${client.id}</li>
            <li class="list-group-item">Dirección: ${client.address}</li>
            <li class="list-group-item">Teléfono: ${client.phone}</li>
            <li class="list-group-item">NIT: ${client.nit}</li>
            </ul>
            </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
            </div>
        </div>
        </div>
        `
    return html
}

function crearTarjetaI(invoice) {
    let products = crearProductos(invoice.products)
    let productsT = crearProductosT(invoice.products)
    let total = totalF(invoice.products)
    let restaurant = JSON.parse(localStorage.getItem("config"))
    let cliente = crearClientes(invoice.client)

    let html = `      
        <div class="card mt-5" style="width: 18rem;">
            <img src="img/facturaF.jpg" class="card-img-top" height="250px" alt="...">
            <div class="card-body">
            <h5 class="card-title">Id: ${invoice.id}, Cliente: ${invoice.client}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item">Fecha: ${invoice.date}</li>
            <li class="list-group-item">Productos:</li>
            ${products}
            ${total}
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#verF" data-bs-whatever="@mdo">Ver</button>
            </ul>
        </div>
        
        <!-- MODAL -->
        <div class="modal fade" id="verF" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                
            <div class="container">
            <div class="row row-cols-2">
                <div class="col">
                <h1> ${restaurant.name}</h1>
                <h5> ${restaurant.address}</h5>
                <h5> ${restaurant.phone}</h5>
                </div>
                <div class="col">
                <h2> FACTURA</h2>
                <h5> no. ${invoice.id}</h5>
                <h5> fecha: ${invoice.date}</h5>
                </div>
                <div class="col">
                ${cliente}
                </div>
                <table class="table">
                <thead>
                    <tr>
                    <th scope="col">Producto</th>
                    <th scope="col">Precio</th>
                    </tr>
                </thead>
                <tbody>
                ${productsT} 
                <tr>
                <th scope="row"></th>
                <td>${total}</td> 
                </tr>            
                </tbody>
                </table>
                
            </div>
            </div>                      
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
            </div>
        </div>
        </div>
        `
    return html
}

function crearClientes(idClient) {
    let clientes = JSON.parse(localStorage.getItem("clients"))
    let html = ""
    for (const cliente of clientes) {
        if (idClient == cliente.id) {
            html = `
                <h4> Facturar a: </h4>
                <p>Nombre: ${cliente.name} </p>
                <p>Dirección: ${cliente.address} </p>
                <p>Teléfono: ${cliente.phone} </p>
                <p>NIT: ${cliente.nit} </p>
                `
            break;
        }
    }
    return html
}

function totalF(products) {
    let total = 0.0;
    for (const product of products) {
        total += product.price
    }
    return `<li class="list-group-item">Total: ${total}</li>`
}

function crearProductosT(products) {
    let html = ""
    for (const product of products) {
        html += `
        <tr>
        <th scope="row">${product.name}</th>
        <td>${product.price}</td>
        </tr>
                `
    }
    return html
}

function crearProductos(products) {
    let html = ""
    for (const product of products) {
        html += crearProducto(product)
    }
    return html
}

function crearProducto(product) {
    return `<li class="list-group-item">Nombre: ${product.name}, Precio: ${product.price}</li>`
}

function crearTarjetaP(product) {
    let ingredients = crearIngredientes(product.ingredients)

    let html = `
        <div class="card mt-5" style="width: 18rem;">
            <img src="img/comidaF.jpg" class="card-img-top" height="250px" alt="...">
            <div class="card-body">
            <h5 class="card-title">Nombre: ${product.name}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item">Id: ${product.id}</li>
            <li class="list-group-item">Descripción: ${product.description}</li>
            <li class="list-group-item">Costo: ${product.cost}, Precio: ${product.price}</li>
            <li class="list-group-item">Ingredientes:</li>
            ${ingredients}
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#verP" data-bs-whatever="@mdo">Ver</button>
            </ul>
        </div>
        <!-- MODAL -->
        <div class="modal fade" id="verP" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                
            <div class="card mt-5" style="width: 18rem;">
            <img src="img/comidaF.jpg" class="card-img-top" height="250px" alt="...">
            <div class="card-body">
            <h5 class="card-title">Nombre: ${product.name}</h5>
            </div>
            <ul class="list-group list-group-flush">
            <li class="list-group-item">Id: ${product.id}</li>
            <li class="list-group-item">Descripción: ${product.description}</li>
            <li class="list-group-item">Costo: ${product.cost}, Precio: ${product.price}</li>
            <li class="list-group-item">Ingredientes:</li>
            ${ingredients}
            </ul>
            </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
            </div>
            </div>
        </div>
        </div>
        `
    return html
}

function crearIngredientes(ingredients) {
    let html = ""
    for (const ingredient of ingredients) {
        html += crearIngrediente(ingredient)
    }
    return html
}

function crearIngrediente(ingredient) {
    return `<li class="list-group-item">Nombre: ${ingredient.name}, Cantidad: ${ingredient.quantity}, Unidades: ${ingredient.units}</li>`
}