package it.polito.tdp.Tesi_Museo_DAnna.model;

public class Statistiche {
	private int clientiSenzaGuida;
	private int recensioniNegative;
	private int recensioniPositive;
	private double insoddisfazioneMedia;
	private double insoddisfazioneTotale;
	private int totaleClienti;
	private int bambini;
	private int anziani;
	private int adulti;
	private int totaleGruppi;
	
	
	public int getTotaleGruppi() {
		return totaleGruppi;
	}
	public int getClientiSenzaGuida() {
		return clientiSenzaGuida;
	}
	public int getRecensioniNegative() {
		return recensioniNegative;
	}
	public int getRecensioniPositive() {
		return recensioniPositive;
	}
	public double getInsoddisfazioneMedia() {
		return insoddisfazioneMedia;
	}
	public double getInsoddisfazioneTotale() {
		return insoddisfazioneTotale;
	}
	public int getTotaleClienti() {
		return totaleClienti;
	}
	public int getBambini() {
		return bambini;
	}
	public int getAnziani() {
		return anziani;
	}
	public int getAdulti() {
		return adulti;
	}
	
	public void incrementaClientiSenzaGuida(int incremento) {
		this.clientiSenzaGuida +=incremento;
	}
	public void incrementaRecensioniNegative(int incremento) {
		this.recensioniNegative +=incremento;
	}
	public void incrementaRecensioniPositive(int incremento) {
		this.recensioniPositive +=incremento;
	}
	public void incrementaInsoddisfazioneTotale(double incremento) {
		this.insoddisfazioneTotale +=incremento;
	}
	public void incrementaClienti(int incremento) {
		this.totaleClienti +=incremento;
	}
	public void incrementaBambini(int incremento) {
		this.bambini +=incremento;
	}
	public void incrementaAdulti(int incremento) {
		this.adulti +=incremento;
	}
	public void incrementaAnziani(int incremento) {
		this.anziani +=incremento;
	}
	public void incrementaGruppi(int incremento) {
		this.totaleGruppi +=incremento;
	}
	public double calcolaMediaInsoddisfazione() {
		this.insoddisfazioneMedia= this.insoddisfazioneTotale/this.totaleGruppi;
		return this.insoddisfazioneMedia;
	}

	
}
