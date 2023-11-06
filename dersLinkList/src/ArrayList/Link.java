package ArrayList;

public class Link {
    public int IData;
    public double dData;
    public Link next;

    public Link(int id,double dd){
        IData = id;
        dData=dd;
    }

    public void displayLink(){
        System.out.println("{"+ IData + ", " + dData + "}");
    }


}
