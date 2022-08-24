package Problemario.EnterosLargos;

import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EnteroLargo numeroEnteroLargo1, numeroEnteroLargo2, resultadoSumaEnterosLargos ;

        int numCasosPrueba = input.nextInt();
        int contCasosPrueba = 1;
        String valorEnteroLargo1 = "", valorEnteroLargo2 = "";
        while (contCasosPrueba <= numCasosPrueba) {
            valorEnteroLargo1 = input.next();
            valorEnteroLargo2 = input.next();

            numeroEnteroLargo1 = new EnteroLargo(valorEnteroLargo1);
            numeroEnteroLargo2 = new EnteroLargo(valorEnteroLargo2);

            resultadoSumaEnterosLargos = numeroEnteroLargo1.sumarNumeros(numeroEnteroLargo2);

            System.out.println(resultadoSumaEnterosLargos.getValorEnteroLargo());

            contCasosPrueba++;
        }
        input.close();
    }
}


class EnteroLargo {
    private String valorEnteroLargo = "";

    public String getValorEnteroLargo() {
        return valorEnteroLargo;
    }

    public EnteroLargo sumarNumeros(EnteroLargo numeroEnteroLargo2) {
        Utilities utilidades = new Utilities();
        int index = 0, carrie = 0, sumaCifras = 0;
        char cifraNumeroEnteroLargo1, cifraNumeroEnteroLargo2;
        boolean seTerminoSuma = false;
        String sumaEnterosLargos = "", auxSumaCifras;

        if(valorEnteroLargo.length() != numeroEnteroLargo2.valorEnteroLargo.length()){

            if(valorEnteroLargo.length() > numeroEnteroLargo2.valorEnteroLargo.length()){

                numeroEnteroLargo2.valorEnteroLargo = utilidades.igualarLogitudNumeros(valorEnteroLargo, numeroEnteroLargo2.valorEnteroLargo);
            }else{
                valorEnteroLargo = utilidades.igualarLogitudNumeros(valorEnteroLargo, numeroEnteroLargo2.valorEnteroLargo);
            }
        }

        index = (valorEnteroLargo.length()-1);
        
        while (!seTerminoSuma) {

            cifraNumeroEnteroLargo1 = valorEnteroLargo.charAt(index);
            cifraNumeroEnteroLargo2 = numeroEnteroLargo2.valorEnteroLargo.charAt(index);

            sumaCifras = Character.getNumericValue(cifraNumeroEnteroLargo1) + Character.getNumericValue(cifraNumeroEnteroLargo2) + carrie;
            auxSumaCifras = String.valueOf(sumaCifras);
            
            if(sumaCifras > 9 && index != 0){
                carrie = 1;
                sumaEnterosLargos = String.valueOf(auxSumaCifras.charAt(1)) + sumaEnterosLargos;
            }else if(sumaCifras > 9 && index == 0){
                carrie = 0;
                sumaEnterosLargos = sumaCifras + sumaEnterosLargos;
            }else{
                carrie = 0;
                sumaEnterosLargos = sumaCifras + sumaEnterosLargos;
            }

            if(index == 0){
                seTerminoSuma = true;
            }
            
            index--;
        }

        EnteroLargo resultadoSumaEnteros = new EnteroLargo(sumaEnterosLargos);
        return resultadoSumaEnteros;
    }

    EnteroLargo(String p_valorEnteroLargo){
        valorEnteroLargo = p_valorEnteroLargo;
    }
}

class Utilities{
    public String igualarLogitudNumeros(String p_valEnteroLargo1, String p_valEnteroLargo2){
        int diferenciaLongitud = 0;
        int contador = 0;
        String numeroLongitudMenor = "";

        if(p_valEnteroLargo1.length() > p_valEnteroLargo2.length()){
            numeroLongitudMenor = p_valEnteroLargo2;
            diferenciaLongitud = p_valEnteroLargo1.length() - p_valEnteroLargo2.length();
        }else{
            numeroLongitudMenor = p_valEnteroLargo1;
            diferenciaLongitud = p_valEnteroLargo2.length() - p_valEnteroLargo1.length();
        }

        for(contador = 0; contador < diferenciaLongitud;contador++){
            numeroLongitudMenor = "0" + numeroLongitudMenor;
        }

        return numeroLongitudMenor;
    }
}