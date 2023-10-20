
public class Main {
    public static void main(String[] args) {
        ConstantsExample constantsExample = new ConstantsExample();
            int sinavNotu = 85;

            if (sinavNotu <= constantsExample.MAX_SINAV_NOTU) //MAX_SINAV_NOTU static olarak oluşturuluğu için sınıf ismini kullanarak çağırdık
                System.out.println("Geçerli sınav notu: " + sinavNotu);
             else
                System.out.println("Geçersiz sınav notu.");
            System.out.println("Bu bir " + constantsExample.UYGULAMA_ISMI);
    }
}