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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class FCFS  implements Runnable{
    Thread T1;
     
    public void algoritmo(){
        Core c = new Core();
        //System.out.println(!colaProcesos.isEmpty());
        if(!colaProcesos.isEmpty()){
            while(!bandera){
                System.out.println("haz nada");
            }
            //Proceso aux = colaProcesos.get(0);
            //System.out.println("nombre: " + aux.nombre);
            c.procesar(colaProcesos.get(0),colaProcesos.get(0).ticks);
            colaProcesos.remove(0);
            
        }
    }
    
     
    public void activaHilo(){
        T1 = new Thread (new FCFS());
        T1.setName("Edgardo");
        T1.start();
    }
    public void asesinaHilo(){
        if(T1.isAlive()) T1.stop();
    }

    @Override
    public void run() {
        while (true) {            
            try {
                algoritmo();
                
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            
        }
        
    }
}
