/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion.so.FXMLDocumentController.colaProcesos;

/**
 *
 * @author ERIDE21
 */
public class ColasMultiNivel implements Runnable {

    Thread T5;

    public void algoritmo() {
        Core c = new Core();

        if (!colaProcesos.isEmpty()) {
            Proceso aux;
            aux = colaProcesos.get(0);
            int temp = aux.tipo;
            for (int i = 1; i < colaProcesos.size(); i++) {
                if (colaProcesos.get(i).tipo < temp) {
                    aux = colaProcesos.get(i);
                    temp = aux.tipo;
                }
            }
            while (!bandera) {
                System.out.println("haz nada");
            }
            c.procesar(aux, aux.tipo);
            colaProcesos.remove(aux);

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
            try {
                algoritmo();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ColasMultiNivel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
