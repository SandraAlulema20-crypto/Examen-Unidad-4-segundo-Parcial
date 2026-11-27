
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner teclado = new Scanner(System.in);

    private static GestionAcademica gestion =
            new GestionAcademica();

    private static GestorArchivos archivos =
            new GestorArchivos();

    public static void main(String[] args) {

        // Recuperar los estudiantes guardados
        ArrayList<Estudiante> recuperados =
                archivos.cargarEstudiantes();

        gestion.cargarEstudiantes(recuperados);

        System.out.println("======================================");
        System.out.println("          SISTEMA AULALOGIC");
        System.out.println("     UNIVERSIDAD TECNICA DE AMBATO");
        System.out.println("======================================");

        System.out.println("Estudiantes recuperados: "
                + gestion.cantidadEstudiantes());

        int opcion;

        do {
            mostrarMenu();

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {

                case 1:
                    registrar();
                    break;

                case 2:
                    gestion.listarEstudiantes();
                    break;

                case 3:
                    buscar();
                    break;

                case 4:
                    gestion.generarReporte();
                    break;

                case 5:
                    archivos.guardarEstudiantes(
                            gestion.getEstudiantes());
                    break;

                case 6:
                    archivos.guardarEstudiantes(
                            gestion.getEstudiantes());

                    System.out.println(
                            "Gracias por utilizar AulaLogic.");

                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println(
                            "Opcion incorrecta. Intente nuevamente.");
            }

        } while (opcion != 6);

        teclado.close();
    }

    // Mostrar menu principal
    public static void mostrarMenu() {

        System.out.println("\n========== MENU PRINCIPAL ==========");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante por codigo");
        System.out.println("4. Generar reporte academico");
        System.out.println("5. Guardar datos");
        System.out.println("6. Salir");
        System.out.println("====================================");
    }

    // Registrar estudiante
    public static void registrar() {

        System.out.println("\n===== REGISTRO DE ESTUDIANTE =====");

        String codigo = leerTexto("Ingrese el codigo: ");
        String nombre = leerTexto("Ingrese el nombre: ");

        if (gestion.buscarEstudiante(codigo) != null) {
            System.out.println(
                    "Error: el codigo ya esta registrado.");
            return;
        }

        int nota1 = leerNota("Ingrese la primera nota: ");
        int nota2 = leerNota("Ingrese la segunda nota: ");
        int nota3 = leerNota("Ingrese la tercera nota: ");

        Estudiante nuevo = new Estudiante(
                codigo, nombre, nota1, nota2, nota3);

        if (gestion.registrarEstudiante(nuevo)) {

            System.out.println(
                    "Estudiante registrado correctamente.");

            System.out.printf("Promedio: %.2f%n",
                    nuevo.calcularPromedio());

            System.out.println("Estado: "
                    + nuevo.obtenerEstado());

        } else {

            System.out.println(
                    "No se pudo registrar el estudiante.");
        }
    }

    // Buscar estudiante por codigo
    public static void buscar() {

        System.out.println("\n===== BUSCAR ESTUDIANTE =====");

        String codigo = leerTexto("Ingrese el codigo: ");

        Estudiante encontrado =
                gestion.buscarEstudiante(codigo);

        if (encontrado != null) {

            System.out.println("Estudiante encontrado:");
            System.out.println(encontrado);

        } else {

            System.out.println(
                    "No existe un estudiante con ese codigo.");
        }
    }

    // Leer texto y validar
    public static String leerTexto(String mensaje) {

        String texto;

        do {

            System.out.print(mensaje);
            texto = teclado.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println(
                        "El campo no puede estar vacio.");
            }

        } while (texto.isEmpty());

        return texto;
    }

    // Leer numeros enteros
    public static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        teclado.nextLine().trim());

            } catch (NumberFormatException ex) {

                System.out.println(
                        "Ingrese un numero entero valido.");
            }
        }
    }

    // Validar notas entre 0 y 20
    public static int leerNota(String mensaje) {

        int nota;

        do {

            nota = leerEntero(mensaje);

            if (nota < 0 || nota > 20) {

                System.out.println(
                        "Error: la nota debe estar entre 0 y 20.");
            }

        } while (nota < 0 || nota > 20);

        return nota;
    }
}
