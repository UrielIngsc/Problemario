package Clase3008;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScanPrintWriter {
    private Scanner readInFile;
    private PrintWriter writeInFile;

    ScanPrintWriter(String rutaArchivo, boolean esLectura) throws FileNotFoundException{
        if(esLectura){
            readInFile = new Scanner(new File(rutaArchivo));
        }
        else{
            writeInFile = new PrintWriter(new File(rutaArchivo));
        }
    }

    public String leerLinea(){
        if(readInFile.hasNextLine()){
            return readInFile.nextLine();
        }
        else{
            return "";
        }
    }

    public void escribirArchivo(double valorEscribir, boolean haySaltoLinea){
        if(haySaltoLinea){
            writeInFile.println(valorEscribir);
        }
        else{
            writeInFile.print(valorEscribir);
        }
    }

    public void cerrarEntradaSalida(boolean esLectura){
        if(esLectura){
            readInFile.close();
        }
        else{
            writeInFile.close();
        }
    }

}
