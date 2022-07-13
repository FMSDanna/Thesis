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
			double prob= Math.random();
			if (prob<=0.5) 
			visitors.add(new Visitatore("adulto"));
			else 
				visitors.add(new Visitatore("anziano"));
		}
		this.visitatori = visitors;
	}
	
//	public Generico(double prob,Periodo period) {
//		super();
//		this.periodoDiInteresse=period;
//		List<Visitatore> visitors= new ArrayList<>();
//		int nVisitatori= (int)(Math.random()*(10+1));
//			visitors.add(new Visitatore("adulto"));
//		for(int i=0;i<nVisitatori;i++) {
//			double probability=Math.random();
//			double probEta= Math.random();
//			if(prob<probability) {
//				if (probEta<=0.5) 
//					visitors.add(new Visitatore("adulto",period));
//					else 
//						visitors.add(new Visitatore("anziano",period));
//				
//
//			}
//			else {
//				if (probEta<=0.5) 
//					visitors.add(new Visitatore("adulto"));
//					else 
//						visitors.add(new Visitatore("anziano"));
//			}
//		}
//		this.visitatori = visitors;
//	}

}
