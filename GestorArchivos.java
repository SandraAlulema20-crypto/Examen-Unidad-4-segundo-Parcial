
import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    private final String ruta = "datos/estudiantes.txt";

    // Guardar estudiantes en archivo
    public void guardarEstudiantes(ArrayList<Estudiante> estudiantes) {

        File carpeta = new File("datos");

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ruta))) {

            for (Estudiante e : estudiantes) {

                String linea = e.getCodigo() + ";"
                        + e.getNombre() + ";"
                        + e.getNota1() + ";"
                        + e.getNota2() + ";"
                        + e.getNota3();

                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Datos guardados correctamente.");

        } catch (IOException ex) {

            System.out.println("Error al guardar: "
                    + ex.getMessage());
        }
    }

    // Recuperar estudiantes del archivo
    public ArrayList<Estudiante> cargarEstudiantes() {

        ArrayList<Estudiante> lista = new ArrayList<>();

        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("Archivo no encontrado. Se creara al guardar.");
            return lista;
        }

        try (BufferedReader br = new BufferedReader(
                new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                try {

                    String[] datos = linea.split(";", -1);

                    if (datos.length != 5) {
                        System.out.println("Registro incorrecto: " + linea);
                        continue;
                    }

                    String codigo = datos[0].trim();
                    String nombre = datos[1].trim();

                    int nota1 = Integer.parseInt(datos[2].trim());
                    int nota2 = Integer.parseInt(datos[3].trim());
                    int nota3 = Integer.parseInt(datos[4].trim());

                    if (codigo.isEmpty() || nombre.isEmpty()
                            || codigo.contains(";")
                            || nombre.contains(";")
                            || nota1 < 0 || nota1 > 20
                            || nota2 < 0 || nota2 > 20
                            || nota3 < 0 || nota3 > 20) {

                        System.out.println("Datos invalidos: " + linea);
                        continue;
                    }

                    boolean duplicado = false;

                    for (Estudiante e : lista) {
                        if (e.getCodigo().equalsIgnoreCase(codigo)) {
                            duplicado = true;
                            break;
                        }
                    }

                    if (!duplicado) {
                        lista.add(new Estudiante(
                                codigo, nombre,
                                nota1, nota2, nota3));
                    } else {
                        System.out.println("Codigo duplicado: " + codigo);
                    }

                } catch (NumberFormatException ex) {

                    System.out.println("Error en las notas: " + linea);
                }
            }

        } catch (IOException ex) {

            System.out.println("Error al leer archivo: "
                    + ex.getMessage());
        }

        return lista;
    }
}
