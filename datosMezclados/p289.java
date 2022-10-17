package Problemario.datosMezclados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p289 {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        Scanner input = new Scanner(System.in);
        String cadenaDatos = "";
        int casosPrueba, casosResueltos;

        casosPrueba = Integer.parseInt(input.nextLine());

        for(casosResueltos = 0; casosResueltos < casosPrueba; casosResueltos++){
            cadenaDatos = input.nextLine();


        }

        input.close();
        
    }
    
}


class Estructuras{
    private Stack<Integer> pila = new Stack<>();
    private Queue<Integer> cola = new LinkedList<>();
    
    public void input(int valorEntrada, boolean esInputPila){
        if(esInputPila){
            pila.push(valorEntrada);
        }else{
            cola.add(valorEntrada);
        }
    }

    public int output(boolean esOutputPila){
        if(esOutputPila){
            return pila.pop();
        }else{
            return cola.poll();
        }
    }
}

class Utilidades{
    public String realizarOperaciones(String cadenaDatos){
        String cadenaValoresFinales = "", operacionRealizar;
        String underFlowPila = "##", underFlowCola = "$$";
        char arrayDatos[] = cadenaDatos.toCharArray();
        int largoOperacionOutput = 2;
        int elementosRecorridos = 0, valorEntrada;


        while (elementosRecorridos < cadenaDatos.length()) {
            operacionRealizar = obtenerOperacionRealizar(arrayDatos, elementosRecorridos);


        }
        

        return cadenaValoresFinales;
    }

    private String obtenerOperacionRealizar(char[] arrayDatos, int elementosRecorridos){
        String operacion = "";
        int index;
        for ( index = 0; index < 2; index++) {
            operacion += arrayDatos[elementosRecorridos];
            elementosRecorridos++;
        }

        return operacion;
    }
    private 
}



