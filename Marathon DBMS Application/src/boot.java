
//This class and its functions serve to start the application. Most of the functionality happens afterwards and elsewhere in the mainmenu class. This just serves
//as a way to get everything started.
public class boot {
	static MainMenu menu;
	//static LoginForm login;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SQLCon DBC = new SQLCon("","");
		
		startUp(DBC);
	}
	
	public static void startUp(SQLCon DBC) {
		if(menu != null) menu.dispose();
		LoginForm login = new LoginForm();
		login.requestFocus();
		while(DBC.con == null) {
			String[] creds = login.getCredentials();
			String username = creds[0]; String password = creds[1];
			DBC = new SQLCon(username, password);

			if(DBC.con == null) {
				System.out.println("Invalid Login");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		login.dispose();
		menu = new MainMenu(DBC);
	}
}