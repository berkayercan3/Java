package SelectionSort;

public class Selection {

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            int min = i; // bundan daha küçük bir değer var mı bulmamız lazım

            for (int j = i + 1; j < arr.length; j++) { //bu küçükten büyüğe bir sıralam olduğu için j değerini her
                                                        //seferinde o anki i değerinin bir fazlası ile başlattık
                                                        //çünkü i mesela 3 ken zaten 3 ten önceki elemanlar dizilmiş
                                                        //oldu yerlerine
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp; // değişme olduğu zaman arr[i] nin yerine arr[j] geçer arr[j] nin yerinede arr[i] geçmiş olur
        }

        System.out.println("Sıralanmış Dizi:");
        for (int value : arr)
            System.out.print(value + " ");
    }
}
