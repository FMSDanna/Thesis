package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.util.ArrayList;
import java.util.List;

public class Turistico extends Gruppo{
		private String periodoInteresse;

		public Turistico() {
			super();
			// TODO Auto-generated constructor stub
			int nTuristi = (int)(Math.random()*(15+1));
			List<Visitatore> membri= new ArrayList<>();
			for(int i=0; i<=nTuristi;i++) {
				membri.add(new Visitatore());
			}
			this.visitatori=membri;
			this.periodoInteresse = null;
		}

		public String getPeriodoInteresse() {
			return periodoInteresse;
		}


		
		
}
