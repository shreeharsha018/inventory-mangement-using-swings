package inventorymangement1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InventoryMainFrame extends JFrame{
	InventoryMainFrame(){
		JButton jb1=new JButton("add");
		JButton jb2=new JButton("delete");
		JButton jb3=new JButton("update");
		JButton jb4=new JButton("display");
		JPanel q=new JPanel(new FlowLayout());
		q.add(jb1);
		q.add(jb2);
		q.add(jb3);
		q.add(jb4);
		add(q);
//		setLayout(new BorderLayout());
		q.setVisible(true);
		setVisible(true);
		setSize(100,200);
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
				Additem ad=new Additem();
				
				ad.setVisible(true);
			}
				
				
			});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
			Deleteitem di=new Deleteitem();
					di.setVisible(true);
					
		
		
	}
	

});
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent e) {
			Updateitem ui=new Updateitem();
					ui.setVisible(true);
					
					
	}
});
	}
}


		
