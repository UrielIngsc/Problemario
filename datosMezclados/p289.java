package Problemario.datosMezclados;

import java.util.Scanner;

public class p289 {
    public static void main(String[] args) {
        String instrucciones;
        int casosPrueba, contador;
        Utilidades utilidades;

        try (Scanner input = new Scanner(System.in)) {
            casosPrueba = Integer.parseInt(input.nextLine());
            for ( contador = 0; contador < casosPrueba; contador++) {
                instrucciones = input.nextLine();
                utilidades = new Utilidades(instrucciones);
                utilidades.procesarInstrucciones();
            }
            
        }
    }
    
}

class Utilidades{
    private Estructuras estructuras;
    private String valoresFinales, instrucciones;
    private char[] arrayInstrucciones;
    private int datosRecorridos;


    public void procesarInstrucciones(){
        String infoInstruccion;
        

        while(datosRecorridos < instrucciones.length()){
            infoInstruccion = obtenerInfo();
            procesarInstruccion(infoInstruccion);
        }
        

    }
    private String obtenerInfo(){
        String info = "";
        int contador;

        for (contador = 0; contador < 2; contador++) {
            info += arrayInstrucciones[datosRecorridos];
            datosRecorridos++;
        }
        System.out.println(info);
        return info;
    }

    private void procesarInstruccion(String infoInstruccion){

        if(infoInstruccion.equalsIgnoreCase("PU") || infoInstruccion.equalsIgnoreCase("LL")){
            realizarInput(infoInstruccion);
        }else{
            realizarOutput(infoInstruccion);
        }
    }
    private void realizarInput(String infoInstruccion){
        String valorEntrada = obtenerInfo();

        if(infoInstruccion.equalsIgnoreCase("PU")){
            estructuras.pila.push(valorEntrada);
        }else{
            estructuras.cola.in(valorEntrada);
        }
    }
    private void realizarOutput(String infoInstruccion){

        if(infoInstruccion.equalsIgnoreCase("PO")){
            valoresFinales += estructuras.pila.pop();
        }else{
            valoresFinales += estructuras.cola.out();
        }
    }

    Utilidades(String instrucciones){
        datosRecorridos = 0;
        valoresFinales = "";
        estructuras = new Estructuras();
        this.instrucciones = instrucciones;
        arrayInstrucciones = instrucciones.toCharArray();
    }

}

class Estructuras{
    Cola cola;
    Pila pila;

    Estructuras(){
        cola = new Cola();
        pila = new Pila();
    }
}

class Cola{
    private Nodo inicio, end;
    private String underFlow = "$$";

    void in(String valorEntrada){
        Nodo nodoEntrada = new Nodo(valorEntrada);
        if(inicio == null){
            inicio = end = nodoEntrada;
        }else{
            end.siguiente = nodoEntrada;   
        }
    }

    String out(){
        Nodo nodoAux;
        if(inicio != null){
            nodoAux = inicio;
            inicio = inicio.siguiente;
            return nodoAux + ",";
        }else{
            return underFlow + ",";
        }
    }
    

    Cola(){
        inicio = null;
    }
}

class Pila{
    private Nodo tope;
    private String underflow = "##";

    void push(String valorEntrada){
        Nodo nodoEntrada = new Nodo(valorEntrada);
        Nodo nodoAux;

        if(tope == null){
            tope = nodoEntrada;
        }else{
            nodoAux = tope;
            tope = nodoEntrada;
            tope.siguiente = nodoAux;
        }
    }

    String pop(){
        Nodo nodoAux;
        if(tope != null){
            nodoAux = tope;
            tope.siguiente = tope;
            return nodoAux.info + ",";
        }else{
            return underflow + ",";
        }
    }
    Pila(){
        tope = null;
    }
}

class Nodo{
    String info;
    Nodo siguiente;

    Nodo(String info){
        this.info = info;
        siguiente = null;
    }
}