package org.example;

import jakarta.persistence.*;
import org.example.controllers.ClienteController;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ClienteController controlador = new ClienteController();

        int bandera = 1;
        int banderaOption;
        int opcion=0;

        while (bandera == 1) {
            banderaOption=1;

            while (banderaOption==1){
                try {
                    System.out.println("1. Crear cliente");
                    System.out.println("2. Listar Clientes");
                    System.out.println("3. Actualizar cliente");
                    System.out.println("4. Eliminar cliente");
                    System.out.println("5. Buscar cliente por ciudad");
                    System.out.println("6. Salir");
                    System.out.print("Opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    banderaOption=2;
                }
                catch (InputMismatchException e)
                {
                    System.out.println("\u001B[31m¡Sólo números, por favor!\u001B[0m");
                    scanner.nextLine();
                }
            }




            switch (opcion) {
                case 1: // Crear

                    controlador.agregarCliente();

                    break;
                case 2: // Leer
                    controlador.listarTodosClientes();
                    break;
                case 3: // Actualizar
                    controlador.actualizarCliente();

                    //METODO DE ACTUALIZAR CON LOS SETS
/*                  System.out.println("ID del cliente a actualizar");
                    long id = scanner.nextInt();
                    controlador.actualizarCliente(id);*/
                    break;
                case 4: // Eliminar
                    controlador.eliminar();
                    break;
                case 5: // Buscar cliente por ciudad:
                    controlador.buscarCiudad();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    bandera = 2;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }


    }


}