package project.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import org.json.JSONException;

public interface IPeopleDao {
	public void createConn() throws SQLException;
	public void closeConn() throws SQLException;
	public void update(People p) throws SQLException;
	public void delete(People p) throws SQLException;
	public void insertDb(People p) throws SQLException;
	public void queryDb() throws SQLException, JSONException, IOException;
	public void inputDb() throws Exception;

}
