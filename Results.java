package CalculatorPackage;

public class Results implements IResults {
	
	private double a, b;
	private double result;
	private boolean isCorrect;
	
	public Results(double a, double b, double result, boolean isCorrect) {
		this.a = a;
		this.b = b;
		this.result = result;
		this.isCorrect = isCorrect;
	}
	
	public double getNum1() {
		return this.a;
	}
	
	public double getNum2() {
		return this.b;
	}
	
	public double getResult() {
		return this.result;
	}
	
	public boolean getIsCorrect() {
		return this.isCorrect;
	}

}
