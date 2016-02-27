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
import static simulacion.so.FXMLDocumentController.colaProcesos;

/**
 *
 * @author ERIDE21
 */
public class ColasMultiNivel implements Runnable{
    Thread T1;
        
    public void algoritmo() {
        Core c = new Core();

        if (!colaProcesos.isEmpty()) {
            while (!bandera) {
                System.out.println("haz nada");
            }
            Proceso aux;
            aux = colaProcesos.get(0);
            Integer temp = aux.tipo;
            for (int i = 1; i < colaProcesos.size(); i++) {
                if (colaProcesos.get(i).tipo < temp) {
                    aux = colaProcesos.get(i);
                    temp = aux.tipo;
                }
            }
            c.procesar(aux, aux.tipo);
            colaProcesos.remove(aux);


        }
    }
    
     
    public void activaHilo(){
        T1 = new Thread (new ColasMultiNivel());
        T1.setName("Edgardo");
        T1.start();
    }
    public void asesinaHilo(){
        T1.stop();
    }

    @Override
    public void run() {
        while (true) {            
            algoritmo();
        }
        
    }
}
