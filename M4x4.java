import java.util.Scanner;

public class M4x4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[4][4]; 
        boolean relleno = false;        // indica si ya se llenó la matriz
        int opcion = 0;

        while (opcion != 12) {
            System.out.println("======================================== MENÚ ========================================");
            System.out.println("1. Rellenar la matriz");
            System.out.println("2. Suma de cada una de las filas y columnas de la matriz");
            System.out.println("3. Suma de la fila que indique el usuario");
            System.out.println("4. Suma de una columna que indique el usuario");
            System.out.println("5. Indicar el mayor y el menor de los números introducidos e indicar su posición");
            System.out.println("6. Contar cuantos son pares");
            System.out.println("7. Contar cuantos son impares");
            System.out.println("8. Generar una nueva matriz con el cuadrado de cada uno de los valores");
            System.out.println("9. Sumar la diagonal principal");
            System.out.println("10. Sumar la diagonal inversa");
            System.out.println("11. La media de todos los valores de la matriz");
            System.out.println("12. Salir");
            System.out.println("======================================================================================");
            System.out.print("Elige una opción: ");

            if (!sc.hasNextInt()) {
                System.out.println("Valor inválido. Debes ingresar un número entre 1 y 12.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Rellenar matriz sin valores repetidos
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            int num;
                            boolean repetido;
                            do {
                                System.out.print("Ingresa un número para la posición [" + i + "][" + j + "]: ");
                                while (!sc.hasNextInt()) {
                                    System.out.println("Valor inválido. Ingresa un número.");
                                    sc.next();
                                }
                                num = sc.nextInt();

                                repetido = false;
                                for (int x = 0; x < 4; x++) {
                                    for (int y = 0; y < 4; y++) {
                                        if (matriz[x][y] == num) {
                                            repetido = true;
                                        }
                                    }
                                }
                                if (repetido) {
                                    System.out.println("Ese número ya se encuentra en la matriz, ingresa otro.");
                                }
                            } while (repetido);
                            matriz[i][j] = num;
                        }
                    }
                    relleno = true;
                    System.out.println("Matriz rellenada correctamente:");
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.print(matriz[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    
                    // Suma de filas
                    System.out.println("Suma de cada fila:");
                    for (int i = 0; i < 4; i++) {
                        int sumaFila = 0;
                        for (int j = 0; j < 4; j++) {
                            sumaFila += matriz[i][j];
                        }
                        System.out.println("Fila " + i + ": " + sumaFila);
                    }
                    
                    // Suma de columnas
                    System.out.println("Suma de cada columna:");
                    for (int j = 0; j < 4; j++) {
                        int sumaCol = 0;
                        for (int i = 0; i < 4; i++) {
                            sumaCol += matriz[i][j];
                        }
                        System.out.println("Columna " + j + ": " + sumaCol);
                    }
                    
                    // Mostrar matriz
                    System.out.println("Matriz actual:");
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            System.out.print(matriz[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int fila;
                    do {
                        System.out.print("Ingresa la fila que quieres sumar (0-3): ");
                        while (!sc.hasNextInt()) { sc.next(); System.out.println("Valor inválido."); }
                        fila = sc.nextInt();
                    } while (fila < 0 || fila > 3);
                    int sumaFila = 0;
                    for (int j = 0; j < 4; j++) sumaFila += matriz[fila][j];
                    System.out.println("Suma de la fila " + fila + ": " + sumaFila);
                    
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) System.out.print(matriz[i][j] + "\t");
                        System.out.println();
                    }
                    break;

                case 4:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int col;
                    do {
                        System.out.print("Ingresa la columna que quieres sumar (0-3): ");
                        while (!sc.hasNextInt()) { sc.next(); System.out.println("Valor inválido."); }
                        col = sc.nextInt();
                    } while (col < 0 || col > 3);
                    int sumaCol = 0;
                    for (int i = 0; i < 4; i++) sumaCol += matriz[i][col];
                    System.out.println("Suma de la columna " + col + ": " + sumaCol);
                   
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) System.out.print(matriz[i][j] + "\t");
                        System.out.println();
                    }
                    break;

                case 5:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int max = matriz[0][0], min = matriz[0][0];
                    int maxI=0,maxJ=0, minI=0,minJ=0;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (matriz[i][j] > max) { max = matriz[i][j]; maxI=i; maxJ=j; }
                            if (matriz[i][j] < min) { min = matriz[i][j]; minI=i; minJ=j; }
                        }
                    }
                    System.out.println("Mayor: " + max + " en posición ["+maxI+"]["+maxJ+"]");
                    System.out.println("Menor: " + min + " en posición ["+minI+"]["+minJ+"]");
                   
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) System.out.print(matriz[i][j] + "\t");
                        System.out.println();
                    }
                    break;

                case 6:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int pares=0;
                    for (int i=0;i<4;i++) for(int j=0;j<4;j++) if(matriz[i][j]%2==0) pares++;
                    System.out.println("Cantidad de números pares: " + pares);
                    
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) { for (int j = 0; j < 4; j++) System.out.print(matriz[i][j] + "\t"); System.out.println(); }
                    break;

                case 7:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int impares=0;
                    for (int i=0;i<4;i++) for(int j=0;j<4;j++) if(matriz[i][j]%2!=0) impares++;
                    System.out.println("Cantidad de números impares: " + impares);
                    
                    // Mostrar matriz
                    for (int i = 0; i < 4; i++) { for (int j = 0; j < 4; j++) System.out.print(matriz[i][j] + "\t"); System.out.println(); }
                    break;

                case 8:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int matrizCuadrado[][] = new int[4][4];
                    for(int i=0;i<4;i++) for(int j=0;j<4;j++) matrizCuadrado[i][j] = matriz[i][j]*matriz[i][j];
                    System.out.println("Matriz al cuadrado:");
                    for(int i=0;i<4;i++){ for(int j=0;j<4;j++) System.out.print(matrizCuadrado[i][j]+"\t"); System.out.println(); }
                    break;

                case 9:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int sumaDiag = 0;
                    for(int i=0;i<4;i++) sumaDiag += matriz[i][i];
                    System.out.println("Suma de la diagonal principal: " + sumaDiag);
                    break;

                case 10:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int sumaDiagInv=0;
                    for(int i=0;i<4;i++) sumaDiagInv += matriz[i][3-i];
                    System.out.println("Suma de la diagonal inversa: " + sumaDiagInv);
                    break;

                case 11:
                    if (!relleno) { System.out.println("Primero debes rellenar la matriz."); break; }
                    int total = 0;
                    for(int i=0;i<4;i++) for(int j=0;j<4;j++) total += matriz[i][j];
                    System.out.printf("Media de todos los valores: %.2f\n", (total/16.0));
                    break;

                case 12:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción inválida, elige un número entre 1 y 12.");
            }
        }

        sc.close();
    }
}
