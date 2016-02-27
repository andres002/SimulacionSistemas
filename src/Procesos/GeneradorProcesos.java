/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.Random;
import static simulacion.so.FXMLDocumentController.colaProcesos;

/**
 *
 * @author Andres
 */
public class GeneradorProcesos implements Runnable{
    
    final double probabilidad =  0.9502;
   
   
    
    public void creaProcesos(){
           Random rnd = new Random();
            double posible = rnd.nextDouble();
            double posibleTipo = rnd.nextDouble();
            if(posible < probabilidad){
                colaProcesos.add(new Proceso());
            }
                
           
           
    }
    
    
    

    @Override
    public void run() {
        
    }
    
}
