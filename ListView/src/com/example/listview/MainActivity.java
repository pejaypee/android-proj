package com.example.listview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener, android.content.DialogInterface.OnClickListener {

	ListView lv;
	Button btnadd;
	AlertDialog.Builder builder;
	ArrayList<String>list=new ArrayList<String>();
	ArrayAdapter adapter;
	private EditText txtadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder=new AlertDialog.Builder(this);
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv.setAdapter(adapter);
        
        this.btnadd=(Button) this.findViewById(R.id.button1);
    
        this.btnadd.setOnClickListener(this);
        
        this.lv.setOnItemClickListener(this);
        
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		txtadd=new EditText(this);
		txtadd.setHint("Enter Name");
		
		builder.setTitle("Add Item");
		builder.setView(txtadd);
		builder.setPositiveButton("OK", this);
		builder.setNegativeButton("CANCEL", this);
		
		AlertDialog dialog=builder.create();
		dialog.show();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		AlertDialog.Builder b=new AlertDialog.Builder(this);
	
		String s=this.lv.getItemAtPosition(arg2).toString();
		b.setTitle("SELECTED ITEM");
		b.setMessage(s);
		b.setNeutralButton("OK", null);
		
		AlertDialog dialog=b.create();
		dialog.show();
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
			String item=this.txtadd.getText().toString();
			
			if(!item.equals("")){
				list.add(item);
				this.adapter.notifyDataSetChanged();
				arg0.dismiss();
			}
			else Toast.makeText(this, "Type name", Toast.LENGTH_SHORT).show();
			
			
			break;
		case DialogInterface.BUTTON_NEGATIVE: 
			arg0.dismiss();
		
		}	
		
	}


    
}
