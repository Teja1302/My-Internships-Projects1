package Tasks;

import java.util.Scanner;

public class Calculator {
public static void main(String[] args) {
	Scanner scn =new Scanner(System.in);
	int num1,num2,result;
	char operator;
	System.out.println("Enter first Number:");
	num1=scn.nextInt();
	System.out.println("Enter operator(+,-,*,/):");
	 operator = scn.next().charAt(0);

     System.out.print("Enter second number: ");
     num2 = scn.nextInt();

     switch (operator) {
         case '+':
             result = num1 + num2;
             break;
         case '-':
             result = num1 - num2;
             break;
         case '*':
             result = num1 * num2;
             break;
         case '/':
             if (num2 != 0) {
                 result = num1 / num2;
             } else {
                 System.out.println("Error! Division by zero is not allowed.");
                 return;
             }
             break;
         default:
             System.out.println("Invalid operator!");
             return;
     }

     System.out.println("Result: " + result);	
}
}
