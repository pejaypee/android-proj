package com.example.colorbar;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
	
	SeekBar skbred,skbgreen,skbblue;
	int redcolor,bluecolor,greencolor;	
	TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.skbred=(SeekBar) this.findViewById(R.id.seekBar1);
        this.skbgreen=(SeekBar) this.findViewById(R.id.seekBar2);
        this.skbblue=(SeekBar) this.findViewById(R.id.seekBar3);
        this.result=(TextView) this.findViewById(R.id.textView4);
        
        this.skbred.setOnSeekBarChangeListener(this);
        this.skbgreen.setOnSeekBarChangeListener(this);
        this.skbblue.setOnSeekBarChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		int id=arg0.getId();
		switch(id){
		case R.id.seekBar1:this.redcolor=this.skbred.getProgress();break;
		case R.id.seekBar2:this.greencolor=this.skbgreen.getProgress();break;
		case R.id.seekBar3:this.bluecolor=this.skbblue.getProgress();break;
		}
		String colortext=String.format("#%02X-%02X-%02X", redcolor,greencolor,bluecolor);
		this.result.setText(colortext);
		this.result.setTextColor(Color.rgb(255- redcolor,255- greencolor,255- bluecolor));
		this.result.setBackgroundColor(Color.rgb(redcolor, greencolor, bluecolor));
	}


	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
