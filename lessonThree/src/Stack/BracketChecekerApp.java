package Stack;

import java.util.Scanner;

public class BracketChecekerApp {
    public static void main(String[] args){
        String input;
        while (true){
            System.out.println("Parantez içeren metin giriniz");
            input = getString();
            if(input.equals(""))
            break;
            BracketCheceker theChecker = new BracketCheceker(input);
            theChecker.check();
        }
    }
    public static String getString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        return s;
    }
}
