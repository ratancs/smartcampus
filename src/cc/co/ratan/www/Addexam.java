package cc.co.ratan.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addexam extends Activity {

	 /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
		        setContentView(R.layout.newexam);
		        Button post_exam= (Button) findViewById(R.id.exam_post);
		        final EditText t1= (EditText) findViewById(R.id.examsunject);
		        final EditText t2= (EditText) findViewById(R.id.venueexam);
		        Button examtime1 = (Button) findViewById(R.id.examtime1);
		        Button examtime2 = (Button) findViewById(R.id.examtime2);
		        Button examdate= (Button) findViewById(R.id.examdate);
		        
		        Calendar cal=Calendar.getInstance();
		        int day=cal.get(Calendar.DAY_OF_MONTH);
		        int mnth=cal.get(Calendar.MONTH);
		        int year=cal.get(Calendar.YEAR);
		        
		        
		        
		        final String date= String.valueOf(day)+"/"+String.valueOf(mnth)+"/"+String.valueOf(year);
		        final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
		    	
		    	post_exam.setOnClickListener(new OnClickListener() {
		    		
		    		public void onClick(View v) {
		    			// TODO Auto-generated method stub
		    			if(v.getId()==R.id.post_hw)
		    			{		
		    				
		    				String tt1= URLEncoder.encode(t1.getText().toString());
		    				String tt2= URLEncoder.encode(t2.getText().toString());
		    				String tt3= URLEncoder.encode(date);
		    				
		    				
		    				String u = "http://ratan.co.cc/hpost.php?sub="+tt1+"&des="+tt2+"&date="+tt3+"&iemi="+tm.getDeviceId().toString();
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
		    			            	
		    				            Toast.makeText(Addexam.this, " Submission Successful ", 5000).show();
		    				            finish();
		    				           
		    			            }
		    			            else
		    			            	Toast.makeText(Addexam.this, " Submission Failed ", 5000).show();
		    			      
		    			           
		    				             		
		    		            	}catch (Exception e) {
		    		            		 
		    			// TODO: handle exception
		    		}	}	}
		    	});
		    	

		        
	   }
	        
		
		        
		

}
