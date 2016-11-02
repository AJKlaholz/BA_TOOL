package testnewpackage;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MockGUI extends JFrame implements ActionListener {
	private JButton saveb = new JButton();
	private JButton loadb = new JButton();
	private JButton deleteb = new JButton();

	
	public MockGUI(){
		this.setTitle("Mockup GUI");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,400));
		this.setLayout(new FlowLayout());
		
		saveb.setText("Save");
		loadb.setText("Load");
		deleteb.setText("Delete");
		
		saveb.setBounds(20, 300, 100, 30);
		loadb.setBounds(140, 300, 100, 30);
		deleteb.setBounds(260, 300, 100, 30);
		
		
		saveb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){
			JFrame f = new JFrame();
			JLabel sB = new JLabel("Object was saved");
			f.add(sB);
			f.pack();
			f.setLocationRelativeTo(null);
			f.setVisible(true);	
			}
		});
	
		loadb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JFrame f = new JFrame();
				JLabel sB = new JLabel("Object was loaded");
				f.add(sB);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
				}
			});
		deleteb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JFrame f = new JFrame();
				JLabel sB = new JLabel("Object was deleted");
				f.add(sB);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
				}
			});
		
		
		this.setLayout(null);
	/*	JTextField jt = new JTextField(30);
		//this.getContentPane().add(jt);
		this.add(jt);
		  jt.setBounds(10,10,80,30);
	      jt.setVisible(true);
	      jt.addActionListener(this);
		*/
		
		
		addingTextfields(this);
		
		
		this.add(saveb);
		this.add(loadb);
		this.add(deleteb);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MockGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void actionPerformed(ActionEvent a) {
		JFrame f = new JFrame();
		JLabel sB = null;
		f.setTitle("Message");
		if(a.equals(knopf)){
			sB = new JLabel("Object was saved");

		}else if(a.equals(knopf2)){
			sB = new JLabel("Object was loaded");
			
		}else if(a.equals(knopf3)){
			sB = new JLabel("Objekt was deleted");
		}
		f.add(sB);
		f.pack();
		f.setVisible(true);
		
	}*/
	
	public void addingTextfields(JFrame jf){
		JTextField[] fieldList = new JTextField[8];
		int y=10;
		
		for(int i=0;i<fieldList.length;i++){
			//fieldList[i].setColumns(30);
			fieldList[i] = new JTextField(30);
			jf.add(fieldList[i]);
			fieldList[i].setBounds(10, y, 80, 20);
			
			y=y+20;
			
			fieldList[i].setVisible(true);
			fieldList[i].addActionListener(this);
			
			
		}
	}
	/*
	 * 		JTextField jt = new JTextField(30);
		//this.getContentPane().add(jt);
		this.add(jt);
		  jt.setBounds(10,10,80,30);
	      jt.setVisible(true);
	      jt.addActionListener(this);
	 */
}
