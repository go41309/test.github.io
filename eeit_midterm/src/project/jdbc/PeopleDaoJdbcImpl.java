package project.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PeopleDaoJdbcImpl implements IPeopleDao {

	private JdbcConnection jdbc2;
	private Connection conn;

	public PeopleDaoJdbcImpl() throws IOException, SQLException {
		jdbc2 = new JdbcConnection();

	}

	@Override
	public void createConn() throws SQLException {
		conn = jdbc2.getConnection();
		boolean status = !conn.isClosed();
		System.out.println("status:" + status);
	}

	@Override
	public void closeConn() throws SQLException {
		conn.close();

	}


	@Override
	public void update(People p) throws SQLException {
		String sqlstr = "Update deadcause106 Set amount=? where id=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, p.getAmount());
		state.setInt(2, p.getId());
		state.execute();
		System.out.println("Update Success.");
	    state.close();}

	@Override
	public void delete(People p) throws SQLException {
		String sqlstr = "Delete From deadcause106 Where id=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, p.getId());
		state.execute();
		System.out.println("Delete Success.");
		state.close();
	}

	@Override
	public void insertDb(People p) throws SQLException {
		String sqlstr = "Insert Into deadcause106(year,county,cause,sex,age_code,amount) Values(?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, p.getYear());
		state.setInt(2, p.getCounty());
		state.setInt(3, p.getCause());
		state.setString(4, p.getSex());
		state.setInt(5, p.getAge_code());
		state.setInt(6, p.getAmount());
		state.execute();
		System.out.println("Insert Success.");
		state.close();
	}
	public void queryDb() throws SQLException, JSONException, IOException {
		Statement state = conn.createStatement();
		String sqlstr = "Select * From deadcause106";
		ResultSet rs = state.executeQuery(sqlstr);
		
		JSONArray jsonArray = new JSONArray();
		FileWriter fw1=new FileWriter("d:/test.csv");
		while (rs.next()) {			
			JSONObject object = new JSONObject();
			object.put("id", rs.getInt("id"));
			object.put("year", rs.getInt("year"));
			object.put("county", rs.getInt("county"));
			object.put("cause", rs.getInt("cause"));
			object.put("sex", rs.getString("sex"));
			object.put("age_code", rs.getInt("age_code"));
			object.put("amount", rs.getInt("amount"));
			jsonArray.put(object);	
			
			System.out.print(rs.getInt("id"));
			System.out.print(rs.getInt("year"));
			System.out.print(rs.getInt("county"));
			System.out.print(rs.getInt("cause"));
			System.out.print(rs.getString("sex"));
			System.out.print(rs.getInt("age_code"));
			System.out.println(rs.getInt("amount"));	
			
		}
		fw1.write(jsonArray.toString());
		fw1.close();
		rs.close();
		state.close();
	}
	
	@Override
	public void inputDb() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\dead106.csv"));
		String data = br.readLine();
		PreparedStatement state = null;
		while ((data = br.readLine()) != null) {
			String[] data2 = new String[6];
			data2 = data.split(",");
			String sqlstr = "Insert Into deadcause106(year,county,cause,sex,age_code,amount)" + "Values(?,?,?,?,?,?)";
			state = conn.prepareStatement(sqlstr);
			for (int i = 0; i < data2.length; i++) {
				System.out.println(data2[i].trim());
				state.setString(i + 1, data2[i].trim());
				
			}
			state.addBatch();
			state.executeBatch();
		}
		br.close();
	}
	

}
