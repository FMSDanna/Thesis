package it.polito.tdp.Tesi_Museo_DAnna.model;

import java.util.ArrayList;
import java.util.List;

public class Turistico extends Gruppo{
		private Periodo periodoInteresse;

		public Turistico() {
			super();
			// TODO Auto-generated constructor stub
			int nTuristi = (int)(Math.random()*(15+1));
			List<Visitatore> membri= new ArrayList<>();
			for(int i=0; i<=nTuristi;i++) {
				membri.add(new Visitatore(false));
			}
			this.visitatori=membri;
			this.periodoInteresse = new Periodo();
		}

		public Periodo getPeriodoInteresse() {
			return periodoInteresse;
		}


		
		
}
