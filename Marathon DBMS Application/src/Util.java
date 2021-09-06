import java.awt.Container;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
//import javax.swing.JFrame;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;

public final class Util{
	public static boolean checkIfInputNumeric(String in) {
		try {
			int intValue = Integer.parseInt(in);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}
	
	public static void displayInfo(ResultSet rs, Dimension d) throws SQLException {
		JFrame tableFrame = new JFrame();
		tableFrame.setVisible(true);
		tableFrame.setSize(d);
		tableFrame.setDefaultCloseOperation(2);
		
		String[] columns = {"ID","Name","DOB","SEX","RANK"};
		
		Container tableContainer = tableFrame.getContentPane();
		
		DefaultTableModel model = buildTableModel(rs);
		rs.close();
		JTable table = new JTable(model) {
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
		table.setDefaultRenderer(String.class, centerRenderer);
		table.setDefaultRenderer(Integer.class, centerRenderer);
		table.setDefaultRenderer(java.sql.Date.class, centerRenderer);
		
		table.setAutoCreateRowSorter(true);
	    //System.out.println(table.getColumnName(1));
	    JScrollPane tableScrollPane = new JScrollPane(table);
		tableFrame.add(tableScrollPane);
	    System.out.println(table.getColumnClass(0));
	    System.out.println(table.getColumnClass(1));
	    System.out.println(table.getColumnClass(2));
	    System.out.println(table.getColumnClass(3));
	    System.out.println(table.getColumnClass(4));
	    System.out.println(table.getValueAt(12, 0));
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    //types of columns
		DefaultTableModel ret = new DefaultTableModel() {
			@Override
			public Class getColumnClass(int column) {
				if(column == 0) return Integer.class;
				else if(column == 1) return String.class;
				else if(column == 3) return String.class;
				else if(column == 2) return java.sql.Date.class;
				else return Integer.class;
			}
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//set column names
		ret.setColumnIdentifiers(columnNames);
		
	    // data of the table
	    //Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        		vector.add( rs.getObject(columnIndex));
	        }
	        ret.addRow(vector);
	    }
	    return ret;

	}
}
