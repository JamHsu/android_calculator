package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.presenter.CalculatorPresenter;
import com.example.calculator.presenter.CalculatorPresenterImpl;
import com.example.calculator.view.ICalculatorView;

public class MainActivity extends Activity implements ICalculatorView{
	
	CalculatorPresenter presenter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.presenter				= new CalculatorPresenterImpl(this);
        List<Button> nubmerBtns 	= findNubmerButtons();
        List<Button> operatorBtns 	= findOperatorButtons();
        
        //set listener
        setNumbersListener(nubmerBtns);
        setOperatorListener(operatorBtns);
        setEqualListener();
        setClearListener();
        setClearAllListener();
        setPointListener();
        setDeleteListener();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private List<Button> findNubmerButtons(){
    	List<Button> buttons = new ArrayList<Button>();
    	Button zero 	= (Button)findViewById(R.id.zero);
    	Button one 		= (Button)findViewById(R.id.one);
    	Button two 		= (Button)findViewById(R.id.two);
    	Button three 	= (Button)findViewById(R.id.three);
    	Button four 	= (Button)findViewById(R.id.four);
    	Button five	 	= (Button)findViewById(R.id.five);
    	Button six 		= (Button)findViewById(R.id.six);
    	Button seven 	= (Button)findViewById(R.id.seven);
    	Button eight 	= (Button)findViewById(R.id.eight);
    	Button nine 	= (Button)findViewById(R.id.nine);
    	buttons.add(zero);
    	buttons.add(one);
    	buttons.add(two);
    	buttons.add(three);
    	buttons.add(four);
    	buttons.add(five);
    	buttons.add(six);
    	buttons.add(seven);
    	buttons.add(eight);
    	buttons.add(nine);

    	return buttons;
    }
    
    private List<Button> findOperatorButtons(){
    	List<Button> buttons = new ArrayList<Button>();
    	Button add 		= (Button)findViewById(R.id.add);
    	Button sub 		= (Button)findViewById(R.id.sub);
    	Button mul 		= (Button)findViewById(R.id.mul);
    	Button div 		= (Button)findViewById(R.id.div);
    	Button mod 		= (Button)findViewById(R.id.mod);
    	buttons.add(add);
    	buttons.add(sub);
    	buttons.add(mul);
    	buttons.add(div);
    	buttons.add(mod);
    	
    	return buttons;
    }
    
    private void setEqualListener(){
    	Button btn = (Button)findViewById(R.id.equal);
    	btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				presenter.onClickEqual();
			}
    		
    	});
    }
    
    private void setNumbersListener(List<Button> numberBtns){
    	for(Button btn : numberBtns){
    		btn.setOnClickListener(new OnClickListener(){

    			@Override
    			public void onClick(View e) {
    				Button numberBtn = (Button)e;
    				presenter.onClickNumber(numberBtn.getText().toString());
    			}
    	    	
    	    });
    	}
    }
    
    private void setOperatorListener(List<Button> operatorBtns){
    	for(Button btn : operatorBtns){
    		btn.setOnClickListener(new OnClickListener(){

    			@Override
    			public void onClick(View e) {
    				Button operatorBtn = (Button)e;
    				presenter.onClickOperator(operatorBtn.getText().toString());
    			}
    	    	
    	    });
    	}
    }
    
    private void setClearListener(){
    	Button btn = (Button)findViewById(R.id.C);
    	btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				presenter.onCLickClear();				
			}
    		
    	});
    }
    
    private void setClearAllListener(){
    	Button btn = (Button)findViewById(R.id.CE);
    	btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				presenter.onClickClearAll();				
			}
    		
    	});
    }
    
    private void setPointListener(){
    	Button btn = (Button)findViewById(R.id.point);
    	btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				presenter.onClickPoint(".");				
			}
    		
    	});
    }
    
    private void setDeleteListener(){
    	Button btn = (Button)findViewById(R.id.del);
    	btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				presenter.onClickDel();			
			}
    		
    	});
    }

	@Override
	public void showResult(String number) {
		EditText text = (EditText)findViewById(R.id.resultText);
		text.setText(number);
	}
    
}
