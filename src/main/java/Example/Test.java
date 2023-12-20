package Example;

public class Test {

    public String dizelArac = "BU BİR TEST CÜMLESİDİR";

    public Test(){
    }



    public Test tekerlek(){
        System.out.println("Tekerlek");
        return this;
    }

    public Test lastik(){
        System.out.println("Lastik");
        return this;
    }


    public Test kaporta(){
        System.out.println("Kaporta");
        return this;
    }

    public String  dizelAraciCalistir() {
        System.out.println(dizelArac);
        return null;
    }

    public String telNo(String No){
        System.out.println("056454");
        return No;
    }


}
