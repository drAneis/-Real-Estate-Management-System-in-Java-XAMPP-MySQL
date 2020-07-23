package activity;
import java.awt.*;
import javax.swing.*;

public class ImageF extends JFrame {
	private ImageIcon image1;
	private JLabel label1;
	private ImageIcon image2;
	private JLabel label2;
	
	ImageF (int a){
		setLayout(new FlowLayout());
		if (a == 0) {
			image1 = new ImageIcon(getClass().getResource("mansion.jpg"));
			label1 = new JLabel(image1);
			add(label1);
		}
			
		else if(a == 1) {
			
			image2 = new ImageIcon(getClass().getResource("rsz_1mansion2.jpg"));
			label2 = new JLabel(image2);
			add(label2);
			
		}
		
	

		
	}
	


}
