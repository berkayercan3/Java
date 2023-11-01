import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter array size:");
        int boyut = scan.nextInt();

        HighArray dizi = new HighArray(boyut);

        dizi.fillRandom(boyut);
        dizi.display();

        dizi.primeNumbersInfo();

        dizi.removeNonPrimeNumbers();
        dizi.display();

        dizi.sort();
        dizi.display();

    }
}