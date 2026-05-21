/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacobi;

import java.util.Scanner;
public class Jacobi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresar el total de ecuaciones: ");
        int n = teclado.nextInt();
        
        double[][] coef = new double [n][n];
        double[] independiente = new double[n];
        double[] valores = new double[n];
        double[] nuevosValores = new double[n];
        
        System.out.println("Datos del sistema de ecuaciones:");
        for (int fila = 0; fila < n; fila++) {
            System.out.println("Ecuación" + (fila + 1));
            
            for (int col = 0; col < n; col++){
                System.out.println("Valor del coeficiente [  " + (fila + 1) + "][" + (col + 1) + "]:");
                coef[fila][col] = teclado.nextDouble();
            }
            System.out.println("Valor del termino independiente: ");
            independiente[fila] = teclado.nextDouble();
        }
        System.out.println("Ingresar los valores iniciales:");
        for (int i = 0; i < n; i++){
            System.out.println("x" + (i + 1) + "=");
            valores[i] = teclado.nextDouble();
        }
        System.out.println("Ingresar la tolerancia: ");
        double tolerancia = teclado.nextDouble();
        
        System.out.println("Ingresar el número maximo de iteraciones: ");
        int maximo = teclado.nextInt();
        
        for (int iteracion = 1; iteracion <= maximo; iteracion++){
            double errorMayor = 0;
            
            System.out.println("Iteración" + iteracion);
            
            for(int fila = 0; fila < n; fila++){
                double suma = 0;
                
                for (int col = 0; col < n; col++){
                    if (col != fila){
                        suma += coef[fila][col] * valores[col];
                    }
                }
                nuevosValores[fila] = (independiente[fila] - suma) / coef[fila][fila];
                
                double error = Math.abs(nuevosValores[fila] - valores[fila]);
                
                if (error > errorMayor){
                    errorMayor = error;
                }
                System.out.println("x" + (fila + 1) + " = " + nuevosValores[fila]);
            }
            System.out.println("Error Mayor = " + errorMayor);
            
            for (int i = 0; i < n; i++){
                valores[i] = nuevosValores[i];
            }
            if (errorMayor < tolerancia){
                System.out.println("El método convergio correctamente.");
                break;
            }
        }
        System.out.println("Resultado final aproximado:");
        for (int i = 0; i < n; i++){
            System.out.println("x" + ( i + 1) + "=" + valores[i]);
        }
    }
    
}
