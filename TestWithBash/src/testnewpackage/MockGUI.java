package testnewpackage;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MockGUI extends JFrame implements ActionListener {
	private JLabel text = new JLabel();
	private JButton knopf = new JButton();
	
	public MockGUI(){
		this.setTitle("Mockup GUI");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		
		knopf.setText("Save");
		knopf.addActionListener(this);
		this.add(knopf);
		this.pack();
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MockGUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame f = new JFrame();
		f.setTitle("Message");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel jl = new JLabel("Object was saved");
		f.add(jl);
		f.pack();
		f.setVisible(true);
		
	}

}
