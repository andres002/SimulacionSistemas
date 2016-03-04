/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import static Algoritmos.Prioridad.recorrido;
import static Algoritmos.RoundRobin.cont_ticks;
import Procesos.Core;
import static Procesos.Core.bandera;
import static Procesos.Core.t_procesador;
import Procesos.Proceso;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static Procesos.GeneradorProcesos.cont;
import static simulacion.so.FXMLDocumentController.Resultados;
import static simulacion.so.FXMLDocumentController.Te;
import static simulacion.so.FXMLDocumentController.Tp;
import static simulacion.so.FXMLDocumentController.Tr;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static simulacion.so.FXMLDocumentController.numProcesos;
import static simulacion.so.FXMLDocumentController.parar;
import static simulacion.so.FXMLDocumentController.pararproceso;
import static simulacion.so.FXMLDocumentController.quantum;

/**
 *
 * @author Andres
 */
public class ColasMultinivel2 implements Runnable {

    Thread T6;
    ArrayList<Proceso> tipo_0 = new ArrayList();
    ArrayList<Proceso> tipo_1 = new ArrayList();
    ArrayList<Proceso> tipo_2 = new ArrayList();
    ArrayList<Proceso> tipo_3 = new ArrayList();
    Integer q;

    public void activaHilo() {
        T6 = new Thread(new FCFS());
        T6.setName("Nicky Minaj 2");
        T6.start();
    }

    public void asesinaHilo() {
        T6.stop();
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
                    while (!colaProcesos.isEmpty()) {
                        while (!bandera) {
                            System.out.println("haz nada");
                        }
                        bandera = false;
                        Proceso aux = colaProcesos.get(0);
                        bandera = true;
                        int tipo = aux.tipo;
                        switch(tipo){
                            case 0:
                                tipo_0.add(aux);                             
                            break;
                            case 1:
                                tipo_1.add(aux);
                            break;
                            case 2:
                                tipo_2.add(aux);
                            break;
                            case 3:
                                tipo_3.add(aux);
                            break;
                            default:
                                System.out.println("error, no debería entrar aqui");
                                break;
                        }
                        colaProcesos.remove(0);
                        while (!bandera) {
                            System.out.println("haz nada");
                        }
                    }
                    
                    if(!tipo_0.isEmpty()){
                        Proceso aux = tipo_0.get(0);
                        if ((aux.ticks - q) > 0) {
                            int te = t_procesador - aux.llegada;
                            Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                                    + " Llegada: " + aux.llegada;
                            //Te = Te + te;
                            //numProcesos++;
                            System.out.println("\n" + Resultados);
                            cont_ticks += (aux.ticks - (aux.ticks - q));
                            Tp = Tr / cont_ticks;
                            c.procesar(aux, q);
                            aux.llegada = t_procesador;
                            aux.espera = aux.espera + te;
                            Thread.sleep(1000 * q);
                            //c.procesar(aux, q);
                            while (!bandera) {
                                System.out.println("haz nada");
                            }
                            bandera = false;
                            colaProcesos.add(tipo_0.get(0));
                            bandera = true;
                            tipo_0.remove(0);

                            
                        } else {
                            System.out.println("entra al elseeeeeeeeeeeeee");
                            Resultados = aux.nombre + ": TE: " + (t_procesador - aux.llegada) + " Ticks: " + aux.ticks
                                    + " Llegada: " + aux.llegada;
                            System.out.println("\n" + Resultados);
                            cont_ticks += aux.ticks;
                            int te = t_procesador - aux.llegada;
                            Te += (te + aux.espera);
                            //int tr = te + cont_ticks;
                            Tr = Te + cont_ticks;
                            Thread.sleep(1000 * aux.ticks);
                            c.procesar(aux, aux.ticks);
                            //Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                            //      + " Llegada: " + aux.llegada;
                            //System.out.println("\n"+Resultados);
                            numProcesos++;                            
                            tipo_0.remove(0);
                        } 
                    }else if(!tipo_1.isEmpty()){
                        
                    }
                } else if (parar) {
                    System.out.println("Se terminaron los procesos");
                    pararproceso = true;
                    return;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
