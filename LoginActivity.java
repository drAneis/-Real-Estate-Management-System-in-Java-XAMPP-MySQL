package activity;

import java.util.Random;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

public class LoginActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonExit, buttonLogin, buttonSignup,buttonRandom;
	private JLabel title, header, usernameLabel, passwordLabel;
	private JTextField usernameTF; //VerificationTF ;
	public static JTextField  passwordTF1,  VerificationTF;
	private JPasswordField passwordF;
	private Random ran;
	
	public static int j;
	
	
	
	public static int nxt, nxt1;
	public LoginActivity() {
		super("Login");
		
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("房屋销售管理系统"); //editei esse parte
		//antes era shop management system
		
		title.setBounds(30, 40, 555, 75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonExit = new JButton("退出"); //antes exit
		buttonExit.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonExit.setFont(Theme.FONT_BUTTON);
		buttonExit.setBackground(Color.WHITE);
		buttonExit.setForeground(Theme.COLOR_TITLE);
		buttonExit.addActionListener(this);
		panel.add(buttonExit);
		
		buttonSignup = new JButton("登记"); //antes sign up
		buttonSignup.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSignup.setFont(Theme.FONT_BUTTON);
		buttonSignup.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSignup.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSignup.addActionListener(this);
		panel.add(buttonSignup);
		
		usernameLabel = new JLabel("用户身份: "); //User ID
		usernameLabel.setBounds(210, 220, 120, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		usernameTF = new JTextField();
		usernameTF.setBounds(330, 220, 220, 30);
		usernameTF.setFont(Theme.FONT_INPUT);
		panel.add(usernameTF);
		
		passwordLabel = new JLabel("密码: "); //password  
		passwordLabel.setBounds(210, 280, 120, 30);
		passwordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(passwordLabel);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(330, 280, 220, 30);
		passwordF.setFont(Theme.FONT_INPUT);
		panel.add(passwordF);
		
		buttonLogin = new JButton("登录"); //antes Login
		buttonLogin.setBounds(230, 380, 300, 30);
		buttonLogin.setFont(Theme.FONT_BUTTON);
		buttonLogin.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonLogin.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonLogin.addActionListener(this);
		panel.add(buttonLogin);
		
		/*
		 * comecou aqui
		 * 
		 */
		
		ran = new Random(); 
		nxt = (ran.nextInt(9999)+1000);
		
		
		
		passwordTF1 = new JTextField(""+nxt);
		passwordTF1.setBounds(330, 320, 65, 30);
		passwordTF1.setFont(Theme.FONT_INPUT);
		passwordTF1.setEnabled(false);
		//passwordTF.setDisabledTextColor(Color.BLACK);
		panel.add(passwordTF1);
		
		buttonRandom = new JButton("验证码");
		buttonRandom.setBounds(210, 320, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonRandom.setFont(Theme.FONT_BUTTON);
		buttonRandom.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonRandom.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonRandom.addActionListener(this);
		panel.add(buttonRandom);
		
		VerificationTF  = new JTextField();
		VerificationTF.setBounds(400, 320, 145, 30);
		VerificationTF.setFont(Theme.FONT_INPUT);
		//VerificationTF.setEnabled(false);
		VerificationTF.setDisabledTextColor(Color.BLACK);
		panel.add(VerificationTF);
		
		try {
			j = Integer.parseInt(VerificationTF.getText());
			System.out.println(j);
		
			if (!VerificationTF.getText().trim().isEmpty())
				System.out.println("The text box is empty!");
		
		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Verification is Wrong!"); 
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonExit))
			System.exit(0);
		else if (ae.getSource().equals(buttonSignup)) {
			this.setVisible(false);
			new SignupActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogin)) {
			
			
			
			
			@SuppressWarnings("deprecation")
			int status = User.checkStatus(usernameTF.getText(), passwordF.getText());
			if (status == 0) {
				EmployeeActivity ea = new EmployeeActivity(usernameTF.getText());
				ea.setVisible(true);
				this.setVisible(false);
			}
			else if (status == 1) {
				CustomerActivity ca = new CustomerActivity(usernameTF.getText());
				ca.setVisible(true);
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this,"密码或用户身份不正确"); 
			}
		}
		
		else if (ae.getSource().equals(buttonRandom)) {
			 nxt1 = (ran.nextInt(9999)+1000);
			passwordTF1.setText(""+nxt1);
		}
		
		
		else {}
	}
}