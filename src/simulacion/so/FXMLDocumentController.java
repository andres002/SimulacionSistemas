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
import javafx.scene.control.TextField;

/**
 *
 * @author Andres
 */
public class FXMLDocumentController implements Initializable {

    public static ArrayList<Proceso> colaProcesos = new ArrayList<Proceso>();
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
    private void IniciarSimulador(ActionEvent event) {

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
            g.activaHilo();
            cm.activaHilo();
        }
        //System.out.println("algo---" + colaProcesos.get(0).nombre);

    }

    @FXML
    private void TerminarSimulador(ActionEvent event) {
        g.asesinaHilo();
        
        if (rbFCFS.isSelected()) {
            f.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
        }
        if (rbSJF.isSelected()) {
            s.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
        }
        if (rbPrioridad.isSelected()) {
            priori.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
        }
        if (rbRR.isSelected()) {
            rr.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
        }
        if (rbCM.isSelected()) {
            cm.asesinaHilo();
            btnIniciar.setDisable(false);
            txtQuantum.setDisable(false);
            rbSJF.setDisable(false);
            rbPrioridad.setDisable(false);
            rbRR.setDisable(false);
            rbFCFS.setDisable(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtQuantum.setText(null);
    }

}
