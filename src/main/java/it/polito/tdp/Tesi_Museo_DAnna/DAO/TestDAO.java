package it.polito.tdp.Tesi_Museo_DAnna.DAO;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
			Map<String,Stanza> mappa=dao.getStanze();
			System.out.println(mappa.size());
			List<String> stanze= new ArrayList<>(mappa.keySet());
			System.out.println(stanze.size());
			for(int i=0;i<30;i++) {
				System.out.println(stanze.get(i)) ;
			}
			System.out.println(stanze.size());
			
		} catch (Exception e) {
			System.err.println("Test FAILED");
		}

	}
}