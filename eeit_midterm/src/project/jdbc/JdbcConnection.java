package project.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class JdbcConnection implements DataSource {

	private Properties props;
	private String mySQLUrl;
	private String myUser;
	private String myPwd;
	private int maxConn;
	private List<Connection> connPools;
	private Connection conn;

	public JdbcConnection() throws IOException {
		this("mysqlserverjdbc.properties");
	}

	public JdbcConnection(String config) throws IOException {
		props = new Properties();
		props.load(new FileInputStream(config));
		mySQLUrl = props.getProperty("mySQLUrl");
		myUser=props.getProperty("myUser");
		myPwd=props.getProperty("myPwd");
		maxConn=Integer.parseInt(props.getProperty("maxConn"));
		
		System.out.println("mySQLUrl:"+mySQLUrl);
		System.out.println("myUser:"+myUser);
		System.out.println("myPwd:"+myPwd);
		System.out.println("maxConn:"+maxConn);
		
		connPools= Collections.synchronizedList(new ArrayList<Connection>());
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		if(connPools.isEmpty()) {
			conn = DriverManager.getConnection(mySQLUrl,myUser,myPwd);
			return conn;
		}else {
			return connPools.remove(connPools.size()-1);
		}
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		if(connPools.isEmpty()) {
			conn = DriverManager.getConnection(mySQLUrl,myUser,myPwd);
			return conn;
		}else {
			return connPools.remove(connPools.size()-1);
		}
	}
	
	public void closeConn() throws SQLException {
		if(connPools.size()==maxConn) {
			conn.close();
		}else {
			connPools.add(conn);
		}
	}
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
	
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
	
		return false;
	}

}
