//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        this.scanner = new Scanner(System.in);
        return this.scanner.nextLine();
    }

    public double getDouble() {
        this.scanner = new Scanner(System.in);
        return this.scanner.nextDouble();
    }

    public double getChar() {
        this.scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        return c;
    }

    public int getInt() {
        try {
            return this.scanner.nextInt();
        } catch (InputMismatchException var2) {
            System.out.println("Not a number - treating as zero");
            this.scanner.nextLine();
            return 0;
        }
    }
}
