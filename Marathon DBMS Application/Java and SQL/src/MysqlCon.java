import java.sql.*;
public class MysqlCon {
	public static void main(String args[]) {
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Marathon_Project","root","Jonluca762001");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Participants");
			while(rs.next())
				System.out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3).toString());
			con.close();
		} catch(Exception e) {System.out.println(e);}*/
		Context context = new initialContext();
	}
}
