package it.polito.tdp.Tesi_Museo_DAnna.model;



import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.Tesi_Museo_DAnna.DAO.MuseoDAO;



public class Model {
	Graph<Stanza,DefaultEdge> museo;
	Map<String,Stanza> stanzeMap;
	Map<Integer,Opera> opereMap;
	List<Autore> autori;
	List<Opera> opereList;
	List<Stanza> stanzeList;
	List<Periodo> periodi; 
	List<Integer> begYear;
	List<Integer> endYear;
	
	MuseoDAO dao;
	public Model() {
		this.periodi=creaPeriodi();
		this.dao=new MuseoDAO();
		this.stanzeMap=new LinkedHashMap<>();
		this.opereMap= new LinkedHashMap<>();
		this.autori=new LinkedList<>();
		this.opereList=new LinkedList<>();
		this.stanzeList=new LinkedList<>();
		
	}

	public void inizializza() {
		this.stanzeList=this.dao.getStanze();
		this.stanzeList.add(new Stanza("West Building",  "M-011", 1, "West Main Floor Gallery 11"));
		this.stanzeList.add(new Stanza("West Building",  "M-137", 1, "West Bldg, Lobby D"));
		this.stanzeList.add(new Stanza("West Building",  "M-103", 1, "West Bldg, Lobby A"));		
		this.stanzeList.add(new Stanza("West Building",  "M-014", 1, "West Main Floor Gallery 14"));
		this.stanzeList.add(new Stanza("West Building",  "M-015", 1, "West Main Floor Gallery 15"));
		this.stanzeList.add(new Stanza("West Building",  "M-016", 1, "West Main Floor Gallery 16"));
		
		
		this.creaStanzeMap();
		
		this.stanzeMap.get("M-001").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-002").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-003").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-004").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-005").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-006").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-007").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-008").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-009").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-010").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-011").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-012").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-013").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-014").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		this.stanzeMap.get("M-015").setPeriodo(new Periodo("13th-to 15th Century Italian"));
		
		this.stanzeMap.get("M-016").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-017").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-018").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-019").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-020").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-021").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-022").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-023").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-024").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-025").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-026").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-027").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		this.stanzeMap.get("M-028").setPeriodo(new Periodo("16th-Century Italian and Spanish"));
		
		
		this.stanzeMap.get("M-029").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-030").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-031").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-032").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-033").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-034").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-036").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		this.stanzeMap.get("M-037").setPeriodo(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		
		
		this.stanzeMap.get("M-035").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-035-A").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-038").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-039").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-040").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-041").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		this.stanzeMap.get("M-041-A").setPeriodo(new Periodo("15th-to 16th-Century Netherlandish and German"));
		
		this.stanzeMap.get("M-042").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-043").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-044").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-045").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-046").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-047").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-048").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-049").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-050").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-051").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-050-A").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-050-B").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));
		this.stanzeMap.get("M-050-C").setPeriodo(new Periodo("17th-Century Dutch and Flemish"));

		this.stanzeMap.get("M-052").setPeriodo(new Periodo("18th- and 19th-Century Spanish"));
		
		this.stanzeMap.get("M-053").setPeriodo(new Periodo("18th-and Early 19th-Century French"));
		this.stanzeMap.get("M-054").setPeriodo(new Periodo("18th-and Early 19th-Century French"));
		this.stanzeMap.get("M-055").setPeriodo(new Periodo("18th-and Early 19th-Century French"));
		this.stanzeMap.get("M-056").setPeriodo(new Periodo("18th-and Early 19th-Century French"));
		
		this.stanzeMap.get("M-080").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-081").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-082").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-083").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-084").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-085").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-086").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-087").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-088").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-089").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-090").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-091").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-092").setPeriodo(new Periodo("19th-Century French"));
		this.stanzeMap.get("M-093").setPeriodo(new Periodo("19th-Century French"));
		
		this.stanzeMap.get("M-057").setPeriodo(new Periodo("British"));
		this.stanzeMap.get("M-058").setPeriodo(new Periodo("British"));
		this.stanzeMap.get("M-059").setPeriodo(new Periodo("British"));
		this.stanzeMap.get("M-061").setPeriodo(new Periodo("British"));
		this.stanzeMap.get("M-063").setPeriodo(new Periodo("British"));

		this.stanzeMap.get("M-060").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-060-A").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-060-B").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-062").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-064").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-065").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-066").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-067").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-068").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-069").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-070").setPeriodo(new Periodo("American"));
		this.stanzeMap.get("M-071").setPeriodo(new Periodo("American"));
		
		this.stanzeMap.get("M-072").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-073").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-074").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-075").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-076").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-077").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-078").setPeriodo(new Periodo("Special Exhibitions"));
		this.stanzeMap.get("M-079").setPeriodo(new Periodo("Special Exhibitions"));

		
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
		this.begYear=this.dao.getBeginYear();
		return this.begYear;
	}
	public List<Integer> getEndYear(){
		this.endYear=this.dao.getEndYear();
		return this.endYear;
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
	
	public void creaGrafo() {
		museo= new SimpleGraph<Stanza,DefaultEdge>(DefaultEdge.class);
		Graphs.addAllVertices(museo, this.stanzeList);
		//collego la Rotunda (hub centrale del museo) con i servizi 
		museo.addEdge(this.stanzeMap.get("M-107"), this.stanzeMap.get("M-113")); 
		museo.addEdge(this.stanzeMap.get("M-107"), this.stanzeMap.get("M-121")); 
		museo.addEdge(this.stanzeMap.get("M-107"), this.stanzeMap.get("M-127")); 
		museo.addEdge(this.stanzeMap.get("M-107"), this.stanzeMap.get("M-106")); 
		museo.addEdge(this.stanzeMap.get("M-107"), this.stanzeMap.get("M-134"));
		
		//collego la "west sculpture hall" con le stanze adiacenti
		
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-001")); 
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-004")); 
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-007")); 
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-051")); 
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-048")); 
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-046"));
		museo.addEdge(this.stanzeMap.get("M-106"), this.stanzeMap.get("M-105"));
		//collego la "lobby B" con la "West Garden Court"
		
		museo.addEdge(this.stanzeMap.get("M-105"), this.stanzeMap.get("M-104"));
		//collego la "West Garden Court" con le stanze adiacenti 
		
		
		museo.addEdge(this.stanzeMap.get("M-104"), this.stanzeMap.get("M-038")); 
		museo.addEdge(this.stanzeMap.get("M-104"), this.stanzeMap.get("M-011")); 
		museo.addEdge(this.stanzeMap.get("M-104"), this.stanzeMap.get("M-103")); 
		//collego la lobby A con le stanze adiacenti
		museo.addEdge(this.stanzeMap.get("M-103"), this.stanzeMap.get("M-028")); 
		museo.addEdge(this.stanzeMap.get("M-103"), this.stanzeMap.get("M-029"));
		//collego la "east sculpture hall" con le stanze adiacenti
		
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-093")); 
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-089")); 
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-085")); 
		
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-057")); 
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-056")); 
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-052"));
		
		museo.addEdge(this.stanzeMap.get("M-134"), this.stanzeMap.get("M-135"));
		//collego la "lobby C" con la "East Garden Court"
		
		museo.addEdge(this.stanzeMap.get("M-135"), this.stanzeMap.get("M-136"));
		//collego la "East Garden Court" con le stanze adiacenti 
		museo.addEdge(this.stanzeMap.get("M-136"), this.stanzeMap.get("M-060"));  
		museo.addEdge(this.stanzeMap.get("M-136"), this.stanzeMap.get("M-137")); 
		museo.addEdge(this.stanzeMap.get("M-136"), this.stanzeMap.get("M-074"));
		museo.addEdge(this.stanzeMap.get("M-136"), this.stanzeMap.get("M-138"));
		//collego la "lobby D" con le stanze adiacenti
		museo.addEdge(this.stanzeMap.get("M-137"), this.stanzeMap.get("M-071"));
		museo.addEdge(this.stanzeMap.get("M-137"), this.stanzeMap.get("M-072"));
		//collego tra loro le stanze
		museo.addEdge(this.stanzeMap.get("M-001"), this.stanzeMap.get("M-002"));
		museo.addEdge(this.stanzeMap.get("M-002"), this.stanzeMap.get("M-003"));
		museo.addEdge(this.stanzeMap.get("M-003"), this.stanzeMap.get("M-004"));
		museo.addEdge(this.stanzeMap.get("M-004"), this.stanzeMap.get("M-005"));
		museo.addEdge(this.stanzeMap.get("M-005"), this.stanzeMap.get("M-006"));
		museo.addEdge(this.stanzeMap.get("M-006"), this.stanzeMap.get("M-007"));
		museo.addEdge(this.stanzeMap.get("M-007"), this.stanzeMap.get("M-008"));
		museo.addEdge(this.stanzeMap.get("M-008"), this.stanzeMap.get("M-009"));
		museo.addEdge(this.stanzeMap.get("M-009"), this.stanzeMap.get("M-010"));
		museo.addEdge(this.stanzeMap.get("M-010"), this.stanzeMap.get("M-011"));
		museo.addEdge(this.stanzeMap.get("M-011"), this.stanzeMap.get("M-012"));
		museo.addEdge(this.stanzeMap.get("M-011"), this.stanzeMap.get("M-022"));
		museo.addEdge(this.stanzeMap.get("M-012"), this.stanzeMap.get("M-017"));
		museo.addEdge(this.stanzeMap.get("M-012"), this.stanzeMap.get("M-021"));
		museo.addEdge(this.stanzeMap.get("M-012"), this.stanzeMap.get("M-013"));
		museo.addEdge(this.stanzeMap.get("M-013"), this.stanzeMap.get("M-014"));
		museo.addEdge(this.stanzeMap.get("M-013"), this.stanzeMap.get("M-016"));
		museo.addEdge(this.stanzeMap.get("M-014"), this.stanzeMap.get("M-015"));
		museo.addEdge(this.stanzeMap.get("M-015"), this.stanzeMap.get("M-016"));
		museo.addEdge(this.stanzeMap.get("M-016"), this.stanzeMap.get("M-017"));
		museo.addEdge(this.stanzeMap.get("M-017"), this.stanzeMap.get("M-018"));
		museo.addEdge(this.stanzeMap.get("M-018"), this.stanzeMap.get("M-019"));
		museo.addEdge(this.stanzeMap.get("M-019"), this.stanzeMap.get("M-020"));
		museo.addEdge(this.stanzeMap.get("M-020"), this.stanzeMap.get("M-021"));
		museo.addEdge(this.stanzeMap.get("M-021"), this.stanzeMap.get("M-022"));
		museo.addEdge(this.stanzeMap.get("M-022"), this.stanzeMap.get("M-023"));
		museo.addEdge(this.stanzeMap.get("M-023"), this.stanzeMap.get("M-027"));
		museo.addEdge(this.stanzeMap.get("M-023"), this.stanzeMap.get("M-024"));
		museo.addEdge(this.stanzeMap.get("M-024"), this.stanzeMap.get("M-025"));
		museo.addEdge(this.stanzeMap.get("M-025"), this.stanzeMap.get("M-026"));
		museo.addEdge(this.stanzeMap.get("M-026"), this.stanzeMap.get("M-027"));
		museo.addEdge(this.stanzeMap.get("M-027"), this.stanzeMap.get("M-028"));
		museo.addEdge(this.stanzeMap.get("M-029"), this.stanzeMap.get("M-033"));
		museo.addEdge(this.stanzeMap.get("M-029"), this.stanzeMap.get("M-030"));
		museo.addEdge(this.stanzeMap.get("M-030"), this.stanzeMap.get("M-031"));
		museo.addEdge(this.stanzeMap.get("M-031"), this.stanzeMap.get("M-032"));
		museo.addEdge(this.stanzeMap.get("M-032"), this.stanzeMap.get("M-030"));
		museo.addEdge(this.stanzeMap.get("M-030"), this.stanzeMap.get("M-033"));
		museo.addEdge(this.stanzeMap.get("M-033"), this.stanzeMap.get("M-034"));
		museo.addEdge(this.stanzeMap.get("M-034"), this.stanzeMap.get("M-035"));
		museo.addEdge(this.stanzeMap.get("M-034"), this.stanzeMap.get("M-036"));
		museo.addEdge(this.stanzeMap.get("M-035"), this.stanzeMap.get("M-035-A"));
		museo.addEdge(this.stanzeMap.get("M-035-A"), this.stanzeMap.get("M-040"));
		museo.addEdge(this.stanzeMap.get("M-035-A"), this.stanzeMap.get("M-036"));
		museo.addEdge(this.stanzeMap.get("M-036"), this.stanzeMap.get("M-037"));
		museo.addEdge(this.stanzeMap.get("M-037"), this.stanzeMap.get("M-038"));
		museo.addEdge(this.stanzeMap.get("M-038"), this.stanzeMap.get("M-039"));
		museo.addEdge(this.stanzeMap.get("M-038"), this.stanzeMap.get("M-043"));
		museo.addEdge(this.stanzeMap.get("M-039"), this.stanzeMap.get("M-040"));
		museo.addEdge(this.stanzeMap.get("M-040"), this.stanzeMap.get("M-041"));
		museo.addEdge(this.stanzeMap.get("M-041"), this.stanzeMap.get("M-041-A"));
		museo.addEdge(this.stanzeMap.get("M-041"), this.stanzeMap.get("M-042"));
		museo.addEdge(this.stanzeMap.get("M-041-A"), this.stanzeMap.get("M-042"));
		museo.addEdge(this.stanzeMap.get("M-042"), this.stanzeMap.get("M-043"));
		museo.addEdge(this.stanzeMap.get("M-042"), this.stanzeMap.get("M-044"));
		museo.addEdge(this.stanzeMap.get("M-044"), this.stanzeMap.get("M-045"));
		museo.addEdge(this.stanzeMap.get("M-045"), this.stanzeMap.get("M-046"));
		museo.addEdge(this.stanzeMap.get("M-046"), this.stanzeMap.get("M-047"));
		museo.addEdge(this.stanzeMap.get("M-046"), this.stanzeMap.get("M-048"));
		museo.addEdge(this.stanzeMap.get("M-047"), this.stanzeMap.get("M-048"));
		museo.addEdge(this.stanzeMap.get("M-047"), this.stanzeMap.get("M-049"));
		museo.addEdge(this.stanzeMap.get("M-048"), this.stanzeMap.get("M-049"));
		museo.addEdge(this.stanzeMap.get("M-048"), this.stanzeMap.get("M-051"));
		museo.addEdge(this.stanzeMap.get("M-049"), this.stanzeMap.get("M-050"));
		museo.addEdge(this.stanzeMap.get("M-050"), this.stanzeMap.get("M-050-A"));
		museo.addEdge(this.stanzeMap.get("M-050"), this.stanzeMap.get("M-051"));
		museo.addEdge(this.stanzeMap.get("M-050-A"), this.stanzeMap.get("M-050-B"));
		museo.addEdge(this.stanzeMap.get("M-050-B"), this.stanzeMap.get("M-050-C"));
		museo.addEdge(this.stanzeMap.get("M-050-C"), this.stanzeMap.get("M-051"));
		
		//ala destra 
		museo.addEdge(this.stanzeMap.get("M-052"), this.stanzeMap.get("M-053"));
		museo.addEdge(this.stanzeMap.get("M-052"), this.stanzeMap.get("M-056"));
		museo.addEdge(this.stanzeMap.get("M-053"), this.stanzeMap.get("M-054"));
		museo.addEdge(this.stanzeMap.get("M-054"), this.stanzeMap.get("M-055"));
		museo.addEdge(this.stanzeMap.get("M-054"), this.stanzeMap.get("M-056"));
		museo.addEdge(this.stanzeMap.get("M-055"), this.stanzeMap.get("M-056"));
		museo.addEdge(this.stanzeMap.get("M-056"), this.stanzeMap.get("M-057"));
		museo.addEdge(this.stanzeMap.get("M-057"), this.stanzeMap.get("M-058"));
		museo.addEdge(this.stanzeMap.get("M-058"), this.stanzeMap.get("M-059"));
		museo.addEdge(this.stanzeMap.get("M-059"), this.stanzeMap.get("M-060"));
		museo.addEdge(this.stanzeMap.get("M-059"), this.stanzeMap.get("M-061"));
		museo.addEdge(this.stanzeMap.get("M-059"), this.stanzeMap.get("M-063"));
		museo.addEdge(this.stanzeMap.get("M-060"), this.stanzeMap.get("M-060-A"));
		museo.addEdge(this.stanzeMap.get("M-060"), this.stanzeMap.get("M-067"));
		museo.addEdge(this.stanzeMap.get("M-060-A"), this.stanzeMap.get("M-060-B"));
		museo.addEdge(this.stanzeMap.get("M-060-A"), this.stanzeMap.get("M-063"));
		museo.addEdge(this.stanzeMap.get("M-060-A"), this.stanzeMap.get("M-065"));
		museo.addEdge(this.stanzeMap.get("M-060-B"), this.stanzeMap.get("M-062"));
		museo.addEdge(this.stanzeMap.get("M-060-B"), this.stanzeMap.get("M-064"));
		museo.addEdge(this.stanzeMap.get("M-061"), this.stanzeMap.get("M-062"));
		museo.addEdge(this.stanzeMap.get("M-061"), this.stanzeMap.get("M-063"));
		museo.addEdge(this.stanzeMap.get("M-062"), this.stanzeMap.get("M-063"));
		museo.addEdge(this.stanzeMap.get("M-064"), this.stanzeMap.get("M-065"));
		museo.addEdge(this.stanzeMap.get("M-064"), this.stanzeMap.get("M-066"));
		museo.addEdge(this.stanzeMap.get("M-066"), this.stanzeMap.get("M-067"));
		museo.addEdge(this.stanzeMap.get("M-065"), this.stanzeMap.get("M-066"));
		museo.addEdge(this.stanzeMap.get("M-067"), this.stanzeMap.get("M-068"));
		museo.addEdge(this.stanzeMap.get("M-068"), this.stanzeMap.get("M-069"));
		museo.addEdge(this.stanzeMap.get("M-067"), this.stanzeMap.get("M-071"));
		museo.addEdge(this.stanzeMap.get("M-069"), this.stanzeMap.get("M-069-A"));
		museo.addEdge(this.stanzeMap.get("M-069"), this.stanzeMap.get("M-070"));
		museo.addEdge(this.stanzeMap.get("M-070"), this.stanzeMap.get("M-071"));
		museo.addEdge(this.stanzeMap.get("M-072"), this.stanzeMap.get("M-073"));
		museo.addEdge(this.stanzeMap.get("M-073"), this.stanzeMap.get("M-074"));
		museo.addEdge(this.stanzeMap.get("M-073"), this.stanzeMap.get("M-077"));
		museo.addEdge(this.stanzeMap.get("M-074"), this.stanzeMap.get("M-075"));
		museo.addEdge(this.stanzeMap.get("M-074"), this.stanzeMap.get("M-083"));
		museo.addEdge(this.stanzeMap.get("M-075"), this.stanzeMap.get("M-076"));
		museo.addEdge(this.stanzeMap.get("M-075"), this.stanzeMap.get("M-079"));
		museo.addEdge(this.stanzeMap.get("M-075"), this.stanzeMap.get("M-082"));
		museo.addEdge(this.stanzeMap.get("M-076"), this.stanzeMap.get("M-077"));
		museo.addEdge(this.stanzeMap.get("M-077"), this.stanzeMap.get("M-078"));
		museo.addEdge(this.stanzeMap.get("M-078"), this.stanzeMap.get("M-079"));
		museo.addEdge(this.stanzeMap.get("M-079"), this.stanzeMap.get("M-080"));
		museo.addEdge(this.stanzeMap.get("M-080"), this.stanzeMap.get("M-081"));
		museo.addEdge(this.stanzeMap.get("M-081"), this.stanzeMap.get("M-082"));
		museo.addEdge(this.stanzeMap.get("M-081"), this.stanzeMap.get("M-083"));
		museo.addEdge(this.stanzeMap.get("M-083"), this.stanzeMap.get("M-084"));
		museo.addEdge(this.stanzeMap.get("M-084"), this.stanzeMap.get("M-085"));
		museo.addEdge(this.stanzeMap.get("M-085"), this.stanzeMap.get("M-086"));
		museo.addEdge(this.stanzeMap.get("M-085"), this.stanzeMap.get("M-089"));
		museo.addEdge(this.stanzeMap.get("M-086"), this.stanzeMap.get("M-087"));
		museo.addEdge(this.stanzeMap.get("M-087"), this.stanzeMap.get("M-088"));
		museo.addEdge(this.stanzeMap.get("M-088"), this.stanzeMap.get("M-089"));
		museo.addEdge(this.stanzeMap.get("M-089"), this.stanzeMap.get("M-090"));
		museo.addEdge(this.stanzeMap.get("M-089"), this.stanzeMap.get("M-093"));
		museo.addEdge(this.stanzeMap.get("M-090"), this.stanzeMap.get("M-091"));
		museo.addEdge(this.stanzeMap.get("M-091"), this.stanzeMap.get("M-092"));
		museo.addEdge(this.stanzeMap.get("M-092"), this.stanzeMap.get("M-093"));
		museo.addEdge(this.stanzeMap.get("M-016"), this.stanzeMap.get("M-017"));

		
		
	}
	
	private List<Periodo> creaPeriodi() {
		List<Periodo> periodi= new ArrayList<Periodo>();
		periodi.add(new Periodo("13th-to 15th Century Italian"));
		periodi.add(new Periodo("16th-Century Italian and Spanish"));
		periodi.add(new Periodo("17th- and 18th-Century Italian, Spanish and French"));
		periodi.add(new Periodo("15th-to 16th-Century Netherlandish and German"));
		periodi.add(new Periodo("17th-Century Dutch and Flemish"));
		periodi.add(new Periodo("18th- and 19th-Century Spanish"));
		periodi.add(new Periodo("18th-and Early 19th-Century French"));
		periodi.add(new Periodo("19th-Century French"));
		periodi.add(new Periodo("British"));
		periodi.add(new Periodo("American"));
		periodi.add(new Periodo("Special Exhibitions"));
		periodi.add(new Periodo("Prints and Drawings"));

		return periodi;
	}
}
