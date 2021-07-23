package testing;

/*This code is for laying the GUI of the Address book 

 *  Date: 6/7/20
 *  Author: Raed K, Cole H
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class AddressBook extends JFrame implements ActionListener, WindowListener {
           
          //TextFields for name, address, city, state, zip code, phone #, and email address
          JTextField nameTextField;
          JTextField lastNameTextField;
          JTextField addressTextField;
          JTextField cityTextField;
          JTextField stateTextField;
          JTextField zipTextField;
          JTextField phoneTextField;
          JTextField emailTextField;
          JTextField miscellaneousTextField;
          
      	//A string arraylist to keep track of all contacts 
         ArrayList<String> contacts = new ArrayList<String>();
         
		public AddressBook() {
          		  //setting size of entire window
                  setSize(800,600);
                  //setting title of application
                  setTitle("Address Book");

                  //container for all the information
                 Container contentPanel = getContentPane();
                  contentPanel.setLayout(new GridLayout(11,3));
                  

                  //setting a label and textfield for their name
                  JLabel nameLabel = new JLabel("Name: ");
                  contentPanel.add(nameLabel);
                  nameTextField = new JTextField(25);
                  contentPanel.add(nameTextField);
                  
                  //setting a label and textfield for their last name
                  JLabel lastnameLabel = new JLabel("Last name: ");
                  contentPanel.add(lastnameLabel);
                  lastNameTextField = new JTextField(25);
                  contentPanel.add(lastNameTextField);

                  //setting a label and textfield for their addresss
                  JLabel addressLabel = new JLabel("Address:  ");
                  contentPanel.add(addressLabel);
                  addressTextField = new JTextField(25);
                  contentPanel.add(addressTextField);

                  //setting a label and textfield for their city
                  JLabel cityLabel = new JLabel("City: ");
                  contentPanel.add(cityLabel);
                  cityTextField = new JTextField(25);
                  contentPanel.add(cityTextField);

                  //setting a label and textfield for their state
                  JLabel stateLabel = new JLabel("State: ");
                 contentPanel.add(stateLabel);
                  stateTextField = new JTextField(25);
                 contentPanel.add(stateTextField);

                 //setting a label and textfield for their zip code
                  JLabel zipLabel = new JLabel("Zip code: ");
                  contentPanel.add(zipLabel);
                  zipTextField = new JTextField(25);
                 contentPanel.add(zipTextField);

                 //setting a label and textfield for their phone number
                  JLabel phoneLabel = new JLabel("Phone number: ");
                  contentPanel.add(phoneLabel);
                  phoneTextField = new JTextField(25);
                  contentPanel.add(phoneTextField);

                  //setting a label and textfield for their email address
                 JLabel emailLabel = new JLabel("Email: ");
                  contentPanel.add(emailLabel);
                  emailTextField = new JTextField(25);
                  contentPanel.add(emailTextField);

                  //setting a label and textfield for micellanious info
                  JLabel micellaniousLabel = new JLabel("Miscellaneous: ");
				  contentPanel.add(micellaniousLabel);
                  miscellaneousTextField = new JTextField(25);
                  contentPanel.add(miscellaneousTextField);

                  //button to save the data	
                  JButton saveButton = new JButton("Save Contact");
                  saveButton.addActionListener(this);
                  contentPanel.add(saveButton);

                  //button to load data that has been saved
                  JButton editButton = new JButton("Edit Contact");
                  editButton.addActionListener(this);
                  contentPanel.add(editButton);
                  
                  //button to see all contacts
                  JButton allContacts = new JButton("See all contacts");
                  allContacts.addActionListener(this);
                  contentPanel.add(allContacts); 

		}
		
          
          public void actionPerformed(ActionEvent e) {
              		//if the save button is pressed, all the info the user entered will be stored in a variable named "data"
                 	 if (e.getActionCommand().equals("Save Contact")) {
                     
                     //A save data file is created, and the info contained in each text field is added to it
                	 SaveData data = new SaveData();
                	 data.name = nameTextField.getText();
                	 data.lastName = lastNameTextField.getText();
                	 data.address = addressTextField.getText();
                	 data.city = cityTextField.getText();
                	 data.state = stateTextField.getText();
                	 data.zip = zipTextField.getText();
                	 data.phoneNumber = phoneTextField.getText();
                	 data.email = emailTextField.getText();
                	 data.miscellaneous = miscellaneousTextField.getText();
                	 //Try to save all the info into a save file. and the name of that save file will be the name of the contact
                	 try {
                		 contacts.add(nameTextField.getText());
                		 ResourceManager.save(data, nameTextField.getText());
                		 JOptionPane.showMessageDialog(null, "The contact has been saved!");
                	 }
                	 // otherwise if something goes terribly wrong, output an error message 
                	 catch (Exception r) {
                		 JOptionPane.showMessageDialog(null, "Couldn't save the contact!");
                	 }
                  }

                 	else if (e.getActionCommand().equals("Edit Contact")) {
                 		try {
                      // if the edit button is pressed, an attempt to load the save data will occur
                 			String loadcontactFile = JOptionPane.showInputDialog("What is the name of the contact you would like to edit?", "");
                 			SaveData data = (SaveData) ResourceManager.load(loadcontactFile);
                 			nameTextField.setText(data.name);
                 			lastNameTextField.setText(data.lastName);
                 			addressTextField.setText(data.address);
                 			cityTextField.setText(data.city);
                 			stateTextField.setText(data.state);
                 			zipTextField.setText(data.zip);
                 			phoneTextField.setText(data.phoneNumber);
                 			emailTextField.setText(data.email);
                 			miscellaneousTextField.setText(data.miscellaneous);
                 			JOptionPane.showMessageDialog(null, "The contact has been loaded!");
                 		}                         
                 		//otherwise, if something goes terribly wrong, output an error message 
                 		catch (Exception r) {
                      		 JOptionPane.showMessageDialog(null, "Couldn't load the contact!");
                 		}
                 	}
                 	else if (e.getActionCommand().equals("See all contacts")) {
                 		//if the contact list is empty, output this message 
                 		if (contacts.isEmpty()) {
                     		 JOptionPane.showMessageDialog(null, "You have 0 contacts!");
                 		}
                 		//otherwise, display all the user's contacts 
                 		else {
                 			//I'm slowly losing my sanity
                    		 JOptionPane.showMessageDialog(null, contacts); 
                 		}
                 	} 
          		}
         //main method
         public static void main(String[] args) {
        	
                 AddressBook GUI = new AddressBook();
                 //setting windowlistener 
                 GUI.addWindowListener(GUI);
                 GUI.setVisible(true);
                 
         }


		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void windowClosed(WindowEvent e) {
			
		}


		@Override
		public void windowClosing(WindowEvent e) {
			//when the application is closing, save everything in the textfields into a save file
			SaveData windowClosed = new SaveData();
			windowClosed.name = nameTextField.getText();
			windowClosed.lastName = lastNameTextField.getText();
			windowClosed.address = addressTextField.getText();
			windowClosed.city = cityTextField.getText();
			windowClosed.state = stateTextField.getText();
			windowClosed.zip = zipTextField.getText();
			windowClosed.phoneNumber = phoneTextField.getText();
			windowClosed.email = emailTextField.getText();
			windowClosed.miscellaneous = miscellaneousTextField.getText();	
			try {
				//attempt to save the text into a file called save state
       		 ResourceManager.save(windowClosed, "Save State");
			}
       		//otherwise, if something goes terribly wrong, output an error message 
			 catch (Exception r) {
        		 JOptionPane.showMessageDialog(null, r.getMessage());
        	 }
		}


		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void windowOpened(WindowEvent e) {
			try {
				//if the window is opened, load the state the application was in
           			SaveData windowOpened = (SaveData) ResourceManager.load("Save State");
           			nameTextField.setText(windowOpened.name);
           			lastNameTextField.setText(windowOpened.lastName);
           			addressTextField.setText(windowOpened.address);
           			cityTextField.setText(windowOpened.city);
           			stateTextField.setText(windowOpened.state);
           			zipTextField.setText(windowOpened.zip);
           			phoneTextField.setText(windowOpened.phoneNumber);
           			emailTextField.setText(windowOpened.email);
           			miscellaneousTextField.setText(windowOpened.miscellaneous);
           		}                         
           		//otherwise, if something goes terribly wrong, output an error message 
           		catch (Exception r) {
                		 JOptionPane.showMessageDialog(null, r.getMessage());
           		}
		}
}