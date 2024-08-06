//package inventorymangement1;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
//public class Updateitem  extends JFrame{
//	Updateitem(){
//	JLabel up1=new JLabel("item name");
//	JTextField jf2=new JTextField(20);
//	JLabel up2=new JLabel("item quantity");
//	JTextField jf3=new JTextField(20);
//	JLabel up3=new JLabel("item price");
//	JTextField jf9=new JTextField(20);
//	JButton jbu =new JButton ("update");
//	JPanel jp2=new JPanel ();
//	jp2.add(up1);
//	jp2.add(jf2);
//	jp2.add(up2);
//	jp2.add(jf3);
//	jp2.add(jbu);
//	jp2.add(up3);
//	jp2.add(jf9);
//	add(jp2);
//	setSize(200,200);
//	setVisible(true);
//	
//
//	jbu.addActionListener(new ActionListener() {
//		public void actionPerformed( ActionEvent e) {
//		String item =up1.getText().trim();
//		int quantity=Integer.parseInt(up2.getText().trim());
//		double price=Double.parseDouble(up3.getText().trim());
//		
//		updateItemToDataBase(item, quantity, price);
//	}
//		private void updateItemToDataBase(String item, int quantity, double price) {
//			String sql="update item set item_quantity = ? , item_price = ? , where itemname=?";
//			
//			try( Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","harsha123"
//	); PreparedStatement ps=conn.prepareStatement(sql)){
//				ps.setInt(1,quantity);
//				ps.setDouble(2,price);
//				ps.setString(3,item);
//				ps.executeUpdate();
//				
//				
//				conn.close();
//				
//			} catch (SQLException e) {
//				
//			}
//		}});
//	}
//	}
//			


package inventorymangement1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Updateitem extends JFrame {
    Updateitem() {
        JLabel up1 = new JLabel("item name");
        JTextField jf2 = new JTextField(20);
        JLabel up2 = new JLabel("item quantity");
        JTextField jf3 = new JTextField(20);
        JLabel up3 = new JLabel("item price");
        JTextField jf9 = new JTextField(20);
        JButton jbu = new JButton("update");
        JPanel jp2 = new JPanel();
        jp2.add(up1);
        jp2.add(jf2);
        jp2.add(up2);
        jp2.add(jf3);
        jp2.add(up3);
        jp2.add(jf9);
        jp2.add(jbu);
        add(jp2);
        setSize(300, 200);
        setVisible(true);

        jbu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = jf2.getText().trim();
                String quantityStr = jf3.getText().trim();
                String priceStr = jf9.getText().trim();

                try {
                    int quantity = Integer.parseInt(quantityStr);
                    double price = Double.parseDouble(priceStr);
                    updateItemToDataBase(item, quantity, price);
                    JOptionPane.showMessageDialog(null, "Item updated successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void updateItemToDataBase(String item, int quantity, double price) {
                String sql = "UPDATE item SET item_quantity = ?, item_price = ? WHERE itemname = ?";

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "harsha123");
                     PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setInt(1, quantity);
                    ps.setDouble(2, price);
                    ps.setString(3, item);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Updateitem();
    }
}


