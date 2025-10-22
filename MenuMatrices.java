import java.util.Scanner;

public class MenuMatrices{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int filas = 0, columnas = 0;
        int matriz[][] = new int[10][10];
        int opcion = 0;
        boolean guardado = false;

        while (opcion != 8) {
            System.out.println("====== MENÚ DE MATRICES ======");
            System.out.println("1. Insertar elementos");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Modificar elemento");
            System.out.println("5. Mostrar/Recorrer matriz");
            System.out.println("6. Eliminar toda la matriz");
            System.out.println("7. Ordenar matriz");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            if(!sc.hasNextInt()){
                System.out.println("El elemento no es válido. Debes ingresar un número entre 1 y 8.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();
            if(opcion < 1 || opcion > 8){
                System.out.println("La opción está fuera de rango. DebeS ingresar un número entre 1 y 8.");
                continue;
            }

            switch(opcion) {

                case 1: // Insertar
                    System.out.print("¿Cuántas filas quieres? (Vertical) : ");
                    if(!sc.hasNextInt()){ sc.next(); break; }
                    filas = sc.nextInt();
                    if (filas < 1 || filas > 10) {System.out.println("El valor es incorrecto. Regresando al menú..."); break;}

                    System.out.print("¿Cuántas columnas quieres? (Horizontal): ");
                    if(!sc.hasNextInt()){ sc.next(); break; }
                    columnas = sc.nextInt();
                    if (columnas < 1 || columnas > 10) {System.out.println("El valor es incorrecto. Regresando al menú..."); break;}

                    System.out.println("====== INSERTAR ELEMENTOS ======");
                    for (int f = 0; f < filas; f++) {
                        for (int c = 0; c < columnas; c++) {
                            System.out.print("Elemento [" + f + "][" + c + "]: ");
                            while(!sc.hasNextInt()){
                                System.out.println("Valor inválido. Ingresa un número:");
                                sc.next();
                            }
                            matriz[f][c] = sc.nextInt();
                        }
                    }
                    guardado = true;
                    break;

                case 2: // Buscar

                    if(!guardado){System.out.println("Primero debes ingresar elementos."); break;}
                    System.out.print("Ingresa el valor que quieres buscar: ");
                    if(!sc.hasNextInt()){ sc.next(); break;}
                    int buscar = sc.nextInt();
                    boolean encontrado = false;
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){
                            if(matriz[f][c]==buscar){
                                System.out.println("Valor encontrado en la posición ["+f+"]["+c+"]");
                                encontrado=true;
                            }
                        }
                    }
                    if(!encontrado){System.out.println("El valor no se encontró en la matriz.");}
                    break;

                case 3: // Eliminar

                    if(!guardado){System.out.println("Primero debes ingresar elementos."); break;}
                    System.out.println("Matriz antes de eliminar:");
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                        System.out.println();
                    }

                    int fElim=-1, cElim=-1;
                    while(true){
                        System.out.print("Fila del elemento que será eliminado (0-"+(filas-1)+"): ");
                        if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); continue;}
                        fElim = sc.nextInt();
                        if(fElim<0 || fElim>=filas){System.out.println("La fila está fuera del rango."); continue;}
                        break;
                    }
                    while(true){
                        System.out.print("Columna del elemento que será eliminado (0-"+(columnas-1)+"): ");
                        if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); continue;}
                        cElim = sc.nextInt();
                        if(cElim<0 || cElim>=columnas){System.out.println("La columna está fuera del rango."); continue;}
                        break;
                    }

                    matriz[fElim][cElim]=0;
                    System.out.println("Elemento eliminado.");
                    System.out.println("Matriz nueva :");
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                        System.out.println();
                    }
                    break;

                case 4: // Modificar

                    if(!guardado){System.out.println("Primero debes ingresar los elementos."); break;}
                    System.out.println("Matriz antes de modificar:");
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                        System.out.println();
                    }

                    int fMod=-1, cMod=-1;
                    while(true){
                        System.out.print("Fila del elemento que sera modificado (0-"+(filas-1)+"): ");
                        if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); continue;}
                        fMod = sc.nextInt();
                        if(fMod<0 || fMod>=filas){System.out.println("La fila está fuera del rango."); continue;}
                        break;
                    }
                    while(true){
                        System.out.print("Columna del elemento que será modificado (0-"+(columnas-1)+"): ");
                        if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); continue;}
                        cMod = sc.nextInt();
                        if(cMod<0 || cMod>=columnas){System.out.println("La columna está fuera del rango."); continue;}
                        break;
                    }

                    System.out.print("Nuevo valor: ");
                    while(!sc.hasNextInt()){ System.out.println("Valor inválido. Ingresa un número:"); sc.next(); }
                    matriz[fMod][cMod] = sc.nextInt();
                    System.out.println("Elemento modificado.");
                    System.out.println("Matriz nueva :");
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                        System.out.println();
                    }
                    break;

                case 5: // Mostrar/Recorrer matriz

                    if(!guardado){System.out.println("Primero debes ingresar elementos."); break;}
                    System.out.println("1. Orden ascendente");
                    System.out.println("2. Orden descendente");
                    System.out.print("Elige una opción: ");
                    int subOpcion = -1;
                    if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); break;}
                    subOpcion = sc.nextInt();
                    if(subOpcion != 1 && subOpcion !=2){System.out.println("Opción inválida."); break;}

                    System.out.println("Matriz:");
                    if(subOpcion==1){ // Ascendente 
                        for(int f=0; f<filas; f++){
                            for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                            System.out.println();
                        }
                    }else{ // Descendente
                        for(int f=filas-1; f>=0; f--){
                            for(int c=columnas-1; c>=0; c--){System.out.print(matriz[f][c]+"\t");}
                            System.out.println();
                        }
                    }
                    break;

                case 6: // Eliminar toda la matriz

                    if(!guardado){System.out.println("La matriz ya está vacía."); break;}
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){matriz[f][c]=0;}
                    }
                    guardado=false; filas=0; columnas=0;
                    System.out.println("Toda la matriz fue eliminada.");
                    break;

                case 7: // Ordenar matriz

                    if(!guardado){System.out.println("Primero debes insertar elementos."); break;}
                    System.out.println("1. Ascendente");
                    System.out.println("2. Descendente");
                    System.out.print("Elige una opción: ");
                    int ord=-1;
                    if(!sc.hasNextInt()){ System.out.println("Valor inválido."); sc.next(); break;}
                    ord = sc.nextInt();
                    if(ord!=1 && ord!=2){System.out.println("La opción es inválida."); break;}

                    
                    int total = filas*columnas;
                    int[] aux = new int[total];
                    int k=0;
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){
                            aux[k++] = matriz[f][c];
                        }
                    }

                  
                    // Ordenación
                    for(int i=0; i<total-1; i++){
                        for(int j=i+1; j<total; j++){
                            if( (ord==1 && aux[i]>aux[j]) || (ord==2 && aux[i]<aux[j]) ){
                                int temp = aux[i];
                                aux[i] = aux[j];
                                aux[j] = temp;
                            }
                        }
                    }

                    
                    k=0;
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){
                            matriz[f][c] = aux[k++];
                        }
                    }

                    System.out.println("Matriz ordenada:");
                    for(int f=0; f<filas; f++){
                        for(int c=0; c<columnas; c++){System.out.print(matriz[f][c]+"\t");}
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.println("Saliendo del programa !Adios¡....");
                    break;
            }
        }
        sc.close();
    }
}
