package cc.co.ratan.www;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Faculty extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faculty);
        
        
    try{
          ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
             
             JSONObject json = JSONfunctions.getJSONfromURL("http://ratan.co.cc/faculty.php");
             
              	JSONArray  faculty = json.getJSONArray("faculty_profile");
              	
           
               	        for(int i=0;i<faculty.length();i++){						
         				
         	        	JSONObject e = faculty.getJSONObject(i);
         	        	HashMap<String, String> map1 = new HashMap<String, String>();
         	    		
         				//map.put("id",  String.valueOf(i));
         	        	map1.put("name", e.getString("name"));
         	        	map1.put("phoneno", "contact : " +  e.getString("phoneno"));
         	        	map1.put("email", "email : " +  e.getString("email"));
         	        	map1.put("designation", e.getString("designation"));
         	        	map1.put("qualification",  e.getString("qualification"));
             	        
         	        	mylist.add(map1);			
         			
         	        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.listview, 
                             new String[] { "name", "email", "phoneno"},
                             
                             new int[] { R.id.item_title, R.id.item_subtitle , R.id.item_subtitle2 });
         	
         	        setListAdapter(adapter);
         	        
            
        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        lv.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
        		@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		Toast.makeText(Faculty.this, "" + o.get("designation")+ " " + o.get("qualification"), Toast.LENGTH_LONG).show(); 

			}
		});
        
               	        }}catch (Exception e) {
        	
        	Log.d("error in shoing list", "list was not generated");
			// TODO: handle exception
               	        }}}
    
