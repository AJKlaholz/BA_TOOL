package testnewpackage.control;

import java.util.ArrayList;

import testnewpackage.entity.RecordToDB;



public class GPRecordManager {
	
		public void setRecord(Record rs){
			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(rs.getName());
			for(int i=0;i<rs.getListOfSTerm().size();i++){
				tmp.add(rs.getListOfSTerm().get(i).getName());
			}
			RecordToDB rdb = new RecordToDB();
			rdb.pushRecordToDb(tmp);
			
		}
		
		public Record getRecord(String s){
			Record lr = new Record();
			ArrayList<Searchterm> als = new ArrayList<Searchterm>();
			RecordToDB rdb = new RecordToDB();
			ArrayList <String> tmp = new ArrayList <String>(6);
			tmp = rdb.pullRecordFromDb(s);
			lr.setName(tmp.get(0));
			
			for(int i=1;i<tmp.size();i++){
				Searchterm st = new Searchterm();
				st.setName(tmp.get(i));
				als.add(st);
			}
			lr.setListofsterm(als);
			return lr;
			
			
		}
		
		public void deleteRecord(String ds){
			RecordToDB rtdb = new RecordToDB();
			rtdb.deleteRecordFromDb(ds);
		}
		
		public ArrayList<String> getAllRecordnames(){
			RecordToDB rtdb = new RecordToDB();
			
			
			return rtdb.pullAllRecordnamesFromDb();
		}
}
