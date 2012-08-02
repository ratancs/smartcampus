package cc.co.ratan.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addtimetable extends Activity {
	

	
	 /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
	        setContentView(R.layout.addtimetable);
	        
	         
	    	final EditText t1 = (EditText) findViewById(R.id.to910);
	    	final EditText t2 = (EditText) findViewById(R.id.to1011);
	    	final EditText t3 = (EditText) findViewById(R.id.to1112);
	    	final EditText t4 = (EditText) findViewById(R.id.to12);
	    	final EditText t5 = (EditText) findViewById(R.id.to23);
	    	final EditText t6 = (EditText) findViewById(R.id.to34);
	    	final EditText day = (EditText) findViewById(R.id.day);
	    	
	    	
	    	
	    	
	    	
	    	Button post_btn = (Button) findViewById(R.id.post_timetable);
	    	final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
	    	
	    	post_btn.setOnClickListener(new OnClickListener() {
	    		
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    			if(v.getId()==R.id.post_timetable)
	    			{		
	    				
	    				String tt1= URLEncoder.encode(t1.getText().toString());
	    				String tt2= URLEncoder.encode(t2.getText().toString());
	    				String tt3= URLEncoder.encode(t3.getText().toString());
	    				String tt4= URLEncoder.encode(t4.getText().toString());
	    				String tt5= URLEncoder.encode(t5.getText().toString());
	    				String tt6= URLEncoder.encode(t6.getText().toString());
	    				
	    				
	    				String u = "http://ratan.co.cc/tpost.php?t1="+tt1+"&t2="+tt2+"&t3="+tt3+"&t4="+tt4+"&t5="+tt5+"&t6="+tt6+"&day="+day.getText().toString()+"&iemi="+tm.getDeviceId().toString();
	    				Log.d("url" , u);
	    				String line=" ";
	    		            try{
	    		            	URL url= null;
	    		            	url= new URL(u);
	    		            	
	    		            	
	    		            	URLConnection conn = url.openConnection();
	    		            	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    		            	
	    		            	line=reader.readLine();
	    		     
	    	            		int ch=line.charAt(0);
	    	            		
	    	            		Log.d("retrive", "connaction established");
	    	            		         //whatever you want
	    			            if(ch=='1')
	    			            {
	    			            	
	    				            Toast.makeText(Addtimetable.this, " Submission Successful ", 5000).show();
	    				            finish();
	    				           
	    			            }
	    			            else
	    			            	Toast.makeText(Addtimetable.this, " Submission Failed ", 5000).show();
	    			      
	    			           
	    				             		
	    		            	}catch (Exception e) {
	    		            		 
	    			// TODO: handle exception
	    		}	}	}
	    	});
	    	

	        
   }
        
	
}
