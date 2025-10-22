import java.util.Scanner;

public class MPromedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 0, M = 0;
        double[][] calificaciones = new double[30][30];
        double[] promedios = new double[30];
        boolean capturado = false;
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("====================== MENÚ DE CALIFICACIONES =======================");
            System.out.println("1. Pedir calificaciones");
            System.out.println("2. Mostrar promedio de cada estudiante");
            System.out.println("3. Mostrar alumnos con promedio entre 9 y 10");
            System.out.println("4. Mostrar alumnos con promedio menor a 7");
            System.out.println("5. Examen con calificación más alta y más baja");
            System.out.println("6. Salir");
            System.out.println("====================================================================");
            System.out.print("Elige una opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Debes ingresar un número entre 1 y 6.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Ingresa el número de estudiantes (N): ");
                    N = sc.nextInt();
                    System.out.print("Ingresa el número de exámenes (M): ");
                    M = sc.nextInt();

                    for (int i = 0; i < N; i++) {
                        System.out.println("Estudiante " + (i + 1) + ":");
                        for (int j = 0; j < M; j++) {
                            double nota;
                            do {
                                System.out.print("Calificación del examen " + (j + 1) + " (0 a 10): ");
                                nota = sc.nextDouble();
                                if (nota < 0 || nota > 10) {
                                    System.out.println("La calificación es inválida. Ingresa un valor entre 0 y 10.");
                                }
                            } while (nota < 0 || nota > 10);
                            calificaciones[i][j] = nota;
                        }
                    }

                    // Calcular los promedios 
                    for (int i = 0; i < N; i++) {
                        double suma = 0;
                        for (int j = 0; j < M; j++) {
                            suma += calificaciones[i][j];
                        }
                        promedios[i] = suma / M;
                    }

                    capturado = true;

                    mostrarMatriz(calificaciones, N, M);
                    break;

                case 2:
                    if (!capturado) {
                        System.out.println("Primero debes ingresar las calificaciones.");
                        break;
                    }
                    System.out.println("------ Promedio de cada estudiante ------");
                    for (int i = 0; i < N; i++) {
                        System.out.printf("Estudiante %d: %.2f\n", (i + 1), promedios[i]);
                    }
                    System.out.println();
                    break;

                case 3:
                    if (!capturado) {
                        System.out.println("Primero debes ingresar las calificaciones.");
                        break;
                    }

                    int contAltos = 0;
                    for (int i = 0; i < N; i++) {
                        if (promedios[i] >= 9 && promedios[i] <= 10) contAltos++;
                    }

                    if (contAltos > 0) {
                        System.out.println("------ Estudiantes con promedio entre 9 y 10 ------");
                        for (int i = 0; i < N; i++) {
                            if (promedios[i] >= 9 && promedios[i] <= 10) {
                                System.out.printf("Estudiante %d: %.2f   Calificaciones: ", (i + 1), promedios[i]);
                                for (int j = 0; j < M; j++) {
                                    System.out.printf("%6.2f  ", calificaciones[i][j]);
                                }
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("No hay estudiantes con promedio entre 9 y 10.");
                    }
                    System.out.println();
                    break;

                case 4:
                    if (!capturado) {
                        System.out.println("Primero debes ingresar las calificaciones.");
                        break;
                    }

                    int contBajos = 0;
                    for (int i = 0; i < N; i++) {
                        if (promedios[i] < 7) contBajos++;
                    }

                    if (contBajos > 0) {
                        System.out.println("------ Estudiantes con promedio menor a 7 ------ ");
                        for (int i = 0; i < N; i++) {
                            if (promedios[i] < 7) {
                                System.out.printf("Estudiante %d: %.2f   Calificaciones: ", (i + 1), promedios[i]);
                                for (int j = 0; j < M; j++) {
                                    System.out.printf("%6.2f  ", calificaciones[i][j]);
                                }
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("No hay estudiantes con promedio menor a 7.");
                    }
                    System.out.println();
                    break;

                case 5:
                    if (!capturado) {
                        System.out.println("Primero debes ingresar las calificaciones.");
                        break;
                    }

                    double maxCal = calificaciones[0][0];
                    double minCal = calificaciones[0][0];

                    // Buscar el valor máximo y mínimo
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (calificaciones[i][j] > maxCal) maxCal = calificaciones[i][j];
                            if (calificaciones[i][j] < minCal) minCal = calificaciones[i][j];
                        }
                    }

                    // Mostrar examen con la calificación mas alta
                    System.out.println("Examen(es) con calificación más alta:");
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (calificaciones[i][j] == maxCal) {
                                System.out.printf("Examen %d: Estudiante %d (%.2f)\n", j + 1, i + 1, calificaciones[i][j]);
                            }
                        }
                    }

                    // Mostrar examen con la calificación mas baja
                    System.out.println("Examen(es) con calificación más baja:");
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (calificaciones[i][j] == minCal) {
                                System.out.printf("Examen %d: Estudiante %d (%.2f)\n", j + 1, i + 1, calificaciones[i][j]);
                            }
                        }
                    }

                    mostrarMatriz(calificaciones, N, M);
                    break;

                case 6:
                    System.out.println("Saliendo del programa. Adiós.");
                    break;

                default:
                    System.out.println("Opción inválida. Ingresa un número entre 1 y 6.");
                    break;
            }
        }
        sc.close();
    }

    //Mostrar matriz 
    public static void mostrarMatriz(double[][] matriz, int filas, int cols) {
        System.out.println("------ Matriz de calificaciones ------");
        System.out.print("                 ");
        for (int j = 0; j < cols; j++) { 
            System.out.printf("Ex%d     ", j + 1);
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.printf("Estudiante %d  ", i + 1);
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6.2f   ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
