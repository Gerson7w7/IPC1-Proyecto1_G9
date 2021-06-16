package main;

import java.util.ArrayList;
import java.util.Scanner;
import Objetos.*;

public class Menu {

    public static Scanner scanner = new Scanner(System.in);
    public boolean menu;
    public CargaMasiva cargaMasiva;

    public Menu() {
        cargaMasiva = new CargaMasiva();
    }

    private void mHeader() {
        System.out.println(" ");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("|                                   BIENVENIDOS                                            |");
        System.out.println("|  Ingrese la opcion deseada                                                               |");
        System.out.println("|    1.Información del restaurante                        2.Usuarios                       |");
        System.out.println("|    3.Productos                                          4.Clientes                       |");
        System.out.println("|    5.Facturas                                           6.Guardar cambios                |");
        System.out.println("|    7.Cerrar programa                                                                     |");
        System.out.println("|                               Ingrese su opción                                          |");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public void menu() {
        while (true) {
            mHeader();
            opciones();
        }
    }

    public void opciones() {
        try {
            System.out.println("¿Qué desea realizar?");
            int op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 1:
                    mostrar(CargaMasiva.restaurant);
                    break;
                case 2:
                    menuUsuario();
                    break;
                case 3:
                    menuProducto();
                    break;
                case 4:
                    menuCliente();
                    break;
                case 5:
                    menuFactura();
                    break;
                case 6:
                    menuGuardarCambios();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.");
        }
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
                        eliminar(CargaMasiva.products);
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
                        eliminar(CargaMasiva.clients);
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
                        eliminar(CargaMasiva.invoices);
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

    public void eliminar(ArrayList eliminar) {
        try {
            ArrayList<Objeto> listar = eliminar;
            System.out.println("Ingrese el id que quiere eliminar:");
            int delete = Integer.parseInt(scanner.nextLine());

            for (Objeto lista : listar) {
                if (lista.getId() == delete) {
                    listar.remove(lista);
                    System.out.println("Se ha eliminado correctamente. :D");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número.\r\n");
        }
    }

    public void ver(ArrayList ver) {
        try{
        ArrayList<Objeto> listar = ver;
        System.out.println("Ingrese el id que quiere ver:");
        int see = Integer.parseInt(scanner.nextLine());

        for (Objeto lista : listar) {
            if (lista.getId() == see) {
                System.out.println(lista);
                break;
            }
        }
        }catch(NumberFormatException e){
            System.out.println("Ingrese un número. \r\n");
        }
    }

    public void eliminarUs(ArrayList eliminar) {
        ArrayList<Usuario> users = eliminar;
        System.out.println("Ingrese el nombre del user que quiere eliminar: ");
        String delete = scanner.nextLine();

        for (Usuario user : users) {
            if (user.getUsername().equals(delete)) {
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
