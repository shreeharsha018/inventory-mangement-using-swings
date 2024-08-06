package inventorymangement1;

//import inventorymangement1.InventoryMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
	LoginFrame(){
		JLabel username=new JLabel("USER NAME");
		JTextField tf1=new JTextField(10);  
		JLabel password=new JLabel("PASSWORD");
		JTextField tf2=new JTextField(10);
		JButton jb=new JButton("LOGIN");
		JPanel p=new JPanel(new FlowLayout());
		p.add(username);
		p.add(tf1);
		p.add(password);
		p.add(tf2);
//		JFrame jFrame = new JFrame();
		add(p);
		p.add(jb);
		setVisible(true);
		setSize(200,200);
		setLocation(400,400);
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				String username=tf1.getText().trim();
				String password=tf2.getText().trim();
				if(username.equals("harsha")&&password.equals("harsha123")) {
		InventoryMainFrame i=new InventoryMainFrame();
		i.setVisible(true);
				}
				else {
					JLabel lf=new JLabel("loginFailed");
					JButton jb5=new JButton("ReLogin");
					JPanel r =new JPanel(new FlowLayout());
					r.add(jb5);
					r.add(lf);
					r.setVisible(true);
					setVisible(true);
					add(r);
					
							
				}
					
			}
		});
	}
				
			
	

	public static void main(String[] args) {
		LoginFrame f=new LoginFrame();
		// TODO Auto-generated method stub

	}

}
