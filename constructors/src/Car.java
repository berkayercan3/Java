//constructor lar sınıf ismiyle aynı ada sahip olmalıdır

public class Car {
    private String brand;
    private String model;
    private int productionYear;

    //aynı constructorları parametreli ve parametresiz başlatmamız overloading(aşırı yükleme)'ye bir örnektir
    //parametreli yapıcı
    public Car (String brand,String model,int productionYear){
        this.brand=brand;
        this.model=model;
        this.productionYear=productionYear;
    }

    //parametresiz yapıcı
    public Car (){
        this.brand=brand;
        this.model=model;
        this.productionYear=productionYear;
    }

    //sadece get tanımladık yani değer alma ve okuma işlemi yapılabilir
    //setter kullansaydım kullanıcı değer değiştrme işlemi de yapabilecekti
    public String getBrand() {
        return brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getModel() {
        return model;
    }
}