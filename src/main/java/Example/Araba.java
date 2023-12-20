package Example;

import Libraries.BaseClass;
import org.openqa.selenium.By;

public class Araba extends BaseClass {

    public static void main(String[] args) {
        Test tt = new Test();
        tt
                .telNo(rastgeleNumaraGir());
    }

    public static void click(){
        System.out.println(rastgeleNumaraGir());
        System.out.println(rastgeleNumaraGir_5ileBaslamayan());

    }




}
