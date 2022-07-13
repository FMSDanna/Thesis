package it.polito.tdp.Tesi_Museo_DAnna.model;


import java.time.Duration;
import java.time.temporal.ValueRange;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.Tesi_Museo_DAnna.model.Event.EventType;

public class Simulator {
	//Modello
	private Graph<Stanza, DefaultEdge> mappaMuseo;
	private List<Gruppo> gruppi;
	private int audioGuide;
	
	private List<String> stanzeCriticheConOra;
	private int capienzaMax;
	private int nPersone;
	private Map<String,Stanza> stanzeMap;
	private List<Visitatore> visitatori;
	private List<String> periodiSponsorizzati;
	private List<String> periodi;
	private int numVisitatoriMax;
	private int durataMinStanza;
	private int durataMaxStanza;
	private int durataMaxVisita;
	private int durataMinVisita;
	private double probabilitaInsoddisfazione;
	private double 	probabilitaSponsor;
;

	//Parametri della simulazione 
	
	
	private int T_ARRIVO_MAX = 17*60;
	private int T_ARRIVO_MIN = 10*60;
	private int T_CHIUSURA= 18*60;

	
	
	//Coda degli eventi
	private PriorityQueue<Event> queue;
	
	//Statistiche
	private Statistiche statistiche;
	
	
	public Simulator(
			Graph<Stanza,DefaultEdge> grafo,Map<String,Stanza> stanzeMap,List<String> periodiSponsorizzati,List<String> periodi) {
		super();
		this.mappaMuseo=grafo;
		this.stanzeMap=stanzeMap;
		this.periodiSponsorizzati=periodiSponsorizzati;
		this.periodi=periodi;

		
	}


