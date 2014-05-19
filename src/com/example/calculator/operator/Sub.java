package com.example.calculator.operator;

public class Sub implements Operator {

	@Override
	public Double compute(Double a, Double b) {
		return a - b;
	}

}
