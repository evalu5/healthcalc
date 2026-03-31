package healthcalc;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HealthCalc calc = new HealthCalcImpl();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter weight (kg): ");
            double p = sc.nextDouble();
            System.out.print("Enter height (m): ");
            double a = sc.nextDouble();
            double imc = calc.bmi(p, a);
            System.out.println("Your BMI is: " + imc + " (" + calc.bmiClassification(imc) + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.print("Enter your gender (H = male, M = female): ");
        char gender = sc.next().toUpperCase().charAt(0);

        System.out.print("Enter your waist circumference (cm): ");
        double waist = sc.nextDouble();
    }
}


