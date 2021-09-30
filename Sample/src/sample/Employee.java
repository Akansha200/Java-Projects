package sample;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.text.MessageFormat;
import java.awt.*;


public class Employee {


	private JFrame frame;
	private JTextField textUSN;
	private JTable table;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textBranch;
	private JTextField textPhoneno;
	private JTextField textSGPA;
	private JTextField textFieldInterested;
	/**
	 * Launch the application.
	 */
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	DefaultTableModel model = new DefaultTableModel();
	
	public void updateTable()
	{
		conn = Sqlitesample.ConnectDB();
		if(conn != null)
		{
			String sql = "Select USN, FirstName,LastName,Branch,Phone No,SGPA,Field Interested";
			
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] columnData = new Object[7];
				
				while(rs.next()) {
					columnData [0] = rs.getString("USN");
					columnData [1] = rs.getString("FirstName");
					columnData [2] = rs.getString("LastName");
					columnData [3] = rs.getString("Branch");
					columnData [4] = rs.getString("Phone No");
					columnData [5] = rs.getString("SGPA");
					columnData [6] = rs.getString("Field Interested");
					
					model.addRow(columnData);
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Employee() {
		initialize();
		
		conn = Sqlitesample.ConnectDB();
		Object col[] = {"USN", "FirstName","LastName","Branch","Phone No","SGPA","Field Interested"};
		model.setColumnIdentifiers(col);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1900, 1020);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 126, -12);
		frame.getContentPane().add(lblNewLabel);
		
		textUSN = new JTextField();
		textUSN.setBounds(1235, 74, 185, 29);
		frame.getContentPane().add(textUSN);
		textUSN.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 74, 837, 641);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"USN", "FirstName", "LastName", "Branch", "Phone No", "SGPA", "Interested Field"
			}
		));
		table.setFont(new Font("Times New Roman", Font.BOLD, 20));
		scrollPane.setViewportView(table);
		
		JLabel lblUSN = new JLabel("USN");
		lblUSN.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblUSN.setBounds(1050, 68, 136, 36);
		frame.getContentPane().add(lblUSN);
		
		JLabel lblFirstName = new JLabel("FirstName");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblFirstName.setBounds(1050, 137, 136, 36);
		frame.getContentPane().add(lblFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(1235, 143, 185, 29);
		frame.getContentPane().add(textFirstName);
		
		JLabel lblLastName = new JLabel("LastName");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblLastName.setBounds(1050, 207, 136, 36);
		frame.getContentPane().add(lblLastName);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(1235, 213, 185, 29);
		frame.getContentPane().add(textLastName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblBranch.setBounds(1050, 276, 136, 36);
		frame.getContentPane().add(lblBranch);
		
		textBranch = new JTextField();
		textBranch.setColumns(10);
		textBranch.setBounds(1235, 282, 185, 29);
		frame.getContentPane().add(textBranch);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPhoneNo.setBounds(1050, 346, 136, 36);
		frame.getContentPane().add(lblPhoneNo);
		
		textPhoneno = new JTextField();
		textPhoneno.setColumns(10);
		textPhoneno.setBounds(1235, 352, 185, 29);
		frame.getContentPane().add(textPhoneno);
		
		JLabel lblSGPA = new JLabel("SGPA");
		lblSGPA.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSGPA.setBounds(1050, 412, 136, 36);
		frame.getContentPane().add(lblSGPA);
		
		textSGPA = new JTextField();
		textSGPA.setColumns(10);
		textSGPA.setBounds(1235, 418, 185, 29);
		frame.getContentPane().add(textSGPA);
		
		JLabel lblFieldInterested = new JLabel("Field Interested");
		lblFieldInterested.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblFieldInterested.setBounds(1009, 486, 223, 36);
		frame.getContentPane().add(lblFieldInterested);
		
		textFieldInterested = new JTextField();
		textFieldInterested.setColumns(10);
		textFieldInterested.setBounds(1235, 486, 185, 29);
		frame.getContentPane().add(textFieldInterested);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO students(USN,FirstNAme,LastName,Branch,Phone No,SGPA,Field Interested)VALUES(?,?,?,?,?,?,?)";
				
				try 
				{
					pst = conn.prepareStatement(sql);
					pst.setString(1, textUSN.getText());
					pst.setString(2, textFirstName.getText());
					pst.setString(3, textLastName.getText());
					pst.setString(4, textBranch.getText());
					pst.setString(5, textPhoneno.getText());
					pst.setString(6, textSGPA.getText());
					pst.setString(7, textFieldInterested.getText());
					
					pst.execute();
					rs.close();
					pst.close();
					
				}
				catch (Exception ev)
				{
					JOptionPane.showMessageDialog(null, "System Update Completed");

				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						 textUSN.getText(),
						 textFirstName.getText(),
					 textLastName.getText(),
						textBranch.getText(),
					 textPhoneno.getText(),
						 textSGPA.getText(),
						 textFieldInterested.getText(),
				});
				
				if(table.getSelectedRow() == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Data updated","Student record system",
								JOptionPane.OK_OPTION);
					}
				};
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(1088, 586, 95, 54);
		frame.getContentPane().add(btnAdd);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in Progress");
				MessageFormat footer = new MessageFormat("Page {0,number,integer}");
				
				try {
					table.print();
				}
				catch(java.awt.print.PrinterException ev) {
					System.out.format("No Printer found", ev.getMessage());
				}
			}
		});
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPrint.setBounds(1283, 587, 95, 54);
		frame.getContentPane().add(btnPrint);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFirstName.setText(null);
				textLastName.setText(null);
				textPhoneno.setText(null);
				textBranch.setText(null);
				textFieldInterested.setText(null);
				textSGPA.setText(null);
				textUSN.setText(null);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(1088, 681, 95, 54);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit\r\n");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Employee Databse System",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)  {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(1283, 681, 95, 58);
		frame.getContentPane().add(btnExit);
		
		
	}

}
