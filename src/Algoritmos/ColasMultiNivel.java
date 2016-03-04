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
 * @author ERIDE21
 */
public class ColasMultiNivel implements Runnable {

    Thread T5;
    ArrayList<Proceso> tipo_0 = new ArrayList();
    ArrayList<Proceso> tipo_1 = new ArrayList();
    ArrayList<Proceso> tipo_2 = new ArrayList();
    ArrayList<Proceso> tipo_3 = new ArrayList();
    Integer q;

    public void algoritmo() {
        Core c = new Core();
        while (!bandera) {
            System.out.println("haz nada algoritmo");
        }
        // bandera = false;
        if (!colaProcesos.isEmpty()) {
            // bandera = true;
            ////////////////////
            while (!colaProcesos.isEmpty()) {
                while (!bandera) {
                    System.out.println("haz nada algoritmo");
                }
                bandera = false;
                int tipo = colaProcesos.get(0).tipo;
                bandera = true;
                if (tipo == 0) {
                    while (!bandera) {
                        System.out.println("haz nada algoritmo");
                    }
                    bandera = false;
                    tipo_0.add(colaProcesos.get(0));
                    bandera = true;
                }
                if (tipo == 1) {
                    while (!bandera) {
                        System.out.println("haz nada algoritmo");
                    }
                    bandera = false;
                    tipo_1.add(colaProcesos.get(0));
                    bandera = true;
                }
                if (tipo == 2) {
                    while (!bandera) {
                        System.out.println("haz nada algoritmo");
                    }
                    bandera = false;
                    tipo_2.add(colaProcesos.get(0));
                    bandera = true;
                }
                if (tipo == 3) {
                    while (!bandera) {
                        System.out.println("haz nada algoritmo");
                    }
                    bandera = false;
                    tipo_3.add(colaProcesos.get(0));
                    bandera = true;
                }
                while (!bandera) {
                    System.out.println("haz nada algoritmo");
                }
                bandera = false;
                colaProcesos.remove(0);
                bandera = true;
            }
            //////////////////

            ///////////////////
            q = Integer.parseInt(quantum);
            if (!tipo_0.isEmpty()) {

                if ((tipo_0.get(0).ticks - q) >= 0) {
                    //int aux = q-tipo_0.get(0).ticks;
                    c.procesar(tipo_0.get(0), q);
                } else {
                    c.procesar(tipo_0.get(0), tipo_0.get(0).ticks);
                    tipo_0.remove(0);
                }

                //tipo_0.remove(0);
                //return;
            }
            if (!tipo_1.isEmpty()) {
                Proceso aux = tipo_1.get(0);
                Proceso aux2;
                int i = 1;
                int limite = tipo_1.size();
                for (i = 1; i < limite; i++) {
                    while (!bandera) {
                        System.out.println("haz nada algoritmo");
                    }
                    bandera = false;
                    aux2 = colaProcesos.get(i);
                    bandera = true;
                    if (aux2.tipo < aux.tipo) {
                        aux = aux2;
                        //temp = aux.tipo;
                    }
                }
                c.procesar(aux, aux.ticks);
                tipo_1.remove(i);
                //return;
            }
            if (!tipo_2.isEmpty()) {
                c.procesar(tipo_2.get(0), tipo_2.get(0).ticks);
                tipo_2.remove(0);
                //return;
            }
            if (!tipo_3.isEmpty()) {
                c.procesar(tipo_3.get(0), tipo_3.get(0).ticks);
                tipo_3.remove(0);
                //return;
            }
            ///////////////////
            /* Proceso aux;
             aux = colaProcesos.get(0);
             int temp = aux.tipo;
             for (int i = 1; i < colaProcesos.size(); i++) {
             if (colaProcesos.get(i).tipo < temp) {
             aux = colaProcesos.get(i);
             temp = aux.tipo;
             }
             }*/

            // c.procesar(aux, aux.tipo);
            // colaProcesos.remove(aux);
        }
    }

    public void activaHilo() {
        T5 = new Thread(new ColasMultiNivel());
        T5.setName("Nicky Minaj");
        T5.start();
    }

    public void asesinaHilo() {
        T5.stop();
    }

