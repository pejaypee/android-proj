package com.example.userlogin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText txtuser,txtpass;
	Button btnlogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.txtpass=(EditText) this.findViewById(R.id.editText2);
		this.txtuser=(EditText) this.findViewById(R.id.editText1);
		this.btnlogin=(Button) this.findViewById(R.id.button1);
		
		this.btnlogin.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String user=this.txtuser.getText().toString();
		String pass =this.txtpass.getText().toString();
		
		if((user.equals("admin"))&&pass.equals("helloworld")){
			
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Message");
			builder.setMessage("LOGGED IN SUCCESSFULLY");
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog=builder.create();
			dialog.show();
		//	Toast.makeText(this, "LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
			this.txtuser.setText("");
			this.txtpass.setText("");
		}
		else{
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("Message");
			builder.setMessage("LOGIN FAILED");
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog=builder.create();
			dialog.show();
			
			this.txtuser.setText("");
			this.txtpass.setText("");
			this.txtuser.requestFocus();
		}
		
	}
}
