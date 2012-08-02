package cc.co.ratan.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class main extends Activity  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
        	SQLiteDatabase   dbe = SQLiteDatabase.openDatabase("/data/data/cc.co.ratan.www/databases/login", null,0);
            Log.d("opendb","EXIST");
            dbe.close();
            startActivity(new Intent(main.this, Menu.class));
            finish();
 
        }catch (Exception e) {
			// TODO: handle exception
		}
        setContentView(R.layout.main);
        
        Button register =(Button) findViewById(R.id.register);
        final EditText reg =(EditText) findViewById(R.id.pass);
        final EditText pass = (EditText) findViewById(R.id.reg);
        final TelephonyManager tm = (TelephonyManager) getSystemService(Academics.TELEPHONY_SERVICE);
        
                
        register.setOnClickListener(new OnClickListener() {
        	
			public void onClick(View v) {
				// TOO Auto-generated method stud 
				if(v.getId()==R.id.register)
				{		
					
String u = "http://ratan.co.cc/test.php?reg="+reg.getText().toString()+"&pass="+pass.getText().toString()+"&iemi="+tm.getDeviceId().toString();
			        
			            try{
			            	URL url= null;
			            	url= new URL(u);
			            	URLConnection conn = url.openConnection();
			            	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			            	String line="";
			            	line=reader.readLine();
			            	Log.d("tag", line);
			     
			            		int ch=line.charAt(0);
			            		
			            		
			            		         //whatever you want
					            if(ch=='1')
					            {
					            	
					            	SQLiteDatabase db = openOrCreateDatabase("login", MODE_PRIVATE, null);
						            db.execSQL("CREATE TABLE IF NOT EXISTS User (Reg INT(8), Pass VARCHAR, Status INT(1));");
						            
						            String s="INSERT INTO User VALUES ( '" + reg.getText().toString() + "' , '" + pass.getText().toString() +" ' , '1' )";
						 
						            db.execSQL(s);
						           
						            Toast.makeText(main.this, " Registration Successful ", 5000).show();
						            db.close();
						            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
						            Notification notify = new Notification(android.R.drawable.stat_notify_more, "Congratulation", SystemClock.currentThreadTimeMillis());
						            Context context = main.this;
						            
						            CharSequence title = "Thanks for Installing SmartCamp";
						            CharSequence details ="Developers Rashmi & Ratan CSE Sem-VI ";
						            Intent intent = new Intent(context, main.class);
						            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
						            notify.setLatestEventInfo(context, title, details, pending);
						            notify.sound = Uri.parse("android.resource://cc.co.ratan.www/" + R.raw.beep);
						            
						            nm.notify(0, notify);
						            
					                startActivity(new Intent(main.this, Menu.class));
					                finish();
					                	
					            }
					            else
					            Toast.makeText(main.this, " Registration Failed ", 5000).show();
						           
			            	
			            }catch (Exception e1) {
							// TODO: handle exception
						}
			            
			            
			            }

					
					
					
					
					
				}
				
			
		}
        
        
    );}
}

