package it.polito.tdp.Tesi_Museo_DAnna;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.Tesi_Museo_DAnna.model.Autore;
import it.polito.tdp.Tesi_Museo_DAnna.model.Model;
import it.polito.tdp.Tesi_Museo_DAnna.model.Opera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FXMLController {
	Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnArtist1;

    @FXML
    private Button btnImport;

    @FXML
    private Button btnOpere1;

    @FXML
    private ComboBox<Autore> cmbArtist1;

    @FXML
    private ComboBox<Integer> cmbBeg;

    @FXML
    private ComboBox<Integer> cmbEnd;

    @FXML
    private ComboBox<Opera> cmbOpere1;

    @FXML
    private TextArea txtResult1;

    @FXML
    void handleGetInfo(ActionEvent event) {
    	
    }

    @FXML
    void handleGetOpereByAutore(ActionEvent event) {
    	if(this.cmbBeg.getValue()==null || this.cmbEnd.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN BEGIN YEAR E UN END YEAR!<");
    		return;
    	} 
    	if(this.cmbBeg.getValue()>this.cmbEnd.getValue()) {
    		this.txtResult1.setText(">ERRORE! L'END YEAR DEBE ESSERE MAGGIORE DEL BEGIN YEAR!<");
    		return;
    	}
    	if(this.cmbArtist1.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN AUTORE DALLA LISTA!<");
    		return;
    	}
    	this.model.inizializza();
    	List<Opera> op= this.model.getOpereByAutoriAnno(this.cmbArtist1.getValue(),
    			this.cmbBeg.getValue(), this.cmbEnd.getValue());
    	for(Opera o:op) {
    		this.cmbOpere1.getItems().add(o);
    	}
    	
    }



    @FXML
    void handleRiempiAutori(ActionEvent event) {
    	this.txtResult1.clear();
    	
    	if(this.cmbBeg.getValue()==null || this.cmbEnd.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN BEGIN YEAR E UN END YEAR!<");
    		return;

    	} 
    	if(this.cmbBeg.getValue()>this.cmbEnd.getValue()) {
    		this.txtResult1.setText(">ERRORE! L'END YEAR DEBE ESSERE MAGGIORE DEL BEGIN YEAR!<");
    		return;

    	}
    	List<Autore> artisti= this.model.getAutoriByAnno(this.cmbBeg.getValue(), this.cmbEnd.getValue());
    	for(Autore a:artisti) {
    		this.cmbArtist1.getItems().add(a);
    	}
    }

    @FXML
    void initialize() {
        assert btnArtist1 != null : "fx:id=\"btnArtist1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnImport != null : "fx:id=\"btnImport\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnOpere1 != null : "fx:id=\"btnOpere1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbArtist1 != null : "fx:id=\"cmbArtist1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBeg != null : "fx:id=\"cmbBeg\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbEnd != null : "fx:id=\"cmbEnd\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbOpere1 != null : "fx:id=\"cmbOpere1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult1 != null : "fx:id=\"txtResult1\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model=model;
    	this.cmbBeg.getItems().clear();
    	List<Integer> anniBegin=this.model.getBeginYear();
    	for(Integer i: anniBegin) {
    		this.cmbBeg.getItems().add(i);
    	}
    	List<Integer> anniEnd=this.model.getEndYear();
    	for(Integer i: anniEnd) {
    		this.cmbEnd.getItems().add(i);
    	}
    	
    }

}