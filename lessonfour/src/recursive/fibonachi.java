package recursive;

import java.util.Scanner;

public class fibonachi {
    public static void main(String[] args){
        System.out.print("Bir sayı giriniz");
        Scanner input = new Scanner(System.in);
        int sayi = input.nextInt();
        long startTime = System.currentTimeMillis();
        long sonuc = fib(sayi);
        long endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;
        System.out.println(totalTime);

        System.out.println(sayi + ". fibonachi sayısı = " + sonuc);
        input.close();
    }

    public  static long fib(int n) {
        if(n==0 || (n==1))
            return n;
        else
            return fib(n-1) + fib(n-2);
    }


}
