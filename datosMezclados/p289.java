package Problemario.datosMezclados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p289 {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        Scanner input = new Scanner(System.in);
        String cadenaDatos;
        int casosPrueba, casosResueltos;

        casosPrueba = Integer.parseInt(input.nextLine());

        for(casosResueltos = 0; casosResueltos < casosPrueba; casosResueltos++){
            try {
                cadenaDatos = input.nextLine();
                utilidades.realizarOperacionesMostrarResultados(cadenaDatos);
                input.close();
            } catch (Exception e) {
                
            }
        }  
    }
}


class Estructuras{
    VerificadorOutput verificador = new VerificadorOutput();
    private Stack<Integer> pila = new Stack<>();
    private Queue<Integer> cola = new LinkedList<>();
    private int elementosPila, elementosCola;
    
    public void input(int valorEntrada, boolean operacionParaPila){
        if(operacionParaPila){
            pila.push(valorEntrada);
            elementosPila++;
        }else{
            cola.add(valorEntrada);
            elementosCola++;
        }
    }

    public String output(String cadenaValoresFinales, boolean operacionParaPila){
        String underFlowPila = "##", underFlowCola = "$$";

        if(operacionParaPila){
            if(verificador.sePuedeHacerOutput(elementosPila)){
                return cadenaValoresFinales += pila.pop();
            }
            else{
                return cadenaValoresFinales += underFlowPila;
            }
        }
        else{
            if(verificador.sePuedeHacerOutput(elementosCola)){
                return cadenaValoresFinales += cola.poll();
            }
            else{
                return cadenaValoresFinales += underFlowCola;
            }
        }
    }

    public String liberarDatosEstructuras(){
        String datosLiberados = "";
        datosLiberados += hacerFree(false);

        return datosLiberados += hacerFree(true);
    }
    private String hacerFree(boolean operacionParaPila){
        String datosLiberados = "";

        if(operacionParaPila){
            while(elementosPila > 0){
                datosLiberados += pila.pop();
                elementosPila--;
            }
            return datosLiberados;
        }
        else{
            while (elementosCola > 0) {
                datosLiberados += pila.peek();
                elementosCola--;
            }
            return datosLiberados;
        }
    }
}

class Utilidades{
    private Estructuras estructuras = new Estructuras();

    public void realizarOperacionesMostrarResultados(String cadenaDatos){
        String cadenaValoresFinales = "", operacionRealizar;
        boolean esOperacionPila;
        char arrayDatos[] = cadenaDatos.toCharArray();
        int elementosRecorridos = 0, valorEntrada;

        while (elementosRecorridos <= cadenaDatos.length()) {
            operacionRealizar = obtenerValor(arrayDatos, elementosRecorridos);

            if(operacionRealizar.equalsIgnoreCase("PU") || operacionRealizar.equalsIgnoreCase("LL")){
                elementosRecorridos += 2;
                valorEntrada = Integer.parseInt(obtenerValor(arrayDatos, elementosRecorridos));
                esOperacionPila = determinarEstructuraOperacion(operacionRealizar);
                estructuras.input(valorEntrada, esOperacionPila);
                elementosRecorridos += 2;
            }
            else{
                elementosRecorridos += 2;
                esOperacionPila = determinarEstructuraOperacion(operacionRealizar);          
                cadenaValoresFinales += estructuras.output(cadenaValoresFinales,esOperacionPila);
            }
        }
        mostrarValores(cadenaValoresFinales, estructuras);
    }

    private String obtenerValor(char[] arrayDatos, int elementosRecorridos){
        String operacion = "";
        int index;
        for ( index = 0; index < 2; index++) {
            operacion += arrayDatos[elementosRecorridos];
            elementosRecorridos++;
        }

        return operacion;
    }
    private boolean determinarEstructuraOperacion(String operacion){
        if(operacion.equalsIgnoreCase("PU") || operacion.equalsIgnoreCase("PO")){
            return true;
        }else{
            return false;
        }
    }

    public void mostrarValores(String cadenaValoresFinales, Estructuras estructuras){
        System.out.println(cadenaValoresFinales + estructuras.liberarDatosEstructuras());
    }
}

class VerificadorOutput{

    public boolean sePuedeHacerOutput(int elementosEstructura){
        if(elementosEstructura > 0){
            return true;
        }else{
            return false;
        }
    }
}


