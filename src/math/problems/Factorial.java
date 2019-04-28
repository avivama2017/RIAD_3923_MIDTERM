package math.problems;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        int fact = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number");
        int m=scanner.nextInt();
        for(int i=1;i<=m;i++)
        {
        fact=fact*i;
        }
        System.out.println("factorial of "+m+"="+fact);

    }
}
