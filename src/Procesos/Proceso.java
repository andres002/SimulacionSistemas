/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author Andres
 */
public class Proceso {
    /* PRIORIDADES
    De sistema ------ 0
    Interactivos----- 1
    edicion---------- 2
    proceso por lotes 3
    */
    public Integer tiempo = 0;
    public int prioridad = 0;
    public int tipo = 0; 
    public String nombre = "";
    
}