    @Override
    public void run() {
        while (true) {
            int i = 1;
            Core c = new Core();
            while (!bandera) {
                System.out.print("");
            }
            bandera = false;
            if (!colaProcesos.isEmpty()) {
                bandera = true;
                ///////////// OBTIENE LOS PROCESOS DE LA COLA PADRE Y LOS ALMACENA EN SU RESPECTIVA COLA (inicio)
                while (!colaProcesos.isEmpty()) {
                    while (!bandera) {
                        System.out.print("");
                    }
                    bandera = false;
                    int tipo = colaProcesos.get(0).tipo;
                    bandera = true;
                    if (tipo == 0) {
                        while (!bandera) {
                            System.out.print("");
                        }
                        bandera = false;
                        tipo_0.add(colaProcesos.get(0));
                        bandera = true;
                    } else if (tipo == 1) {
                        while (!bandera) {
                            System.out.print("");
                        }
                        bandera = false;
                        tipo_1.add(colaProcesos.get(0));
                        bandera = true;
                    } else if (tipo == 2) {
                        while (!bandera) {
                            System.out.print("");
                        }
                        bandera = false;
                        tipo_2.add(colaProcesos.get(0));
                        bandera = true;
                    } else if (tipo == 3) {
                        while (!bandera) {
                            System.out.print("");
                        }
                        bandera = false;
                        tipo_3.add(colaProcesos.get(0));
                        bandera = true;
                    }
                    System.out.println("Proceso 0: " + colaProcesos.size());
                    while (!bandera) {
                        System.out.print("");
                    }
                    bandera = false;
                    colaProcesos.remove(0);
                    bandera = true;
                }
                ///////////// OBTIENE LOS PROCESOS DE LA COLA PADRE Y LOS ALMACENA EN SU RESPECTIVA COLA (fin)

                q = Integer.parseInt(quantum);

                ////////////COMIENZA ROUND ROBIN CON PROCESOS TIPO 0 (inicio)
                if (!tipo_0.isEmpty()) {

                    Proceso aux = tipo_0.get(0);

                    if (aux.ticks - q > 0) {
                        int te = t_procesador - aux.llegada;
                        Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks
                                + " Llegada: " + aux.llegada;
                        c.procesar(aux, q);
                        System.out.println("\n" + Resultados);
                        cont_ticks += (aux.ticks - (aux.ticks - q));
                        Tp = Tr / cont_ticks;
                        c.procesar(aux, q);
                        aux.llegada = t_procesador;
                        aux.espera = aux.espera + te;
                        try {
                            Thread.sleep(1000 * q);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ColasMultiNivel.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        colaProcesos.add(tipo_0.get(0));
                        tipo_0.remove(0);

                    } else {
                        System.out.println("entra al elseeeeeeeeeeeeee");
                        Resultados = aux.nombre + ": TE: " + (t_procesador - aux.llegada) + " Ticks: " + aux.ticks
                                + " Llegada: " + aux.llegada;
                        System.out.println("\n" + Resultados);
                        cont_ticks += aux.ticks;
                        int te = t_procesador - aux.llegada;
                        Te += (te + aux.espera);
                        Tr = Te + cont_ticks;
                        try {
                            Thread.sleep(1000 * aux.ticks);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ColasMultiNivel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        c.procesar(aux, aux.ticks);

                        numProcesos++;
                        while (!bandera) {
                            System.out.println("haz nada");
                        }
                        bandera = false;
                        colaProcesos.remove(0);
                        bandera = true;
                    }

                } ////////////COMIENZA ROUND ROBIN CON PROCESOS TIPO 0 (inicio)
                ///////////COMIENZA PRIORIDAD CON PROCESOS TIPO 1 (inicio)
                else if (!tipo_1.isEmpty()) {
                    System.out.println("Numero de procesos de tipo 1: " + tipo_1.size());

                    Proceso aux, aux2;
                    aux = tipo_1.get(0);
                    int temp = aux.tipo;
                    int limite = tipo_1.size();

                    for (recorrido = 1; recorrido < limite; recorrido++) {
                        aux2 = tipo_1.get(recorrido);
                        if (aux2.tipo < aux.tipo) {
                            aux = aux2;
                            //temp = aux.tipo;
                        }
                    }
                    try {
                        int te = cont - aux.llegada;
                        double tr = te + aux.ticks;
                        double tp = (te + aux.ticks) / aux.ticks.doubleValue();
                        System.out.println("Valor de tp " + tp);
                        Te = Te + te;
                        numProcesos++;
                        Resultados = aux.nombre + ": TE: " + te + " Ticks: " + aux.ticks + "Prioridad: " + aux.tipo
                                + " Llegada: " + aux.llegada + " Tr: " + tr + " Tp: "
                                + tp;
                        Tr += te + aux.ticks;
                        Tp += (te + aux.ticks) / aux.ticks;
                        System.out.println("\n" + Resultados);
                        Thread.sleep(1000 * aux.ticks);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Prioridad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    c.procesar(aux, aux.ticks);
                    tipo_1.remove(aux);

                } ///////////COMIENZA PRIORIDAD CON PROCESOS TIPO 1 (fin)
                /////////COMIENZA FCFS CON PROCESOS TIPO 2 (inicio)
                else if (!tipo_2.isEmpty()) {
                    System.out.println("Numero de procesos de tipo 2: " + tipo_2.size());
                    c.procesar(tipo_2.get(0), tipo_2.get(0).ticks);
                    tipo_2.remove(0);
                } /////////COMIENZA FCFS CON PROCESOS TIPO 2 (fin)
                /////////COMIENZA FCFS CON PROCESOS TIPO 3 (inicio)
                else if (!tipo_3.isEmpty()) {
                    System.out.println("Numero de procesos de tipo 3: " + tipo_3.size());
                    c.procesar(tipo_3.get(0), tipo_3.get(0).ticks);
                    tipo_3.remove(0);
                }
                /////////COMIENZA FCFS CON PROCESOS TIPO 3 (fin) 

            }
            ////////////////SI TODAS LAS COLAS DE PROCESOS ESTAN VACIAS SE CAMBIA LA BANDERA
            //if(tipo_0.isEmpty() && tipo_1.isEmpty()&& tipo_2.isEmpty() && tipo_3.isEmpty()){  Tu condicion era esta
            if (colaProcesos.isEmpty()) {  //creo que la correcta es esta, porque se puede dar la ocasión de que quede un huerfanito en la proceos
                if (parar) {
                    System.out.println("Se terminaron los procesos");
                    pararproceso = true;
                    return;
                }
            }

        }

    }
}
