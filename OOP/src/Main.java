
/*"Ogrenci" sınıfında "ad" ve "yas" adında iki özellik içerir.
 "getAd" ve "getYas" metotları bu özellikleri okurken,
  "setAd" ve "setYas" metotları bu özellikleri ayarlar.
   Bu şekilde, sınıfın kullanıcıları bu özelliklere erişirken ve
   değiştirirken "get" ve "set" metotları kullanabilirler. */


public class Main {
    public static void main(String[] args) {
            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setAd("Berkay");
            ogrenci.setYas(14);

            System.out.println(ogrenci.getAd());
            System.out.println(ogrenci.getYas());

    }
    }