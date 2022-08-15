package fiap;
import java.sql.*;
import java.util.*;

public class CarroDAO {
	private Connection con;
	
	public CarroDAO(Connection con) {
		setCon(con);
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}	
}
