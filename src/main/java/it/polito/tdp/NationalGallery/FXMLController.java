package it.polito.tdp.NationalGallery;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.NationalGallery.model.Autore;
import it.polito.tdp.NationalGallery.model.Model;
import it.polito.tdp.NationalGallery.model.Opera;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Button btnSelectSponsor;

    @FXML
    private Button btnSimula;

    @FXML
    private ComboBox<Autore> cmbArtist1;

    @FXML
    private ComboBox<Integer> cmbBeg;

    @FXML
    private ComboBox<Integer> cmbEnd;

    @FXML
    private ComboBox<String> cmbPeriodiSponsor;
    @FXML
    private ComboBox<Opera> cmbOpere1;
    @FXML
    private Slider slideDissatisfaction;

    @FXML
    private Slider slideSponsor;
    @FXML
    private TextArea txtResult1;
    @FXML
    private TextField txtAudioGuides;
    

    @FXML
    private TextField txtMaxRoom;
    @FXML
    private TextField txtMaxRoomCapacity;
    @FXML
    private TextField txtMaxVisit;	
    @FXML
    private TextField txtMaxVisitors;
    @FXML
    private TextField txtMinRoom;
    @FXML
    private TextField txtMinVisit;
    @FXML
    private TextArea txtResult2;
    
    @FXML
    void handleAggiungiSponsor(ActionEvent event) {
    	this.txtResult2.clear();
    	this.txtResult2.appendText("Periodi sponsorizzati aggiunti: ");
    	for(String s: this.model.getPeriodiSponsorizzati()) {
    		this.txtResult2.appendText("\n"+s);
    	}
    	String p= this.cmbPeriodiSponsor.getValue();
    	if (p==null) {
    		this.txtResult2.setText(">ERRORE! SELEZIONA UN'OPERA, SE PRESENTE NELL'ELENCO!<");
    		return;
    	}
    	this.model.aggiungiSponsorizzati(p);
    	this.txtResult2.appendText("\n"+p);
    }

    @FXML
    void handleSimula(ActionEvent event) {
    	this.txtResult2.clear();
    	try {
    		int audioGuide= Integer.parseInt((this.txtAudioGuides.getText()));
    		int capienzaMax=Integer.parseInt((this.txtMaxRoomCapacity.getText()));
    		int numVisitatoriMax=Integer.parseInt((this.txtMaxVisitors.getText()));
    		int durataMinStanza=Integer.parseInt((this.txtMinRoom.getText()));
    		int durataMaxStanza=Integer.parseInt((this.txtMaxRoom.getText()));
			int durataMaxVisita=Integer.parseInt((this.txtMaxVisit.getText()));
			int durataMinVisita=Integer.parseInt((this.txtMinVisit.getText()));
			double probabilitaInsoddisfazione=((double)(this.slideDissatisfaction.getValue())/100); 
			double probabilitaSponsor=((double)(this.slideSponsor.getValue())/100); 
			
	    	this.txtResult2.setText(
	    			this.model.iniziaSimulazione(
	    					audioGuide, capienzaMax, numVisitatoriMax, durataMinStanza, durataMaxStanza,
	    					durataMaxVisita, durataMinVisita, probabilitaInsoddisfazione, probabilitaSponsor
	    					)
	    			);
    	}catch(Exception e){
    		this.txtResult2.setText(e.toString());
    		this.txtResult2.appendText("\n>ERRORE! INSERIRE SOLO NUMERI INTERI E ALMENO UN PERIODO SPONSORIZZATO<");
    		return;
    	}
    	
    	

    }
    @FXML
    void handleGetInfo(ActionEvent event) {
    	this.txtResult1.clear();
    	if(this.cmbOpere1.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN'OPERA, SE PRESENTE NELL'ELENCO!<");
    		return;
    	} 
    	this.txtResult1.setText(this.model.getInfo(this.cmbOpere1.getValue()));
    }

    @FXML
    void handleGetOpereByAutore(ActionEvent event) {
    	this.cmbOpere1.getItems().clear();
    	
    	if(this.cmbBeg.getValue()==null || this.cmbEnd.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN BEGIN YEAR E UN END YEAR!<");
    		return;
    	} 
    	if(this.cmbBeg.getValue()>this.cmbEnd.getValue()) {
    		this.txtResult1.setText(">ERRORE! L'END YEAR DEVE ESSERE MAGGIORE DEL BEGIN YEAR!<");
    		return;
    	}
    	if(this.cmbArtist1.getValue()==null) {
    		this.txtResult1.setText(">ERRORE! SELEZIONA UN AUTORE DALLA LISTA!<");
    		return;
    	}
    	
    	List<Opera> op= this.model.getOpereByAutoriAnno(this.cmbArtist1.getValue(),
    			this.cmbBeg.getValue(), this.cmbEnd.getValue());
    	for(Opera o:op) {
    		this.cmbOpere1.getItems().add(o);
    	}
    	
    }



    @FXML
    void handleRiempiAutori(ActionEvent event) {
    	this.cmbArtist1.getItems().clear();
    	this.cmbOpere1.getItems().clear();
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
        assert btnOpere1 != null : "fx:id=\"btnOpere1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSelectSponsor != null : "fx:id=\"btnSelectSponsor\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbArtist1 != null : "fx:id=\"cmbArtist1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBeg != null : "fx:id=\"cmbBeg\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbEnd != null : "fx:id=\"cmbEnd\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbOpere1 != null : "fx:id=\"cmbOpere1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbPeriodiSponsor != null : "fx:id=\"cmbPeriodiSponsor\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAudioGuides != null : "fx:id=\"txtAudioGuides\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxRoom != null : "fx:id=\"txtMaxRoom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxVisit != null : "fx:id=\"txtMaxVisit\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMaxVisitors != null : "fx:id=\"txtMaxVisitors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinRoom != null : "fx:id=\"txtMinRoom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMinVisit != null : "fx:id=\"txtMinVisit\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult1 != null : "fx:id=\"txtResult1\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model=model;
    	this.model.inizializza();
    	this.cmbBeg.getItems().clear();
    	List<Integer> anniBegin=this.model.getBeginYear();
    	for(Integer i: anniBegin) {
    		this.cmbBeg.getItems().add(i);
    	}
    	List<Integer> anniEnd=this.model.getEndYear();
    	for(Integer i: anniEnd) {
    		this.cmbEnd.getItems().add(i);
    	}
    	List<String> periodi=this.model.getPeriodi();
    	for(String s: periodi) {
    		this.cmbPeriodiSponsor.getItems().add(s);
    	}
    }

}