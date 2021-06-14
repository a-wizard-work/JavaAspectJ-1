package com.addressbook.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public aspect UpdateAddressAspect {
	
	pointcut traceUpdateModel() : execution(public void com.addressbook.demo.test.updateModel(..));
	
	before() : traceUpdateModel() {
		JTable table = (JTable)thisJoinPoint.getArgs()[0];
		try (PrintWriter writer = new PrintWriter(new FileWriter("UpdatesLog.txt", true))) {
	    	int i = table.getSelectedRow();
	        DefaultTableModel model = (DefaultTableModel)table.getModel();
	        String strAddress = ""; 
	        if(i >= 0) 
	        {
	        	for (int col = 0; col < 7; col++) {
	        		strAddress += model.getValueAt(i, col) + " ";
	        	}
	        	
	        }
	      writer.println("Record updated : " + strAddress);
	      System.out.println("Record updated : " + strAddress);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		System.out.println("Calling a method " + thisJoinPoint.getSignature());
	}

	pointcut traceDeleteModel() : execution(public void com.addressbook.demo.test.deleteModel(..));
	
	before() : traceDeleteModel() {
		JTable table = (JTable)thisJoinPoint.getArgs()[0];
		try (PrintWriter writer = new PrintWriter(new FileWriter("UpdatesLog.txt", true))) {
	    	int i = table.getSelectedRow();
	        DefaultTableModel model = (DefaultTableModel)table.getModel();
	        String strAddress = ""; 
	        if(i >= 0) 
	        {
	        	for (int col = 0; col < 7; col++) {
	        		strAddress += model.getValueAt(i, col) + " ";
	        	}
	        	
	        }
	      writer.println("Record deleted : " + strAddress);
	      System.out.println("Record deleted : " + strAddress);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		System.out.println("Calling a method " + thisJoinPoint.getSignature());
	}
}
