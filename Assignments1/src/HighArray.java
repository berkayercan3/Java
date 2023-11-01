import java.util.Random;
import java.util.Scanner;

public class HighArray {
    int dizisize;
    private long[] dizi;

    public HighArray(int index) {
        dizi=new long[index];
    }

    public void fillRandom(int index){
        dizisize = index;
        Random randomNumber = new Random();
        for (int i = 0; i < dizi.length; i++) {
            int randomNum;
            boolean unique;
            do {
                randomNum = randomNumber.nextInt(100);
                unique = true;
                for (int j = 0; j < i; j++) {
                    if (dizi[j] == randomNum) {
                        unique= false;
                        break;
                    }
                }
            } while (!unique);
            dizi[i] = randomNum;
        }
    }

    public static boolean asalCheck(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void primeNumbersInfo(){
        int value;
        int counter=0;
        System.out.print("Prime Numbers in Array;\n");
        for (int i = 0; i < dizi.length ; i++) {
            value= (int) dizi[i];
            if (asalCheck(value)) {
                System.out.print(value + " ");
                counter++;
            }
        }
        System.out.println();
        System.out.println("Prime Number Count: "+counter +"\n");
    }

    public void removeNonPrimeNumbers(){
        int value;
        System.out.println("Number to be deleted:");
        for (int i = 0; i < dizisize; i++) {
            value = (int) dizi[i];
            if (!asalCheck(value)) {
                System.out.print("{" +value+ "} ");
                for (int j = i; j < dizisize - 1; j++) {
                    dizi[j] = dizi[j + 1];
                }
                dizisize--;
                i--; // Bir eleman çıkarıldığında, aynı konumu tekrar kontrol et
            }
        }
        System.out.println("\nNon-Prime Numbers Removed!\n");
    }

    public void sort(){
        int temp;
        for (int i = 0; i < dizisize; i++) {
            for (int j = dizisize-1; j >i; j--) {
                if (dizi[j-1]> dizi[j]){
                    temp =(int) dizi[j-1];
                    dizi[j-1]=dizi[j];
                    dizi[j]=temp;
                }
            }
        }
        System.out.println("Array Sorted");
    }

    public void display(){
        System.out.println("\nArray Elements is;");
        for (int d = 0; d < dizisize; d++) {
            System.out.print(dizi[d]+" ");
        }
        System.out.println("\n");
    }
}


