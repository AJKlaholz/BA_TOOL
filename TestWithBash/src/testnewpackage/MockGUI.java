package testnewpackage;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MockGUI extends JFrame implements ActionListener {
	private JLabel text = new JLabel();
	private JButton knopf = new JButton();
	private JButton knopf2 = new JButton();
	private JButton knopf3 = new JButton();
	
	public MockGUI(){
		this.setTitle("Mockup GUI");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,400));
		this.setLayout(new FlowLayout());
		
		
		knopf.setText("Save");
		knopf2.setText("Load");
		knopf3.setText("Delete");
		
		knopf.setBounds(20, 70, 200, 100);
		
		
		knopf.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){
			JFrame f = new JFrame();
			JLabel sB = new JLabel("Object was saved");
			f.add(sB);
			f.pack();
			f.setLocationRelativeTo(null);
			f.setVisible(true);	
			}
		});
	
		knopf2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JFrame f = new JFrame();
				JLabel sB = new JLabel("Object was loaded");
				f.add(sB);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
				}
			});
		knopf3.addActionListener(new ActionListener(){
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
		this.add(knopf);
		this.add(knopf2);
		this.add(knopf3);
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

}