	public void init( int audioGuide,int capienzaMax,int numVisitatoriMax,int durataMinStanza,int durataMaxStanza,
			int durataMaxVisita,int durataMinVisita,double probabilitaInsoddisfazione,double probabilitaSponsor ) {
		this.queue = new PriorityQueue<Event>();
		this.statistiche = new Statistiche();
		this.gruppi = new LinkedList<Gruppo>();
		this.audioGuide=audioGuide;
		this.stanzeCriticheConOra= new LinkedList<>();
		this.numVisitatoriMax = numVisitatoriMax;
		this.durataMinStanza = durataMinStanza;
		this.durataMaxStanza = durataMaxStanza;
		this.durataMaxVisita=durataMaxVisita;
		this.durataMinVisita=durataMinVisita;
		this.probabilitaInsoddisfazione = probabilitaInsoddisfazione;
		this.probabilitaSponsor = probabilitaSponsor;
		this.capienzaMax=capienzaMax;
		this.visitatori=new LinkedList<>();
		this.nPersone=0;
		
	
		creaEventi();
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
	private void sceglieSponsor(Gruppo g) {
		// TODO Auto-generated method stub
		g.setPeriodoDiInteresse(this.periodiSponsorizzati.get((int) Math.random()*periodiSponsorizzati.size()));
	}
	
	private void creaEventi() {
		Duration arrivo;
		Gruppo g;
		
		Stanza rotonda= this.stanzeMap.get("M-107");
		while(this.nPersone<numVisitatoriMax) {
			arrivo= Duration.ofMinutes(T_ARRIVO_MIN);
			arrivo = arrivo.plusMinutes((int)(Math.random() * (this.T_ARRIVO_MAX - this.T_ARRIVO_MIN)+ 1));
			//Creo un gruppo 33% famiglia ,33% turistico  etc
				g=creaGruppo();
				Double probSponsor= Math.random();
				if(probSponsor<probabilitaSponsor) {
					//al x% il gruppo sarà interessato a un periodo sponsorizzato
					sceglieSponsor(g);
				}
				else {
					//nel 30% dei casi invece sarà un periodo casuale
					g.setPeriodoDiInteresse(this.periodi.get((int)Math.random()*(this.periodi.size()+1)));
				}
			
			
			
			//Se un gruppo è formato da un numero di persone che supererebbe il numero massimo
			//non viene inserito e se ne crea un altro, finchè non si raggiunge la soglia e 
			//si esce dal while
			if(!(this.nPersone+g.getVisitatori().size()>numVisitatoriMax)) {
				//Creo l'evento entrata associato a quel gruppo 
				
				Duration durata = Duration.ofMinutes(this.durataMinVisita + 
						(int)(Math.random() * (this.durataMaxVisita - this.durataMinVisita) + 1));
				queue.add(new Event(arrivo,EventType.ENTRATA_GRUPPO,g.getVisitatori().size(),g,durata, null,rotonda));
				g.setNomeGruppo(this.nPersone);
				
				System.out.println("Entrato gruppo : "+this.nPersone+" con "+g.getVisitatori().size()+" persone");
				this.nPersone+=g.getVisitatori().size();
			
			}
			
		}
	}
	

	
	



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
			Stanza rotonda= this.stanzeMap.get("M-107");
			rotonda.setCapienzaAttuale(rotonda.getCapienzaAttuale()+e.getnPersone());
			//aumento il numero di visitatori e aggiungo il gruppo al mondo del simulatore
			gruppi.add(g);
			this.statistiche.incrementaClienti(e.getnPersone());
			this.statistiche.incrementaGruppi(1);
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
					this.statistiche.incrementaTuristici(1);
					//controllo sulle audioGuide
					int diff= e.getnPersone()-audioGuide;
					if(diff>0) {
						this.statistiche.incrementaVisitatoriSenzaGuida(diff);
						audioGuide=0;
					}
					else {
						audioGuide=audioGuide-e.getnPersone();
					}
					//creo l'evento uscita dal museo,
					//se il time è anteriore all'orario di chiusura allora viene settato 
					//alla fine della durata della visita
					//sennò all'orario di chiusura.
					//poi cambio la stanza perchè inizia il tour, quindi creo un evento
					//cambio_stanza 
					
					
					Duration uscita= e.getTime().plus(e.getDurata());
					if (uscita.toMinutes()>T_CHIUSURA) {
						uscita=Duration.ofMinutes(T_CHIUSURA);
					}
					g.setUscita(uscita);
					esci(uscita,EventType.USCITA_GRUPPO,g.getVisitatori().size(),g,null,null);
					Stanza stanza= scegliStanza(e.getStanzaPrecedente(),e.getStanzaPartenza(),g.getVisitate(), g,null);
					Duration durataStanza= Duration.ofMinutes((int)(Math.random() * (this.durataMaxStanza - this.durataMinStanza)+2));
					Duration time= e.getTime().plus(durataStanza);
					if(time.toMinutes()<=g.getUscita().toMinutes()) {
						Event cambio= new Event(time,EventType.CAMBIO_STANZA,nPersone,g,durataStanza,e.getStanzaPrecedente(),stanza);
						queue.add(cambio);
					}
					
				}
				if(g instanceof Famiglia) {
					this.statistiche.incrementaFamiglie(1);
					Duration uscita= e.getTime().plus(e.getDurata());
					if (uscita.toMinutes()>T_CHIUSURA) {
						uscita=Duration.ofMinutes(T_CHIUSURA);
					}
					g.setUscita(uscita);
					esci(uscita,EventType.USCITA_GRUPPO,g.getVisitatori().size(),g,null,null);
					Stanza stanza= scegliStanza(e.getStanzaPrecedente(),e.getStanzaPartenza(),g.getVisitate(), g,null);
					Duration durataStanza= Duration.ofMinutes( 
							(int)(Math.random() * (this.durataMaxStanza - this.durataMinStanza)+2));
					Duration time= e.getTime().plus(durataStanza);
					if(time.toMinutes()<=g.getUscita().toMinutes()) {
					Event cambio= new Event(time,EventType.CAMBIO_STANZA,nPersone,g,durataStanza,e.getStanzaPartenza(),stanza);
					queue.add(cambio);
					}
				}
				if(g instanceof Generico) {
					this.statistiche.incrementaGenerici(1);
					Duration uscita= e.getTime().plus(e.getDurata());
					if (uscita.toMinutes()>T_CHIUSURA) {
						uscita=Duration.ofMinutes(T_CHIUSURA);
					}

						g.setUscita(uscita);
						esci(uscita,EventType.USCITA_GRUPPO,g.getVisitatori().size(),g,null,null);
						Stanza stanza= scegliStanza(e.getStanzaPrecedente(),e.getStanzaPartenza(),g.getVisitate(), g,null);
						Duration durataStanza= Duration.ofMinutes( 
								(int)(Math.random() * (this.durataMaxStanza - this.durataMinStanza)+2));
						Duration time= e.getTime().plus(durataStanza);
						if(time.toMinutes()<=g.getUscita().toMinutes()) {
						Event cambio= new Event(time,EventType.CAMBIO_STANZA,nPersone,g,durataStanza,e.getStanzaPartenza(),stanza);
						queue.add(cambio);
						}
						
						


				}
			break;

		case CAMBIO_STANZA:
			
