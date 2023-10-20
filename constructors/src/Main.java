/* "Araba" adında bir sınıfı temsil eder.
Sınıf içinde hem parametreli bir kurucu metot (constructor)
hem de parametresiz bir kurucu metot bulunur.
Parametreli kurucu metot, sınıfın özelliklerine başlangıç değerleri verirken kullanılırken,
parametresiz kurucu metot varsayılan değerlerle bir nesne oluşturur
Bu sayede sınıf kullanıcıları istedikleri kadar parametreli veya
parametresiz kurucu metodu kullanarak nesne oluşturabilirler.*/

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW","E30",2023);
        Car car1 =new Car();
        System.out.println("car: " + car.getBrand() + " " + car.getModel() + " - Üretim Yılı: " + car.getProductionYear());
        System.out.println("car1: " + car1.getBrand() + " " + car1.getModel() + " - Üretim Yılı: " + car1.getProductionYear());

    }
}