package cc.co.ratan.www;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		//these are the button created on the menu activity
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setOnClickListener(this);
		
		Button b3 = (Button) findViewById(R.id.button3);
		b3.setOnClickListener(this);
		
		Button b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(this);
		
		Button b5 = (Button) findViewById(R.id.button5);
		b5.setOnClickListener(this);
		
		Button b6 = (Button) findViewById(R.id.button6);
		b6.setOnClickListener(this);
		
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		//these all call the different activity depending on the button clicked
		if(v.getId()==R.id.button1)
			startActivity(new Intent(Menu.this, Academics.class));
		else if(v.getId()==R.id.button2)
			startActivity(new Intent(Menu.this, Helpme.class));
		else if(v.getId()==R.id.button3)
			startActivity(new Intent(Menu.this, Cocurricular.class));
		else if(v.getId()==R.id.button4)
			startActivity(new Intent(Menu.this, Library.class));
		else if(v.getId()==R.id.button5)
			startActivity(new Intent(Menu.this, Faculty.class));
		else if(v.getId()==R.id.button6)
			startActivity(new Intent(Menu.this, Collegemap.class));
			
	}

}
