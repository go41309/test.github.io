package project.jdbc;

import java.io.IOException;
import java.sql.SQLException;

public class PeopleDaoFactory {
public static IPeopleDao createPeopleDao() throws IOException, SQLException {
	IPeopleDao pDao = new PeopleDaoJdbcImpl();
	return pDao;
	
}
}
