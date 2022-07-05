package it.polito.tdp.Tesi_Museo_DAnna.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.Tesi_Museo_DAnna.model.Autore;
import it.polito.tdp.Tesi_Museo_DAnna.model.Opera;
import it.polito.tdp.Tesi_Museo_DAnna.model.Stanza;





public class MuseoDAO {
	
	public List<Opera> getOpere() {
		
		String sql = "SELECT *  FROM objects o WHERE o.objectid IN (SELECT  o1.objectid FROM objects o1, locations l1 WHERE o1.locationid=l1.locationid);";
		List<Opera> opere = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Opera o = new Opera(res.getInt("objectid"), res.getInt("accessioned"),res.getString("accessionnum"),res.getString("locationid"),res.getString("title"),
						res.getString("displaydate"),res.getString("beginyear"),res.getString("endyear"),res.getString("visualbrowsertimespan"),res.getString("medium"),res.getString("dimensions"),res.getString("inscription"),res.getString("markings"),res.getString("attributioninverted"),res.getString("attribution"),
						res.getString("provenancetext"),res.getString("creditline"),res.getString("classification"),res.getString("subclassification"),res.getString("visualbrowserclassification"),res.getString("parentid"),res.getInt("isvirtual"),res.getString("departmentabbr"),res.getString("portfolio"),res.getString("series"),
						res.getString("volume"),res.getString("watermarks"),res.getString("lastdetectedmodification"),res.getString("customprinturl"));
				opere.add(o);
				System.out.println("aggiunta opera:" +o);
				
			}
				

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return opere;
	}
	public List<Stanza> getStanze() {

		String sql = "SELECT DISTINCT l.site,l.room,l.publicacces,l.description  FROM objects o, locations l where o.locationid=l.locationid;";
		List<Stanza> stanze = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				String site=res.getString("site");
				String room=res.getString("room");
				int publicAccess=res.getInt("publicacces");
				String description=res.getString("description");
				Stanza s= new Stanza(site,room,publicAccess,description);
				stanze.add(s);
					
				
			}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//ArrayList<Stanza>stanze=new ArrayList<>(stanzeMap.values());
		return stanze;
	}
	/*public List<Location> getLocation() {
		String sql = "SELECT o.objectid,l.room  FROM objects o, locations l where o.locationid=l.locationid;";
		List<Location> result= new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				String room=res.getString("room");
				int objectid=res.getInt("objectid");
				Location l= new Location(objectid,room);
				result.add(l);				
				}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//ArrayList<Stanza>stanze=new ArrayList<>(stanzeMap.values());
		return result;
	} */
	public List<Autore> getAutoriByAnno(int beg,int end) {

		String sql = "SELECT DISTINCT attribution FROM objects WHERE beginyear>=? AND endyear<=? ORDER BY attribution;";
		List<Autore> autori = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, beg);
			st.setInt(2, end);
			ResultSet res = st.executeQuery();

			while (res.next()) {
						Autore a= new Autore(res.getString("attribution"));
						autori.add(a);
			}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return autori;
	}
	public List<Integer> getOpereByAutoriAnno(Autore a,int beg,int end) {

		String sql = "SELECT DISTINCT * FROM objects WHERE beginyear>? AND endyear<? AND attribution=? ORDER BY title;";
		List<Integer> opereA = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, beg);
			st.setInt(2, end);
			st.setString(3, a.getNome());
			ResultSet res = st.executeQuery();

			while (res.next()) {
					opereA.add(res.getInt("objectid"));
						
			}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return opereA;
	}
	public List<Integer> getBeginYear() {

		String sql = "SELECT DISTINCT beginyear FROM objects ORDER BY beginyear;";
		List<Integer> anni = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
					try {
						anni.add(Integer.parseInt(res.getString("beginyear")));
					}catch(NumberFormatException e) {
						
					}
						
			}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return anni;
	}
	public List<Integer> getEndYear() {

		String sql = "SELECT DISTINCT endyear FROM objects ORDER BY endyear;";
		List<Integer> anni = new LinkedList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
					try {
						anni.add(Integer.parseInt(res.getString("endyear")));
					}catch(NumberFormatException e) {
						
					}
						
			}
			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return anni;
	}
	
}


