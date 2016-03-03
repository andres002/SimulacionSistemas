/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static simulacion.so.FXMLDocumentController.quantum;
import static Procesos.GeneradorProcesos.cont;
import static simulacion.so.FXMLDocumentController.numProcesos;
import static simulacion.so.FXMLDocumentController.fx;
import static simulacion.so.FXMLDocumentController.Te;
import static simulacion.so.FXMLDocumentController.Resultados;
import static simulacion.so.FXMLDocumentController.parar;
import static simulacion.so.FXMLDocumentController.pararproceso;

/**
 *
 * @author ERIDE21
 */
public class RoundRobin implements Runnable {

    Thread T4;
    Integer q;



    public void activaHilo() {
        T4 = new Thread(new RoundRobin());
        T4.setName("Christopher Robin");
        T4.start();
    }

    public void asesinaHilo() {
        T4.stop();
    }

    @Override
    public void run() {
        while (true) {
            try {
                q = Integer.parseInt(quantum);
                Core c = new Core();
                if (!colaProcesos.isEmpty()) {
                    while (!bandera) {
                        System.out.println("haz nada");
                    }
                    bandera =false;
                    Proceso aux = colaProcesos.get(0); 
                    bandera = true;
                    if ((aux.ticks - q) > 0) {
                         int te = cont - aux.llegada;
                        //Te = Te + te;
                        //numProcesos++;
                        Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                                + "llegada: " + aux.llegada;
                        System.out.println("\n" + Resultados);
                        c.procesar(aux, q);
                        aux.llegada = cont;
                        aux.espera = aux.espera + te;
                        Thread.sleep(1000 * q);
                        //c.procesar(aux, q);
                        while (!bandera) {
                            System.out.println("haz nada");
                        }
                        bandera = false;
                        colaProcesos.add(colaProcesos.get(0));
                        colaProcesos.remove(0);
                        
                        bandera = true;
                    } else {
                        System.out.println("entra al elseeeeeeeeeeeeee");
                        int te = cont - aux.llegada;
                        Te += (te + aux.espera); 
                        
                        Thread.sleep(1000 * aux.ticks);
                       c.procesar(aux, aux.ticks);
                        Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                                + "llegada: " + aux.llegada;
                        System.out.println("\n"+Resultados);
                         numProcesos++;
                        while (!bandera) {
                            System.out.println("haz nada");
                        }
                         bandera = false;
                        colaProcesos.remove(0);
                         bandera = true;
                        
                    }

                }else{
                   if(parar){
                    System.out.println("Se terminaron los procesos");
                    pararproceso = true;
                    return;
                }
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
