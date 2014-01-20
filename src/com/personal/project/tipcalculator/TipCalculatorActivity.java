package com.personal.project.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class TipCalculatorActivity extends Activity {
	public String totalAmt;
	public EditText etTipAmt;
	public double lastSelectedPercent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etTipAmt = (EditText) findViewById(R.id.etTipAmt);
        EditText etValue = (EditText) findViewById(R.id.etTotalAmt);
        etValue.addTextChangedListener(new TextWatcher() {
       
			@Override
        	public void afterTextChanged(Editable s) {
        		// Fires right after the text has changed
        		String totAmt = s.toString().trim();
        		//if(null != totAmt && !"".equals(totAmt)){
        			totalAmt = totAmt;
        		//}
        		
        		updateTipAmt();
        		
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
				
			}
        });
    }
    
    public void onClick10Percent(View v){
    	if(null != totalAmt && !"".equals(totalAmt.trim())){
    		etTipAmt.setText(calculateTip(10));
    		lastSelectedPercent = 10;
    		clearCustomTipText();
    		
    	}
    	
    }
    
    public void onClick15Percent(View v){
    	if(null != totalAmt && !"".equals(totalAmt.trim())){
    		
    		etTipAmt.setText(calculateTip(15));
    		lastSelectedPercent = 15;
    		clearCustomTipText();
    	}
    	
    }
    
    public void onClick20Percent(View v){
    	if(null != totalAmt && !"".equals(totalAmt.trim())){
    		
    		etTipAmt.setText(calculateTip(20));
    		lastSelectedPercent = 20;
    		clearCustomTipText();
    	}
    	
    }
    
    public void onClickCustomCalc(View v){
    	EditText etVal = (EditText) findViewById(R.id.etCustomTip);
    	String tipAmt = etVal.getEditableText().toString().trim();
    	if(null != tipAmt && !"".equals(tipAmt)){
    		double tips = Double.parseDouble(tipAmt);
    		
    		etTipAmt.setText(calculateTip(tips));
    		lastSelectedPercent = tips;
    	}
    }
    
    
    private void clearCustomTipText(){
    	EditText etVal = (EditText) findViewById(R.id.etCustomTip);
    	etVal.setText("");
    	
    }
    private void updateTipAmt() {
		// TODO Auto-generated method stub
    	if(null == totalAmt || "".equals(totalAmt.trim())){
    		etTipAmt.setText("");
    	} else {
			etTipAmt.setText(calculateTip(lastSelectedPercent));
    	}
	}
    
    private String calculateTip(double percent){
    	Double totAmt = new Double(totalAmt);
		totAmt = totAmt * percent/100;
		return totAmt.toString();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
}
