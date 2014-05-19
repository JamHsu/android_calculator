package com.example.calculator.operator;

public class Mod implements Operator {

	@Override
	public Double compute(Double a, Double b) {
		return a % b;
	}

}
