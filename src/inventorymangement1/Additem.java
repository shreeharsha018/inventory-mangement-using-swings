package inventorymangement1;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javax.swing.*;

public class Additem extends JFrame {
	Additem(){
		JLabel in=new JLabel("ITEM NAME");
		JTextField it=new JTextField(30);
		JLabel iq=new JLabel("ITEM QUANTITY");
		JTextField qt=new JTextField(30);
		JLabel ip=new JLabel("ITEM PRICE");
		JTextField ir=new JTextField(30);
		JButton jb6=new JButton ("OK");
		JPanel s=new JPanel(new FlowLayout());
		s.add(in);
		s.add(it);
		s.add(iq);
		s.add(qt);
		s.add(ip);
		s.add(ir);
		s.add(jb6);
		add(s);
		setSize(200,400);
		setVisible(true);
	

jb6.addActionListener(new ActionListener() {
	public void actionPerformed( ActionEvent e) {
	String item =it.getText().trim();
	int quantity=Integer.parseInt(qt.getText().trim());
	double price=Double.parseDouble(ir.getText().trim());
	
	addItemToDataBase(item, quantity, price);
}
	private void addItemToDataBase(String item, int quantity, double price) {
		String sql="insert into item (itemname,item_quantity,item_price) values (?, ?, ?)";
		
		try( Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","harsha123"
); PreparedStatement ps=conn.prepareStatement(sql)){
			ps.setString(1,item);
			ps.setInt(2,quantity);
			ps.setDouble(3,price);
			ps.executeUpdate();
			
			
			conn.close();
			
		} catch (SQLException e) {
			
		}
	}});
}
}
		




