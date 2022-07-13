package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class Visitatore {
	protected String age;
	protected List<Autore> autoriDiInteresse;
	protected String periodoDiInteresse;
	protected Duration uscita;
	protected List<Stanza> visitate;
	


	public Visitatore(String age) {
		//se specifico l'età
		this.age = age;
		
		this.visitate= new LinkedList<>();
		this.autoriDiInteresse = generaAutoriDiInteresse();
		this.periodoDiInteresse = null;
	}

	public Visitatore() {
		this.age=generaAge();
		this.visitate= new LinkedList<>();
		this.periodoDiInteresse = null;
		this.autoriDiInteresse = generaAutoriDiInteresse();
		
	}
	
//	
//	public Visitatore(Periodo period) {
//		this.age=generaAge();
//		this.visitate= new LinkedList<>();
//		this.periodoDiInteresse = new Periodo(period.getPeriodo());
//		this.autoriDiInteresse = generaAutoriDiInteresse();
//			}
//	public Visitatore(boolean b) {
//		this.age=generaAge();
//		this.periodoDiInteresse = null;
//		this.autoriDiInteresse = null;
//		this.visitate= new LinkedList<>();
//	}
//	public Visitatore(String age,Boolean b) {
//		//se specifico l'età
//		this.age = age;
//		
//		this.visitate= new LinkedList<>();
//		this.periodoDiInteresse = null;
//		this.autoriDiInteresse = null;
//	}
//	public Visitatore(String age,Periodo period) {
//		this.age=age;
//		this.visitate= new LinkedList<>();
//		this.periodoDiInteresse = new Periodo(period.getPeriodo());
//		this.autoriDiInteresse = generaAutoriDiInteresse();
//			}

	private String generaAge() {
		double prob=Math.random();
		String age="";
		if(prob<=0.33) {
			age="bambino";
		}
		else if(prob>0.33 && prob<=0.66) {
			age="adulto";
		}
		else {
			age="anziano";
		}
		return age;
	}

	public String getAge() {
		return age;
	}

	public List<Autore> getAutoriDiInteresse() {
		return autoriDiInteresse;
	}

	public String getPeriodoDiInteresse() {
		return periodoDiInteresse;
	}
	
	private List<Autore> generaAutoriDiInteresse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Duration getUscita() {
		return uscita;
	}

	public void setUscita(Duration uscita) {
		this.uscita = uscita;
	}

	public List<Stanza> getVisitate() {
		return visitate;
	}

	public void setPeriodoDiInteresse(String periodoDiInteresse) {
		this.periodoDiInteresse = periodoDiInteresse;
	}
	
}
