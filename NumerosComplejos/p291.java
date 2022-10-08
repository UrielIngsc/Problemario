package Problemario.NumerosComplejos;

import java.util.Scanner;
import java.util.StringTokenizer;

public class p291 {
    public static void main(String[] args) {
        Utilities utilidades = new Utilities();
        String operador;
        Scanner input = new Scanner(System.in);
        double parteReal1, parteReal2, parteImaginaria1, parteImaginaria2;
        NumeroComplejo numeroComplejo1, numeroComplejo2, numeroComplejoResultado;

        String datosNumeros = input.nextLine();
        StringTokenizer sTokenizer = new StringTokenizer(datosNumeros);

        parteReal1 = Double.parseDouble(sTokenizer.nextToken());
        parteImaginaria1 = utilidades.obtenerValorParteImaginaria(sTokenizer.nextToken());

        parteReal2 = Double.parseDouble(sTokenizer.nextToken());
        parteImaginaria2 = utilidades.obtenerValorParteImaginaria(sTokenizer.nextToken());

        operador = sTokenizer.nextToken();

        numeroComplejo1 = new NumeroComplejo(parteReal1, parteImaginaria1);
        numeroComplejo2 = new NumeroComplejo(parteReal2, parteImaginaria2);
        numeroComplejoResultado = utilidades.llamarOperacionCompleja(numeroComplejo1, numeroComplejo2, operador);

        utilidades.mostrarResultado(numeroComplejoResultado);

        input.close();
    }
}

class NumeroComplejo{
    private double parteReal;
    private double parteImaginaria;

    public double getParteImaginaria() {
        return parteImaginaria;
    }
    public double getParteReal() {
        return parteReal;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public NumeroComplejo sumarNumerosComplejos(NumeroComplejo p_objNumeroComplejo) {
        double resultadoParteReal = parteReal + p_objNumeroComplejo.parteReal;
        double resultadoParteImaginaria = parteImaginaria + p_objNumeroComplejo.parteImaginaria;


        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo restarNumerosComplejos(NumeroComplejo p_objNumeroComplejo) {
        double resultadoParteReal = parteReal - p_objNumeroComplejo.parteReal;
        double resultadoParteImaginaria = parteImaginaria - p_objNumeroComplejo.parteImaginaria;

        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo multiplicarNumerosComplejos(NumeroComplejo p_objNumeroComplejo){
        double resultadoParteReal = ((parteReal*p_objNumeroComplejo.parteReal)+((parteImaginaria*p_objNumeroComplejo.parteImaginaria)*-1));
        double resultadoParteImaginaria = ((parteReal*p_objNumeroComplejo.parteImaginaria)+(parteImaginaria*p_objNumeroComplejo.parteReal));

        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    public NumeroComplejo dividirNumerosComplejos(NumeroComplejo p_objNumeroComplejo){
        double conjugado = (p_objNumeroComplejo.parteImaginaria)*-1;
        double divisor = (double)((Math.pow(p_objNumeroComplejo.parteReal, 2))+(Math.pow(p_objNumeroComplejo.parteImaginaria, 2)));

        double resultadoParteReal = (((parteReal*p_objNumeroComplejo.parteReal)+((parteImaginaria*conjugado)*-1))/divisor);
        double resultadoParteImaginaria = (((parteReal*conjugado)+(parteImaginaria*p_objNumeroComplejo.parteReal))/divisor);


        NumeroComplejo objResultado = new NumeroComplejo(resultadoParteReal, resultadoParteImaginaria);
        return objResultado;
    }

    

    NumeroComplejo(double p_parteReal, double p_parteImaginaria){
        parteReal = p_parteReal;
        parteImaginaria = p_parteImaginaria;
    }
}

class Utilities{

   public NumeroComplejo llamarOperacionCompleja(NumeroComplejo numeroComplejo1, NumeroComplejo numeroComplejo2, String operador){
        NumeroComplejo numeroComplejoResultado;

        switch (operador) {
            case "+":
                numeroComplejoResultado = numeroComplejo1.sumarNumerosComplejos(numeroComplejo2);
                break;
            case "-":
                numeroComplejoResultado = numeroComplejo1.restarNumerosComplejos(numeroComplejo2);
                break;
            case "*":
                numeroComplejoResultado = numeroComplejo1.multiplicarNumerosComplejos(numeroComplejo2);
                break;
            case "/":
                numeroComplejoResultado = numeroComplejo1.dividirNumerosComplejos(numeroComplejo2);
                break;
            default:
                numeroComplejoResultado = new NumeroComplejo(0.0, 0.0);
                break;
        }
        numeroComplejoResultado.setParteReal(redondearDecimales(numeroComplejoResultado.getParteReal()));
        numeroComplejoResultado.setParteImaginaria(redondearDecimales(numeroComplejoResultado.getParteImaginaria()));

        return numeroComplejoResultado;
   }

   public double obtenerValorParteImaginaria(String parteImaginaria) {
        String valorParteImaginaria = "";
        char cifraParteImaginaria;
        int index;

        for(index = parteImaginaria.length()-2;index >= 0; index--){
            cifraParteImaginaria = parteImaginaria.charAt(index);
            valorParteImaginaria = cifraParteImaginaria + valorParteImaginaria;
        }
        
        return (Double.parseDouble(valorParteImaginaria));
   }

   public void mostrarResultado(NumeroComplejo numeroComplejoResultado){
        String operadorMostrar = " ";

        if(numeroComplejoResultado.getParteImaginaria() >= 0.0){
            operadorMostrar = " +";
        }

        System.out.println(numeroComplejoResultado.getParteReal() + operadorMostrar + numeroComplejoResultado.getParteImaginaria());
   }

    private double redondearDecimales(double numeroRedondear){
        int index = 0;
        char decimal;
        boolean seRedondeoNumero = false;
        String decimales = Double.toString(numeroRedondear);
        String numeroRedondeado = "";

        while (!seRedondeoNumero) {
            decimal = decimales.charAt(index);

            if(Character.compare(decimal, '.') != 0){
                numeroRedondeado = decimal + numeroRedondeado;
                index++;
            }
            else if(Character.compare(decimal, '.') == 0){
                numeroRedondeado += decimal;
                decimal = decimales.charAt((++index));
                numeroRedondeado += decimal ;
                seRedondeoNumero = true;
            }
            
        }
        return Double.parseDouble(numeroRedondeado);
    }
}