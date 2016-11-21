package application.boundary;

import org.jfree.chart.ChartPanel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import application.control.GPGTrends;
import application.control.GPRecordManager;
import application.control.Record;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;	

public class LineChart_AWT extends ApplicationFrame
{
	GPRecordManager rm = new GPRecordManager();
	GPGTrends t = new GPGTrends();
   public LineChart_AWT( String applicationTitle , String chartTitle ,String r)
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createTimeSeriesChart(
         chartTitle,
         "time interval","popularity",
         createDataset(GPGTrends.parsDataFromJavaIntoRecord(t.parsDataFromJavaIntoRecord(rm.getRecord(r)))),
         true,true,false);
     
      
      
      
      
      
      
      
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
     
      chartPanel.setPreferredSize( new java.awt.Dimension(1500, 500 ) );
      setContentPane( chartPanel );
     
   }


   public TimeSeriesCollection createDataset(Record gt)
   {
	   
	  TimeSeriesCollection  dataset = new TimeSeriesCollection ( );  
     for(int i=0;i<gt.getListOfSTerm().size();i++){
    	 TimeSeries xys = new TimeSeries(gt.getListOfSTerm().get(i).getName()) ; 
     for(Map.Entry<Date, Double> entry : gt.getListOfSTerm().get(i).getDateListFromSearchterm().entrySet()){
    	 //dataset.addValue( 15 , "schools" , "1970" );
    	//System.out.println(entry.getKey().getDay());
    	//System.out.println(  entry.getKey().getDay()+"   " +entry.getKey().getMonth()+"  "+entry.getKey().getYear());
    	 
    	 xys.addOrUpdate((new Day(entry.getKey().getDay(),entry.getKey().getMonth()+1,entry.getKey().getYear())), entry.getValue());
     }
     dataset.addSeries(xys);
      
     }
      return dataset;
   }

}