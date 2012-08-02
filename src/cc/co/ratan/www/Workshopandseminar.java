package cc.co.ratan.www;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Workshopandseminar extends ListActivity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.workshopandseminar);
	        
	    try{
	          ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
	             
	             JSONObject json = JSONfunctions.getJSONfromURL("http://ratan.co.cc/Workshop&Seminarjson.php");
	             
	              	JSONArray  message = json.getJSONArray("Workshop&Seminar");
	              	
	           
	               	        for(int i=0;i<message.length();i++){						
	         				
	         	        	JSONObject e = message.getJSONObject(i);
	         	        	HashMap<String, String> map1 = new HashMap<String, String>();
	         	    		
	         	        	map1.put("from", " By :" + e.getString("from"));
	         	        	map1.put("type", "Catogary :" + e.getString("type"));
	         	        	map1.put("subject","Sub :" + e.getString("subject"));
	         	        	map1.put("description", e.getString("description"));
	         	        	map1.put("time", "on :" +  e.getString("time"));
	         	        	Log.d("retrive", e.getString("from")+ e.getString("type") + e.getString("subject") + e.getString("description") + e.getString("time"));
	         	        	mylist.add(map1);			
	         			
	         	        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.listview, 
	                             new String[] { "subject", "from" , "time"},
	                             
	                             new int[] { R.id.item_title, R.id.item_subtitle , R.id.item_subtitle2});
	         	
	         	        setListAdapter(adapter);
	         	        
	            
	        final ListView lv = getListView();
	        lv.setTextFilterEnabled(true);	
	        lv.setOnItemClickListener(new OnItemClickListener() {
	        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
	        		@SuppressWarnings("unchecked")
					HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
	        		Toast.makeText(Workshopandseminar.this, "" + o.get("subject"), Toast.LENGTH_LONG).show();
	        		Intent in = new Intent(Workshopandseminar.this, Post.class);
	        	try{	
	        		in.putExtra("subject", o.get("subject").toString());
	        		in.putExtra("desc", o.get("description").toString());
	        		in.putExtra("type", o.get("type").toString());
	        		in.putExtra("from", o.get("from").toString());
	        		in.putExtra("time", o.get("time").toString());
	        		in.putExtra("cat", "Workshop");
	        		startActivity(in);
	        	}catch (Exception e) {
	        		
	        		
					// TODO: handle exception
				}
	        		
	        		
	        		
	        			
				}
			});
	        
	               	        }}catch (Exception e) {
	        	
	        	Log.d("error in shoing list", "list was not generated");
				// TODO: handle exception

	}}
		

	}
	    
