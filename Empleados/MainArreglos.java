package Empleados.Empleados;

import java.util.Scanner;

public class MainArreglos {

    public static void main(String[] args) {
        Empleados[] empleados = new Empleados[3];
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int contadorEmpleados = 0;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. Ingresar nombres y salario");
            System.out.println("2. Mostrar el salario anual");
            System.out.println("3. Aumentar el salario");
            System.out.println("4. Ver toda la información");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (contadorEmpleados < empleados.length) {
                        scanner.nextLine();
                        System.out.print("Ingrese el primer nombre del empleado: ");
                        String primerNombre = scanner.nextLine();
                        System.out.print("Ingrese el apellido del empleado: ");
                        String apellido = scanner.nextLine();
                        System.out.print("Ingrese el salario mensual del empleado: ");
                        double salarioMensual = scanner.nextDouble();
                        empleados[contadorEmpleados] = new Empleados(primerNombre, apellido, salarioMensual);
                        contadorEmpleados++;
                    } else {
                        System.out.println("Ya no se pueden agregar más empleados.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del empleado para mostrar el salario anual: ");
                    String nombreBusqueda = scanner.nextLine();
                    mostrarSalarioAnual(empleados, nombreBusqueda);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del empleado para aumentar el salario: ");
                    String nombreAumento = scanner.nextLine();
                    aumentarSalario(empleados, nombreAumento);
                    break;
                case 4:
                    verTodaLaInformacion(empleados);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static int buscarEmpleado(Empleados[] empleados, String nombre) {
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null && empleados[i].getPrimerNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static void mostrarSalarioAnual(Empleados[] empleados, String nombre) {
        int indice = buscarEmpleado(empleados, nombre);
        if (indice != -1) {
            Empleados empleado = empleados[indice];
            System.out.printf("El salario anual de %s %s es: $%.2f%n",
                    empleado.getPrimerNombre(), empleado.getApellido(),
                    empleado.getSalarioMensual() * 12);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void aumentarSalario(Empleados[] empleados, String nombre) {
        int indice = buscarEmpleado(empleados, nombre);
        if (indice != -1) {
            Empleados empleado = empleados[indice];
            empleado.setSalarioMensual(empleado.getSalarioMensual() * 1.10);
            System.out.printf("El nuevo salario mensual de %s %s es: $%.2f%n",
                    empleado.getPrimerNombre(), empleado.getApellido(),
                    empleado.getSalarioMensual());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void verTodaLaInformacion(Empleados[] empleados) {
        for (Empleados empleado : empleados) {
            if (empleado != null) {
                System.out.println(empleado.toString());
            }
        }
    }
}
