/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Procesos.Core;
import Procesos.Proceso;
import static simulacion.so.FXMLDocumentController.colaProcesos;

/**
 *
 * @author ERIDE21
 */
public class Prioridad {
    Core procesador = new Core();

    public void algoritmo(){
        Proceso aux;
        aux = colaProcesos.get(0);
        Integer temp = aux.prioridad;
        while(true){
            for (int i = 1; i < colaProcesos.size(); i++) {
                if (colaProcesos.get(i).prioridad < temp) {
                    aux = colaProcesos.get(i);
                }
                procesador.procesar(aux, aux.ticks);
            }

        }


    }
}
