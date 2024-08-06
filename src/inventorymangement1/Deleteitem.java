package inventorymangement1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class Deleteitem extends JFrame {
    Deleteitem() {
        JLabel in1 = new JLabel("ITEM NAME");
        JTextField it1 = new JTextField(30);

        JButton jb7 = new JButton("Delete");
        JPanel t = new JPanel(new FlowLayout());
        t.add(in1);
        t.add(it1);
        t.add(jb7);
        add(t);
        setSize(400, 150);
        setVisible(true);

        jb7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = it1.getText().trim();

                if (!item.isEmpty()) {
                    deleteItemFromDatabase(item);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid item name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }

            private void deleteItemFromDatabase(String item) {
                String sql = "DELETE FROM item WHERE itemname = ?";

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "harsha123");
                     PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, item);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Item deleted successfully!");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}

//
//
