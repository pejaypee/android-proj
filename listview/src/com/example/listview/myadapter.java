package com.example.listview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class myadapter extends BaseAdapter {

	Context context;
	ArrayList<Person>list;
	LayoutInflater inflater;
	
	public myadapter(Context context, ArrayList<Person> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		personhandler handler=null;
		
		if(arg1==null){
			arg1=inflater.inflate(R.layout.my_layout,null);
			handler=new personhandler();
			handler.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			handler.name=(TextView) arg1.findViewById(R.id.textView1);
			handler.course=(TextView) arg1.findViewById(R.id.textView2);
			arg1.setTag(handler);
		}
		else handler=(personhandler) arg1.getTag();
			handler.iv.setImageResource(list.get(arg0).getImg());
			handler.name.setText(list.get(arg0).getName());
			handler.course.setText(list.get(arg0).getCourse());
			
		return arg1;
	}
static class personhandler{
	ImageView iv;
	TextView name,course;
	
}
}
