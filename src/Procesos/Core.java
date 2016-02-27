/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Core {    
    public static boolean bandera = true;
    public void procesar(Proceso p, Integer ticks) {
        bandera = false;
        p.ticks = p.ticks - ticks;
        System.out.println("Nombre: " + p.nombre + " Ticks: " + ticks);
        bandera = true;
    }
}
