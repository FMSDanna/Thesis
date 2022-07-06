package it.polito.tdp.Tesi_Museo_DAnna.model;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.Tesi_Museo_DAnna.DAO.MuseoDAO;



public class Model {
	Map<String,Stanza> stanzeMap;
	Map<Integer,Opera> opereMap;
	List<Autore> autori;
	List<Opera> opereList;
	List<Stanza> stanzeList;
	
	MuseoDAO dao;
	public Model() {
		this.dao=new MuseoDAO();
		this.stanzeMap=new LinkedHashMap<>();
		this.opereMap= new LinkedHashMap<>();
		this.autori=new LinkedList<>();
		this.opereList=new LinkedList<>();
		this.stanzeList=new LinkedList<>();
	}
	public void inizializza() {
		this.stanzeList=this.dao.getStanze();
		this.creaStanzeMap();
		this.opereList=this.dao.getOpere(stanzeMap);
		this.creaOpereMap();
		
		
	}

	public List<Opera> getOpere(){
		
		return this.opereList ;
	}
	public List<Stanza> getStanze(){
	
		return this.stanzeList;
	}
	public List<Autore> getAutoriByAnno(int beg,int end){
		this.autori= this.dao.getAutoriByAnno(beg, end);
		return this.autori;
	}
	public void creaStanzeMap() {
		if(this.stanzeMap.size()==0 && !(this.stanzeList.size()==0)) {
			for(Stanza s: this.stanzeList) {
				stanzeMap.put(s.getRoom(), s);
			}
		}
		
	}
	public void creaOpereMap() {
		if(this.opereMap.size()==0 && !(this.opereList.size()==0)) {
			for(Opera o: this.opereList) {
				opereMap.put(o.getObjectid(), o);
			}
		}
	}
	
	public List<Opera> getOpereByAutoriAnno(Autore a, int beg, int end){
		List<Opera> result= new LinkedList<>();
		List<Integer> codici= this.dao.getOpereByAutoriAnno(a, beg, end);
		for(Integer i: codici) {
			result.add(this.opereMap.get(i));
				
			
		}
		return result;
	}
	public List<Integer> getBeginYear(){
		return this.dao.getBeginYear();
	}
	public List<Integer> getEndYear(){
		return this.dao.getEndYear();
	}
	public String getInfo(Opera o) {
		
		String result="Work "+o.getObjectid()+
						":\n-Title : "+ o.getTitle()+
						"\n-Attribution : "+o.getAttribution()+
						"\n-Period : "+o.getBeginYear()+" - "+o.getEndYear()+
						"\n-Description : " +o.getClassification()+" - \n"+o.getMedium()+
						"\n-Dimensions : "+o.getDimensions()+"\n";
		return result;
	}
}
