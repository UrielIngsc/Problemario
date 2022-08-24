package Problemario.NumerosComplejos;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p291 {
    public static void main(String[] args) {
        
    }
}

class NumeroComplejo{
    private float parteReal;
    private float parteImaginaria;

    public float getParteImaginaria() {
        return parteImaginaria;
    }
    public float getParteReal() {
        return parteReal;
    }

    NumeroComplejo(float p_parteReal, float p_parteImaginaria){
        parteReal = p_parteReal;
        parteImaginaria = p_parteImaginaria;
    }
}

class Utilities{

    public NumeroComplejo procesoPrincipal() {

        StringTokenizer stringTokenizer;
        Scanner input = new Scanner(System.in);
        String operador;
        int contador;
        float parteReal1, parteReal2, parteImaginaria1, parteImaginaria2;

        String datosNumeros = input.next();
        stringTokenizer = new StringTokenizer(datosNumeros);

        for(contador = 1; contador <= datosNumeros.length();contador++){
            parteReal1 = Float.parseFloat(stringTokenizer.nextToken());
            parteImaginaria1 = Float.parseFloat(stringTokenizer.nextToken());

            parteReal2 = Float.parseFloat(stringTokenizer.nextToken());
            parteImaginaria2 = Float.parseFloat(stringTokenizer.nextToken());

            operador = stringTokenizer.nextToken();

        }

        input.close();
   }
}