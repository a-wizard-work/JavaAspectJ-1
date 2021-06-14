package com.addressbook.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class test {
	
	private static JTextField textFirstName;
	private static JTextField textLastName;
	private static JTextField textStreet;
	private static JTextField textCity;
	private static JTextField textState;
	private static JTextField textZip;
	private static JTextField textPhoneNumber;
	private JFrame frame;
	private JTable mTable;
	private DefaultTableModel mModel;
	private JScrollPane pane;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblStreet;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblPhone;
	private Object[] row = new Object[7];
	
	public test() {
		prepareGUI();
	}
	
	public static void main(String[] args) {
		
		test testDemo = new test();
		testDemo.addButton();
		testDemo.updateButton();
		testDemo.deleteButton();
	}
	
	private void prepareGUI() {
		mTable = new JTable();		
		Object[] columns = {"First Name", "Last Name", "Street", "City", "State", "Zip", "Phone Number"};
		mModel = new DefaultTableModel();
		
		frame = new JFrame("Address Book Window");
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100,100,1000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		mModel.setColumnIdentifiers(columns);
		mTable.setModel(mModel);
		
		
		mTable.setBackground(Color.white);
		mTable.setForeground(Color.black);
		mTable.setSelectionBackground(Color.red);
		mTable.setGridColor(Color.red);
		mTable.setSelectionForeground(Color.white);
		mTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
		mTable.setRowHeight(30);
		mTable.setAutoCreateRowSorter(true);
		
		pane = new JScrollPane(mTable);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.WHITE);
		pane.setBounds(10,400,980,350);
		mTable.getTableHeader().setBackground(pane.getBackground());
		frame.getContentPane().add(pane);
		//table.setVisible(false);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(150,10,300,35);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(650,10,300,35);
		frame.getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		textStreet = new JTextField();
		textStreet.setBounds(150,70,800,35);
		frame.getContentPane().add(textStreet);
		textStreet.setColumns(10);
		
		textCity = new JTextField();
		textCity.setBounds(150,130,300,35);
		frame.getContentPane().add(textCity);
		textCity.setColumns(10);
		
		textState = new JTextField();
		textState.setBounds(600,130,50,35);
		frame.getContentPane().add(textState);
		textState.setColumns(10);
		
		textZip = new JTextField();
		textZip.setBounds(750,130,200,35);
		frame.getContentPane().add(textZip);
		textZip.setColumns(10);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setBounds(150,190,300,35);
		frame.getContentPane().add(textPhoneNumber);
		textPhoneNumber.setColumns(10);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(10,10,184,35);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(500,10,184,35);
		frame.getContentPane().add(lblLastName);
		
		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStreet.setForeground(Color.WHITE);
		lblStreet.setBounds(10,70,184,35);
		frame.getContentPane().add(lblStreet);

		lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(10,130,100,35);
		frame.getContentPane().add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblState.setForeground(Color.WHITE);
		lblState.setBounds(500,130,50,35);
		frame.getContentPane().add(lblState);
		
		lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblZip.setForeground(Color.WHITE);
		lblZip.setBounds(700,130,50,35);
		frame.getContentPane().add(lblZip);
		
		lblPhone = new JLabel("Phone Number");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(10,190,140,35);
		frame.getContentPane().add(lblPhone);
		
		JCheckBox checkbox = new JCheckBox("View Table Contents");
		checkbox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		checkbox.setForeground(Color.WHITE);
		checkbox.setBounds(650,190,300,35);
		frame.add(checkbox);
		checkbox.setSelected(false);
		mTable.setVisible(false);
		checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (checkbox.isSelected()) {
					mTable.setVisible(true);
				} else {
					mTable.setVisible(false);
				}
			}
		});
	}
	
	public void addButton() {
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(30,300,300,40);
		frame.getContentPane().add(btnAdd);
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent b) {
				row[0] = textFirstName.getText();
				row[1] = textLastName.getText();
				row[2] = textStreet.getText();
				row[3] = textCity.getText();
				row[4] = textState.getText();
				row[5] = textZip.getText();
				row[6] = textPhoneNumber.getText();
				
				mModel.addRow(row);
				frame.revalidate();
			}
		});
		frame.setVisible(true);
	}
	
	public void updateButton() {
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(360,300,300,40);
		frame.getContentPane().add(btnUpdate);
		
		btnUpdate.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent c) {
	             updateModel(mTable);
            }
		});
		frame.setVisible(true);
	}
	
	public void updateModel(JTable table) {
		// i = the index of the selected row
        int i = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        if(i >= 0) 
        {
        	model.setValueAt(textFirstName.getText(), i, 0);
        	model.setValueAt(textLastName.getText(), i, 1);
        	model.setValueAt(textStreet.getText(), i, 2);
        	model.setValueAt(textCity.getText(), i, 3);
        	model.setValueAt(textState.getText(), i, 4);
        	model.setValueAt(textZip.getText(), i, 5);
        	model.setValueAt(textPhoneNumber.getText(), i, 6);
           
        }
        else{
            System.out.println("Update Error");
        }
	}
	
	public void deleteButton() {
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(690,300,300,40);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent d) {
				deleteModel(mTable);
			}
		});
		frame.setVisible(true);
	}
	
	public void deleteModel(JTable table) {
		int viewIndex = table.getSelectedRow();
		if (table.getSelectedRow() != -1) {
			int modelIndex = table.convertRowIndexToModel(viewIndex);
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.removeRow(modelIndex);
			
		}
		else {
			JOptionPane.showMessageDialog(frame, "Delete Error");
			
		}
	}

}