package testnewpackage.control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import testnewpackage.boundary.Command;

public class GPGTrends {
	/*public static void main(String[] args){
		GPRecordManager rm = new GPRecordManager();
		GPGTrends.parsDataFromJavaIntoRecord(rm.getRecord("blizzard"));
	}*/
	public static Record parsDataFromJavaIntoRecord(Record re){
			
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\Adrian\\Documents\\pytrends-master\\examples\\table.txt"));
			sc.nextLine();
			sc.nextLine();
			while(sc.hasNextLine()){
				String sdate = sc.next();
				String year = "";
				String month = "";
				String day = "";
				for(int i=0;i<sdate.length();i++){
					if(i<4){
						year+=sdate.charAt(i);
					}else if((i==5)||(i==6)){
						month+=sdate.charAt(i);
					}else if((i==8)||(i==9)){
						day+=sdate.charAt(i);
					}
					
					
				}
				Date d =new Date(Integer.parseInt(year)-1900,Integer.parseInt(month)-1,Integer.parseInt(day));
				
				for(int i=0;i<re.getListOfSTerm().size();i++){
				
					re.getListOfSTerm().get(i).addDateAndPopularity(d, Double.parseDouble(sc.next()));
					
				
				}
				
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return re;

		
	}
	public static void printTableIntoFile(ArrayList <String> searchterms){
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
				c.exec("py testjava.py > table.txt");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
