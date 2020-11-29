package CalculatorPackage;

import java.util.Vector;

public interface ICalculatorTest {
	
	public double isSuccessAdd(double a, double b);	
	public double isSuccessSubtract(double a, double b);	
	public void run(int signBit);	
	public double getSuccessRate();	
	public Calculator getCalculator();	
	public Vector<IResults> getResults();

}
