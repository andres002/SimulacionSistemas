/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.so;

import Algoritmos.ColasMultiNivel;
import Algoritmos.FCFS;
import Algoritmos.Prioridad;
import Algoritmos.RoundRobin;
import static Algoritmos.RoundRobin.cont_ticks;
import Algoritmos.SJF;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Procesos.*;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 *
 * @author Andres
 */
public class FXMLDocumentController implements Initializable {

    public static ArrayList<Proceso> colaProcesos = new ArrayList<Proceso>();
    public static int numProcesos;
    public static FXMLDocumentController fx = new FXMLDocumentController();
    public static double Te = 0;
    public static double Tr = 0;
    public static double Tp = 0;
    public static String Resultados = "";
    public static boolean parar = false, pararproceso = false; 
    GeneradorProcesos g = new GeneradorProcesos();
    FCFS f = new FCFS();
    SJF s = new SJF();
    Prioridad priori = new Prioridad();
    RoundRobin rr = new RoundRobin();
    ColasMultiNivel cm = new ColasMultiNivel();
    public static String quantum;
    @FXML
    RadioButton rbFCFS, rbSJF, rbPrioridad, rbRR, rbCM;
    @FXML
    TextField txtQuantum;
    @FXML
    Button btnIniciar, btnTerminar;
    
    @FXML
    TextArea resultados;

    @FXML
    private void IniciarSimulador(ActionEvent event) {
        numProcesos  = 0;
        Resultados = "";
        parar = false;
        pararproceso = false; 
        btnIniciar.setDisable(true);
        if (rbFCFS.isSelected()) {
            f.activaHilo();
            g.activaHilo();
            txtQuantum.setDisable(true);
            rbSJF.setDisable(true);
            rbPrioridad.setDisable(true);
            rbRR.setDisable(true);
            rbCM.setDisable(true);
        }
        if (rbSJF.isSelected()) {
            s.activaHilo();
            g.activaHilo();
            txtQuantum.setDisable(true);
            rbFCFS.setDisable(true);
            rbPrioridad.setDisable(true);
            rbRR.setDisable(true);
            rbCM.setDisable(true);
        }
        if (rbPrioridad.isSelected()) {
            priori.activaHilo();
            g.activaHilo();
            txtQuantum.setDisable(true);
            rbSJF.setDisable(true);
            rbFCFS.setDisable(true);
            rbRR.setDisable(true);
            rbCM.setDisable(true);
        }
        if (rbRR.isSelected()) {
            rbSJF.setDisable(true);
            rbPrioridad.setDisable(true);
            rbFCFS.setDisable(true);
            rbCM.setDisable(true);
            if (txtQuantum.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("Falta el Quantum");
                alert.showAndWait();
                btnIniciar.setDisable(false);
            } else {
                btnIniciar.setDisable(true);
                txtQuantum.setDisable(true);
                this.quantum = txtQuantum.getText();
                System.out.println("Valor de quantum: "+quantum);
                g.activaHilo();
                rr.activaHilo();
            }

        }
        if (rbCM.isSelected()) {
            txtQuantum.setDisable(true);
            rbSJF.setDisable(true);
            rbPrioridad.setDisable(true);
            rbRR.setDisable(true);
            rbFCFS.setDisable(true);
            
            
            if (txtQuantum.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ERROR");
                alert.setContentText("Falta el Quantum");
                alert.showAndWait();
                btnIniciar.setDisable(false);
            } else {
                btnIniciar.setDisable(true);
                txtQuantum.setDisable(true);
                this.quantum = txtQuantum.getText();
                System.out.println("Valor de quantum: "+quantum);
               g.activaHilo();
                cm.activaHilo();
            }
        }
        //System.out.println("algo---" + colaProcesos.get(0).nombre);

    }
    
    @FXML
    public void setResultados(){
       resultados.setText(resultados.getText() + "\n" + Resultados);
    }
    
    
    
    
    

    @FXML
    private void TerminarSimulador(ActionEvent event) {
        //g.asesinaHilo();
        parar = true;
        
        if (rbFCFS.isSelected()) {
            //f.asesinaHilo();
            
            System.out.println("Valor de parar procesos: "+pararproceso);
            while(!pararproceso){
                System.out.print("");

                //System.out.println("Me atore");
                /*if (colaProcesos.size() == 0) {
                    System.out.println("Entro en este if");
                    pararproceso=true;
                }*/
            }
           
            System.out.println("Imprimo tiempos");
            f.asesinaHilo();
             g.asesinaHilo();//mata al hilo de los procesos
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbCM.setDisable(false);
        }
        if (rbSJF.isSelected()) {
            //s.asesinaHilo();
           
            while(!pararproceso){
                System.out.print("");
            }
            s.asesinaHilo();
            g.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
            rbCM.setDisable(false);
        }
        if (rbPrioridad.isSelected()) {
           
            while(!pararproceso){
                System.out.print("");
            }
            priori.asesinaHilo();
            g.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
            rbCM.setDisable(false);
        }
        if (rbRR.isSelected()) {
            while(!pararproceso){
                System.out.print("");
            }
            System.out.println("Se terminaron los procesos");
            rr.asesinaHilo();
             g.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbFCFS.setDisable(false);
            rbCM.setDisable(false);
        }
        if (rbCM.isSelected()) {
            while(!pararproceso){
                System.out.print("");
            }
            System.out.println("Se terminaron los procesos");
            cm.asesinaHilo();
            g.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
            rbCM.setDisable(false);
        }
        
        resultados.setText("\n\nTiempo de espera promedio: " + (Te/numProcesos) +"\n"+"\n\nTiempo de respuesta: "+(Tr/numProcesos)
                +"\n"+"\n\nTiempo de penalizacion: "+((Tr/numProcesos))/cont_ticks);
        
        //System.out.println("\n\nTiempo de espera promedio: " + (Te/numProcesos));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtQuantum.setText(null);
        rbFCFS.setSelected(true);
        resultados.setText("");
    }

}
