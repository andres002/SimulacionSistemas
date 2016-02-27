/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static simulacion.so.FXMLDocumentController.quantum;

/**
 *
 * @author ERIDE21
 */
public class RoundRobin implements Runnable{
    Thread T1;
    int q;
    public void algoritmo() {
        q = Integer.parseInt(quantum);
        Core c = new Core();
        if (!colaProcesos.isEmpty()) {
            while (!bandera) {
                System.out.println("haz nada");
            }
            Proceso aux = colaProcesos.get(0);
            System.out.println("nombre: " + aux.nombre);
            c.procesar(aux, q);
            if (aux.ticks <= 0) {
                colaProcesos.remove(aux);
            }else{
                colaProcesos.add(aux);
                colaProcesos.remove(0);
            }
        }
    }

    public void activaHilo() {
        T1 = new Thread(new FCFS());
        T1.setName("Edgardo");
        T1.start();
    }

    public void asesinaHilo() {
        T1.stop();
    }

    @Override
    public void run() {
        while (true) {
            algoritmo();
        }

    }
}
