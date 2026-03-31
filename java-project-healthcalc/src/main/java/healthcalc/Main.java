package healthcalc;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HealthCalc calc = new HealthCalcImpl();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter weight (kg): ");
            double p = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            double a = sc.nextDouble();
            double imc = calc.bmi(p, a/100.0);
            System.out.println("Your BMI is: " + imc + " (" + calc.bmiClassification(imc) + ")");
            System.out.print("Enter your gender (H = male, M = female): ");
            char gender = sc.next().toUpperCase().charAt(0);

            System.out.print("Enter your waist circumference (cm): ");
            double waist = sc.nextDouble();
            double ibw = calc.idealBodyWeight(a, gender);
            System.out.println("Your IBW is: " + ibw);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}


