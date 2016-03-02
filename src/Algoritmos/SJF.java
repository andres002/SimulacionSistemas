/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Procesos.Core;
import Procesos.Proceso;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static Procesos.Core.bandera;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Procesos.GeneradorProcesos.cont;
import static simulacion.so.FXMLDocumentController.numProcesos;
import static simulacion.so.FXMLDocumentController.fx;
import static simulacion.so.FXMLDocumentController.Te;
import static simulacion.so.FXMLDocumentController.Resultados;
import static simulacion.so.FXMLDocumentController.Tp;
import static simulacion.so.FXMLDocumentController.Tr;
import static simulacion.so.FXMLDocumentController.parar;
import static simulacion.so.FXMLDocumentController.pararproceso;

/**
 *
 * @author ERIDE21
 */
public class SJF implements Runnable {

    Core procesador = new Core();
    Thread T2;

    public void algoritmo() {
       

    }

    public void activaHilo() {
        T2 = new Thread(new SJF());
        T2.setName("Edgardo");
        T2.start();
    }

    public void asesinaHilo() {
            T2.stop();
    }
    
    public boolean vive(){
        return T2.isAlive();
    }

    @Override
    public void run() {
        while (true) {

            try {
                if (!colaProcesos.isEmpty()) {
                    while (!bandera) {
                        System.out.println("haz nada");
                    }
                    Proceso aux;
                    aux = colaProcesos.get(0);
                    Integer temp = aux.ticks.intValue();
                    //int sizeNow = colaProcesos.size();
                    for (int i = 1; i < colaProcesos.size(); i++) {
                        if (colaProcesos.get(i).ticks.intValue() < temp) {
                            aux = colaProcesos.get(i);
                            temp = aux.ticks.intValue();
                        }
                    }
                    double te = cont-aux.llegada;
                    double tr = te + aux.ticks;
                    double tp = (te + aux.ticks) / aux.ticks;
                    Te = Te + te;
                    numProcesos++;
                    Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                            + " Llegada: " + aux.llegada+ " Tr: "+ tr + " Tp: "
                            + tp;
                    Tr += te + aux.ticks;
                    Tp += (te + aux.ticks) / aux.ticks;
                    System.out.println("\n" + Resultados);
                     Thread.sleep(1000*aux.ticks);
                    procesador.procesar(aux, aux.ticks);
                    colaProcesos.remove(aux);
                }else{
                if(parar){
                   System.out.println("Se terminaron los procesos");
                    pararproceso = true;
                    return;
                }
            }
               
            } catch (InterruptedException ex) {
                Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
