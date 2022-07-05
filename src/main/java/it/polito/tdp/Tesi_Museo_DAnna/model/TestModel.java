package it.polito.tdp.Tesi_Museo_DAnna.model;
import java.util.Map;

import it.polito.tdp.Tesi_Museo_DAnna.model.Model;
import it.polito.tdp.Tesi_Museo_DAnna.model.Stanza;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		model.getOpere();
		Map<String,Stanza> stanze=model.getStanze();
		int i=0;
		
		for(Stanza s:stanze.values()) {
			System.out.println(s.getOpere());
			i++;
			if(i>20) break;
		}
		
	}
}