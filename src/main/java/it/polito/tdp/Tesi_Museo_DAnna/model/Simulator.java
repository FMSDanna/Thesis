package it.polito.tdp.Tesi_Museo_DAnna.model;


import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.Tesi_Museo_DAnna.model.Event.EventType;

public class Simulator {
	//Modello
	private Graph<Stanza, DefaultEdge> mappaMuseo;
	private List<Gruppo> gruppi;
	private int audioGuide;
	private Map<Stanza,Integer> stanzeCapienza;
	private List<String> stanzeCriticheConOra;
	private int capienzaMax;
	private int nPersone;
	private Map<String,Stanza> stanzeMap;
	
	//Parametri della simulazione 
	private int NUM_VISITATORI_MAX = 14500;
	private int T_ARRIVO_MAX = 17*60;
	private int T_ARRIVO_MIN = 10*60;
	
	
	private int DURATA_MIN_STANZA = 2;
	private int DURATA_MAX_STANZA = 10;
	private int DURATA_MAX_VISITA=3*60;
	private int DURATA_MIN_VISITA=90;

	private double TOLLERANZA_MAX = 0.9;
	private double OCCUPAZIONE_MAX = 0.5;
	
	//Coda degli eventi
	private PriorityQueue<Event> queue;
	
	//Statistiche
	private Statistiche statistiche;
	
	
	public void init(Graph<Stanza,DefaultEdge> grafo, int audioGuide,int capienzaMax,Map<String,Stanza> stanzeMap ) {
		this.queue = new PriorityQueue<Event>();
		this.statistiche = new Statistiche();
		this.gruppi = new LinkedList<Gruppo>();
		this.audioGuide=audioGuide;
		this.mappaMuseo=grafo;
		this.stanzeCapienza= new LinkedHashMap<>();
		this.capienzaMax=capienzaMax;
		this.stanzeCriticheConOra= new LinkedList<>();
		this.nPersone=0;
		this.stanzeMap=stanzeMap;
		creaStanzeCapienza();
		creaEventi();
	}
	
	
	private void creaStanzeCapienza() {
		for(Stanza s: this.mappaMuseo.vertexSet()) {
			this.stanzeCapienza.put(s,0);
		}
		
	}
	private Gruppo creaGruppo() {
		double prob=Math.random();
		
		if(prob<=0.33) {
			return new Turistico();
		}
		else if(prob>0.33 && prob<=0.66) {
			return new Famiglia();
		}
		else {
			return new Generico();
		}
	
	}

	private void creaEventi() {
		Duration arrivo= Duration.ofMinutes(T_ARRIVO_MIN);
		Gruppo g;
		arrivo = arrivo.plusMinutes((int)(Math.random() * this.T_ARRIVO_MAX + 1));
		Stanza rotonda= this.stanzeMap.get("M-107");
		while(this.nPersone<=NUM_VISITATORI_MAX) {
			//Creo un gruppo 33% famiglia ,33% turistico  etc
				double probG= Math.random();
				if(probG<=0.33) {
					 g= new Famiglia();
				}
				if(probG>0.33 && probG<=0.66) {
					 g= new Generico();
				}
				else {
					g= new Turistico();
				}
			
			
			
			
			if(!(this.nPersone+g.getVisitatori().size()>NUM_VISITATORI_MAX)) {
				//Creo l'evento entrata associato a quel gruppo 
				gruppi.add(g);
				Duration durata = Duration.ofMinutes(this.DURATA_MIN_VISITA + 
						(int)(Math.random() * (this.DURATA_MAX_VISITA - this.DURATA_MIN_VISITA + 1)));
				queue.add(new Event(arrivo,EventType.ENTRATA_GRUPPO,g.getVisitatori().size(),g,durata, rotonda, null));
				this.statistiche.incrementaClienti(g.getVisitatori().size());
				for(Visitatore v:g.getVisitatori() ) {
					switch(v.getAge()) {
					case "adulto": 
						this.statistiche.incrementaAdulti(1);
						break;
					case "bambino":
						this.statistiche.incrementaBambini(1);
						break;
					case "anziano":
						this.statistiche.incrementaAnziani(1);
						break;
					}
				}
			
			}
			
		}
	}
	
//	private void creaEventi() {
//		Duration arrivo = Duration.ofMinutes(0);
//		for (int i = 0; i < this.NUM_EVENTI; i++) {
//			int nPersone = (int) (Math.random() * this.NUM_PERSONE_MAX + 1);
//			Duration durata = Duration.ofMinutes(this.DURATA_MIN + 
//					(int)(Math.random() * (this.DURATA_MAX - this.DURATA_MIN + 1)));
//			double tolleranza = Math.random() * this.TOLLERANZA_MAX;
//			
//			Event e = new Event(arrivo, EventType.ARRIVO_GRUPPO_CLIENTI,
//					nPersone, durata, tolleranza, null);
//			this.queue.add(e);
//			
//			arrivo = arrivo.plusMinutes((int)(Math.random() * this.T_ARRIVO_MAX + 1));
//			
//		}
//	}
	
	

	
	
