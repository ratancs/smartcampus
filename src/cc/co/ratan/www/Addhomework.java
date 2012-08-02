package cc.co.ratan.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addhomework extends Activity {
	

    int mDay;
    int mMonth;
    int mYear;
    Button mPickDate = (Button) findViewById(R.id.pickDate);
    TextView mDateDisplay = (TextView) findViewById(R.id.dDisplay);
   
    
    static final int DATE_DIALOG_ID = 0;
    
	 /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       
		        setContentView(R.layout.addhomework);
		        
		        Button post_hw= (Button) findViewById(R.id.post_hw);
		        
		        
		        
		        mDateDisplay.setText("empty");
		      
		        
		  

		        final EditText t1= (EditText) findViewById(R.id.hwsub);
		        final EditText t2= (EditText) findViewById(R.id.hwdec);
	         
		        
		        final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
		    	
		    	post_hw.setOnClickListener(new OnClickListener() {
		    		
		    		public void onClick(View v) {
		    			// TODO Auto-generated method stub
		    			if(v.getId()==R.id.pickDate)
		    			{ showDialog(DATE_DIALOG_ID);}
		    			
		    			
		    			if(v.getId()==R.id.post_hw)
		    			{		

		                     String date = mDateDisplay.getText().toString();
		    				String tt1= URLEncoder.encode(t1.getText().toString());
		    				String tt2= URLEncoder.encode(t2.getText().toString());
		    				  final String tt3= URLEncoder.encode(date);
		    				
		    				
		    				
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
		    			            	
		    				            Toast.makeText(Addhomework.this, " Submission Successful ", 5000).show();
		    				            finish();
		    				           
		    			            }
		    			            else
		    			            	Toast.makeText(Addhomework.this, " Submission Failed ", 5000).show();
		    			      
		    			           
		    				             		
		    		            	}catch (Exception e) {
		    		            		 
		    			// TODO: handle exception
		    		}	}	}
		    	});
		    	

		        final Calendar c = Calendar.getInstance();
	            mYear = c.get(Calendar.YEAR);
	            mMonth = c.get(Calendar.MONTH);
	            mDay = c.get(Calendar.DAY_OF_MONTH);

	            // display the current date (this method is below)
	            updateDisplay();
	   }
	    // updates the date in the TextView
	   
	   private void updateDisplay() {
	        mDateDisplay.setText(
	            new StringBuilder()
	                    // Month is 0 based so add 1
	                    .append(mMonth + 1).append("-")
	                    .append(mDay).append("-")
	                    .append(mYear).append(" "));
	        
	    }
	    
	    // the callback received when the user "sets" the date in the dialog
	    private DatePickerDialog.OnDateSetListener mDateSetListener =
	            new DatePickerDialog.OnDateSetListener() {

	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                    mYear = year;
	                    mMonth = monthOfYear;
	                    mDay = dayOfMonth;
	                    updateDisplay();
	                }
	            };
	            @Override
	            protected Dialog onCreateDialog(int id) {
	                switch (id) {
	                case DATE_DIALOG_ID:
	                    return new DatePickerDialog(this,
	                                mDateSetListener,
	                                mYear, mMonth, mDay);
	                }
	                return null;
	            }
	        
	            
	   
	        
	   }
		        
		        
	   
	   
		 