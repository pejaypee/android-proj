package com.example.listview;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements OnItemClickListener  {

	ListView lv;
	myadapter adapter;
	//ArrayAdapter<String> adapter;
	ArrayList<Person>list=new ArrayList<Person>();
	ArrayList<Person>source=new ArrayList<Person>();
	AlertDialog.Builder builder;
    EditText txtsearch;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtsearch=(EditText) this.findViewById(R.id.editText1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new myadapter(this,list);
        this.lv.setAdapter(adapter); 
        
        this.lv.setOnItemClickListener(this);
        
       //* this.source.add(/*R.drawable.add,*/"Add");
     //   this.source.add(/*R.drawable.call,*/"Call");
       // this.source.add(/*R.drawable.camera,*/"Camera");
        //this.source.add(/*R.drawable.close,*/"Close");*/
        
        this.source.add(new Person(R.drawable.add,"Add","BSIT"));
        this.source.add(new Person(R.drawable.call,"Call","BSIT"));
        this.source.add(new Person(R.drawable.camera,"Camera","BSIT"));
        this.source.add(new Person(R.drawable.close,"Close","BSIT"));
        this.source.add(new Person(R.drawable.compass,"Compass","BSIT"));
        this.source.add(new Person(R.drawable.delete,"Delete","BSIT"));
        this.source.add(new Person(R.drawable.direction,"Direction","BSIT"));
        this.source.add(new Person(R.drawable.edit,"Edit","BSIT"));
        this.source.add(new Person(R.drawable.gallery,"Gallery","BSIT"));
        this.source.add(new Person(R.drawable.rotate,"Rotate","BSIT"));
        this.source.add(new Person(R.drawable.save,"Save","BSIT"));
        this.source.add(new Person(R.drawable.search,"Search","BSIT"));
        this.source.add(new Person(R.drawable.send,"Send","BSIT"));
        this.source.add(new Person(R.drawable.upload,"Upload","BSIT")); 
        this.source.add(new Person(R.drawable.share,"Share","BSIT"));
       
     
        this.txtsearch.addTextChangedListener(new TextWatcher(){
       
	@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				list.clear();
				Pattern p=Pattern.compile(arg0.toString());
					for(int i=0;i<source.size();i++){
						Matcher m=p.matcher(source.get(i));
						if(m.find()){
							list.add(source.get(i));
						}
						adapter.notifyDataSetChanged();
					}
			}});
        
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		ImageView iv=new ImageView(this);
		
		builder=new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		iv.setImageResource(list.get(arg2).getImg());
		builder.setView(iv);
		builder.setMessage("COURSE: "+list.get(arg2).getCourse());
		builder.setNeutralButton("OK", null);
		
		AlertDialog dialog=builder.create();
		dialog.show();
	}
}
