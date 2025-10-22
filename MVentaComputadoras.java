import java.util.Scanner;

public class MVentaComputadoras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int zonas = 0, vendedores = 0;
        int ventas[][] = new int[15][15]; // Filas = zonas, Columnas = vendedores
        boolean capturado = false;
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("========================================");
            System.out.println("            MENÚ PRINCIPAL");
            System.out.println("========================================");
            System.out.println("1. Pedir ventas por zona y vendedores");
            System.out.println("2. Mostrar resultados");
            System.out.println("3. Salir");

          
            System.out.print("Elige una opción: ");
            String entrada = sc.next();
            if (!esNumeroValido(entrada)) {
                System.out.println("¡Cometiste un error! Debes ingresar un número entre 1 y 3.");
                continue;
            }
            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    // Número de zonas
                    System.out.print("¿Cuántas zonas diferentes existen?: ");
                    String entradaZonas = sc.next();
                    if (!esNumeroValido(entradaZonas)) {
                        System.out.println("¡Cometiste un error! Debes ingresar un número.");
                        break;
                    }
                    zonas = Integer.parseInt(entradaZonas);
                    if (zonas < 1 || zonas > 15) {
                        System.out.println("El valor es inválido. Debes ingresar un número entre 1 y 15.");
                        break;
                    }

                    // Número de vendedores
                    System.out.print("¿Cuántos vendedores hay por zona?: ");
                    String entradaVend = sc.next();
                    if (!esNumeroValido(entradaVend)) {
                        System.out.println("¡Cometiste un error! Debes ingresar un número.");
                        break;
                    }
                    vendedores = Integer.parseInt(entradaVend);
                    if (vendedores < 1 || vendedores > 10) {
                        System.out.println("El valor es inválido. Debes ingresar un número entre 1 y 10.");
                        break;
                    }

                    // Captura de ventas
                    System.out.println("======= Pedir ventas =======");
                    for (int z = 0; z < zonas; z++) {
                        System.out.println("Zona " + (z + 1));
                        for (int v = 0; v < vendedores; v++) {
                            System.out.print("Ventas del vendedor " + (v + 1) + ": ");
                            String entradaVenta = sc.next();
                            while (!esNumeroValido(entradaVenta)) {
                                System.out.println("¡Cometiste un error! Debes ingresar un número.");
                                System.out.print("Ventas del vendedor " + (v + 1) + ": ");
                                entradaVenta = sc.next();
                            }
                            ventas[z][v] = Integer.parseInt(entradaVenta);
                        }
                    }
                    capturado = true;
                    System.out.println("Las ventas fueron capturadas correctamente.");
                    break;

                case 2:
                    if (!capturado) {
                        System.out.println("Primero debes capturar las ventas.");
                        break;
                    }

                    // Mostrar matriz
                    System.out.println("======= MATRIZ DE VENTAS =======");
                    System.out.print("\t");
                    for (int v = 0; v < vendedores; v++) {
                        System.out.print("V" + (v + 1) + "\t");
                    }
                    System.out.println();
                    for (int z = 0; z < zonas; z++) {
                        System.out.print("Zona " + (z + 1) + ":\t");
                        for (int v = 0; v < vendedores; v++) {
                            System.out.print(ventas[z][v] + "\t");
                        }
                        System.out.println();
                    }

                    // Zona que más vendió
                    int maxZona = 0, zonaMax = 0;
                    for (int z = 0; z < zonas; z++) {
                        int suma = 0;
                        for (int v = 0; v < vendedores; v++) {
                            suma += ventas[z][v];
                        }
                        if (suma > maxZona) {
                            maxZona = suma;
                            zonaMax = z;
                        }
                    }

                    // Vendedores que más y menos vendieron
                    int maxV = ventas[0][0], minV = ventas[0][0];
                    int vendedorMaxZ = 0, vendedorMaxV = 0;
                    int vendedorMinZ = 0, vendedorMinV = 0;

                    for (int z = 0; z < zonas; z++) {
                        for (int v = 0; v < vendedores; v++) {
                            int valor = ventas[z][v];
                            if (valor > maxV) {
                                maxV = valor;
                                vendedorMaxZ = z;
                                vendedorMaxV = v;
                            }
                            if (valor < minV) {
                                minV = valor;
                                vendedorMinZ = z;
                                vendedorMinV = v;
                            }
                        }
                    }

                    // Total de computadoras vendidad 
                    int total = 0;
                    for (int z = 0; z < zonas; z++) {
                        for (int v = 0; v < vendedores; v++) {
                            total += ventas[z][v];
                        }
                    }

                    // Mostrar resultados
                    System.out.println("======= RESULTADOS =======");
                    System.out.println("1) Zona que más computadoras vendió: Zona " + (zonaMax + 1) + " con " + maxZona + " computadoras.");
                    System.out.println("2) Vendedor que menos vendió: Zona " + (vendedorMinZ + 1) + ", Vendedor " + (vendedorMinV + 1) + " con " + minV + " computadoras.");
                    System.out.println("3) Vendedor que más vendió: Zona " + (vendedorMaxZ + 1) + ", Vendedor " + (vendedorMaxV + 1) + " con " + maxV + " computadoras.");
                    System.out.println("4) Total de computadoras vendidas por todos los vendedores en todas las zonas: " + total);

                    break;

                case 3:
                    System.out.println("Saliendo del programa. ¡Adiós!");
                    break;

                default:
                    System.out.println("La opción es inválida. Debes elegir un número del 1 al 3.");
            }
        }

        sc.close();
    }

    // Verificar errores
    public static boolean esNumeroValido(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
