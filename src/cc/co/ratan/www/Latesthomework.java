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

public class Latesthomework extends ListActivity{
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.latesthomework);
		  final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
	       
		  
	    try{
	          ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

	          String url="http://ratan.co.cc/homework.php?iemi="+tm.getDeviceId().toString();
	           Log.d("url", url);
	    
	          
	             JSONObject json = JSONfunctions.getJSONfromURL(url);
	             
	              	JSONArray  homework = json.getJSONArray("homework");
	              	
	           
	               	        for(int i=0;i<homework.length();i++){						
	         				
	         	        	JSONObject e = homework.getJSONObject(i);
	         	        	HashMap<String, String> map1 = new HashMap<String, String>();
	         	    		
	         	        	map1.put("subject","Subject : " + e.getString("subject"));
	         	        	map1.put("subdate", "Submission date : " +  e.getString("subdate"));
	         	        	map1.put("desc", "Description : "+ e.getString("desc"));
	         	        	map1.put("givendate", "Given on : " +  e.getString("givendate"));
	         	        	map1.put("by", "Posted By : " +  e.getString("by"));
	         	        	
	         	        	mylist.add(map1);			
	         			
	         	        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.homeworkview, 
	                             new String[] { "subject","subdate", "desc", "givendate", "by"},
	                             
	                             new int[] { R.id.hwsubject, R.id.hwsubdate , R.id.hwsubdes,R.id.hwgivendate,R.id.hwby });
	         	
	         	        setListAdapter(adapter);
	         	        
	            
	        final ListView lv = getListView();
	        lv.setTextFilterEnabled(true);	
	        lv.setOnItemClickListener(new OnItemClickListener() {
	        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
	        		@SuppressWarnings("unchecked")
					HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
	        		Toast.makeText(Latesthomework.this, "" + o.get("subject")+ " " + o.get("by"), Toast.LENGTH_LONG).show(); 

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
    	

    	Intent in = new Intent(Latesthomework.this, Addhomework.class);
    	
   
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
