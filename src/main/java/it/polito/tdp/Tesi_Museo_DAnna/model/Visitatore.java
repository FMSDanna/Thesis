package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.util.List;

public class Visitatore {
	String age;
	List<Autore> autoriDiInteresse;
	Periodo periodoDiInteresse;
	


	public Visitatore(String age) {
		//se specifico l'età
		this.age = age;
		
		
		this.autoriDiInteresse = generaAutoriDiInteresse();
		this.periodoDiInteresse = new Periodo();
	}

	public Visitatore() {
		this.age=generaAge();
		
		this.periodoDiInteresse = new Periodo();
		this.autoriDiInteresse = generaAutoriDiInteresse();
		
	}
	
	
	public Visitatore(Periodo period) {
		this.age=generaAge();
		
		this.periodoDiInteresse = new Periodo(period.getPeriodo());
		this.autoriDiInteresse = generaAutoriDiInteresse();
			}
	public Visitatore(boolean b) {
		this.age=generaAge();
		this.periodoDiInteresse = null;
		this.autoriDiInteresse = null;
	}
	public Visitatore(String age,Boolean b) {
		//se specifico l'età
		this.age = age;
		
		
		this.periodoDiInteresse = null;
		this.autoriDiInteresse = null;
	}

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

	public Periodo getPeriodoDiInteresse() {
		return periodoDiInteresse;
	}
	
	private List<Autore> generaAutoriDiInteresse() {
		// TODO Auto-generated method stub
		return null;
	}
}
