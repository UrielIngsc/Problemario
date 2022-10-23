package Problemario.datosMezclados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p289 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            Utilidades utilidades = new Utilidades();
            String cadenaDatos;
            int casosPrueba, casosResueltos;

            casosPrueba = Integer.parseInt(input.nextLine());

            for(casosResueltos = 0; casosResueltos < casosPrueba; casosResueltos++){
                
                cadenaDatos = input.nextLine();
                utilidades.realizarOperaciones(cadenaDatos); 
            }  

            input.close();
        } catch (NumberFormatException e) {
            
        }

    }
}

class Utilidades{
    private int datosRecorridos = 0;
    private Pila pila = new Pila();
    private Cola cola = new Cola();
    private String cadenaDatosFinal = "";

    public void realizarOperaciones(String cadenaDatos){
        char arrayCadenaDatos[] = cadenaDatos.toCharArray();
        String infoObtenida;
        
        while (datosRecorridos < cadenaDatos.length()) {
            infoObtenida = obtenerInfo(arrayCadenaDatos);
            cadenaDatosFinal += evaluarOperacion(infoObtenida, arrayCadenaDatos);
        }

        mostrarResultados();
    }

    private String obtenerInfo(char[] arrayCadenaDatos){
        String infoObtenida = "";
        int index;

        for (index = 0;index < 2;index++) {
            infoObtenida += arrayCadenaDatos[datosRecorridos];
            datosRecorridos++;
        }
        return infoObtenida;
    }
    
    private String evaluarOperacion(String operacion, char[] arrayCadenaDatos){
        if(operacion.equalsIgnoreCase("PU") || operacion.equalsIgnoreCase("LL")){
            realizarInput(operacion, arrayCadenaDatos);
            return "";
        }else{
            return realizarOutput(operacion);
        }
    }

    private void realizarInput(String operacion, char[] arrayCadenaDatos){
        int valorEntrada = Integer.parseInt(obtenerInfo(arrayCadenaDatos));

        if(operacion.equalsIgnoreCase("PU")) pila.push(valorEntrada);
        else cola.in(valorEntrada);
    }

    private String realizarOutput(String operacion){
        if(operacion.equalsIgnoreCase("PO")){
            return cadenaDatosFinal += pila.pop(cadenaDatosFinal);
        }
        else{
            return cadenaDatosFinal += cola.out(cadenaDatosFinal);
        }
    }

    private void mostrarResultados(){
        liberarDatos();
        System.out.println(cadenaDatosFinal);
    }

    private void liberarDatos(){
        cadenaDatosFinal += cola.free();
        cadenaDatosFinal += pila.free();
    }
}


class Pila extends UtilidadesEstructuras{
    private Stack<Integer> pila = new Stack<>();
    private int elementosPila = 0;
    private String underFlow = "##";

    public int getElementosPila() {
        return elementosPila;
    }
    public Stack<Integer> getPila() {
        return pila;
    }

    public void push(int valorEntrada){
        pila.push(valorEntrada);
        elementosPila++;
    }
    public String pop(String cadenaValoresFinales){
        String elementoSalida;
        if(verificarOutput(elementosPila)){
            elementosPila--;
            elementoSalida = String.valueOf(pila.pop());
            return cadenaValoresFinales += elementoSalida;
        }
        else {
            elementoSalida = underFlow;
            return cadenaValoresFinales += elementoSalida;
        }
    }
    public String free(){
        String valoresLiberados = "", valorSalida;
        if(verificarOutput(elementosPila)){
            while(elementosPila > 0){
                valorSalida = String.valueOf(pila.pop());
                valoresLiberados += valorSalida;
                elementosPila--;
            }
            return valoresLiberados;
        }
        else{
            return valoresLiberados;
        }
    }
}

class Cola extends UtilidadesEstructuras{
    private Queue<Integer> cola = new LinkedList<>();
    private int elementosCola = 0;
    private String underflow = "$$";

    public Queue<Integer> getCola() {
        return cola;
    }
    public int getElementosCola() {
        return elementosCola;
    }

    public void in(int valorEntrada){
        cola.add(valorEntrada);
        elementosCola++;
    }
    public String out(String cadenaValoresFinales){
        String valorSalida;
        if(verificarOutput(elementosCola)){
            elementosCola--;
            valorSalida = String.valueOf(cola.remove());
            return cadenaValoresFinales += valorSalida;
        }else{
            valorSalida = underflow;
            return cadenaValoresFinales += underflow;
        }
    }
    public String free(){
        String valoresLiberados = "", valorSalida;
        if(verificarOutput(elementosCola)){
            while(elementosCola > 0){
                valorSalida = String.valueOf(cola.remove());
                valoresLiberados += valorSalida;
                elementosCola--;
            }
            return valoresLiberados;
        }
        else{
            return valoresLiberados;
        }
    }
}
class UtilidadesEstructuras{
    protected boolean verificarOutput(int elementosTotales){
        if(elementosTotales > 0 ) return true;
        else return false;
    }
    // protected String aplicarFormato(String cadenaValoresFinales, String valorSalida){
    //     if(cadenaValoresFinales.length() == 0){return valorSalida + ",";}
    //     else{return "," + valorSalida;}
    // }
}
