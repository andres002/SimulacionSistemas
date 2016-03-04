/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import static simulacion.so.FXMLDocumentController.parar;
import static Procesos.Core.bandera;

/**
 *
 * @author Andres
 */
public class GeneradorProcesos implements Runnable {

    final double probabilidad = 0.9502;
    static public int cont = -1;

    Thread T0;

    public void creaProcesos() {
        Random rnd = new Random();
        double posible = rnd.nextDouble();      //posibilidad de que se cree un proceso
        int posibleTick = rnd.nextInt(10) + 1;  // posibilidad de ticks
        double posibleTipo = rnd.nextDouble();  // posibilidad de un tipo de proceso
        int posiblePrioriodad;
        cont++;
        if (!parar) {
            if (posible < probabilidad) {
                if (posibleTipo <= 0.25) {    // Procesos de Sistema

                    posiblePrioriodad = rnd.nextInt(4) + 1;
                    /*while (!bandera) {
                        System.out.print("");
                    }*/
                    bandera = false;
                    colaProcesos.add(new Proceso(posibleTick, 0, posiblePrioriodad, "P" + cont, cont));
                    bandera = true;

                    
                } else if (posibleTipo <= 0.50) { //Procesos interactivos

                    posiblePrioriodad = rnd.nextInt(2) + 1;
                    while (!bandera) {
                        System.out.println("haz nada procesos");
                    }
                    bandera = false;
                    colaProcesos.add(new Proceso(posibleTick, 1, posiblePrioriodad, "P" + cont, cont));
                    bandera = true;

                } else if (posibleTipo <= 0.75) { // Procesos de edicion

                    posiblePrioriodad = rnd.nextInt(2) + 1;
                    while (!bandera) {
                        System.out.println("haz nada procesos");
                    }
                    bandera = false;
                    colaProcesos.add(new Proceso(posibleTick, 2, posiblePrioriodad, "P" + cont, cont));
                    bandera = true;

                } else if (posibleTipo <= 1) { //Proceso por lotes

                    posiblePrioriodad = rnd.nextInt(2) + 1;
                    while (!bandera) {
                        System.out.println("haz nada procesos");
                    }
                    bandera = false;
                    colaProcesos.add(new Proceso(posibleTick, 3, posiblePrioriodad, "P" + cont, cont));
                    bandera = true;

                }
            }
        }
        // System.out.println("cont " + cont);
    }

    @Override
    public void run() {
        while (true) {
            creaProcesos();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GeneradorProcesos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void activaHilo() {
        T0 = new Thread(new GeneradorProcesos());
        T0.setName("Ernesto");
        T0.start();
    }

    public void asesinaHilo() {
        T0.stop();
    }

}
