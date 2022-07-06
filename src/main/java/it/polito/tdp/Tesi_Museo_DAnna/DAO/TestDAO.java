package it.polito.tdp.Tesi_Museo_DAnna.DAO;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.Tesi_Museo_DAnna.model.Opera;
import it.polito.tdp.Tesi_Museo_DAnna.model.Stanza;






public class TestDAO {
	public static void main(String[] args) {
		
		try {
			Connection connection = ConnectDB.getConnection();
			connection.close();
			System.out.println("Connection Test PASSED");
			
			MuseoDAO dao = new MuseoDAO() ;
		/*	List<Opera> opere=dao.getOpere();
			System.out.println(opere.size());
			for(int i=0;i<30;i++) {
				System.out.println(opere.get(i)) ;
			}
			*/
			List<Stanza> mappa=dao.getStanze();
			Map<String,Stanza> mappaStanze=new LinkedHashMap<>();
			for(Stanza s: mappa) {
				mappaStanze.put(s.getRoom(), s);
			}
			List<Opera> opere=dao.getOpere(mappaStanze);
			System.out.println(mappa.size());
			for(int i=0;i<10;i++) {
				System.out.println(mappa.get(i)) ;
				List<Opera> opereStanza=new LinkedList<>(mappa.get(i).getOpere());
				System.out.println(opereStanza);
			}
			System.out.println(mappa.size());
			
			
		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}
}