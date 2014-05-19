package com.example.calculator.presenter;

import com.example.calculator.factory.OperatorFactory;
import com.example.calculator.operator.Operator;
import com.example.calculator.view.ICalculatorView;

public class CalculatorPresenterImpl implements CalculatorPresenter {
	
	StringBuffer currentEnterStr = null;
	Double preNumber;
	Operator operator;
	ICalculatorView display;
	
	public CalculatorPresenterImpl(ICalculatorView view){
		this.display = view;
	}

	@Override
	public void onClickOperator(String operator) {
		this.operator = OperatorFactory.getOperator(operator);
		preNumber = Double.valueOf(currentEnterStr.toString());
		currentEnterStr =null;
	}

	@Override
	public void onClickNumber(String number) {
		if(currentEnterStr == null){
			currentEnterStr = new StringBuffer();
		}
		currentEnterStr.append(number);
		display.showResult(currentEnterStr.toString());
	}

	@Override
	public void onClickEqual() {
		Double currentNumber = Double.valueOf(currentEnterStr.toString());
		Double result = operator.compute(preNumber, currentNumber);
		currentEnterStr = new StringBuffer(result.toString());
		display.showResult(result.toString());
	}

	@Override
	public void onClickDel() {
		int length = currentEnterStr.length();
		currentEnterStr.delete(length-1, length);
		display.showResult(currentEnterStr.toString());
	}

	@Override
	public void onClickPoint(String point) {
		if(!currentEnterStr.toString().contains(".")){
			currentEnterStr.append(point);
		}
		display.showResult(currentEnterStr.toString());
	}

	@Override
	public void onCLickClear() {
		int length = currentEnterStr.length();
		currentEnterStr.delete(0, length);
		display.showResult(currentEnterStr.toString());
	}

	@Override
	public void onClickClearAll() {
		int length = currentEnterStr.length();
		currentEnterStr.delete(0, length);
		preNumber = 0.0;
		operator = null;
		display.showResult(currentEnterStr.toString());
	}

}
