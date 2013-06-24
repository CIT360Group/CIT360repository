package com.example.mathapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
  private ImageButton fruitButton;
	private ImageButton caterpillarButton;
	private ImageButton countButton;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fruitButton = (ImageButton) findViewById(R.id.imageButton1);
		fruitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				startFruit(view);
			}
 
		});
		
		caterpillarButton = (ImageButton) findViewById(R.id.imageButton2);
		caterpillarButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
			}
 
		});
		
		countButton = (ImageButton) findViewById(R.id.imageButton3);
		countButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
			}
 
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void startFruit(View view){
		Intent intent = new Intent(this, FruitActivity.class);
		startActivity(intent);
	}

}
