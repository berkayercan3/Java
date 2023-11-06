/*"Java'da, LowArray adlı bir sınıfı kullanarak aşağıdaki işlemleri yapan bir programı yazınız:
        Bir dizi oluşturun ve 100 elemanlı olsun.
        Bu dizinin içine 10 tane sayı ekleyin: 77, 99, 44, 55, 22, 88, 11, 1, 66, 33.
        Diziyi listeleyin ve sonucu ekrana yazdırın.
        88 sayısını arayın ve dizinin içinde varsa bulunduğunu, yoksa bulunamadığını yazdırın.
        Diziden 55 sayısını silin ve sonucu ekrana yazdırın.
*/

public class LowArrayApp {
    public static void main(String[] args) {
        LowArray dizi= new LowArray(100);
        int j;
        int searchNumber=20;

        dizi.setDizi(0,12);
        dizi.setDizi(1,13);
        dizi.setDizi(2,14);
        dizi.setDizi(3,17);
        dizi.setDizi(4,15);
        dizi.setDizi(5,16);
        dizi.setDizi(6,19);
        dizi.setDizi(7,18);
        dizi.setDizi(8,11);
        dizi.setDizi(9,10);

        //listeleme
        for (j = 0; j < 10; j++)
            System.out.println(dizi.getDizi(j));

        //arama
        do{
            j = -1;
            j++;
        }while((dizi.getDizi(j) == searchNumber) || j==10);

        if (j==11)
            System.out.println("bulunamadı");
        else System.out.println("bulundu");
    }
}