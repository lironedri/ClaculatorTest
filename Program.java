package CalculatorPackage;

import java.util.ArrayList;

public class Program {
	
	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Calculator> calculatorsLst = new ArrayList<Calculator>(); 
		
		Calculator calculator1 = new Calculator("Crystal 1");
        Calculator calculator2 = new Calculator("Crystal 2");
        calculatorsLst.add(calculator1);
        calculatorsLst.add(calculator2);
		
		int numOfTests = 10;
		int bitSign = 1; // add sign is 1, 2 sign is subtract
		
		MultiCalculatorTest test = new MultiCalculatorTest();
		test.runTest(calculatorsLst, numOfTests, bitSign);
	 }
	
}
