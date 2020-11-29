package CalculatorPackage;

import java.util.ArrayList;
import java.util.Vector;

public class MultiCalculatorTest extends Thread {

	private ArrayList<ICalculatorTest> testsLst;
	private ArrayList<Thread> trdLst;

	public MultiCalculatorTest() {
		this.testsLst = new ArrayList<ICalculatorTest>();
		this.trdLst = new ArrayList<Thread>();
	}

	public void runTest(ArrayList<Calculator> calculatorsArr, int numOfTests, int signBit) throws InterruptedException {
		if (!signValidation(signBit)) {
			return;
		}

		for (Calculator c : calculatorsArr) {
			ICalculatorTest quantumCalculatorTest = new QuantumCalculatorTest(c, numOfTests);
			this.testsLst.add(quantumCalculatorTest);

			Thread t = new Thread() {
				public void run() {
					quantumCalculatorTest.run(signBit);
				}
			};
			t.start();
			this.trdLst.add(t);
		}

		for (Thread t : this.trdLst) {
			t.join();
		}

		printData(signBit);

		extractBestCalculator(numOfTests);
	}

	public boolean signValidation(int signBit) {
		if (signBit != 1 && signBit != 2) {
			System.out.println("There is no such sign");
			return false;
		}
		return true;
	}

	public void printData(int signBit) {
		for (ICalculatorTest calTst : this.testsLst) {
			Printer.printName(calTst.getCalculator().getName());
			for (IResults result : calTst.getResults()) {
				Printer.printFormat(result.getNum1(), result.getNum2(), result.getResult(), result.getIsCorrect(),
						signBit);
			}
			System.out.print("\n");
		}
	}

	public void extractBestCalculator(int numOfTests) {
		Vector<String> bestCalNames = new Vector<String>();
		double bestCalculatorSucRate = 0;
		for (ICalculatorTest calTst : this.testsLst) {
			double num = numOfTests;
			double sucRate = calTst.getSuccessRate() / num;
			Printer.printSuccessRate(calTst.getCalculator().getName(), sucRate);
			if (sucRate > bestCalculatorSucRate) {
				bestCalculatorSucRate = sucRate;
				bestCalNames.removeAllElements();
				bestCalNames.add(calTst.getCalculator().getName());
			} else if (sucRate == bestCalculatorSucRate) {
				bestCalNames.add(calTst.getCalculator().getName());
			}
		}
		Printer.printTheBest(bestCalNames);
	}

	public static class Printer {

		public static void printName(String name) {
			System.out.printf("Calculator %s:\n", name);
		}

		public static void printFormat(double a, double b, double calculatorResult, boolean isCorrect, int signBit) {
			String format = "%-80s%s%n";
			String prefix = "";
			switch (signBit) {
			case 1:
				prefix = a + " + " + b + " = " + calculatorResult;
				break;
			case 2:
				prefix = a + " - " + b + " = " + calculatorResult;
				break;
			default:
				return;
			}

			if (isCorrect) {
				String str = "(correct)";
				System.out.printf(format, prefix, str);
			} else {
				String str = "(error)";
				System.out.printf(format, prefix, str);
			}
		}

		public static void printSuccessRate(String name, double successRate) {
			System.out.printf("%s Success rate: %.1f\n", name, successRate);
		}

		public static void printTheBest(Vector<String> bestCalName) {
			int size = bestCalName.size();
			if (1 == size) {
				System.out.println(bestCalName.get(0) + " is better");
			} else {
				System.out.println(bestCalName + " are the same");
			}

		}

	}
}
