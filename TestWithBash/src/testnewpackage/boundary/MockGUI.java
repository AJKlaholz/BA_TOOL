package testnewpackage.boundary;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.Iterator;

import testnewpackage.control.GPRecordManager;
import testnewpackage.control.Record;
import testnewpackage.control.Searchterm;

public class MockGUI extends JFrame implements ActionListener {
	Connection dbConnection = null;
	
	private JButton saveb = new JButton();
	private JButton loadb = new JButton();
	private JButton deleteb = new JButton();
	private JButton downloadb = new JButton();
	private JButton resultb = new JButton();
	private JComboBox cm = new JComboBox();
	

	
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
		deleteb.setBounds(380, 300, 100, 30);
		downloadb.setBounds(500, 300, 100, 30);
		resultb.setBounds(620, 300, 100, 30);
		cm.setBounds(260, 300, 100, 30);
		
		
		//adds ALL items from database record to jcombobox
		
	
		//Statement preparedStatement = null;

		

		try {
			dbConnection = DriverManager.getConnection("jdbc:sqlite:sample.de");
			Statement preparedStatement = dbConnection.createStatement();
			ResultSet selectAllRecords = preparedStatement.executeQuery("SELECT Recordname From record");
			while(selectAllRecords.next()){
				
				cm.addItem(selectAllRecords.getString("Recordname"));
			
			}
		

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

		
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
		
		
		
		
		
		
		
		saveb.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ev){

			//INSERT INTO RECORD DATABASE
			
			GPRecordManager rp = new GPRecordManager();
			Record al = new Record();
			ArrayList <Searchterm> ast = new ArrayList();
			al.setName(fieldList[0].getText());
			for(int i=1;i<fieldList.length;i++){
				Searchterm st = new Searchterm();
				st.setName(fieldList[i].getText());
				ast.add(st);
				
			}
			
			al.setListofsterm(ast);
			rp.setRecord(al);
			
			
			
			
			
			
			
			
			//add Object to JComboBox
			cm.addItem(fieldList[0].getText());
			
			
			
			
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
				//Load selected record from JComboBox to JTextField.
				//Don't cast to record. Need to iterate on listofrec to get 
				//selected record
				Object selcObj= cm.getSelectedItem();
				String ObjtoString = selcObj.toString();
				GPRecordManager rm = new GPRecordManager();
				
				Record tmp = rm.getRecord(ObjtoString);

				fieldList[0].setText(tmp.getName());
				
			for(int i=1;i<7;i++){
				
					fieldList[i].setText(tmp.getListOfSTerm().get(i-1).getName());
				
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
				GPRecordManager rm = new GPRecordManager();
				rm.deleteRecord((String)cm.getSelectedItem());
				cm.removeItemAt(cm.getSelectedIndex());
				
				
				
				JFrame f = new JFrame();
				JLabel sB = new JLabel("Object was deleted");
				f.add(sB);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
				}
			});
		
		resultb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				JFrame f = new JFrame();
				ImageIcon ii = new ImageIcon(getClass().getResource("Ausgabegrafik.png"));
				JLabel picture = new JLabel(ii);
				
				f.add(picture);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);	
				}
			});
		
		
		this.setLayout(null);

		addingTextfieldsandLabels(this,fieldList,jl);
		
		
		this.add(saveb);
		this.add(loadb);
		this.add(deleteb);
		this.add(downloadb);
		this.add(resultb);
		this.add(cm);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		//new SQLliteSample();
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
