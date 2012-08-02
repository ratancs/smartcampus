package cc.co.ratan.www;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Examdetails extends ListActivity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.examdetails);
		  final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
	       
		  
	    try{
	          ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

	          String url="http://ratan.co.cc/exam.php?iemi="+tm.getDeviceId().toString();
	           Log.d("url", url);
	    
	          
	             JSONObject json = JSONfunctions.getJSONfromURL(url);
	             
	              	JSONArray  homework = json.getJSONArray("exam");
	              	
	           
	               	        for(int i=0;i<homework.length();i++){						
	         				
	         	        	JSONObject e = homework.getJSONObject(i);
	         	        	HashMap<String, String> map1 = new HashMap<String, String>();
	         	    		
	         				//map.put("id",  String.valueOf(i));
	         	        	map1.put("subject","Subject : " + e.getString("subject"));
	         	        	map1.put("time", "Time : " +  e.getString("time"));
	         	        	map1.put("date", "Date : "+ e.getString("date"));
	         	        	map1.put("venue", "Venue : "+ e.getString("venue"));
	         	        	mylist.add(map1);			
	         			
	         	        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.examview, 
	                             new String[] { "subject", "time", "date" , "venue"},
	                             
	                             new int[] { R.id.subjectexam, R.id.timeexam , R.id.dateexam , R.id.venueexam });
	         	
	         	        setListAdapter(adapter);
	         	        
	            
	        final ListView lv = getListView();
	        lv.setTextFilterEnabled(true);	
	        lv.setOnItemClickListener(new OnItemClickListener() {
	        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
	        		@SuppressWarnings("unchecked")
					HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
	        		Toast.makeText(Examdetails.this, "" + o.get("subject")+ " " + o.get("date"), Toast.LENGTH_LONG).show(); 

				}
			});
	        
	               	        }}catch (Exception e) {
	        	
	        	Log.d("error in shoing list", "list was not generated");
				// TODO: handle exception
	               	        }}
	
	
  
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // TODO Auto-generated method stub
    MenuInflater mf = getMenuInflater();
    mf.inflate(R.menu.menu, menu);

    return true;
    }	

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // TODO Auto-generated method stub
    	

    	Intent in = new Intent(Examdetails.this, Addexam.class);
    	
   
    if(item.getItemId()== R.id.newpost)
    { 
    	startActivity(in);
    	finish();
    }

    if(item.getItemId() == R.id.delpost)
    {
    	
    }
    return true;
    }

    




}
