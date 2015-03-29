/**
File name: MainAcitivty.java
Author: Muath Alqurashi
Email Address: mhalqurashi@suffolk.edu
Last day of modification: Mar 10, 2015
Description: This app calculates the maximum and target heart rates using age.
*/
package com.muath.target_heart_ratecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private SeekBar ageSeekBar;
	private TextView ageDisplayTextView;
	private TextView maxHeartRateDisplayTextView;
	private TextView targerHeartRateDisplayTextView;
	private int age = 40;
	private int maxRate = 180;
	private double minTargetRate = 90.0;//50% of max hear rate.
	private double maxTargetRate = 153.0;//85% of max heart rate.
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ageSeekBar = (SeekBar) findViewById(R.id.ageSeekBar);
		ageDisplayTextView = 
				(TextView) findViewById(R.id.ageDisplayTextView);
		maxHeartRateDisplayTextView = 
				(TextView) findViewById(R.id.maxHeartRateDisplayTextView);
		targerHeartRateDisplayTextView = 
				(TextView) findViewById(R.id.targerHeartRateDisplayTextView);
		updateOutput();
		ageSeekBar.setOnSeekBarChangeListener(ageSeekBarListener);
	}
	
	private void updateOutput () {
		ageDisplayTextView.setText(String.valueOf(age));
		String maxRateString, targetRateString;
		maxRateString = String.format("%d bpm", maxRate);
		targetRateString = String.format("%.0f-%.0f bpm", 
				Math.floor(minTargetRate), Math.floor(maxTargetRate));
		maxHeartRateDisplayTextView.setText(maxRateString);
		targerHeartRateDisplayTextView.setText(targetRateString);
	}
	
	private OnSeekBarChangeListener ageSeekBarListener =
			new OnSeekBarChangeListener() {
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			age = progress;
			maxRate = 220 - age;
			minTargetRate = maxRate * 0.50;
			maxTargetRate = maxRate * 0.85;
			updateOutput();
		}
		
		@Override
		public void onStartTrackingTouch (SeekBar seekbar) {}
		@Override
		public void onStopTrackingTouch (SeekBar seekbar) {}
	};

}
