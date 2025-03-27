package UI;

import Models.Agenda;
import Models.Contacto;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void iniciarMenu() {
        int opc;
        boolean loop = true;
        Scanner scn = new Scanner(System.in);
        String nombreCompleto;
        Agenda agenda = new Agenda();

        do {
            textMenu();
            opc = scn.nextInt();
            switch (opc) {
                case 1:
                    Contacto c = ingresarContacto();

                    if (Agenda.agregarContacto(c)) {
                        System.out.println("Contacto agregado!");
                    } else {
                        System.out.println("No se pudo agregar el contacto.");
                    }
                    menuPausa();
                    clearConsole();
                    break;

                case 2:
                    nombreCompleto = ingresarNombreCompleto();

                    if (Agenda.eliminarContacto(nombreCompleto)) {
                        System.out.println("Contacto eliminado!");
                    } else {
                        System.out.println("El contacto no existe.");
                    }
                    menuPausa();
                    clearConsole();
                    break;

                case 3:
                    nombreCompleto = ingresarNombreCompleto();

                    if(Agenda.buscarPorNombre(nombreCompleto) != null){
                        System.out.println(Agenda.buscarPorNombre(nombreCompleto).toString());;
                    }
                    else {
                        System.out.println("El contacto no existe.");
                    }
                    System.out.println("Pulse una tecla para continuar...");
                    try {
                        System.in.read();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    clearConsole();
                    break;

                case 4:
                    if(!Agenda.listarContactos()){
                        System.out.println("La agenda está vacía.");
                    }

                    menuPausa();
                    clearConsole();
                    break;

                    case 5:
                    modificarNum();
                    try{
                        System.in.read();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    menuPausa();
                       clearConsole();

                    break;

                case 0:
                    loop = false;
                    clearConsole();
                    System.out.println("Saliendo...");
                    menuPausa();
                    break;

                default:
                    System.out.println("Elija una opción válida.");
                    menuPausa();
                    clearConsole();
                    break;

            }
        } while (loop);
    }

    private static void textMenu() {
        System.out.println("\n---------MENÚ AGENDA---------");
        System.out.println("\n1- Agregar Contacto");
        System.out.println("2- Eliminar Contacto");
        System.out.println("3- Buscar Contacto");
        System.out.println("4- Listar Contactos");
        System.out.println("5- Modificar numero de Contacto");
        System.out.println("\n0- Salir");
        System.out.println("-----------------------------\n");
        System.out.println("\nIngrese una opción: ");
    }

    private static void clearConsole() {
        for (int i = 0; i < 15; i++) {
            System.out.println("");
        }
    }

    private static Contacto ingresarContacto(){
        Scanner scn = new Scanner(System.in);

        System.out.println("Ingrese nombre: ");
        String nombre = scn.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = scn.nextLine();
        System.out.println("Ingrese numero: ");
        String nroTelefono = scn.nextLine();

        Contacto c = new Contacto(nombre, apellido, nroTelefono);

        return c;
    }

    private static String ingresarNombreCompleto(){
        Scanner scn = new Scanner(System.in);

        System.out.println("Ingrese nombre: ");
        String nombre = scn.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = scn.nextLine();

        return nombre+apellido;
    }

    private static void menuPausa(){
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void  modificarNum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingresa el nombre del contacto a modificar");
        String nombreContacto = ingresarNombreCompleto();
         Contacto contacto = Agenda.buscarPorNombre(nombreContacto);

         if(contacto !=null){
            System.out.println(Agenda.buscarPorNombre(nombreContacto).toString());
            System.out.println("ingrese el nuevo numero de telefono del contacto: ");
            String nuevoNumero = scanner.nextLine();
            if (Agenda.modificarNumero(nombreContacto, nuevoNumero)){
                System.out.println("numero de telefono modificado con exito");
            }else{
                System.out.println("el numero de telefono no se pudo modificar.");
            }
         }else{
            System.out.println("el contacto no existe.");
         }
         System.out.println("Pulse una tecla para continuar...");

    }
}
