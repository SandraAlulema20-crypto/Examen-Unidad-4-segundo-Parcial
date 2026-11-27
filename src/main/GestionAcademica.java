import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GestionAcademica {

    private ArrayList<Estudiante> estudiantes;

    public GestionAcademica() {
        estudiantes = new ArrayList<>();
    }

    // Registrar estudiante
    public boolean registrarEstudiante(Estudiante estudiante) {

        if (buscarEstudiante(estudiante.getCodigo()) != null) {
            return false;
        }

        estudiantes.add(estudiante);
        return true;
    }

    // Buscar estudiante por codigo
    public Estudiante buscarEstudiante(String codigo) {

        for (Estudiante e : estudiantes) {

            if (e.getCodigo().equalsIgnoreCase(codigo)) {
                return e;
            }
        }

        return null;
    }

    // Listar estudiantes
    public void listarEstudiantes() {

        if (estudiantes.isEmpty()) {
            System.out.println("No existen estudiantes registrados.");
            return;
        }

        System.out.println("\n===== LISTADO DE ESTUDIANTES =====");

        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }

    // Obtener cantidad de estudiantes
    public int cantidadEstudiantes() {
        return estudiantes.size();
    }

    // Obtener lista para guardar archivos
    public ArrayList<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    // Cargar estudiantes recuperados del archivo
    public void cargarEstudiantes(ArrayList<Estudiante> lista) {

        for (Estudiante e : lista) {
            registrarEstudiante(e);
        }
    }

    // Reporte general
    public void generarReporte() {

        if (estudiantes.isEmpty()) {
            System.out.println("No hay datos para generar el reporte.");
            return;
        }

        int aprobados = 0;
        int reprobados = 0;

        double sumaPromedios = 0;

        Estudiante mayor = estudiantes.get(0);
        Estudiante menor = estudiantes.get(0);

        for (Estudiante e : estudiantes) {

            double promedio = e.calcularPromedio();

            sumaPromedios += promedio;

            if (e.obtenerEstado().equals("APROBADO")) {
                aprobados++;
            } else {
                reprobados++;
            }

            if (promedio > mayor.calcularPromedio()) {
                mayor = e;
            }

            if (promedio < menor.calcularPromedio()) {
                menor = e;
            }
        }

        double promedioGeneral =
                sumaPromedios / estudiantes.size();

        double porcentajeAprobados =
                (aprobados * 100.0) / estudiantes.size();

        System.out.println("\n========== REPORTE ACADEMICO ==========");

        System.out.println("Total de estudiantes: "
                + estudiantes.size());

        System.out.println("Estudiantes aprobados: "
                + aprobados);

        System.out.println("Estudiantes reprobados: "
                + reprobados);

        System.out.printf("Promedio general: %.2f%n",
                promedioGeneral);

        System.out.printf("Porcentaje de aprobados: %.2f%%%n",
                porcentajeAprobados);

        System.out.println("\n--- NOTA MAXIMA ---");
        System.out.println(mayor);

        System.out.println("\n--- NOTA MINIMA ---");
        System.out.println(menor);

        System.out.println("\n--- ESTUDIANTES BAJO EL PROMEDIO GENERAL ---");

        boolean encontrados = false;

        for (Estudiante e : estudiantes) {

            if (e.calcularPromedio() < promedioGeneral) {
                System.out.println(e);
                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No existen estudiantes bajo el promedio general.");
        }

        // Uso de arreglo para ordenar por promedio descendente
        Estudiante[] ordenados =
                estudiantes.toArray(new Estudiante[0]);

        Arrays.sort(ordenados,
                Comparator.comparingDouble(
                        Estudiante::calcularPromedio
                ).reversed());

        System.out.println("\n--- ORDEN DESCENDENTE POR PROMEDIO ---");

        for (Estudiante e : ordenados) {
            System.out.println(e);
        }

        System.out.println("=======================================");
    }
}
