package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.util.ArrayList;
import java.util.List;

public class Generico extends Gruppo{

	public Generico() {
		super();
		List<Visitatore> visitors= new ArrayList<>();
		int nVisitatori= (int)(Math.random()*(10+1));
			visitors.add(new Visitatore("adulto"));
		for(int i=0;i<nVisitatori;i++) {
			visitors.add(new Visitatore());
		}
		this.visitatori = visitors;
	}
	
	public Generico(double prob,Periodo period) {
		super();
		List<Visitatore> visitors= new ArrayList<>();
		int nVisitatori= (int)(Math.random()*(10+1));
			visitors.add(new Visitatore("adulto"));
		for(int i=0;i<nVisitatori;i++) {
			double probability=Math.random();
			if(prob<probability) {
				visitors.add(new Visitatore(period));

			}
			else {
				visitors.add(new Visitatore());
			}
		}
		this.visitatori = visitors;
	}

}
