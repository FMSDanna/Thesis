package it.polito.tdp.Tesi_Museo_DAnna.model;

public class Statistiche {

	private int recensioniNegative;
	private int recensioniPositive;
	private double insoddisfazioneMedia;
	private double insoddisfazioneTotale;
	private int totaleClienti;
	private int bambini;
	private int anziani;
	private int adulti;
	private int totaleGruppi;
	private int visitatoriSenzaGuida;
	private int gruppiTuristici;
	private int gruppiGenerici;
	private int gruppiFamiglie;

	
	public Statistiche() {
		super();
		this.recensioniNegative = 0;
		this.recensioniPositive = 0;
		this.insoddisfazioneMedia = 0;
		this.insoddisfazioneTotale = 0;
		this.totaleClienti = 0;
		this.bambini = 0;
		this.anziani = 0;
		this.adulti = 0;
		this.totaleGruppi = 0;
		this.visitatoriSenzaGuida = 0;
		this.gruppiFamiglie=0;
		this.gruppiGenerici=0;
		this.gruppiTuristici=0;
	}

	public int getTotaleGruppi() {
		return totaleGruppi;
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
	
	public int getGruppiTuristici() {
		return gruppiTuristici;
	}

	public int getGruppiGenerici() {
		return gruppiGenerici;
	}

	public int getGruppiFamiglie() {
		return gruppiFamiglie;
	}

	public int getVisitatoriSenzaGuida() {
		return visitatoriSenzaGuida;
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
	public void incrementaVisitatoriSenzaGuida(int incremento) {
		this.visitatoriSenzaGuida +=incremento;
	}
	public double calcolaMediaInsoddisfazione() {
		this.insoddisfazioneMedia= this.insoddisfazioneTotale/this.totaleGruppi;
		return this.insoddisfazioneMedia;
	}
	
	public void incrementaTuristici(int incremento) {
		this.gruppiTuristici +=incremento;
	}
	public void incrementaFamiglie(int incremento) {
		this.gruppiFamiglie +=incremento;
	}
	public void incrementaGenerici(int incremento) {
		this.gruppiGenerici +=incremento;
	}
	@Override
	public String toString() {
		return "Statistiche:\n" + "\nTotale Gruppi= " + totaleGruppi + "\nDi cui:"
				+"\n#Famiglie= " + gruppiFamiglie +"\n#Generici= " + gruppiGenerici +"\n #Turistici= " + gruppiTuristici 
				+ "\nTotale Visitatori= " + totaleClienti + "\nDi cui:\n -Bambini= " + bambini + "\n-Anziani= " + anziani + "\n-Adulti= "
				+ adulti + "\nVisitatoriSenzaGuida= " + visitatoriSenzaGuida+ "\nRecensioni Positive= " + recensioniPositive +"\nRecensioni Negative= " + recensioniNegative+ "\nInsoddisfazione Media= " + insoddisfazioneMedia;
	}

	
}
