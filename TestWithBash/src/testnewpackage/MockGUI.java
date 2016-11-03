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
	private JButton downloadb = new JButton();
	private JButton resultb = new JButton();
	
	private ArrayList<Record> listofrec = new ArrayList<Record>();
	
	JTextField[] fieldList = new JTextField[8];
	JLabel[] jl = new JLabel[8];

	
	public MockGUI(){
		this.setTitle("Mockup GUI");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,400));
		this.setLayout(new FlowLayout());
		
		saveb.setText("Save");
		loadb.setText("Load");
		deleteb.setText("Delete");
		downloadb.setText("Download");
		resultb.setText("Result");
		
		saveb.setBounds(20, 300, 100, 30);
		loadb.setBounds(140, 300, 100, 30);
		deleteb.setBounds(260, 300, 100, 30);
		downloadb.setBounds(500, 300, 100, 30);
		resultb.setBounds(620, 300, 100, 30);
		
		
		saveb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){
			Record tmp = new Record();
			tmp.setName(fieldList[0].getText());
			System.out.println(fieldList[0].getText());
			listofrec.add(tmp);
			
			
			
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
				for(int i=0;i<listofrec.size();i++){
				System.out.println(listofrec.get(i).getName());
				}
				
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
		
		
		addingTextfieldsandLabels(this,fieldList,jl);
		
		
		this.add(saveb);
		this.add(loadb);
		this.add(deleteb);
		this.add(downloadb);
		this.add(resultb);
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

	
	
	//adding an array of JTextFields to a JFrame
	public void addingTextfieldsandLabels(JFrame jf, JTextField[] fieldList, JLabel[] jl){
		//JTextField[] fieldList = new JTextField[8];
		//JLabel[] jl = new JLabel[8];
		int y=10;
		
		for(int i=0;i<fieldList.length;i++){
			if(i==0){
				jl[i] = new JLabel("Record:"); 
			}else{
				jl[i] = new JLabel("Searchterm:");
			}
			
			fieldList[i] = new JTextField(30);
			jf.add(fieldList[i]);
			jf.add(jl[i]);
			fieldList[i].setBounds(100, y, 150, 20);
			jl[i].setBounds(10, y, 100, 20);
			
			y=y+30;
			
			
			
			
		}
	}

}
