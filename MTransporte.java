import java.util.Scanner;

public class MTransporte {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = 5; // número de choferes
        int columnas = 7; // días de la semana

       
        String[] nombres = {"Mario", "Paulo", "Braulio", "Abdiel", "Roberto"};
        double[] sueldoHora = {40, 46, 50, 45, 52};
        int[] descanso = {2, 3, 4, 5, 6}; // 0=Lunes, 1=Martes... 6=Domingo

        int[][] horas = new int[filas][columnas];
        int[] totalHoras = new int[filas];
        double[] sueldoSemanal = new double[filas];
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

        // Ingresar las horas trabajadas
        for (int i = 0; i < filas; i++) {
            System.out.println("Chofer: " + nombres[i]);
            System.out.println("Día de descanso: " + dias[descanso[i]] + " (" + (descanso[i] + 1) + ")");
            for (int j = 0; j < columnas; j++) {
                if (j == descanso[i]) {
                    horas[i][j] = 0;
                    System.out.println(dias[j] + " (descanso): 0 horas");
                } else {
                    System.out.print("Horas trabajadas el " + dias[j] + ": ");
                    horas[i][j] = sc.nextInt();
                }
            }
        }

        // Calcular sueldos
        double totalEmpresa = 0;
        for (int i = 0; i < filas; i++) {
            totalHoras[i] = 0;
            for (int j = 0; j < columnas; j++) {
                totalHoras[i] = totalHoras[i] + horas[i][j];
            }
            sueldoSemanal[i] = totalHoras[i] * sueldoHora[i];
            totalEmpresa = totalEmpresa + sueldoSemanal[i];
        }

        // Buscar quién trabajó más horas el dia lunes
        int posMaxLunes = 0;
        int maxLunes = horas[0][0];
        for (int i = 1; i < filas; i++) {
            if (horas[i][0] > maxLunes) {
                maxLunes = horas[i][0];
                posMaxLunes = i;
            }
        }

        // Imprimir reporte
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
