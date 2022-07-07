package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.util.ArrayList;
import java.util.List;

public class Famiglia extends Gruppo{

	public Famiglia() {
		super();
		List<MembroFamiglia> membri= new ArrayList<>();
		membri.add(new MembroFamiglia("adulto",false));
		membri.add(new MembroFamiglia("bambino",false));
		//aggiungo altri bambini casualmente
		
			double prob= Math.random();
			
			if(prob<=0.33) {
				membri.add(new MembroFamiglia("bambino",false));			
				}
			else if(prob>0.33 && prob<=0.66) {
				membri.add(new MembroFamiglia("bambino",false));
				membri.add(new MembroFamiglia("bambino",false));
			}
			else {
				membri.add(new MembroFamiglia("bambino",false));
				membri.add(new MembroFamiglia("bambino",false));
				membri.add(new MembroFamiglia("bambino",false));
			}
			
			//aggiungo un altro adulto casualmente
			prob=Math.random();
			
			if(prob<=0.5) {
				membri.add(new MembroFamiglia("adulto",false));			
				}
			//aggiungo anziani casualmente
			prob=Math.random();
			
			if(prob<=0.25) {
				membri.add(new MembroFamiglia("anziano",false));			
				}
			else if(prob>0.25 && prob<=0.50) {
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
			}
			else if(prob>0.5 && prob<=0.75){
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
			}
			else {
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
				membri.add(new MembroFamiglia("anziano",false));
			}
			List<Visitatore> visitatori=new ArrayList<>();
			for(MembroFamiglia m: membri) {
				visitatori.add(m);
			}
			this.visitatori=visitatori;
		}

	}
		

