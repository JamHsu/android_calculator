package com.example.calculator.presenter;

public interface CalculatorPresenter {
	void onClickOperator(String operator);
	void onClickNumber(String number);
	void onClickEqual();
	void onClickDel();
	void onClickPoint(String ponint);
	void onCLickClear();
	void onClickClearAll();
}
