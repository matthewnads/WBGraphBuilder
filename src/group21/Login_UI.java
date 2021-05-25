package group21;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;

/**
 * Login_UI class acts as the login interface, and is also used to launch the whole application. Start here to try our program out. 
 * @author group21
 *
 */
public class Login_UI {

	private JFrame frame; //Login Window Frame
	private JTextField txtuserName; //User username field
	private JPasswordField txtPassword; //User password field

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_UI window = new Login_UI();
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
	public Login_UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.setBounds(200, 200, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbLogin = new JLabel("Login System");
		lbLogin.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lbLogin.setBounds(186, 18, 159, 36);
		frame.getContentPane().add(lbLogin);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbUsername.setBounds(87, 93, 78, 16);
		frame.getContentPane().add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbPassword.setBounds(91, 145, 74, 16);
		frame.getContentPane().add(lbPassword);
		
		txtuserName = new JTextField();
		txtuserName.setBounds(217, 89, 233, 26);
		frame.getContentPane().add(txtuserName);
		txtuserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(217, 141, 233, 26);
		frame.getContentPane().add(txtPassword);
		
		/**
		 * Intake user login credentials and performing verification.
		 */
		JButton btnLoginButton = new JButton("Login");
		btnLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText(); //stores user password entered
				String userName = txtuserName.getText(); //stores username entered
								
				bufferedFileReader fileReader = new bufferedFileReader("loginCreds.txt");
			
				/**
				 *Verifies user credentials.
				 */
				if (userName.equals(fileReader.getUserName()) && password.equals(fileReader.getPassword())) {
					txtPassword.setText(null);
					txtuserName.setText(null);
					
					FrontEnd.main(null); //Imports main UI
					Selection.getInstance(); //Gets instance of selection class
					
					frame.setVisible(false); //removes login window upon credential verification
				
				}
				
				/**
				 * Shows a pop-up message indicating the credentials were not verified.
				 */
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Deatails", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtuserName.setText(null);
				}
				
			}
		});
		
		/**
		 *Settings for the reset button.
		 */
		btnLoginButton.setBounds(228, 221, 117, 29);
		frame.getContentPane().add(btnLoginButton);
		
		JButton btnResetButton = new JButton("Reset");
		btnResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtuserName.setText(null);
				txtPassword.setText(null);	
				
			}
		});
		
		btnResetButton.setBounds(357, 221, 117, 29);
		frame.getContentPane().add(btnResetButton);
		
		/**
		 *Settings for the exit button.
		 */
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.exit(0);
			}
		});
		btnExitButton.setBounds(67, 221, 117, 29);
		frame.getContentPane().add(btnExitButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(795, 197, -717, 16);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(42, 197, 406, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(443, 54, -376, 12);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(67, 54, 1, 12);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(44, 54, 406, 12);
		frame.getContentPane().add(separator_1_1);
	}
}
