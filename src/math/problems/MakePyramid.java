package math.problems;

import java.util.Scanner;

public class MakePyramid {
    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
        //System.out.println("Enter  number of rows");

        //int n =scanner.nextInt();

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}



/*   Implement a large Pyramid of stars in the screen with java.

 *
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *

 */
