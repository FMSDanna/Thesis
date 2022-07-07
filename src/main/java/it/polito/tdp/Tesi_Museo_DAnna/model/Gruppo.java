package it.polito.tdp.Tesi_Museo_DAnna.model;


import java.util.List;



public class Gruppo {
	protected List<Visitatore> visitatori;
	protected int insoddisfazione;
	
	
	public Gruppo() {
		this.insoddisfazione = 0;
	}
	public void aumentaInsoddisfazione() {
		this.insoddisfazione++;
	}
	public List<Visitatore> getVisitatori() {
		return visitatori;
	}
	public int getInsoddisfazione() {
		return insoddisfazione;
	}
	
}
