package Problemario.LosEmpleados;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class p360 {
    public static void main(String[] args) {
        Utilidades utilidades = new Utilidades();
        String datosLeidos[];
        
        do {
            datosLeidos = utilidades.leerDatos();

        } while (datosLeidos != null);
        
    }
}

class Persona {
    private String nombre, puesto;
    private float sueldo;
    private int antiguedad;

    public int getAntiguedad() {
        return antiguedad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPuesto() {
        return puesto;
    }
    public float getSueldo() {
        return sueldo;
    }

    Persona(String nombre, String puesto, float sueldo, int antiguedad){
        this.antiguedad = antiguedad;
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }
}

class Utilidades{

    public String[] leerDatos(){
        Scanner input = new Scanner(System.in);
        String nombreEmpleadoUno, nombreEmpleadoDos, nombreEmpleadoTres, rutaArchivo = "";
        String datosLeidos[] = new String[4];

        try {
            rutaArchivo = input.nextLine();
            nombreEmpleadoUno = input.nextLine();
            nombreEmpleadoDos = input.nextLine();
            nombreEmpleadoTres = input.nextLine();

            datosLeidos[0] = rutaArchivo;
            datosLeidos[1] = nombreEmpleadoUno;
            datosLeidos[2] = nombreEmpleadoDos;
            datosLeidos[3] = nombreEmpleadoTres;

        } catch (Exception e) {
            System.err.println(e);
        }
        input.close();
        return datosLeidos;
    }

    public void leerArchivoProcesarDatos(String[] datosLeidos) throws IOException, ClassNotFoundException{
        FileInputStream archivoEntrada = new FileInputStream(datosLeidos[0]);
        ObjectInputStream objetoPersonaEntrada = new ObjectInputStream(archivoEntrada);
        ArrayList<Persona> empleadosExistentes = new ArrayList<>();
        int empleadosConAntiguedad = 0;
        float pagaPuesto = 0.0f;
        
        Persona empleadoLeido = (Persona) objetoPersonaEntrada.readObject();
        
        while(empleadoLeido != null){
            if(empleadoLeido.getAntiguedad() > 20){empleadosConAntiguedad++;}
            if(empleadoLeido.getPuesto().equalsIgnoreCase("nivel")){pagaPuesto = empleadoLeido.getSueldo();}

            if(existeEmpleado(empleadoLeido, datosLeidos)){
                empleadosExistentes.add(empleadoLeido);
            }
            empleadoLeido = (Persona) objetoPersonaEntrada.readObject();
        }

        System.out.println(empleadosConAntiguedad);
        System.out.println("$"+pagaPuesto);
        imprimirEmpleados(datosLeidos, empleadosExistentes);

        archivoEntrada.close();
        objetoPersonaEntrada.close();
    }

    private boolean existeEmpleado(Persona empleadoLeido, String[] datosLeidos){
        if(empleadoLeido.getNombre().equalsIgnoreCase(datosLeidos[1])){
            return true;
        }
        else if(empleadoLeido.getNombre().equalsIgnoreCase(datosLeidos[2])){
            return true;
        }
        else if(empleadoLeido.getNombre().equalsIgnoreCase(datosLeidos[3])){
            return true;
        }
        else{
            return false;
        }
    }
    private void imprimirEmpleados(String[] datosLeidos, ArrayList<Persona> empleadosExistentes){
        
    }
}