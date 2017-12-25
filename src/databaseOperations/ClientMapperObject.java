package databaseOperations;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapperObject {

	public ClientDto ClientMapper(ResultSet rs) throws SQLException {
		
		ClientDto clientToMap = null;
		
		try {
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			int id = rs.getInt("id");
			long pesel = rs.getLong("pesel");
			
			clientToMap = new ClientDto(name, surname, id, pesel);
		
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return clientToMap;
	}
}
