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
    ArrayList<Proceso> tipo_0 = new ArrayList();
    ArrayList<Proceso> tipo_1 = new ArrayList();
    ArrayList<Proceso> tipo_2 = new ArrayList();
    ArrayList<Proceso> tipo_3 = new ArrayList();
    

    public void algoritmo() {
        Core c = new Core();

        if (!colaProcesos.isEmpty()) {
            
            ////////////////////
            while(!colaProcesos.isEmpty()){
                int tipo = colaProcesos.get(0).tipo;
                if(tipo == 0){
                    tipo_0.add(colaProcesos.get(0));
                }
                if(tipo == 1){
                    tipo_1.add(colaProcesos.get(0));
                }
                if(tipo == 2){
                    tipo_2.add(colaProcesos.get(0));
                }
                if(tipo == 3){
                    tipo_3.add(colaProcesos.get(0));
                }
                colaProcesos.remove(0);
            }
            //////////////////
            
            while (!bandera) {
                System.out.println("haz nada");
            }
            
            ///////////////////
            
            if(!tipo_0.isEmpty()){
                c.procesar(tipo_0.get(0), tipo_0.get(0).ticks);
                tipo_0.remove(0);
                return;
            }
            if(!tipo_1.isEmpty()){
                 c.procesar(tipo_1.get(0), tipo_1.get(0).ticks);
                tipo_1.remove(0);
                return;
            }
            if(!tipo_2.isEmpty()){
                 c.procesar(tipo_2.get(0), tipo_2.get(0).ticks);
                tipo_2.remove(0);
                return;
            }
            if(!tipo_3.isEmpty()){
                 c.procesar(tipo_3.get(0), tipo_3.get(0).ticks);
                tipo_3.remove(0);
                return;
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
            try {
                algoritmo();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ColasMultiNivel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
