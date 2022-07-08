package it.polito.tdp.Tesi_Museo_DAnna.model;


import java.time.Duration;

public class Event implements Comparable<Event>{

	public enum EventType {
		ENTRATA_GRUPPO,
		CAMBIO_STANZA,
		USCITA_GRUPPO
	}
	
	private Duration time;
	private EventType type;
	private int nPersone;
	private Gruppo gruppo;
	private Duration durata;
	//private double tolleranza;
	private Stanza stanza;
	private Visitatore visitatore;
	


	public Event(Duration time, EventType type, int nPersone, Gruppo gruppo, Duration durata, Stanza stanza,
			Visitatore visitatore) {
		super();
		this.time = time;
		this.type = type;
		this.gruppo = gruppo;
		this.nPersone = gruppo.getVisitatori().size();
		this.durata = durata;
		this.stanza = stanza;
		this.visitatore = visitatore;
	}



	public Duration getTime() {
		return time;
	}



	public void setTime(Duration time) {
		this.time = time;
	}



	public EventType getType() {
		return type;
	}



	public void setType(EventType type) {
		this.type = type;
	}



	public int getnPersone() {
		return nPersone;
	}



	public void setnPersone(int nPersone) {
		this.nPersone = nPersone;
	}



	public Gruppo getGruppo() {
		return gruppo;
	}



	public void setGruppo(Gruppo gruppo) {
		this.gruppo = gruppo;
	}



	public Duration getDurata() {
		return durata;
	}



	public void setDurata(Duration durata) {
		this.durata = durata;
	}



	public Stanza getStanza() {
		return stanza;
	}



	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}



	public Visitatore getVisitatore() {
		return visitatore;
	}



	public void setVisitatore(Visitatore visitatore) {
		this.visitatore = visitatore;
	}



	@Override
	public int compareTo(Event o) {
		return this.time.compareTo(o.getTime());
	}
	
	
	
	
}
