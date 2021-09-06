import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SearchFrame extends JFrame implements ActionListener {
	MainMenu parent;
	boolean using_ID = false, editMode = false;
	
	JButton searchButton, cancelButton, editButton, submitButton;
	JPanel newPanel;
	JLabel IDLabel, nameLabel, DOBLabel, sexLabel, rankLabel;
	JRadioButton DOBeq, DOBgt, DOBlt, rankeq, rankgt, ranklt;
	ButtonGroup DOBb, rankb;
	char DOBConfig = '=', rankConfig = '=';
	
	JTable resultTable;
	JScrollPane scrollPane;
	GridBagConstraints gbc_table, gbc_scrollPane;
	
//	String ID, name, DOB, sex, rank;
	final JTextField IDText, nameText, DOBText, sexText, rankText;
	
	public SearchFrame(MainMenu _parent) {
		parent = _parent;
		setSize(1000,600);
		//create text fields
		setBounds(100, 100, 916, 540);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		newPanel = new JPanel();
		newPanel.setBounds(new Rectangle(2, 0, 0, 0));
		newPanel.setBorder(new CompoundBorder());
		getContentPane().add(newPanel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		newPanel.setLayout(gbl_panel);
		
		JLabel IDLabel = new JLabel("ID");
		GridBagConstraints gbc_IDLabel = new GridBagConstraints();
		gbc_IDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IDLabel.gridx = 0;
		gbc_IDLabel.gridy = 0;
		newPanel.add(IDLabel, gbc_IDLabel);
		
		IDText = new JTextField();
		GridBagConstraints gbc_IDText = new GridBagConstraints();
		gbc_IDText.gridwidth = 4;
		gbc_IDText.insets = new Insets(0, 0, 5, 0);
		gbc_IDText.fill = GridBagConstraints.HORIZONTAL;
		gbc_IDText.gridx = 1;
		gbc_IDText.gridy = 0;
		newPanel.add(IDText, gbc_IDText);
		IDText.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 1;
		newPanel.add(nameLabel, gbc_nameLabel);
		
		nameText= new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		newPanel.add(nameText, gbc_textField);
		nameText.setColumns(10);
		
		JLabel sexLabel = new JLabel("Sex");
		GridBagConstraints gbc_sexLabel = new GridBagConstraints();
		gbc_sexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sexLabel.gridx = 0;
		gbc_sexLabel.gridy = 2;
		newPanel.add(sexLabel, gbc_sexLabel);
		
		sexText = new JTextField();
		GridBagConstraints gbc_sexText = new GridBagConstraints();
		gbc_sexText.gridwidth = 4;
		gbc_sexText.insets = new Insets(0, 0, 5, 0);
		gbc_sexText.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexText.gridx = 1;
		gbc_sexText.gridy = 2;
		newPanel.add(sexText, gbc_sexText);
		sexText.setColumns(10);
		
		DOBLabel = new JLabel("DOB");
		GridBagConstraints gbc_DOBLabel = new GridBagConstraints();
		gbc_DOBLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DOBLabel.gridx = 0;
		gbc_DOBLabel.gridy = 3;
		newPanel.add(DOBLabel, gbc_DOBLabel);
		
		DOBeq = new JRadioButton("=");
		GridBagConstraints gbc_DOBeq = new GridBagConstraints();
		gbc_DOBeq.insets = new Insets(0, 0, 5, 5);
		gbc_DOBeq.gridx = 1;
		gbc_DOBeq.gridy = 3;
		newPanel.add(DOBeq, gbc_DOBeq);
		
		DOBlt = new JRadioButton("<");
		GridBagConstraints gbc_DOBlt = new GridBagConstraints();
		gbc_DOBlt.insets = new Insets(0, 0, 5, 5);
		gbc_DOBlt.gridx = 2;
		gbc_DOBlt.gridy = 3;
		newPanel.add(DOBlt, gbc_DOBlt);
		
		DOBgt = new JRadioButton(">");
		GridBagConstraints gbc_DOBgt = new GridBagConstraints();
		gbc_DOBgt.insets = new Insets(0, 0, 5, 5);
		gbc_DOBgt.gridx = 3;
		gbc_DOBgt.gridy = 3;
		newPanel.add(DOBgt, gbc_DOBgt);
		DOBText = new JTextField();
		GridBagConstraints gbc_DOBText = new GridBagConstraints();
		gbc_DOBText.insets = new Insets(0, 0, 5, 0);
		gbc_DOBText.fill = GridBagConstraints.HORIZONTAL;
		gbc_DOBText.gridx = 4;
		gbc_DOBText.gridy = 3;
		newPanel.add(DOBText, gbc_DOBText);
		DOBText.setColumns(10);
		
		rankLabel = new JLabel("Rank");
		GridBagConstraints gbc_rankLabel = new GridBagConstraints();
		gbc_rankLabel.insets = new Insets(0, 0, 5, 5);
		gbc_rankLabel.gridx = 0;
		gbc_rankLabel.gridy = 4;
		newPanel.add(rankLabel, gbc_rankLabel);
		
		rankeq = new JRadioButton("=");
		GridBagConstraints gbc_rankeq = new GridBagConstraints();
		gbc_rankeq.anchor = GridBagConstraints.SOUTH;
		gbc_rankeq.insets = new Insets(0, 0, 5, 5);
		gbc_rankeq.gridx = 1;
		gbc_rankeq.gridy = 4;
		newPanel.add(rankeq, gbc_rankeq);
		
		ranklt = new JRadioButton("<");
		GridBagConstraints gbc_ranklt = new GridBagConstraints();
		gbc_ranklt.insets = new Insets(0, 0, 5, 5);
		gbc_ranklt.gridx = 2;
		gbc_ranklt.gridy = 4;
		newPanel.add(ranklt, gbc_ranklt);
		
		rankgt = new JRadioButton(">");
		GridBagConstraints gbc_rankgt = new GridBagConstraints();
		gbc_rankgt.insets = new Insets(0, 0, 5, 5);
		gbc_rankgt.gridx = 3;
		gbc_rankgt.gridy = 4;
		newPanel.add(rankgt, gbc_rankgt);
		
		rankText = new JTextField();
		GridBagConstraints gbc_rankText = new GridBagConstraints();
		gbc_rankText.insets = new Insets(0, 0, 5, 0);
		gbc_rankText.fill = GridBagConstraints.HORIZONTAL;
		gbc_rankText.gridx = 4;
		gbc_rankText.gridy = 4;
		newPanel.add(rankText, gbc_rankText);
		rankText.setColumns(10);
		
		
		searchButton = new JButton("Search");
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.insets = new Insets(0, 0, 5, 5);
		gbc_searchButton.gridx = 0;
		gbc_searchButton.gridy = 6;
		newPanel.add(searchButton, gbc_searchButton);
		
		editButton = new JButton("Edit");
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.insets = new Insets(0, 0, 5, 5);
		gbc_editButton.gridx = 0;
		gbc_editButton.gridy = 7;
		newPanel.add(editButton, gbc_editButton);
		
		submitButton = new JButton("Submit");
		GridBagConstraints gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.insets = new Insets(0, 0, 5, 5);
		gbc_submitButton.gridx = 0;
		gbc_submitButton.gridy = 8;
		newPanel.add(submitButton, gbc_submitButton);
		
		JButton deleteButton = new JButton("Delete");
		GridBagConstraints gbc_deleteB = new GridBagConstraints();
		gbc_deleteB.insets = new Insets(0, 0, 5, 5);
		gbc_deleteB.gridx = 0;
		gbc_deleteB.gridy = 9;
		newPanel.add(deleteButton, gbc_deleteB);
		
		cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 0;
		gbc_cancelButton.gridy = 10;
		newPanel.add(cancelButton, gbc_cancelButton);
		
		//resultTable = new JTable();
//		gbc_table = new GridBagConstraints();
//		gbc_table.gridheight = 5;
//		gbc_table.gridwidth = 4;
//		gbc_table.fill = GridBagConstraints.BOTH;
//		gbc_table.gridx = 1;
//		gbc_table.gridy = 5;
		//newPanel.add(resultTable, gbc_table);
		
		scrollPane = new JScrollPane();
		gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		newPanel.add(scrollPane, gbc_scrollPane);
		
		searchButton.setActionCommand("search");
		editButton.setActionCommand("edit");
		submitButton.setActionCommand("submit");
		cancelButton.setActionCommand("cancel");
		deleteButton.setActionCommand("delete");
		
		searchButton.addActionListener(this);
		cancelButton.addActionListener(this);
		editButton.addActionListener(this);
		submitButton.addActionListener(this);
		deleteButton.addActionListener(this);
			
		DOBb = new ButtonGroup();
		DOBb.add(DOBeq);
		DOBb.add(DOBgt);
		DOBb.add(DOBlt);
		
		rankb = new ButtonGroup();
		rankb.add(rankeq);
		rankb.add(rankgt);
		rankb.add(ranklt);
		
		DOBeq.addActionListener(this);
		DOBgt.addActionListener(this);
		DOBlt.addActionListener(this);
		rankeq.addActionListener(this);
		rankgt.addActionListener(this);
		ranklt.addActionListener(this);
		
		DOBeq.setActionCommand("DOBeq");
		DOBgt.setActionCommand("DOBgt");
		DOBlt.setActionCommand("DOBlt");
		rankgt.setActionCommand("rankgt");
		rankeq.setActionCommand("rankeq");
		ranklt.setActionCommand("ranklt");
		
		IDText.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				using_ID = true;
				
				nameText.setEditable(false);
				DOBText.setEditable(false);
				sexText.setEditable(false);
				rankText.setEditable(false);
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				using_ID = false;
				
				nameText.setEditable(true);
				DOBText.setEditable(true);
				sexText.setEditable(true);
				rankText.setEditable(true);
			}
		});
		//IDLabel.requestFocus();
		searchButton.setFocusable(false);
		DOBeq.setSelected(true);
		rankeq.setSelected(true);
		setVisible(true);
		setTitle("SEACH FORM");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
			case "search" :
				if(using_ID) {
					if(Util.checkIfInputNumeric(IDText.getText())) {
						ResultSet rs = parent.DBC.runQuery("SELECT * FROM Participants WHERE PID = "+Integer.parseInt(IDText.getText())+';');
						if(rs == null) {
							JOptionPane.showMessageDialog(newPanel, "Error in executing query");
							break;
						}
						try {
							displayResults(rs);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(newPanel, "Error in displaying query results\n"
									+ "e");
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(newPanel, "ID must be a whole number");
					}
				} else {
					String q = parseSearch(nameText.getText(), DOBText.getText(), sexText.getText(), rankText.getText());
					ResultSet rs = parent.DBC.runQuery(q);
					if(rs == null) {
						JOptionPane.showMessageDialog(newPanel, "Error in executing query");
						break;
					}
					try {
						displayResults(rs);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(newPanel, "Error in displaying query results\n"
								+ "e");
						e1.printStackTrace();
					}
				}
				break;
				
			case "edit" :
				int sRow = resultTable.getSelectedRow();
				if(sRow == -1) {
					JOptionPane.showMessageDialog(newPanel, "Please select a row from the table first");
					break;
				}
				IDText.setEditable(false);
				searchButton.setEnabled(false);
				editButton.setEnabled(false);
				submitButton.setEnabled(true);
				
				editMode = true;
				IDText.setText(String.valueOf(resultTable.getValueAt(sRow, 0)));
				nameText.setText((String) resultTable.getValueAt(sRow, 1));
				DOBText.setText((String) resultTable.getValueAt(sRow, 2).toString());
				sexText.setText((String) resultTable.getValueAt(sRow, 3));
				Object rank = resultTable.getValueAt(sRow, 4);
				if(rank != null) rankText.setText((String.valueOf((int) rank))); else rankText.setText("");
				break;
				
			case "submit" :
				String query = "UPDATE Participants SET "
						+ "PName = "+"'"+nameText.getText()+"'"+", "
								+ "PDOB = "+"'"+DOBText.getText()+"'"+", "
										+ "PSex = "+"'"+sexText.getText()+"'"+", "
												+ "PRank = "+rankText.getText()+" "
														+ "WHERE PID = "+IDText.getText()+";";
				System.out.println(query);
				JOptionPane.showMessageDialog(newPanel, "Successfully updated "+parent.DBC.runUpdate(query)+" user");
				IDText.setEditable(true);
				editMode = false;
				IDText.setText("");
				nameText.setText("");
				DOBText.setText("");
				sexText.setText("");
				rankText.setText("");
				searchButton.setEnabled(true);
				editButton.setEnabled(true);
				submitButton.setEnabled(false);
				IDText.setEditable(true);
				break;
			
			case "DOBeq" :
				DOBConfig = '=';
				break;
			
			case "DOBgt" :
				DOBConfig = '>';
				break;
			
			case "DOBlt" :
				DOBConfig = '<';
				break;
				
			case "rankeq" :
				rankConfig = '=';
				break;
				
			case "rankgt" :
				rankConfig = '>';
				break;
				
			case "ranklt" :
				rankConfig = '<';
				break;
				
			case "cancel" :
				if(editMode) {
					nameText.setText("");
					DOBText.setText("");
					sexText.setText("");
					rankText.setText("");
					searchButton.setEnabled(true);
					editButton.setEnabled(true);
					submitButton.setEnabled(false);
					IDText.setEditable(true);
					editMode = false;
				} else {
					this.dispose();
					break;
				}
			
			case "delete" :
				int sRow2 = resultTable.getSelectedRow();
				if(sRow2 == -1) {
					JOptionPane.showMessageDialog(newPanel, "Please select a row from the table first");
					break;
				}
				int deleteID = (int) resultTable.getValueAt(sRow2, 0);
				String query1 = "DELETE FROM Participants WHERE PID = "+deleteID+";";
				JOptionPane.showMessageDialog(newPanel, "Successfully removed "
						+parent.DBC.runUpdate(query1)+" data points");
				break;
		}
		
	}
	
	public String parseSearch(String name, String DOB, String sex, String rank_String) {
		String query = "SELECT * FROM Participants";
		if(!DOB.isEmpty() && !DOB.matches("\\d{4}-\\d{2}-\\d{2}$")) {
			JOptionPane.showMessageDialog(newPanel, "Please enter DOB in the correct format\n"
					+ "YYYY-MM-DD");
			System.out.println(DOB);
		} else if(!sex.isEmpty() && sex.length() > 2) {
			JOptionPane.showMessageDialog(newPanel, "Please enter an appropriate sex\n"
					+ "'M' - Male | 'F' Female | 'NB' Non-Binary");
		} else if(!rank_String.isEmpty() && !Util.checkIfInputNumeric(rank_String)) {
			JOptionPane.showMessageDialog(newPanel, "Please enter a whole number for rank");
		} else {
			int filterCount = 0;
			if(!name.isEmpty()) {
				if(filterCount == 0) query += " WHERE ";
				query += "PName LIKE "+'"'+'%'+name+'%'+'"'+" ";
				filterCount += 1;
			}
			if(!DOB.isEmpty()) {
				if(filterCount > 0) query += " AND ";
				else if(filterCount == 0) query += " WHERE ";
				query += "PDOB "+DOBConfig+" "+'"'+DOB+'"';
				filterCount += 1;
			}
			if(!sex.isEmpty()) {
				if(filterCount > 0) query += " AND ";
				else if(filterCount == 0) query += " WHERE ";
				query += "PSex = "+'"'+sex+'"';
				filterCount += 1;
			}
			if(!rank_String.isEmpty()) {
				if(filterCount > 0) query += " AND ";
				else if(filterCount == 0) query += " WHERE ";
				query += "PRank "+rankConfig+" "+Integer.parseInt(rank_String);
			}
		}
		System.out.println(query);
		return query;
	}
	
	public void displayResults(ResultSet rs) throws SQLException {
		DefaultTableModel model = Util.buildTableModel(rs);
		rs.close();
		resultTable = new JTable(model) {
			public String getColumnName(int col) {
				return model.getColumnName(col);
			}
			@Override
			public Class getColumnClass(int column) {
				if(column == 0) return Integer.class;
				else if(column == 1) return String.class;
				else if(column == 3) return String.class;
				else if(column == 2) return java.sql.Date.class;
				else return Integer.class;
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		resultTable.setDefaultRenderer(String.class, centerRenderer);
		resultTable.setDefaultRenderer(Integer.class, centerRenderer);
		resultTable.setDefaultRenderer(java.sql.Date.class, centerRenderer);
		
		resultTable.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(resultTable);
	}
}
