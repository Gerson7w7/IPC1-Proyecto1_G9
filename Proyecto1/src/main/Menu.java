package main;

import java.util.ArrayList;
import java.util.Scanner;
import Objetos.*;
import static main.CargaMasiva.fechaHoraActuales;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    public boolean menu;
    public CargaMasiva cargaMasiva;

    public Menu() {
        cargaMasiva = new CargaMasiva();
    }
  
    public void menuUsuario() {
        try {
            menu = true;
            while (menu) {
                System.out.println(" ");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("|                                   USUARIOS                                               |");
                System.out.println("|  Ingrese la opcion deseada                                                               |");
                System.out.println("|    1.Listar usuarios                                    2.Eliminar usuarios              |");
                System.out.println("|    3.Ver usuario                                        4.Menú principal                 |");
                System.out.println("|                               Ingrese su opción                                          |");
                System.out.println("--------------------------------------------------------------------------------------------");
                int opUsuario = Integer.parseInt(scanner.nextLine());

                switch (opUsuario) {
                    case 1:
                        listar(CargaMasiva.users);
                        break;
                    case 2:
                        eliminarUs(CargaMasiva.users);
                        break;
                    case 3:
                        verUs(CargaMasiva.users);
                        break;
                    case 4:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
    }

    public void menuProducto() {
        try {
            menu = true;
            while (menu) {
                System.out.println(" ");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("|                                   PRODUCTOS                                              |");
                System.out.println("|  Ingrese la opcion deseada                                                               |");
                System.out.println("|    1.Listar producto                                    2.Eliminar producto              |");
                System.out.println("|    3.Ver producto                                       4.Menú principal                 |");
                System.out.println("|                               Ingrese su opción                                          |");
                System.out.println("--------------------------------------------------------------------------------------------");
                int opProducto = Integer.parseInt(scanner.nextLine());

                switch (opProducto) {
                    case 1:
                        listar(CargaMasiva.products);
                        break;
                    case 2:
                        eliminarP(CargaMasiva.products);
                        break;
                    case 3:
                        ver(CargaMasiva.products);
                        break;
                    case 4:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
    }

    public void menuCliente() {
        try {
            menu = true;
            while (menu) {
                System.out.println(" ");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("|                                   CLIENTE                                                |");
                System.out.println("|  Ingrese la opcion deseada                                                               |");
                System.out.println("|    1.Listar clientes                                    2.Eliminar cliente               |");
                System.out.println("|    3.Ver cliente                                        4.Menú principal                 |");
                System.out.println("|                               Ingrese su opción                                          |");
                System.out.println("--------------------------------------------------------------------------------------------");
                int opCliente = Integer.parseInt(scanner.nextLine());

                switch (opCliente) {
                    case 1:
                        listar(CargaMasiva.clients);
                        break;
                    case 2:
                        eliminarC(CargaMasiva.clients);
                        break;
                    case 3:
                        ver(CargaMasiva.clients);
                        break;
                    case 4:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
    }

    public void menuFactura() {
        try {
            menu = true;
            while (menu) {
                System.out.println(" ");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("|                                   FACTURA                                                |");
                System.out.println("|  Ingrese la opcion deseada                                                               |");
                System.out.println("|    1.Listar facturas                                    2.Eliminar factura               |");
                System.out.println("|    3.Ver factura                                        4.Menú principal                 |");
                System.out.println("|                               Ingrese su opción                                          |");
                System.out.println("--------------------------------------------------------------------------------------------");
                int opFactura = Integer.parseInt(scanner.nextLine());

                switch (opFactura) {
                    case 1:
                        listar(CargaMasiva.invoices);
                        break;
                    case 2:
                        eliminarF(CargaMasiva.invoices);
                        break;
                    case 3:
                        ver(CargaMasiva.invoices);
                        break;
                    case 4:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
    }

    public void mostrar(Restaurante restaurante) {
        System.out.println("\n" + restaurante);
    }

    public void listar(ArrayList listar) {
        int contador = 1;
        for (Object lista : listar) {
            System.out.println("no. " + (contador++) + ":");
            System.out.println(lista);
        }
    }

    public void eliminarP(ArrayList eliminar) {
        try {
            ArrayList<Producto> productos = eliminar;
            System.out.println("Ingrese el id del producto que quiere eliminar:");
            int delete = Integer.parseInt(scanner.nextLine());

            for (Producto producto : productos) {
                if (producto.getId() == delete) {
                    String log = fechaHoraActuales
                            + "\t\t" + CargaMasiva.users.get(Login.usuario).getUsername()
                            + ": Eliminó el producto \"" + producto.getName()
                            + "\" con id " + producto.getId() + ".\r\n";
                    Log.addToEndFile("log.log", log);
                    productos.remove(producto);
                    System.out.println("Se ha eliminado correctamente. :D");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.\r\n");
        }
    }

    public void eliminarC(ArrayList eliminar) {
        try {
            ArrayList<Cliente> clientes = eliminar;
            System.out.println("Ingrese el id del cliente que quiere eliminar:");
            int delete = Integer.parseInt(scanner.nextLine());

            for (Cliente cliente : clientes) {
                if (cliente.getId() == delete) {
                    String log = fechaHoraActuales
                            + "\t\t" + CargaMasiva.users.get(Login.usuario).getUsername()
                            + ": Eliminó el cliente \"" + cliente.getName()
                            + "\" con id " + cliente.getId() + ".\r\n";
                    Log.addToEndFile("log.log", log);
                    clientes.remove(cliente);
                    System.out.println("Se ha eliminado correctamente. :D");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.\r\n");
        }
    }

    public void eliminarF(ArrayList eliminar) {
        try {
            ArrayList<Factura> facturas = eliminar;
            System.out.println("Ingrese el id del cliente que quiere eliminar:");
            int delete = Integer.parseInt(scanner.nextLine());

            for (Factura factura : facturas) {
                if (factura.getId() == delete) {
                    String log = fechaHoraActuales
                            + "\t\t" + CargaMasiva.users.get(Login.usuario).getUsername()
                            + ": Eliminó la factura del  \"cliente "
                            + factura.getClient() + "\" con id " + factura.getId()
                            + ".\r\n";
                    Log.addToEndFile("log.log", log);
                    facturas.remove(factura);
                    System.out.println("Se ha eliminado correctamente. :D");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.\r\n");
        }
    }

    public void ver(ArrayList ver) {
        try {
            ArrayList<Objeto> listar = ver;
            System.out.println("Ingrese el id que quiere ver:");
            int see = Integer.parseInt(scanner.nextLine());

            for (Objeto lista : listar) {
                if (lista.getId() == see) {
                    System.out.println(lista);
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número. \r\n");
        }
    }

    public void eliminarUs(ArrayList eliminar) {
        ArrayList<Usuario> users = eliminar;
        System.out.println("Ingrese el nombre del user que quiere eliminar: ");
        String delete = scanner.nextLine();

        for (Usuario user : users) {
            if (user.getUsername().equals(delete)) {
                String log = fechaHoraActuales
                        + "\t\t" + CargaMasiva.users.get(Login.usuario).getUsername()
                        + ": Eliminó al usuario " + user.getUsername() + ".\r\n";
                Log.addToEndFile("log.log", log);
                users.remove(user);
                System.out.println("Se ha eliminado el usuario correctamente. :D");
                break;
            }
        }
    }

    public void verUs(ArrayList ver) {
        ArrayList<Usuario> users = ver;
        System.out.println("Ingrese el nombre del user que quiere ver: ");
        String see = scanner.nextLine();

        for (Usuario user : users) {
            if (user.getUsername().equals(see)) {
                System.out.println(user);
                break;
            }
        }
    }

    public void menuGuardarCambios() {
        try {
            menu = true;
            while (menu) {
                System.out.println(" ");
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("|                                   GUARDAR CAMBIOS                                        |");
                System.out.println("|  Ingrese la opcion deseada                                                               |");
                System.out.println("|    1.Guardar cambios en Json                            2.Guardar cambios en Bin         |");
                System.out.println("|    3.Menú principal                                                                      |");
                System.out.println("|                               Ingrese su opción                                          |");
                System.out.println("--------------------------------------------------------------------------------------------");
                int opGuardar = Integer.parseInt(scanner.nextLine());

                switch (opGuardar) {
                    case 1:
                        cargaMasiva.guardarDatosJson();
                        break;
                    case 2:
                        cargaMasiva.guardarDatosBin();
                        break;
                    case 3:
                        menu = false;
                        break;
                    default:
                        System.out.println("Opción fuera de rango.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
    }

}
