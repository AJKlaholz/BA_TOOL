package testnewpackage.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Searchterm {
	private String name;
	private HashMap<Date, Double> DateListFromSearchterm = new HashMap<Date, Double>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void addDateAndPopularity(Date d, double pop){
		this.DateListFromSearchterm.put(d, pop);
	}
	
	
	public Map<Date, Double> getDateListFromSearchterm(){
		return this.DateListFromSearchterm;
	}

}
