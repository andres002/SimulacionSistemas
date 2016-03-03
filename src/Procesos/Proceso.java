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
    /* Tipos de proceso
    De sistema ------ 0
    Interactivos----- 1
    edicion---------- 2
    proceso por lotes 3
    */
    public int espera=0;
    public Integer ticks = 0;
    public int prioridad = 0;
    public int tipo = 0; 
    public String nombre = "";
    public int llegada = 0;
    
    public Proceso(Integer ticks,int tipo,int prioridad, String nombre, int llegada){
        this.ticks = ticks;
        this.prioridad = prioridad;
        this.tipo = tipo;
        this.nombre = nombre;
        this.llegada = llegada;
    }
    
}
