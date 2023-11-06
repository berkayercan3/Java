public class LowArray{
private long[] dizi;
    public LowArray(int size) {
        dizi = new long[size];
    }
    public long getDizi(int index) {
        return dizi[index];
    }

    public void setDizi(int index,long value) {
        dizi[index] = value;
    }


}