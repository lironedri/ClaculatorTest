package CalculatorPackage;
public class Calculator{

	private String name;
	private double errorConstant;
	
	public Calculator(String name) {
		this.name = name;
		this.errorConstant = Math.random();
	}
	
	public double add(Double a, Double b) {
		double calculation = a + b;

		calculation = addQuantomError(calculation);
		
		return calculation;
	}

	
	public double subtract(Double a, Double b) {
		double calculation = a - b;

		calculation = addQuantomError(calculation);
		
		return calculation;
	}
	
	private double addQuantomError(double calculation) {
		if (Math.random() < this.errorConstant) {
			calculation = calculation + Math.random();
		}
		return calculation;
	}

	public String getName() {
		return name;
	}

}
