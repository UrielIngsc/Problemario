package Problemario.NumerosComplejos;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p291 {
    public static void main(String[] args) {
        Utilities utilidades = new Utilities();
        utilidades.procesoPrincipal();
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

    public NumeroComplejo sumarNumerosComplejos(NumeroComplejo p_objNumeroComplejo) {
        float resultadoParteReal = parteReal + p_objNumeroComplejo.parteReal;
        float resultadoParteImaginaria = parteImaginaria + p_objNumeroComplejo.parteImaginaria;


        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo restarNumerosComplejos(NumeroComplejo p_objNumeroComplejo) {
        float resultadoParteReal = parteReal - p_objNumeroComplejo.parteReal;
        float resultadoParteImaginaria = parteImaginaria - p_objNumeroComplejo.parteImaginaria;

        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo multiplicarNumerosComplejos(NumeroComplejo p_objNumeroComplejo){
        float resultadoParteReal = ((parteReal*p_objNumeroComplejo.parteReal)+((parteImaginaria*p_objNumeroComplejo.parteImaginaria)*-1));
        float resultadoParteImaginaria = ((parteReal*p_objNumeroComplejo.parteImaginaria)+(parteImaginaria*p_objNumeroComplejo.parteReal));

        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo dividirNumerosComplejos(NumeroComplejo p_objNumeroComplejo){
        float conjugado = (p_objNumeroComplejo.parteImaginaria)*-1;
        float divisor = (float)((Math.pow(p_objNumeroComplejo.parteReal, 2))+(Math.pow(p_objNumeroComplejo.parteImaginaria, 2)));

        float resultadoParteReal = (((parteReal*p_objNumeroComplejo.parteReal)+((parteImaginaria*conjugado)*-1))/divisor);
        float resultadoParteImaginaria = (((parteReal*conjugado)+(parteImaginaria*p_objNumeroComplejo.parteReal))/divisor);

        resultadoParteReal = redondearDecimales(resultadoParteReal);

        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    private float redondearDecimales(float numeroRedondear){
        System.out.println("entre");
        int parteEntera = (int) numeroRedondear;
        String decimales = String.valueOf(numeroRedondear-parteEntera);

        System.out.println(decimales);
        return 0.0f;

    }

    NumeroComplejo(float p_parteReal, float p_parteImaginaria){
        parteReal = p_parteReal;
        parteImaginaria = p_parteImaginaria;
    }
}

class Utilities{

    public void procesoPrincipal() {
        String operador;
        Scanner input = new Scanner(System.in);
        float parteReal1, parteReal2, parteImaginaria1, parteImaginaria2;
        NumeroComplejo objNumeroComplejo1, objNumeroComplejo2, objNumeroComplejoResultado;

        //Entrada de datos y segmentacion de los numeros complejos con su operador
        String datosNumeros = input.nextLine();
        StringTokenizer sTokenizer = new StringTokenizer(datosNumeros);

        parteReal1 = Float.parseFloat(sTokenizer.nextToken());
        parteImaginaria1 = obtenerValorParteImaginaria(sTokenizer.nextToken());

        parteReal2 = Float.parseFloat(sTokenizer.nextToken());
        parteImaginaria2 = obtenerValorParteImaginaria(sTokenizer.nextToken());

        operador = sTokenizer.nextToken();

        //Instacia de los numeros complejos
        objNumeroComplejo1 = new NumeroComplejo(parteReal1, parteImaginaria1);
        objNumeroComplejo2 = new NumeroComplejo(parteReal2, parteImaginaria2);

        switch (operador) {
            case "+":
                objNumeroComplejoResultado = objNumeroComplejo1.sumarNumerosComplejos(objNumeroComplejo2);
                break;
            case "-":
                objNumeroComplejoResultado = objNumeroComplejo1.restarNumerosComplejos(objNumeroComplejo2);
                break;
            case "*":
                objNumeroComplejoResultado = objNumeroComplejo1.multiplicarNumerosComplejos(objNumeroComplejo2);
                break;
            case "/":
                objNumeroComplejoResultado = objNumeroComplejo1.dividirNumerosComplejos(objNumeroComplejo2);
                break;
            default:
                objNumeroComplejoResultado = new NumeroComplejo(0.0f, 0.0f);
                break;
        }

        System.out.println(objNumeroComplejoResultado.getParteReal() + " " + objNumeroComplejoResultado.getParteImaginaria()+"i");
        input.close();
   }

   private float obtenerValorParteImaginaria(String parteImaginaria) {
        String valorParteImaginaria = "";
        char cifraParteImaginaria;
        int index;

        for(index = parteImaginaria.length()-2;index >= 0; index--){
            cifraParteImaginaria = parteImaginaria.charAt(index);
            valorParteImaginaria = cifraParteImaginaria + valorParteImaginaria;
        }
        
        return (Float.parseFloat(valorParteImaginaria));
   }
}