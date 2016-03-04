/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;
import static Algoritmos.RoundRobin.cont_ticks;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;
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
 * @author Andres
 */
public class FCFS  implements Runnable{
    Thread T1;
    
     
    
     
    public void activaHilo(){
        T1 = new Thread (new FCFS());
        T1.setName("Edgardo");
        T1.start();
    }
    public void asesinaHilo(){
        T1.stop();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Core c = new Core();
                //System.out.println(!colaProcesos.isEmpty());
                if (!colaProcesos.isEmpty()) {
                    while (!bandera) {
                        System.out.println("haz nada");
                    }
                    //Proceso aux = colaProcesos.get(0);
                    //System.out.println("nombre: " + aux.nombre
                    System.out.println("aqui imprimimos el cooooooooont ---  " + cont);
                    double te = cont-colaProcesos.get(0).llegada;
                    double tr = te + colaProcesos.get(0).ticks;
                    double tp = (te + colaProcesos.get(0).ticks) / colaProcesos.get(0).ticks;
                    Te = Te + te;
                    numProcesos++;
                    
                    Resultados = colaProcesos.get(0).nombre + ": TE: " + te + " Ticks: " + colaProcesos.get(0).ticks
                            + " Llegada: " + colaProcesos.get(0).llegada + " Tr: "+ tr + " Tp: "
                            + tp;
                    Tr += te + colaProcesos.get(0).ticks;
                    Tp += (te + colaProcesos.get(0).ticks) / colaProcesos.get(0).ticks;
                    System.out.println("\n" + Resultados);
                    System.out.println("aqui imprimimos el TIIIIIIIIICKS ---  " + colaProcesos.get(0).ticks);
                    Thread.sleep(1000 * colaProcesos.get(0).ticks);
                    System.out.println("despues de dormir");
                    //fx.setResultados();
                    cont_ticks += colaProcesos.get(0).ticks;
                    c.procesar(colaProcesos.get(0), colaProcesos.get(0).ticks);
                    colaProcesos.remove(0);
                }else{
                if(parar){
                    System.out.println("Se terminaron los procesos");
                    pararproceso = true;
                    return;
                }
            }

                
            } catch (InterruptedException ex) {
                Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
            }

                
            
        }
        
    }
}
