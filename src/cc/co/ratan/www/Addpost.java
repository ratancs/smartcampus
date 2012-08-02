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

public class Addpost extends Activity {
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	        setContentView(R.layout.addpost);
         
	final EditText sub = (EditText) findViewById(R.id.post_sub);
	final EditText des = (EditText) findViewById(R.id.post_desc);
	Button post_btn = (Button) findViewById(R.id.post_button);
	final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
	final String s ;
	s= getIntent().getExtras().getString("cat");
	
	post_btn.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId()==R.id.post_button)
			{		
				
				String sb= URLEncoder.encode(sub.getText().toString());
				String ds= URLEncoder.encode(des.getText().toString());
				
				
				String u = "http://ratan.co.cc/post.php?sub="+sb+"&des="+ds+"&iemi="+tm.getDeviceId().toString()+"&type="+s;
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
			            	
				            Toast.makeText(Addpost.this, " Submission Successful ", 5000).show();
				            finish();
				           
			            }
			            else
			            	Toast.makeText(Addpost.this, " Submission Failed ", 5000).show();
			      
			           
				             		
		            	}catch (Exception e) {
		            		 
			// TODO: handle exception
		}	}	}
	});
	
    }

}
