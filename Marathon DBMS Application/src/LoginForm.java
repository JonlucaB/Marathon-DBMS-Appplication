import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;    

public class LoginForm extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	JButton b1;
//	JPanel newPanel;
//	JLabel userLabel, passLabel;
	String username, password;
	JTextField textField1;
	JPasswordField textField2;

	
	public LoginForm()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,100);
		username = null; password = null;
		
		//create text fields
		JLabel userLabel = new JLabel();
		userLabel.setText("Username");
		
		textField1 = new JTextField(15);
		
		JLabel passLabel = new JLabel();
		passLabel.setText("Password");
		
		textField2 = new JPasswordField(15);
		textField2.setEchoChar('*');
		JButton b1 = new JButton("SUBMIT");
		
		//creating a panel
		JPanel newPanel = new JPanel(new GridLayout(3,1));
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
        
        add(newPanel, BorderLayout.CENTER);  
        
        b1.addActionListener(this);     //add action listener to button  
        b1.requestFocus();
        setVisible(true);
        setTitle("LOGIN FORM"); 
        System.out.println("Login Form has been created");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		username = textField1.getText(); //get username
		password = textField2.getText(); //get password	
	}
	
	public String[] getCredentials() {
		String[] ret = {username, password};
		return ret;
	}
}