			Gruppo gc= e.getGruppo();
			Stanza attuale= e.getStanzaPartenza();
			if((attuale.getCapienzaAttuale()+e.getnPersone())>=capienzaMax) {
				Double prob= Math.random();
				if(prob<=probabilitaInsoddisfazione)
				gc.aumentaInsoddisfazione();
				
				if(gc.getInsoddisfazione()>=5) {
					esci(e.getTime().plus(Duration.ofMinutes(1)),EventType.USCITA_GRUPPO,gc.getVisitatori().size(),gc,null,null);
					this.statistiche.incrementaRecensioniNegative(e.getnPersone());
					break;
				}
				int t= (int)e.getTime().toMinutes();
				int hours = t / 60; //since both are ints, you get an int
				int minutes = t % 60;
				
				this.stanzeCriticheConOra.add("STANZA CRITICA: "+attuale+" alle ore "+hours+":"+minutes );
				
			
			}

			
				System.out.println("Cambio stanza gruppo "+gc.getNomeGruppo());
				Stanza stanzaS= scegliStanza(e.getStanzaPrecedente(),e.getStanzaPartenza(),gc.getVisitate(), gc,null);
				Duration durataStanzaS= Duration.ofMinutes(
						(int)(Math.random() * (this.durataMaxStanza - this.durataMinStanza)+2));
				Duration timeS= e.getTime().plus(durataStanzaS);
				if(timeS.toMinutes()<=gc.getUscita().toMinutes()) {
				Event cambioS= new Event(timeS,EventType.CAMBIO_STANZA,nPersone,gc,durataStanzaS,e.getStanzaPartenza(),stanzaS);
				queue.add(cambioS);
				attuale.setCapienzaAttuale(attuale.getCapienzaAttuale()-e.getnPersone());
				stanzaS.setCapienzaAttuale(stanzaS.getCapienzaAttuale()+e.getnPersone());
				}
				else {
					attuale.setCapienzaAttuale(attuale.getCapienzaAttuale()-e.getnPersone());
				}

			
			break;
			
		case USCITA_GRUPPO:
			Gruppo gu= e.getGruppo();
			if(!this.gruppi.contains(gu)) break;
			if(gu instanceof Generico) {
				audioGuide+=e.getnPersone();
				
				
			}
			this.statistiche.incrementaInsoddisfazioneTotale(gu.getInsoddisfazione());
			if(gu.getInsoddisfazione()<=3)
				statistiche.incrementaRecensioniPositive(e.getnPersone());
			this.gruppi.remove(gu);
			break;
		
		}
		
	}


private Stanza scegliStanza(Stanza stanzaPrecedente,Stanza stanzaAttuale,List<Stanza> visitate,Gruppo g, Visitatore v) {
	// TODO Auto-generated method stub
	String periodoInteresse="";
	if(g!=null) {
		//si sta spostando un gruppo
		periodoInteresse= g.getPeriodoDiInteresse();
		
	}
	if (v!=null) {
		//si sta spostando un visistatore
		periodoInteresse= v.getPeriodoDiInteresse();
		
	}

	Stanza prossima= null;
	Stanza precedente=stanzaPrecedente;
	List<Stanza> possibili= new LinkedList<>(Graphs.neighborListOf(this.mappaMuseo, stanzaAttuale)) ;
	List<Stanza> possibiliPreferite= new LinkedList<>();


	
	int conta=0;
	//Conto quante stanze hanno in comune le visitate e le possibili
	for(Stanza sv: visitate) {
		for(Stanza sp: possibili) {
			
			if (sv.equals(sp)) conta++;
		} 
	}
	//se il contatore è uguale alla grandezza delle possibili allora ho già visitato tutte le possibili
	if (conta==possibili.size()) {
		possibili.remove(precedente);
		//rimuovo la precedente dalle possibili per evitare eccessivi cicli
		if(possibili.size()==0) {
			//se la size di possibili è zero allora ho un vicolo cieco perchè
			//se rimuovendo la precedente la lista possibili è vuota allora la 
			//precedente è l'unica stanza disponibile e la scelgo
			prossima=precedente;
			
		}
		else {
			//sennò ne scelgo una a caso tra le possibili anche se già visitate
			prossima=possibili.get((int)(Math.random()*(possibili.size())));
		}
		
		
	}
	
	else {
		//se non è un vicolo cieco lavoro con le stanze preferibili perchè hanno un periodo di interesse uguale a quello
		//del gruppo o del visitatore
		if(possibili.size()!=0) {
			for(Stanza p: possibili) {
				if(periodoInteresse.compareTo(p.getPeriodo())==0) {
					possibiliPreferite.add(p);
				}
			}
		}

	}
	if(possibiliPreferite.size()!=0) {
		//se ci sono delle stanze preferibili scelgo una a caso tra quelle
		prossima= possibiliPreferite.get((int)(Math.random()*(possibiliPreferite.size())));
	}
	else {
		if(possibili.size()!=0) {
			double random=Math.random();
			int indice= (int) (random*(possibili.size()));
			prossima= possibili.get(indice);
		}
		//Se non ci sono ne scelgo una a caso tra le possibili

	}
	System.out.println(" dalla stanza "+stanzaAttuale+" Alla stanza "+prossima);
	visitate.add(prossima);
	return prossima;
}


private void esci(Duration time, EventType type, int nPersone, Gruppo gruppo, Duration durata, Stanza stanza
		) {
		// TODO Auto-generated method stub
		Event e= new Event(time,type,nPersone,gruppo,durata,null,null);
		queue.add(e);
}


	public Statistiche getStatistiche() {

		this.statistiche.calcolaMediaInsoddisfazione();
		
		return this.statistiche;
	}
	
	
	
}
