public class Estudiante {

    private String codigo;
    private String nombre;
    private int nota1;
    private int nota2;
    private int nota3;

    public Estudiante(String codigo, String nombre,
                      int nota1, int nota2, int nota3) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota1() {
        return nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public double calcularPromedio() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public String obtenerEstado() {
        if (calcularPromedio() >= 11) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + " | Nombre: " + nombre
                + " | Nota 1: " + nota1
                + " | Nota 2: " + nota2
                + " | Nota 3: " + nota3
                + " | Promedio: "
                + String.format("%.2f", calcularPromedio())
                + " | Estado: " + obtenerEstado();
    }
}
