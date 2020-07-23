package attr;

import java.lang.*;
import java.util.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import attr.*;
import activity.*;
import javax.swing.*;

public class Product {
	private String productId;
	private String productName;
	private double price; //or cost as defined by me
	private int quantity;
	private String location;
	private String area;
	private String owner;
	private int phone;
	private String email;
	public static String[] columnNames = {"ID", "姓名", "地址", "代价", "面积", "房主", "手机号", "邮件"}; 			//{"PID", "Name", "Price", "AvailableQuantity"} //vou adicionar colunas aqui
	
	public Product() {}
	public Product(String productId) {
		if (!productId.isEmpty())
			this.productId = productId;
		else
			throw new IllegalArgumentException("Fill in the ID");
	}
	
	public void setProductID(String m) {
		if (!m.isEmpty())
			this.productId = m;
		else
			throw new IllegalArgumentException("Fill in the ID");
	}
	
	public void setProductName(String name) {
		if (!name.isEmpty())
			this.productName = name;
		else
			throw new IllegalArgumentException("Fill in the name");
	}
	public void setPrice(double p) {
		this.price = p;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public String getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setLocation(String loc) {
		if (!loc.isEmpty())
			this.location = loc;
		else
			throw new IllegalArgumentException ("Fill int the location!");
	}
	public String getLocation() {
		return location;
	}
	
	public void setArea(String ar) {
		if (!ar.isEmpty())
			this.area= ar;
		else throw new IllegalArgumentException("Fill int the area!");
		
	}
	
	public String getArea() {
		return area;
	}
	
	public void setOwner(String ow) {
		if(!ow.isEmpty())
			this.owner= ow;
		else throw new IllegalArgumentException("Fill in the Owner!");
	}
	
	public String getOwner() {
		return owner;
	}
	public void setPhone(int n) {
		this.phone= n;
	}
	public int getPhone() {
		return phone;
	}
	public void setEmail(String em) {
		if(!em.isEmpty())
			this.email = em;
		else throw new IllegalArgumentException("Fill in the email!");
	}
	
	public String getEmail() {
		return email;
	}
	
	public void fetch() {
		String query = "SELECT `productId`, `productName`, `location`, `price`, `area`, `owner`, `phone`, `email` FROM `product` WHERE productId='"+this.productId+"';";     
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				this.productName = rs.getString("productName");
				//adicionei isso 
				
				this.location = rs.getString("location");
			
				this.price = rs.getDouble("price");
				//this.quantity = rs.getInt("quantity");
				this.area = rs.getString("area");
				this.owner = rs.getString("owner");
				this.phone = rs.getInt("phone");
				this.email = rs.getString("email");
				
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void sellProduct(String uid) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		String query = "INSERT INTO `purchaseInfo` (`userId`, `productId`,`cost`, `date`) VALUES ('"+uid+"','"+this.productId+"','"+this.price+"','"+date+"');";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert
			System.out.println("data inserted");
			
			deleteProduct(); //linha adicionada por mim about deleting product
		//	updateProduct(this.productName, this.price);
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Customer doesn't exist!"); 
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void updateProduct(String name, double price, int phone, String email) {
		String query = "UPDATE `product` SET `productName`='"+name+"', `price`="+price+", `phone`='"+phone+"',`email`='"+email+"'  WHERE `productId`='"+this.productId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.executeUpdate(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Done!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public void createProduct() {
		String query = "INSERT INTO `product` (`productId`,`productName`, `location`, `price`, `area`, `owner`, `phone`, `email`) VALUES ('"+productId+"','"+productName+"','"+location+"','"+price+"','"+area+"','"+owner+"','"+phone+"','"+email+"');";        
		Connection con = null;
        Statement st = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query);//insert
			System.out.println("data inserted");
			JOptionPane.showMessageDialog(null,"Product Created!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to add Product!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
	
	public static DefaultTableModel searchProduct(String keyword, String byWhat) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		String query = "SELECT `productId`, `productName`, `location`, `price`, `area`, `owner`, `phone`, `email` FROM `product` WHERE  `productId`='"+keyword+"';";
		if (byWhat.equals("By Name"))
			query = "SELECT `productId`, `productName`, `location`, `price`, `area`, `owner`, `phone`, `email` FROM `product` WHERE `productName` LIKE '%"+keyword+"%';";
		else {}
        Connection con = null;
        Statement st = null;
		ResultSet rs = null;
		System.out.println(query);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("productId"), rs.getString("productName"), rs.getDouble("price"), rs.getString("location"), rs.getString("area"), rs.getString("owner"), rs.getInt("phone"), rs.getString("email")});
			}
		}
        catch(Exception ex) {
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
		return model;
	}
	
	public void deleteProduct() {
		String query1 = "DELETE FROM `product` WHERE `productId`='"+this.productId+"';";
		Connection con = null;
        Statement st = null;
		System.out.println(query1);
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(Database.HOST_URI, Database.USER, Database.PASSWORD);
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			st.execute(query1);//delete
			System.out.println("data deleted");
			JOptionPane.showMessageDialog(null,"Product Deleted!");
		}
        catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Failed to delete product!");
			System.out.println("Exception : " +ex.getMessage());
        }
        finally {
            try {
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex) {}
        }
	}
}