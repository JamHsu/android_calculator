package com.example.calculator.factory;

import com.example.calculator.operator.Add;
import com.example.calculator.operator.Div;
import com.example.calculator.operator.Mod;
import com.example.calculator.operator.Mul;
import com.example.calculator.operator.Operator;
import com.example.calculator.operator.Sub;

public class OperatorFactory {
	
	public static Operator getOperator(String operator){
		
		Operator o = null;
		if(operator.equalsIgnoreCase("+")){
			o = new Add();
		} else if(operator.equalsIgnoreCase("-")){
			o = new Sub();
		} else if(operator.equalsIgnoreCase("X")){
			o = new Mul();
		} else if(operator.equalsIgnoreCase("/")){
			o = new Div();
		} else if(operator.equalsIgnoreCase("mod")){
			o = new Mod();
		} 

		return o;
	}
}
