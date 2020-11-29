package CalculatorPackage;

import java.util.Vector;

public class QuantumCalculatorTest implements ICalculatorTest {

	private Calculator calculator;
	private int numOfTests;
	private double successRate;
	Vector<IResults> resultsVec;

	public QuantumCalculatorTest(Calculator c, int numOfTests) {
		this.calculator = c;
		this.numOfTests = numOfTests;
		this.successRate = 0;
		this.resultsVec = new Vector<IResults>(numOfTests);
	}

	public double isSuccessAdd(double a, double b) {
		double calcuatorResult = calculator.add(a, b);
		double correctResult = a + b;
		return calcuatorResult - correctResult;
	}

	public double isSuccessSubtract(double a, double b) {
		double calcuatorResult = calculator.subtract(a, b);
		double correctResult = a - b;
		return calcuatorResult - correctResult;
	}

	public void run(int signBit) {
		boolean check;

		for (int i = 0; i < numOfTests; i++) {
			double a = Math.random();
			double b = Math.random();
			double calcuatorResult;
			double gap = 0;

			switch (signBit) {
			case 1:
				calcuatorResult = this.calculator.add(a, b);
				gap = isSuccessAdd(a, b);
				break;
			case 2:
				calcuatorResult = this.calculator.subtract(a, b);
				gap = isSuccessAdd(a, b);
				break;
			default:
				return;
			}

			if (gap == 0) {
				check = true;
				this.successRate += 1;
			} else {

				check = false;
			}

			this.resultsVec.addElement(new Results(a, b, calcuatorResult, check));
		}
	}

	public double getSuccessRate() {
		return this.successRate;
	}

	public Calculator getCalculator() {
		return this.calculator;
	}

	public Vector<IResults> getResults() {
		return this.resultsVec;
	}

}
