import java.util.Scanner;

public class MReporteTransporte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = 5; // número de choferes
        int columnas = 7; // días de la semana (lunes a domingo)

        String[] nombres = new String[filas];
        double[] sueldoHora = new double[filas];
        int[] descanso = new int[filas];
        int[][] horas = new int[filas][columnas];
        int[] totalHoras = new int[filas];
        double[] sueldoSemanal = new double[filas];

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        System.out.println("REGISTRO DE CHOFERES (5 choferes)");

        for (int i = 0; i < filas; i++) {
            System.out.println("Chofer " + (i + 1));
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            System.out.print("Sueldo por hora:$ ");
            sueldoHora[i] = sc.nextDouble();

            System.out.print("Ingresa tu día de descanso (1=Lunes, 2=Martes,3=Miércoles,4=Jueves,5=Viernes,6=Sábado,7=Domingo): ");
            descanso[i] = sc.nextInt() - 1;

            System.out.println("Ingresa las horas trabajadas por día:");
            for (int j = 0; j < columnas; j++) {
                if (j == descanso[i]) {
                    horas[i][j] = 0;
                    System.out.println(dias[j] + " (descanso): 0 horas");
                } else {
                    System.out.print(dias[j] + ": ");
                    horas[i][j] = sc.nextInt();
                }
            }
            sc.nextLine(); 
            System.out.println();
        }

        // a) Calcular total de horas semanales
        for (int i = 0; i < filas; i++) {
            totalHoras[i] = 0;
            for (int j = 0; j < columnas; j++) {
                totalHoras[i] = totalHoras[i] + horas[i][j];
            }
        }

        // b) Calcular sueldo semanal
        for (int i = 0; i < filas; i++) {
            sueldoSemanal[i] = totalHoras[i] * sueldoHora[i];
        }

        // c)Calcular total que pagará la empresa
        double totalEmpresa = 0;
        for (int i = 0; i < filas; i++) {
            totalEmpresa = totalEmpresa + sueldoSemanal[i];
        }

        // d) Indicar el nombre del chofer que más trabajo el lunes
        int posMaxLunes = 0;
        int maxLunes = horas[0][0];
        for (int i = 1; i < filas; i++) {
            if (horas[i][0] > maxLunes) {
                maxLunes = horas[i][0];
                posMaxLunes = i;
            }
        }

        // e) Imprimir reporte
        System.out.println("========= REPORTE SEMANAL =========");

        for (int i = 0; i < filas; i++) {
            System.out.println("Chofer: " + nombres[i]);
            System.out.println("Sueldo por hora: $" + sueldoHora[i]);
            System.out.println("Día de descanso: " + dias[descanso[i]] + " (" + (descanso[i] + 1) + ")");
            System.out.println("Horas por día:");
            for (int j = 0; j < columnas; j++) {
                System.out.println("   " + dias[j] + ": " + horas[i][j]);
            }
            System.out.println("Total de horas: " + totalHoras[i]);
            System.out.println("Sueldo semanal: $" + sueldoSemanal[i]);
            System.out.println("-----------------------------------");
        }

        System.out.println("Total que pagará la empresa: $" + totalEmpresa);
        System.out.println("Chofer que más trabajó el lunes: " + nombres[posMaxLunes] + " (" + maxLunes + " horas)");
        System.out.println("===================================");
    }
}
