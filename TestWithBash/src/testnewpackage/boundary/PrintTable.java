package testnewpackage.boundary;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class PrintTable {
	public static void print(ArrayList <String> searchterms){
	String s = searchterms.get(0);
	
	for(int i=1;i<searchterms.size();i++){
		s+=", "+searchterms.get(i);
	}
	
		
	try { 
	       String nameAusgabedatei = "C:\\Users\\Adrian\\Documents\\pytrends-master\\examples\\testjava.py"; 
	        File ausgabedatei = new File(nameAusgabedatei); 
	        FileWriter fw = new FileWriter(ausgabedatei,false); //true für append!
	       BufferedWriter bw = new BufferedWriter(fw); 
	        bw.write(""); 
	        bw.close(); 
	      } catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		try(FileWriter fw = new FileWriter("C:\\Users\\Adrian\\Documents\\pytrends-master\\examples\\testjava.py", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println("from pytrends.request import TrendReq \n"+
			    		"\n"+
			    		"google_username = \"adrian.klaholz@gmail.com\" \n" +
			    		"google_password = \"Zoxoduvu123\"\n" +
			    		"path = \"\"\n"+
			    		"\n"+
			    		"# connect to Google\n"+
			    		"pytrend = TrendReq(google_username, google_password, custom_useragent=None)\n"+
			    		"\n"+
			    		"trend_payload = {'q': '"+s+"','date':'today 12-m'}\n"+
			    		"# trend\n"+
			    		"trend = pytrend.trend(trend_payload)\n"+
			    		"#print(trend)\n"+
			    		"df = pytrend.trend(trend_payload, return_type='dataframe')\n"+
			    		"print(df)");
			    
			    
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		
		
		Command c = new Command("C:\\Users\\Adrian\\Documents\\pytrends-master\\examples");
		try {
			c.exec("py testjava.py");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
