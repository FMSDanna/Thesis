package it.polito.tdp.NationalGallery.model;

import java.util.ArrayList;
import java.util.List;

public class Famiglia extends Gruppo{

	public Famiglia() {
		super();
		List<MembroFamiglia> membri= new ArrayList<>();
		membri.add(new MembroFamiglia("adulto"));
		membri.add(new MembroFamiglia("bambino"));
		//aggiungo altri bambini casualmente
		
			double prob= Math.random();
			
			if(prob<=0.33) {
				membri.add(new MembroFamiglia("bambino"  ));			
				}
			else if(prob>0.33 && prob<=0.66) {
				membri.add(new MembroFamiglia("bambino"  ));
				membri.add(new MembroFamiglia("bambino"  ));
			}
			else {
				membri.add(new MembroFamiglia("bambino"  ));
				membri.add(new MembroFamiglia("bambino"  ));
				membri.add(new MembroFamiglia("bambino"  ));
			}
			
			//aggiungo un altro adulto casualmente
			prob=Math.random();
			
			if(prob<=0.5) {
				membri.add(new MembroFamiglia("adulto"  ));			
				}
			//aggiungo anziani casualmente
			prob=Math.random();
			
			if(prob<=0.25) {
				membri.add(new MembroFamiglia("anziano"  ));			
				}
			else if(prob>0.25 && prob<=0.50) {
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
			}
			else if(prob>0.5 && prob<=0.75){
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
			}
			else {
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
				membri.add(new MembroFamiglia("anziano"  ));
			}
			List<Visitatore> visitatori=new ArrayList<>();
			for(MembroFamiglia m: membri) {
				visitatori.add(m);
			}
			this.visitatori=visitatori;
		}

	}
		

