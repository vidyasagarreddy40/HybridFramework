package functionalSuite;

public class cClass extends pClass {

    cClass(){
        System.out.println("child class");
    }
    public static void main(String[] args) {
        int hh = pClass.salary;
        System.out.println(hh);
        cClass c = new cClass();
        c.handle();
    }

    public void handle() {
        int sf = sa;
        System.out.println(sa);
    }

    public int add(int a, int b) {
        System.out.println("one");
        return a;
    }
}
