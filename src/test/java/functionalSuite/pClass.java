package functionalSuite;

public class pClass {

    public static int salary = 10000;
    int sa = 2345;
    int speed;

    pClass() {
        System.out.println("parent class");
    }

    public void display() {
        System.out.println("red color");
    }

    {
        speed = 100;
        System.out.println("intilising the instance block");
    }

    public static void main(String[] args) {
        pClass pp = new pClass();
    }
}
