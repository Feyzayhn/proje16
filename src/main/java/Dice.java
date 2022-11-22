import java.util.Scanner;

public class Dice {
    static int diceA;
    static int diceB;

    public static void main(String[] args) {

        diceA = (int) (Math.random() * 6) + 1;
        diceB = (int) (Math.random() * 6) + 1;

        System.out.println("diceA = " + diceA);
        System.out.println("diceB = " + diceB);

        if (diceA == diceB) {
            System.out.println(diceA * 100);
        } else if ((diceA == 1 && diceB == 2) || (diceA == 2 && diceB == 1)) {
            System.out.println(1000);
        } else if (diceA > diceB) {
            System.out.println(diceA + "" + diceB);
        } else
            System.out.println(diceB + "" + diceA);

        if (diceA == 1) System.err.println(".");
        if (diceA == 2) System.err.println(". .");
        if (diceA == 3) System.err.println(". \n .\n  .");
        if (diceA == 4) System.err.println(". .\n. .");
        if (diceA == 5) System.err.println(". .\n .\n. .");
        if (diceA == 6) System.err.println("...\n...");

        if (diceB == 1) System.out.println(".");
        if (diceB == 2) System.out.println(". .");
        if (diceB == 3) System.out.println(". \n .\n  .");
        if (diceB == 4) System.out.println(". .\n. .");
        if (diceB == 5) System.out.println(". .\n .\n. .");
        if (diceB == 6) System.out.println("... \n...");

        int gcd = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("1. tamsayiyi girin : ");
        int s1 = scan.nextInt();
        System.out.print("2. tamsayiyi girin : ");
        int s2 = scan.nextInt();
        for (int i = 1; i <= s1; i++) {
            if (s1 % i == 0 && s2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(s1 + " ve " + s2 + " icin GCD = " + gcd);
    }
}
