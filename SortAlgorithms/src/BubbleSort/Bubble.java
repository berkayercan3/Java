package BubbleSort;

public class Bubble { //
    public static void bubbleSort(int[] arr ){
        int n = arr.length;

        for (int i = 0; i < n-1 ; i++) { //n-1 yazılmasının nedeni eleman sayısı 5 ise 4 kere döngü çalıştığında işlem
                                            //hallolur 0,1,2,3  4 adım etti 3 e kadar döner o da i< n-1 ==== n-1= 4 eder
                                                    //i<4 den 3 e kadar yani 0,1,2,3 dedin mi 4 adım eder.

            for (int j = 0; j <n-i-1 ; j++) { // n-i-1 in anlamı ise işten tasaruf sağlar yani n=5 olsun,mesela i = 2
                                                //iken i zaten 0 ve 1. adımı halletmiştir bu halletme sırasında en son
                                                    // 2 sayı yerini bulmuş tur geriye 3 sayı kalıyor sıralanması gerekn
                                                        //yani demeki 2 kere dönse yeter bize n-i-1 den 5-2-1= 2 sağlamış
                                                            //olduk..
                if(arr[j] >arr[j+1])
                {
                    int temp= arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(" BubbleSort ile Siralanmis Dizi:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
