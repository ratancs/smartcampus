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

public class Timetable extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
        
        
    try{
          ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
             String url="http://ratan.co.cc/timetable.php?iemi="+tm.getDeviceId().toString();
             Log.d("url", url);
             JSONObject json = JSONfunctions.getJSONfromURL(url);
             
              	JSONArray  timetable = json.getJSONArray("timetable");
              	
           
               	        for(int i=0;i<timetable.length();i++){						
         			
         	        	JSONObject e = timetable.getJSONObject(i);
         	        	HashMap<String, String> map1 = new HashMap<String, String>();
         	    		
         				
         	        	map1.put("9:00 - 10:00", "9:00 - 10:00 :" + e.getString("9:00 - 10:00"));
         	        	map1.put("10:00 - 11:00", "10:00 - 11:00 : " +e.getString("10:00 - 11:00"));
         	        	map1.put("11:00 - 12:00", "11:00 - 12:00 : " +e.getString("11:00 - 12:00"));
         	        	map1.put("1:00 - 2:00", "1:00 - 2:00 : " +e.getString("1:00 - 2:00"));
         	        	map1.put("2:00 - 3:00", "2:00 - 3:00 : " +e.getString("2:00 - 3:00"));
         	        	map1.put("3:00 - 4:00", "4:00 - 4:00 : " +e.getString("3:00 - 4:00"));
         	        	map1.put("day", "day : " +  e.getString("day"));
         	        	map1.put("updated", "updated : " +  e.getString("updated"));
         	        	
         	        	mylist.add(map1);			
         	        	
         			
         	        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.timetaview, 
                             new String[] { "9:00 - 10:00","10:00 - 11:00","11:00 - 12:00","1:00 - 2:00","2:00 - 3:00","3:00 - 4:00","day","updated" },
                             
                             new int[] { R.id.t1 , R.id.t2 , R.id.t3 , R.id.t4 , R.id.t5 , R.id.t6 , R.id.day, R.id.updated });
         	
         	        setListAdapter(adapter);
         	        
            
        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        lv.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
        		@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		Toast.makeText(Timetable.this, "" + o.get("updated"), Toast.LENGTH_LONG).show(); 

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
    	

    	Intent in = new Intent(Timetable.this, Addtimetable.class);
    	
   
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
    
