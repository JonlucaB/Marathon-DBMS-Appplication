import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;  
public class MainMenu extends JFrame implements ActionListener{
	JButton viewB, insertB, searchB, closeB;
	JPanel buttonPanel;
	JPanel contentPane; //big daddy pane
	Dimension lWindow = new Dimension(1000,600);
	SQLCon DBC;
	
	final int BOX_WIDTH = 100, BOX_HEIGHT = 50;
	
	public MainMenu(SQLCon _DBC) {
		DBC = _DBC;
		
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 48, 502, 261);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jonlu\\eclipse-workspace\\SQLMarathon\\images\\Marathon.jpg"));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 309, 502, 111);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton viewB = new JButton("View Table");
		viewB.setBounds(21, 30, 114, 23);
		panel_1.add(viewB);
		
		JButton insertB = new JButton("Add Data");
		insertB.setBounds(188, 30, 114, 23);
		panel_1.add(insertB);
		
		JButton searchB = new JButton("Search Data");
		searchB.setBounds(357, 30, 135, 23);
		panel_1.add(searchB);
		
		JButton closeB = new JButton("Exit");
		closeB.setBounds(201, 88, 85, 23);
		panel_1.add(closeB);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 502, 39);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Title = new JLabel("Marathon Database Management");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Title.setBounds(10, 5, 482, 23);
		panel_2.add(Title);

		viewB.addActionListener(this);
		viewB.setActionCommand("v");
		insertB.addActionListener(this);	
		insertB.setActionCommand("i");
		searchB.addActionListener(this);
		searchB.setActionCommand("s");	
		closeB.addActionListener(this);
		closeB.setActionCommand("c");

		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "v" :
				System.out.println("View pressed");
				try(ResultSet rs = DBC.runQuery("SELECT * FROM Participants")) {
					Util.displayInfo(rs, new Dimension(1000,600));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(viewB, e);
				}
				break;
			case "i" :
				InsertFrame insertFrame = new InsertFrame(this);
				break;
			case "s" :
				SearchFrame searchFrame = new SearchFrame(this);
				break;
			case "c" :
				try {
					DBC.disconnect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			default :
				System.out.println("Unrecognized action performed "+e.getActionCommand());
		}
	}
}
