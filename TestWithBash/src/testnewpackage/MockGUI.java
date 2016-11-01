package testnewpackage;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MockGUI extends JFrame {
	private JLabel text = new JLabel();
	private JButton knopf = new JButton();
	
	public MockGUI(){
		this.setTitle("Mockup GUI");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		knopf.setText("Save");
		this.add(knopf);
		this.pack();
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MockGUI();
	}

}
