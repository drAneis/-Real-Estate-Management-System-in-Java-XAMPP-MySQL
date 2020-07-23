package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

public class AddProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private ViewProductActivity activity;
	private Employee employee;
	private JButton buttonLogout, buttonBack, buttonAdd;
	private JLabel title, header, productIDLabel, productNameLabel, productQtLabel, productPriceLabel, productLocatLabel, productAreaLabel, productOwnerLabel, productPhoneLabel,productEmailLabel ;
	private JTextField productIDTF, productNameTF, productQtTF, productPriceTF, productLocatTF, productAreaTF, productOwnerTF, productPhoneTF, productEmailTF;
	
	public AddProductActivity(ViewProductActivity prev, Employee employee) {
		super("Add Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("增加");
		title.setBounds(30, 40, 280,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("退出");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonBack = new JButton("返回");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		productIDLabel = new JLabel("身份证: ");
		productIDLabel .setBounds(60, 140, 140, 30);
		productIDLabel .setFont(Theme.FONT_REGULAR);
		panel.add(productIDLabel );
		
		productNameLabel = new JLabel("姓名: ");
		productNameLabel.setBounds(60, 190, 140, 30);
		productNameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("代价: ");
		productPriceLabel.setBounds(60, 240, 140, 30);
		productPriceLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productPriceLabel);
		
		productLocatLabel = new JLabel("地址: ");
		productLocatLabel.setBounds(60, 290, 140, 30);
		productLocatLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productLocatLabel);
		
	
		productAreaLabel = new JLabel("面积: ");
		productAreaLabel.setBounds(60, 340, 140, 30);
		productAreaLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productAreaLabel);
		
		productOwnerLabel = new JLabel("房主: ");
		productOwnerLabel.setBounds(60, 390, 140, 30);
		productOwnerLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productOwnerLabel);  
		
		productPhoneLabel = new JLabel("手机号: ");
		productPhoneLabel.setBounds(60, 440, 140, 30);
		productPhoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productPhoneLabel);
		
		productEmailLabel = new JLabel("邮件: ");
		productEmailLabel.setBounds(60, 490, 140, 30);
		productEmailLabel.setFont(Theme.FONT_REGULAR);
		panel.add(productEmailLabel);
		

		productIDTF = new JTextField();
		productIDTF.setBounds(180, 140, 220, 30);
		productIDTF.setFont(Theme.FONT_INPUT);
		panel.add(productIDTF);
		
		productNameTF = new JTextField();
		productNameTF.setBounds(180, 190, 220, 30);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productNameTF);
		
		productPriceTF = new JTextField();
		productPriceTF.setBounds(180, 240, 220, 30);
		productPriceTF.setFont(Theme.FONT_INPUT);
		panel.add(productPriceTF);
		
		productLocatTF = new JTextField();
		productLocatTF.setBounds(180, 290, 220, 30);
		productLocatTF.setFont(Theme.FONT_INPUT);
		panel.add(productLocatTF);
		
	
		productAreaTF = new JTextField();
		productAreaTF.setBounds(180, 340, 220, 30);
		productAreaTF.setFont(Theme.FONT_INPUT);
		panel.add(productAreaTF);
		
		productOwnerTF = new JTextField();
		productOwnerTF.setBounds(180, 390, 220, 30);
		productOwnerTF.setFont(Theme.FONT_INPUT);
		panel.add(productOwnerTF);
		
		productPhoneTF = new JTextField();
		productPhoneTF.setBounds(180, 440, 220, 30);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productPhoneTF);
		
		productEmailTF = new JTextField();
		productEmailTF.setBounds(180, 490, 220, 30);
		productEmailTF.setFont(Theme.FONT_INPUT);
		panel.add(productEmailTF); 
		
		
		
		
		
		buttonAdd = new JButton("添加");
		buttonAdd.setBounds(Theme.GUI_WIDTH-140, 495, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonAdd.setFont(Theme.FONT_BUTTON);
		buttonAdd.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAdd.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAdd.addActionListener(this);
		panel.add(buttonAdd);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			new ViewProductActivity(new EmployeeActivity(employee.getUserId()), employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonAdd)) {
			/*aqui aonde devo aumentar comentario para adicionar na minha database*/
			
			try {
				Product p = new Product();
				p.setProductID(productIDTF.getText().trim());
				p.setProductName(productNameTF.getText().trim());
				p.setPrice(Double.parseDouble(productPriceTF.getText()));
				p.setLocation(productLocatTF.getText().trim());
				//p.setQuantity(Integer.parseInt(productQtTF.getText())); //I do not need quantity
				p.setArea(productAreaTF.getText().trim());
				p.setOwner(productOwnerTF.getText().trim());
				p.setPhone(Integer.parseInt(productPhoneTF.getText()));
				p.setEmail(productEmailTF.getText().trim());
				
				
				p.createProduct();
				productIDTF.setText("");
				productNameTF.setText("");
				productPriceTF.setText("");
				productLocatTF.setText("");
				productAreaTF.setText("");
				productOwnerTF.setText("");
				productPhoneTF.setText("");
				productEmailTF.setText("");
				
			//	productQtTF.setText("");
				if (!activity.keywordTF.getText().trim().isEmpty())
					activity.table.setModel(Product.searchProduct(activity.keywordTF.getText().trim(), activity.byWhatCB.getSelectedItem().toString()));
				else
					activity.table.setModel(Product.searchProduct("", "By Name"));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Enter price/quantity correctly!"); 
			}
			catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this,e.getMessage()); 
			}
		}
		else {}
	} 
}