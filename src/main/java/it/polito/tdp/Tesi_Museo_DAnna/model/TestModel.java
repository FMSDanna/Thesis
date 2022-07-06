package it.polito.tdp.Tesi_Museo_DAnna.model;
import java.util.List;
import java.util.Map;

import it.polito.tdp.Tesi_Museo_DAnna.model.Model;
import it.polito.tdp.Tesi_Museo_DAnna.model.Stanza;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		model.inizializza();
		List<Opera> opere=model.getOpere();
		
		int i=0;
		
		for(Opera o:opere) {
			System.out.println(o);
			i++;
			if(i>5) break;
		}
		System.out.println(model.getStanze()); 
	}
}