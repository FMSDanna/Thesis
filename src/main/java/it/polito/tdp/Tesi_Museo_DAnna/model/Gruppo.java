package it.polito.tdp.Tesi_Museo_DAnna.model;


import java.time.Duration;
import java.util.LinkedList;
import java.util.List;



public class Gruppo {
	protected List<Visitatore> visitatori;
	protected int insoddisfazione;
	protected Duration uscita;
	protected List<Stanza> visitate;
	protected String periodoDiInteresse;
	protected int nomeGruppo;
	
	public Gruppo() {
		this.insoddisfazione = 0;
		this.visitatori= new LinkedList<>();
		this.uscita= null;
		this.visitate= new LinkedList<>();
		this.periodoDiInteresse=null;
		this.nomeGruppo=0;
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
	public void setInsoddisfazione(int insoddisfazione) {
		this.insoddisfazione = insoddisfazione;
	}
	public List<Stanza> getVisitate() {
		return visitate;
	}
	public Duration getUscita() {
		return uscita;
	}
	public void setUscita(Duration uscita) {
		this.uscita = uscita;
	}
	public String getPeriodoDiInteresse() {
		return periodoDiInteresse;
	}
	public void setPeriodoDiInteresse(String periodoDiInteresse) {
		this.periodoDiInteresse = periodoDiInteresse;
	}
	public int getNomeGruppo() {
		return nomeGruppo;
	}
	public void setNomeGruppo(int nomeGruppo) {
		this.nomeGruppo = nomeGruppo;
	}
	
}
