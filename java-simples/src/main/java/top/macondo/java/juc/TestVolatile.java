package top.macondo.java.juc;

public class TestVolatile {

    public static volatile int counter = 1;

    public static void main(String[] args){
        counter = 2;
        System.out.println(counter);
    }
}