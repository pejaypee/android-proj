package com.example.listview2;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity implements OnItemClickListener {

	ListView lv;
	myadapter adapter;
	ArrayList<Person>list=new ArrayList<Person>();
	AlertDialog.Builder builder;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.lv=(ListView) this.findViewById(R.id.listView1);
        
        list.add(new Person(R.drawable.img1,"Albert Suico","BSIT"));
        list.add(new Person(R.drawable.img2,"Ken Xu","BSBA"));
        list.add(new Person(R.drawable.img3,"Chen Xi","ACT"));
        list.add(new Person(R.drawable.img4,"Ric Fox","HRM"));
        list.add(new Person(R.drawable.img5,"Allan Smith","BSEE"));
        list.add(new Person(R.drawable.img6,"Borgy Firesale","BSC"));
        list.add(new Person(R.drawable.img7,"Chuck Norris ","BSED"));
        list.add(new Person(R.drawable.img8,"Anderson Silva","CRIM"));
        list.add(new Person(R.drawable.img9,"Renshin Akuma","BSA"));
        
        
        adapter=new myadapter(this,list);
        this.lv.setAdapter(adapter);
        this.adapter.notifyDataSetChanged();
        this.lv.setOnItemClickListener(this);
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

		 builder=new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		
		ImageView myiv=new ImageView(this);
			myiv.setImageResource(list.get(arg2).getImg());
		TextView myname=new TextView(this);
			myname.setText(list.get(arg2).getName());
		TextView mycourse=new TextView(this);
			mycourse.setText(list.get(arg2).getCourse());
		
		LinearLayout mainLayout=new LinearLayout(this);	
				mainLayout.setOrientation(LinearLayout.HORIZONTAL);
				mainLayout.addView(myiv);
				
		LinearLayout subLayout=new LinearLayout(this);
			subLayout.setOrientation(LinearLayout.VERTICAL);
			subLayout.addView(myname);
			subLayout.addView(mycourse);
			
			mainLayout.addView(subLayout);
			
			builder.setView(mainLayout);
			builder.setNeutralButton("OK", null);
			
	AlertDialog dialog=builder.create();
		dialog.show();
	}
}
