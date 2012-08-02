package cc.co.ratan.www;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Post extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        TextView aapid = (TextView) findViewById(R.id.aapid);
        TextView subject = (TextView) findViewById(R.id.subject);
        TextView desc = (TextView) findViewById(R.id.desc);
        TextView type = (TextView) findViewById(R.id.type);
        TextView from = (TextView) findViewById(R.id.from);
        TextView time = (TextView) findViewById(R.id.time);
        try{
        	
        aapid.setText(getIntent().getExtras().getString("aapid"));
        subject.setText(getIntent().getExtras().getString("subject"));
        desc.setText(getIntent().getExtras().getString("desc"));
        type.setText(getIntent().getExtras().getString("type"));
        from.setText(getIntent().getExtras().getString("from"));
        time.setText(getIntent().getExtras().getString("time"));
        }catch (Exception e) {
			// TODO: handle exception
        	Log.d("error", "was nt able to get data");
		}
}
    
    
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
    	

    	Intent in = new Intent(Post.this, Addpost.class);
    	String s;
    	s=getIntent().getExtras().getString("cat");
    	in.putExtra("cat", s);
   
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
