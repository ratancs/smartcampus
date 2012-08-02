package cc.co.ratan.www;

import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class Academics extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		try{

        	SQLiteDatabase   dbe = SQLiteDatabase.openDatabase("/data/data/cc.co.ratan.www/databases/academics", null,0);
            Log.d("opendb","EXIST");
            dbe.close();
            
		}
		catch(Exception e){
			Log.d(" Database", "not found");
			
			
			
		}
		setContentView(R.layout.academics);
		
		
	}

}
