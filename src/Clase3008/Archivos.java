package Clase3008;

import java.io.FileNotFoundException;

public class Archivos {
    public static void main(String[] args) throws FileNotFoundException {
       ScanPrintWriter objScanPrintWriter = new ScanPrintWriter("src/Archivos/Numeros.txt", false);

       int contador;

       for(contador = 0;contador < 3;contador++){
        objScanPrintWriter.escribirArchivo(Math.random(), true);
       }
       
       objScanPrintWriter.cerrarEntradaSalida(false);

       objScanPrintWriter = new ScanPrintWriter("src/Archivos/Numeros.txt", true);

       while(contador >= 0){
            System.out.println(objScanPrintWriter.leerLinea());
            contador--;
       }

       objScanPrintWriter.cerrarEntradaSalida(true);
    
    }
}