	public void run() {
		while(!queue.isEmpty()) {
			Event e = queue.poll();
			processaEvento(e);
		}
	}
	
	
	private void processaEvento(Event e) {
		switch(e.getType()) {
		case ENTRATA_GRUPPO:
			Gruppo g= e.getGruppo();
			//aumento il numero di visitatori
			this.statistiche.incrementaClienti(g.getVisitatori().size());
			for(Visitatore v:g.getVisitatori() ) {
				switch(v.getAge()) {
				case "adulto": 
					this.statistiche.incrementaAdulti(1);
					break;
				case "bambino":
					this.statistiche.incrementaBambini(1);
					break;
				case "anziano":
					this.statistiche.incrementaAnziani(1);
					break;
				}
			}
				if (g instanceof Turistico) {
					
				}
				if(g instanceof Famiglia) {
					
				}
				if(g instanceof Generico) {
					double prob= Math.random();
					if(prob<=0.5) {
						
					}
					if(prob>0.5) {
						
					}
				}
			break;
		case CAMBIO_STANZA:
			break;
		case USCITA_GRUPPO:
			break;
		
		}
	}
//	switch (e.getType()){
//	case ARRIVO_GRUPPO_CLIENTI:
//		//conto i clienti totali
//		this.statistiche.incrementaClienti(e.getnPersone());
//		
//		//cerco un tavolo
//		Tavolo tavolo = null;
//		
//		for (Tavolo t : this.tavoli) {
//			if (!t.isOccupato() && t.getPosti() >= e.getnPersone() 
//					&&
//					t.getPosti() * this.OCCUPAZIONE_MAX <= e.getnPersone()) {
//				tavolo = t;
//				break;
//			}
//		}
//		
//		if(tavolo != null) {
//			System.out.format("Trovato un tavolo da %d per %d persone\n", tavolo.getPosti(), e.getnPersone());
//			statistiche.incrementaSoddisfatti(e.getnPersone());
//			tavolo.setOccupato(true);
//			e.setTavolo(tavolo);
//			//dopo un po' i clienti si alzeranno
//			queue.add(new Event(e.getTime().plus(e.getDurata()), EventType.TAVOLO_LIBERATO, e.getnPersone(), e.getDurata(), e.getTolleranza(), tavolo));
//			
//		} else {
//			//c'è solo il bancone
//			double bancone = Math.random();
//			if(bancone <= e.getTolleranza()) {
//				//sì, ci fermiamo
//				System.out.format("%d persone si fermano al bancone\n", e.getnPersone());
//				statistiche.incrementaSoddisfatti(e.getnPersone());
//			} else {
//				//no, andiamo a casa
//				System.out.format("%d persone vanno a casa\n", e.getnPersone());
//				statistiche.incrementaInsoddisfatti(e.getnPersone());
//			}
//		}
//		
//		break;
//	case TAVOLO_LIBERATO:
//		e.getTavolo().setOccupato(false);
//		break;
//}
	
	public Statistiche getStatistiche() {
		return this.statistiche;
	}
	
	
	
}
