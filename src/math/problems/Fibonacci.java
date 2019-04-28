package math.problems;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */
         int  a=1;
         int b=1;
        Scanner scanner=new Scanner(System.in);
        int  k=0;
        System.out.println("enter any number");
        int n = scanner.nextInt();
        System.out.println("1 1");
         while(k<=n)
        {

          k=a+b;
            if (k>=n)
                break;
            System.out.println(k+ " ");
            a=b;
            b=k;
        }

    }}