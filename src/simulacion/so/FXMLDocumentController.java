/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.so;

import Algoritmos.FCFS;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Procesos.*;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class FXMLDocumentController implements Initializable{
    
    public static ArrayList<Proceso> colaProcesos = new ArrayList<Proceso>();
    GeneradorProcesos g = new GeneradorProcesos();
    FCFS f = new FCFS();
    
    
    @FXML
    private void IniciarSimulador(ActionEvent event) {
        g.activaHilo();
        f.activaHilo();
        //System.out.println("algo---" + colaProcesos.get(0).nombre);
        
    }
    
    @FXML
    private void TerminarSimulador(ActionEvent event) {
        g.asesinaHilo();
        f.asesinaHilo();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
