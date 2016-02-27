/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;
import static simulacion.so.FXMLDocumentController.colaProcesos;
import Procesos.Core;
import static Procesos.Core.bandera;
import Procesos.Proceso;

/**
 *
 * @author Andres
 */
public class FCFS  implements Runnable{
    Thread T1;
     
    public void algoritmo(){
        Core c = new Core();
        
        if(!colaProcesos.isEmpty()){
            while(!bandera){
                System.out.println("haz nada");
            }
            Proceso aux = colaProcesos.get(0);
            System.out.println("nombre: " + aux.nombre);
            colaProcesos.remove(0);
            c.procesar(aux,aux.ticks);
        }
    }
    
     
    public void activaHilo(){
        T1 = new Thread (new FCFS());
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
