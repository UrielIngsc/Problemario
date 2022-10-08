package Problemario.PilaRestrictiva;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class p269 {
    public static void main(String[] args) {
        Pila pila;
        Scanner input = new Scanner(System.in);
        String accionRealizarPila = "";
        Utilidades utilidades = new Utilidades();
        int longitdPilaIngresada = 0;
        try {
            longitdPilaIngresada = Integer.parseInt(input.nextLine());
            if(longitdPilaIngresada > 0){
                pila = new Pila(longitdPilaIngresada);
                do {
                    accionRealizarPila = input.nextLine();
                    utilidades.efectuarAccionPila(accionRealizarPila, pila);
                } while (accionRealizarPila != "" || accionRealizarPila != null);
            }

        } catch (Exception e) {
        }
        
        input.close();
    }
}

class Pila {
    private int longitdPila;
    private int espaciosOcupados;
    private Stack<Integer> pila = new Stack<>();
    private VerificarAccionesPila verificadorAcciones = new VerificarAccionesPila();

    Pila(int longitdPila){
        this.longitdPila = longitdPila;
        this.espaciosOcupados = 0;
    }
    public int getLongitdPila() {
        return longitdPila;
    }
    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }

    public void push(int valorAlmacenar){
        if(verificadorAcciones.sePuedeHacerPush(longitdPila, espaciosOcupados)){
            pila.push(valorAlmacenar);
            espaciosOcupados++;
        }
        else{System.out.println("OVERFLOW "+valorAlmacenar);}
    }
    public void pop(){
        if(verificadorAcciones.sePuedeHacerPop(espaciosOcupados)){
            System.out.println(pila.pop());
            espaciosOcupados--;
        }
        else{System.out.println("UNDERFLOW");}
    }
    public void free(){
        if(verificadorAcciones.sePuedeHacerFree(espaciosOcupados)){
            while(espaciosOcupados > 0){
                System.out.println(pila.pop()); 
                espaciosOcupados--;
            }
        }
        else{System.out.println("UNDERFLOW");}
    }
}
class Utilidades{
    public void efectuarAccionPila(String accionRealizarPila, Pila pila){
        StringTokenizer stringTokenizer = new StringTokenizer(accionRealizarPila);
        String accionRealizar = stringTokenizer.nextToken();
        int valorAlmacenar;

        if(accionRealizar.equalsIgnoreCase("PUSH")){
            valorAlmacenar = Integer.parseInt(stringTokenizer.nextToken());
            verificarRealizarPush(valorAlmacenar, pila);
        }
        else if (accionRealizar.equalsIgnoreCase("POP")){
            pila.pop();
        }
        else if(accionRealizar.equalsIgnoreCase("FREE")){
            pila.free();
        }
        else{
            System.out.println("Operacion Invalida");
        }
    }  
    
    public void verificarRealizarPush(int valorAlmacenar, Pila pila){
        if(valorAlmacenar >= 1 && valorAlmacenar <= 99)pila.push(valorAlmacenar);
        else System.out.println("PUSH ERRONEO " + valorAlmacenar);
    }
}

class VerificarAccionesPila{
    public boolean sePuedeHacerPush(int longitudPila, int espaciosOcupados){
        if(espaciosOcupados < longitudPila) return true;
        else return false;
    }
    public boolean sePuedeHacerPop(int espaciosOcupados){
        if(espaciosOcupados > 0) return true;
        else return false;
    }
    public boolean sePuedeHacerFree(int espaciosOcupados){
        if(espaciosOcupados > 0) return true;
        else return false;
    }
}