package Empleados.Empleados;

public class Empleados {

    private static int contadorEmpleados = 0;
    private String primerNombre;
    private String apellido;
    private double salarioMensual;

    public static int getContadorEmpleados() {
        return contadorEmpleados;
    }

    public static void setContadorEmpleados(int contadorEmpleados) {
        Empleados.contadorEmpleados = contadorEmpleados;
    }

    public Empleados(String primerNombre, String apellido, double salarioMensual) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        if (salarioMensual > 0.0) {
            this.salarioMensual = salarioMensual;
        }
        contadorEmpleados++;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0.0) {
            this.salarioMensual = salarioMensual;
        }
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    @Override
    public String toString() {
        return String.format("----------INFORMACION POR EMPLEADO-----------"+
                        "\nEmpleado: %s %s, Salario Mensual: $%.2f, Salario Anual: $%.2f",
                primerNombre, apellido, salarioMensual, salarioMensual * 12);
    }
}
