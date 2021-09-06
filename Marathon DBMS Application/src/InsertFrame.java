import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class InsertFrame extends JFrame implements ActionListener{
	JButton submitButton, cancelButton;
	JPanel panel, contentPane;
	JLabel nameLabel, DOBLabel, sexLabel, rankLabel;
	String name, DOB, sex;
	String rank;
	final JTextField nameText, DOBText, sexText, rankText;
	MainMenu parent; //reference so it can call functions over there, I really should
	//have used actors...
	
	
	public InsertFrame(MainMenu _parent) {
	parent = _parent;
	//create text fields
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 400, 200);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	panel = new JPanel();
	panel.setBackground(UIManager.getColor("CheckBox.background"));
	panel.setForeground(Color.RED);
	contentPane.add(panel, BorderLayout.CENTER);
	GridBagLayout gbl_panel = new GridBagLayout();
	gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
	gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
	gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	panel.setLayout(gbl_panel);
	
	JLabel nameLabel = new JLabel("Name");
	GridBagConstraints gbc_NameLabel = new GridBagConstraints();
	gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
	gbc_NameLabel.gridx = 0;
	gbc_NameLabel.gridy = 0;
	panel.add(nameLabel, gbc_NameLabel);
	
	nameText = new JTextField();
	GridBagConstraints gbc_NameText = new GridBagConstraints();
	gbc_NameText.gridwidth = 2;
	gbc_NameText.insets = new Insets(0, 0, 5, 0);
	gbc_NameText.fill = GridBagConstraints.HORIZONTAL;
	gbc_NameText.gridx = 1;
	gbc_NameText.gridy = 0;
	panel.add(nameText, gbc_NameText);
	nameText.setColumns(10);
	
	JLabel DOBFormatLabel = new JLabel("DOB Format 'YYYY-MM-DD'");
	GridBagConstraints gbc_DOBFormatLabel = new GridBagConstraints();
	gbc_DOBFormatLabel.gridwidth = 2;
	gbc_DOBFormatLabel.insets = new Insets(0, 0, 5, 5);
	gbc_DOBFormatLabel.gridx = 1;
	gbc_DOBFormatLabel.gridy = 1;
	panel.add(DOBFormatLabel, gbc_DOBFormatLabel);
	
	JLabel DOBLabel = new JLabel("DOB");
	GridBagConstraints gbc_DOBLabel = new GridBagConstraints();
	gbc_DOBLabel.insets = new Insets(0, 0, 5, 5);
	gbc_DOBLabel.gridx = 0;
	gbc_DOBLabel.gridy = 2;
	panel.add(DOBLabel, gbc_DOBLabel);
	
	DOBText = new JTextField();
	GridBagConstraints gbc_DOBText = new GridBagConstraints();
	gbc_DOBText.gridwidth = 2;
	gbc_DOBText.insets = new Insets(0, 0, 5, 0);
	gbc_DOBText.fill = GridBagConstraints.HORIZONTAL;
	gbc_DOBText.gridx = 1;
	gbc_DOBText.gridy = 2;
	panel.add(DOBText, gbc_DOBText);
	DOBText.setColumns(10);
	
	JLabel sexLabel = new JLabel("Sex");
	GridBagConstraints gbc_sexLabel = new GridBagConstraints();
	gbc_sexLabel.insets = new Insets(0, 0, 5, 5);
	gbc_sexLabel.gridx = 0;
	gbc_sexLabel.gridy = 4;
	panel.add(sexLabel, gbc_sexLabel);
	
	sexText = new JTextField();
	GridBagConstraints gbc_sexText = new GridBagConstraints();
	gbc_sexText.gridwidth = 2;
	gbc_sexText.insets = new Insets(0, 0, 5, 0);
	gbc_sexText.fill = GridBagConstraints.HORIZONTAL;
	gbc_sexText.gridx = 1;
	gbc_sexText.gridy = 4;
	panel.add(sexText, gbc_sexText);
	sexText.setColumns(10);
	
	JLabel rankLabel = new JLabel("Rank");
	GridBagConstraints gbc_rankLabel = new GridBagConstraints();
	gbc_rankLabel.insets = new Insets(0, 0, 5, 5);
	gbc_rankLabel.gridx = 0;
	gbc_rankLabel.gridy = 6;
	panel.add(rankLabel, gbc_rankLabel);
	
	rankText = new JTextField();
	GridBagConstraints gbc_RankText = new GridBagConstraints();
	gbc_RankText.gridwidth = 2;
	gbc_RankText.insets = new Insets(0, 0, 5, 0);
	gbc_RankText.fill = GridBagConstraints.HORIZONTAL;
	gbc_RankText.gridx = 1;
	gbc_RankText.gridy = 6;
	panel.add(rankText, gbc_RankText);
	rankText.setColumns(10);
	
	JButton submitButton = new JButton("Submit");
	GridBagConstraints gbc_submitButton = new GridBagConstraints();
	gbc_submitButton.insets = new Insets(0, 0, 0, 5);
	gbc_submitButton.gridx = 1;
	gbc_submitButton.gridy = 8;
	panel.add(submitButton, gbc_submitButton);
	
	JButton cancelButton = new JButton("Cancel");
	GridBagConstraints gbc_cancelButton = new GridBagConstraints();
	gbc_cancelButton.gridx = 2;
	gbc_cancelButton.gridy = 8;
	panel.add(cancelButton, gbc_cancelButton);
	
	add(panel, BorderLayout.CENTER);
	
	submitButton.setActionCommand("submit");
	cancelButton.setActionCommand("cancel");
	submitButton.addActionListener(this);
	cancelButton.addActionListener(this);
	nameLabel.requestFocus();
	setVisible(true);
	setTitle("INSERT FORM");
	}
	
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		switch(e.getActionCommand()) {
			case "submit" :
				name = nameText.getText();
				DOB = DOBText.getText();
				sex = sexText.getText().toUpperCase();
				rank = rankText.getText();
				if(name.isEmpty() || DOB.isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Name and DOB cannot be empty");
				} else if((sex.length() > 2 || (!sex.equals("M") && !sex.equals("F") && !sex.equals("NB"))) && sex=="") {
					JOptionPane.showMessageDialog(panel, "Sex is 'M' for Male, 'F' for Female, or 'NB' for Non-Binary");
				} else if(!DOB.matches("\\d{4}-\\d{2}-\\d{2}$")){
					JOptionPane.showMessageDialog(panel, "Please enter DOB in correct format"
							+ " YYYY-MM-DD");
				} else if(rank.isEmpty() && !Util.checkIfInputNumeric(rank)) {
					JOptionPane.showMessageDialog(panel, "Rank must be a whole number");
				} else if(!sex.isEmpty() && !rank.isEmpty()){
					String query = "INSERT INTO Participants(PName, PDOB, PSex, PRank)"
							+ " VALUES("+'"'+name+'"'+","+'"'+DOB+'"'+","+'"'+sex+'"'+","+Integer.parseInt(rank)+");";
					JOptionPane.showMessageDialog(panel, "Successfully added "+parent.DBC.runUpdate(query)+" new entry");
				} else if(sex.isEmpty() && !rank.isEmpty()) {
					String query = "INSERT INTO Participants(PName, PDOB, PRank)"
							+ " VALUES("+'"'+name+'"'+","+'"'+DOB+'"'+","+Integer.parseInt(rank)+");";
					JOptionPane.showMessageDialog(panel, "Successfully added "+parent.DBC.runUpdate(query)+" new entry");
				} else if(!sex.isEmpty() && rank.isEmpty()) {
					String query = "INSERT INTO Participants(PName, PDOB, PSex)"
							+ " VALUES("+'"'+name+'"'+","+'"'+DOB+'"'+","+'"'+sex+'"'+");";
					JOptionPane.showMessageDialog(panel, "Successfully added "+parent.DBC.runUpdate(query)+" new entry");
				} else {
					String query = "INSERT INTO Participants(PName, PDOB)"
							+ " VALUES("+'"'+name+'"'+","+'"'+DOB+'"'+");";
					JOptionPane.showMessageDialog(panel, "Successfully added "+parent.DBC.runUpdate(query)+" new entry");
				}
				nameText.setText("");
				DOBText.setText("");
				sexText.setText("");
				rankText.setText("");
				break;
			case "cancel" :
				System.out.println("test");
				this.dispose();
				break;
		}
	}
	
}