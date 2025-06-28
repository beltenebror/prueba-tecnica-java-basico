package org.example.controllers;

import com.mysql.cj.xdevapi.Client;
import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class ClienteController {
    ClienteJPA clienteJPA = new ClienteJPA();
    Scanner scanner = new Scanner(System.in);
    String nombre;
    String apellidos;
    String sexo = "";
    String ciudad;
    int dia;
    int mes;
    int año;
    String telefono;
    String correoElectronico;
    long id;

    public void agregarCliente() {
        Cliente cliente = recogerDatos();
        if (cliente != null) {
            clienteJPA.crear(cliente);
        }

    }

    public void listarTodosClientes() {

        List<Cliente> clientes = clienteJPA.listarClientes();

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }


    }

    public void actualizarCliente() {
        System.out.println("ID del cliente a actualizar");
        try{

            id = scanner.nextInt();
            scanner.nextLine();
            if (clienteJPA.comprobarId(id)) {
                Cliente cliente = recogerDatos();

                if (cliente != null) {
                    cliente.setId(id);
                    clienteJPA.actualizar(cliente);
                }
            } else {
                System.out.println("\u001B[31mEl id de cliente no existe\u001B[0m");
            }
        }
        catch (Exception e){
            System.out.println("\u001B[31mEl id debe ser un número\u001B[0m");
            scanner.nextLine();

        }

    }

    //METODO DE ACTUALIZAR CON LOS SETS
     /*public void actualizarCliente(long id) {



       System.out.println("Dime el nombre");
        nombre = scanner.nextLine();
        if (Objects.equals(nombre, "") || nombre == null) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        System.out.println("Dime los apellidos");
        apellidos = scanner.nextLine();
        if (Objects.equals(apellidos, "") || nombre == null) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        int bandera2 = 1;
        while (bandera2 == 1) {
            System.out.println("Elige el sexo:");
            System.out.println("H: Hombre");
            System.out.println("M: Mujer");
            System.out.println("O: Otro");

            String opcionSexo = scanner.nextLine();
            switch (opcionSexo) {
                case "H":
                    sexo = "Hombre";
                    bandera2 = 0;
                    break;
                case "M":
                    sexo = "Mujer";
                    bandera2 = 0;
                    break;
                case "O":
                    sexo = "Otro";
                    bandera2 = 0;
                    break;
                case "h":
                    sexo = "Hombre";
                    bandera2 = 0;
                    break;
                case "m":
                    sexo = "Mujer";
                    bandera2 = 0;
                    break;
                case "o":
                    sexo = "Otro";
                    bandera2 = 0;
                    break;
                default:
                    System.out.println("\u001B[33mElija una opción correcta:\u001B[0m");
                    break;

            }
        }

        System.out.println("Dime la ciudad");
        ciudad = scanner.nextLine();
        if (Objects.equals(ciudad, "") || nombre == null) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        System.out.println("Vamos a por la fecha de nacimiento:");
        System.out.println("Dia");
        dia = scanner.nextInt();
        if (dia > 31 || dia < 1) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        System.out.println("Mes del 1 al 12");
        mes = scanner.nextInt();
        if (mes > 12 || mes < 1) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }
        System.out.println("Año");
        año = scanner.nextInt();
        if (año < 1930 || año > 2025) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
        scanner.nextLine();
        System.out.println("Introduce tu telefono");
        telefono = scanner.nextLine();
        if (Objects.equals(telefono, "") || telefono == null) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }

        System.out.println("Introduce tu correo");
        correoElectronico = scanner.nextLine();
        if (Objects.equals(correoElectronico, "") || correoElectronico == null) {
            System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
            return;
        }
        clienteJPA.actualizar(id, nombre, apellidos, sexo, ciudad, fechaNacimiento, telefono, correoElectronico);


    }*/

    public void eliminar() {
        System.out.print("ID a eliminar: ");
        try{
            long idEliminar = scanner.nextInt();
            scanner.nextLine();
            if (clienteJPA.comprobarId(idEliminar)) {
                clienteJPA.eliminar(idEliminar);
            } else {
                System.out.println("\u001B[31mEl id de cliente no existe\u001B[0m");
            }

        }
        catch (Exception e){
            System.out.println("\u001B[31mEl id debe ser un número\u001B[0m");
            scanner.nextLine();

        }



    }

    public void buscarCiudad() {
        System.out.println("Dime la ciudad a la que buscar");
        ciudad = scanner.nextLine();
        List<Cliente> clientes = clienteJPA.listarClientes();

        for (int i = 0; i < clientes.size(); i++) {
            if (!(clientes.get(i).getCiudad().equalsIgnoreCase(ciudad)) && !(clientes.get(i).getCiudad().toLowerCase().contains(ciudad.toLowerCase()))) {
                clientes.remove(i);
                i--;
            }
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }


    }

    private Cliente recogerDatos() {

        try {
            System.out.println("Dime el nombre");
            nombre = scanner.nextLine();
            if (Objects.equals(nombre, "") || nombre == null) {
                System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
                return null;
            }

            System.out.println("Dime los apellidos");
            apellidos = scanner.nextLine();
            if (Objects.equals(apellidos, "") || apellidos == null) {
                System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
                return null;
            }

            int bandera2 = 1;
            while (bandera2 == 1) {
                System.out.println("Elige el sexo:");
                System.out.println("H: Hombre");
                System.out.println("M: Mujer");
                System.out.println("O: Otro");

                String opcionSexo = scanner.nextLine();
                switch (opcionSexo) {
                    case "H":
                        sexo = "Hombre";
                        bandera2 = 2;
                        break;
                    case "M":
                        sexo = "Mujer";
                        bandera2 = 2;
                        break;
                    case "O":
                        sexo = "Otro";
                        bandera2 = 2;
                        break;
                    case "h":
                        sexo = "Hombre";
                        bandera2 = 2;
                        break;
                    case "m":
                        sexo = "Mujer";
                        bandera2 = 2;
                        break;
                    case "o":
                        sexo = "Otro";
                        bandera2 = 2;
                        break;
                    default:
                        System.out.println("\u001B[33mElija una opción correcta:\u001B[0m");
                        break;

                }
            }

            System.out.println("Dime la ciudad");
            ciudad = scanner.nextLine();
            if (Objects.equals(ciudad, "") || ciudad == null) {
                System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
                return null;
            }


            System.out.println("Vamos a por la fecha de nacimiento:");

            while (bandera2 == 2) {

                System.out.println("Dia");
                dia = scanner.nextInt();
                if (dia > 31 || dia < 1) {
                    System.out.println("\u001B[33mDía incorrecto vuelva a intentarlo\u001B[0m");
                } else {
                    bandera2 = 3;
                }

            }

            while (bandera2 == 3) {

                System.out.println("Mes del 1 al 12");
                mes = scanner.nextInt();
                if (mes > 12 || mes < 1) {
                    System.out.println("\u001B[33mMes incorrecto vuelva a intentarlo\u001B[0m");
                } else {
                    bandera2 = 4;
                }

            }


            while (bandera2 == 4) {

                System.out.println("Año");
                año = scanner.nextInt();
                if (año < 1930 || año > 2025) {
                    System.out.println("\u001B[33mAño erroneo vuelva a intentarlo\u001B[0m");
                } else {
                    bandera2 = 5;
                }

            }


            LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
            scanner.nextLine();
            System.out.println("Introduce tu telefono");
            telefono = scanner.nextLine();
            if (Objects.equals(telefono, "") || telefono == null) {
                System.out.println("Datos introducidos incorrectos");
                return null;
            }

            System.out.println("Introduce tu correo");
            correoElectronico = scanner.nextLine();
            if (Objects.equals(correoElectronico, "") || correoElectronico == null) {
                System.out.println("\u001B[31mDatos introducidos incorrectos\u001B[0m");
                return null;
            }

            return new Cliente(nombre, apellidos, sexo, ciudad, fechaNacimiento, telefono, correoElectronico);

        } catch (Exception e) {
            System.out.println("\u001B[31mError al recoger los datos del cliente\u001B[0m");
            return null;
        }


    }


}

