import java.sql.*;
public class SQLCon {
	public Connection con;
	
	public SQLCon(String un, String pwd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Marathon",un,pwd);
			System.out.println("Login successful\n"
					+"Connection established");
		} catch(Exception e) {
			System.out.println("Login Unsuccessful\nFailed to establish connection with database\n"
					+ "Error:\n"+e);
			con = null;
		}
	}
	
	public boolean testCon() {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT 1 FROM Participants");
			return true;
		} catch(final Exception e) {
			System.out.println("There as an error in executing the query\n"
					+ "Please check your syntax\n"
					+ "Error:\n"+e);
			return false;
		}
	}
	
	public ResultSet runQuery(String q) {
		try {
			Statement stmt = con.createStatement();
			return stmt.executeQuery(q);
		} catch(final Exception e) {
			System.out.println("There as an error in executing the query\n"
					+ "Please check your syntax\n"
					+ "Error:\n"+e);
		}
		return null;
	}
	
	public int runUpdate(String q) {
		try {
			Statement stmt = con.createStatement();
			return stmt.executeUpdate(q);
		} catch(final Exception e) {
			System.out.println("There as an error in executing the query\n"
					+ "Please check your syntax\n"
					+ "Error:\n"+e);
		}
		return 0;
	}
	
	public void disconnect() throws SQLException {
		con.close();
		System.out.println("Connection sucessfully closed\n"
			+ "Have a nice day :)");
		con = null;
	}
}

