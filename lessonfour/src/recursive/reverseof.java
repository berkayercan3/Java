package recursive;
import java.util.Scanner;
public class reverseof {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Metin gir");
        String metin = input.nextLine();
        System.out.println(reverseOf(metin));
    }

    public static String reverseOf(String metin) {
        if ( metin.length()==0)
            return null;
        else{
            int n = metin.length();
            return metin.charAt(n -1) + reverseOf(metin.substring(0,n-1));
        }

    }
}
