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

/**
 *
 * @author ERIDE21
 */
public class RoundRobin implements Runnable {

    Thread T4;
    Integer q;

    public void algoritmo() {
        
        q = Integer.parseInt(quantum);
        Core c = new Core();
        if (!colaProcesos.isEmpty()) {
            Proceso aux = colaProcesos.get(0);
            while (!bandera) {
                System.out.println("haz nada");
            }
            if(aux.ticks.intValue() - q >= 0){
                c.procesar(aux, q);
            }else{
                c.procesar(aux, aux.ticks);
            }
           
            if (aux.ticks <= 0) {
                colaProcesos.remove(aux);
            } else {
                colaProcesos.add(aux);
                colaProcesos.remove(0);
            }
        }
    }

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
                algoritmo();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
