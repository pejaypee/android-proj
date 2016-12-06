package com.example.userform;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {
	
	EditText txtidno,txtname;
	RadioGroup rdgsex;
	Spinner course;
	Button btnok,btncancel;
	private String selected_course;
	private int selected_sex;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.txtidno=(EditText) this.findViewById(R.id.editText1);
		this.txtname=(EditText) this.findViewById(R.id.editText2);
		this.rdgsex=(RadioGroup) this.findViewById(R.id.radioGroup1);
		this.course=(Spinner) this.findViewById(R.id.spinner1);
		this.btnok=(Button) this.findViewById(R.id.button1);
		this.btncancel=(Button) this.findViewById(R.id.button2);
		//listener
		this.btnok.setOnClickListener(this);
		this.btncancel.setOnClickListener(this);
		this.course.setOnItemSelectedListener(this);
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
		int id=v.getId();
		switch(id){
		
		case R.id.button1:
			String idno=this.txtidno.getText().toString();
			String name=this.txtname.getText().toString();
			//manage radio button for gender
			selected_sex=this.rdgsex.getCheckedRadioButtonId();
			RadioButton selected=(RadioButton) this.findViewById(selected_sex);
			//get string for gender
			String gender=selected.getText().toString();
			String message="IDNO: "+idno+"\nNAME: "+name+"\nGENDER: "+gender+"\nCOURSE: "+selected_course;
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
			
		/*	AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("STUDEN INFORMATION");
			builder.setMessage(message);	
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog=builder.create();
			dialog.show(); */
			break;
		
		case R.id.button2:
			this.txtidno.setText("");
			this.txtname.setText("");
			this.rdgsex.setSelected(false);
			this.course.setSelection(0);
			this.txtidno.requestFocus();
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		selected_course=this.course.getItemAtPosition(position).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
}
