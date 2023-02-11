import java.util.*;
import java.util.Scanner;

public class taxcalculator {
	private static Scanner keyboard = new Scanner(System.in);
	

	public static void main(String[] args) {
	
		double incomes[] = new double[20];
		double deductions[] = new double[20];

	
		int i = 0;
		int j = 0;

		System.out.println(
				"If your itemized deductions' total is less than the standard deviation amount ($12,950), then the standard deduction will be used.");
		System.out.println("Please enter incomes and deductions... ");
		
		while (true) {
		
			System.out.print("Enter the amount: ");
			double input = keyboard.nextFloat();
			if (input == 0.0) {
				break;
			}

			
			else if (input > 0) {
				incomes[i] = input;
				i++;
			}

			
			else {
				deductions[j] = input;
				j++;
			}
		}

		// Compute total income
		double totalIncome = computeTotalIncome(incomes);
		// Compute total deduction
		double totalDeduction = computeTotalDeduction(deductions);

		// Compute taxable income
		double taxableIncome = computeTaxableIncome(totalIncome, totalDeduction);

		// Compute tax amount
		double taxAmount = computeTaxAmountandBracket(taxableIncome, 0);
		// Display tax information
		display(totalIncome, totalDeduction, taxableIncome, 0, taxAmount);
	}

	// Compute total income
	static double computeTotalIncome(double incomes[]) {
		int sum = 0;
		for (int i = 0; i < incomes.length; i++) {
			sum += incomes[i];
		}
		return sum;
	}

	// Compute total deduction
	static double computeTotalDeduction(double deductions[]) {
		int sum = 0;
		for (int i = 0; i < deductions.length; i++) {
			sum += deductions[i];
		}
		return -sum;
	}

	// Compute Taxable income
	static double computeTaxableIncome(double income, double deduction) {
		if (income >= deduction) {
			return income - deduction;
		} else {
			return 0.0;
		}
	}

	// Compute tax amount
	static double computeTaxAmountandBracket(double taxableincome, int i) {
		if (taxableincome <= 12950) {
			return taxableincome = 12950;
		}
		return taxableincome;
	}

	// Display tax information
	static void display(double totalIncome, double totalDeduction, double taxableIncome, int i, double taxAmount) {
		System.out.println("Reporting...");
		System.out.println("Incomes = $" + totalIncome);
		System.out.println("Deductions = $" + totalDeduction);
		System.out.println("Taxable Income = $" + taxableIncome);
		System.out.println("Tax Amount = $" + taxAmount);
	}
}