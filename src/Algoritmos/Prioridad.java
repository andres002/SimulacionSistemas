/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import static Algoritmos.RoundRobin.cont_ticks;
import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static Procesos.GeneradorProcesos.cont;
import static simulacion.so.FXMLDocumentController.numProcesos;
import static simulacion.so.FXMLDocumentController.fx;
import static simulacion.so.FXMLDocumentController.parar;
import static simulacion.so.FXMLDocumentController.Te;
import static simulacion.so.FXMLDocumentController.Resultados;
import static simulacion.so.FXMLDocumentController.Tp;
import static simulacion.so.FXMLDocumentController.Tr;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static simulacion.so.FXMLDocumentController.pararproceso;

/**
 *
 * @author ERIDE21
 */
public class Prioridad implements Runnable {

    Core procesador = new Core();
    Thread T3;

    

    public void activaHilo() {
        T3 = new Thread(new Prioridad());
        T3.setName("Andres");
        T3.start();
    }

    public void asesinaHilo() {
        T3.stop();
    }
    public boolean vive(){
        return T3.isAlive();
    }
static int recorrido;
    @Override
    public void run() {
        while (true) {

            if (!colaProcesos.isEmpty()) {
                Proceso aux,aux2;
               // int i=1;
                aux = colaProcesos.get(0);
                int temp = aux.tipo;
                int limite = colaProcesos.size();
                
                for ( recorrido = 1; recorrido < limite; recorrido++) {
                    aux2 = colaProcesos.get(recorrido);
                    if (aux2.tipo < aux.tipo) {
                        aux = aux2;
                        //temp = aux.tipo;
                    }
               }
                while (!bandera) {
                    System.out.println("haz nada");
                }
                try {
                    int te = cont - aux.llegada;
                    double tr = te + aux.ticks;
                    double tp = (te + aux.ticks) / aux.ticks.doubleValue();
                    System.out.println("Valor de tp "+ tp);
                    Te = Te + te;
                    numProcesos++;
                    Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks + "Prioridad: "+aux.tipo
                            + " Llegada: " + aux.llegada + " Tr: "+ tr + " Tp: "
                            + tp;
                    cont_ticks += aux.ticks;
                    Tr += te + aux.ticks;
                    System.out.println("\n" + Resultados);
                    Thread.sleep(1000 * aux.ticks);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Prioridad.class.getName()).log(Level.SEVERE, null, ex);
                }
                procesador.procesar(aux, aux.ticks);
                colaProcesos.remove(aux);

            }else{
                if(parar){
                    //T3.stop();
                    pararproceso = true;
                }
            }
            

            
            recorrido=1;
        }

    }
}
