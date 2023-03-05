package functionalSuite;

import java.io.IOException;

public class cclasssone extends cClass {
    public static void main(String[] args) {
        pClass p = new pClass();
        p.display();
        cclasssone cc=new cclasssone();
        cc.sum(20L,30L);
    }

    @Override
    public void display() {
        super.display();
    }

    public void sum(int a, int b){
        System.out.println(" m1 invoked");
    }
    public  void sum(long a, long b){
        System.out.println(" m2 invoked");
    }

    public final void add(int a){

    }
    public final void add(long b){

    }
}
