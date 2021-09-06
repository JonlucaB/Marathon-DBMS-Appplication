import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainMenuWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuWindow frame = new MainMenuWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuWindow() {
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
	}
}
