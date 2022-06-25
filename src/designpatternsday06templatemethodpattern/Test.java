package designpatternsday06templatemethodpattern;

abstract class X {

    public void step1() {
        System.out.println("Hello.");
    }

    public void step3() {
        System.out.println("Institute.");
    }

    public abstract void step2();

    public abstract void step4();

    public final void order() {
        step1();
        if (hook1()) {
            step2();
        }
        step3();
        step4();
    }

    public boolean hook1() {
        return true;
    }

}

class A extends X {

    @Override
    public void step2() {
        System.out.println("Java.");
    }

    @Override
    public void step4() {
        System.out.println("Welcome.");
    }

    @Override
    public boolean hook1() {
        return false;
    }

}

class B extends X {

    @Override
    public void step2() {
        System.out.println("IIT.");
    }

    @Override
    public void step4() {
        System.out.println("Thanks.");
    }

}

public class Test {

    public static void main(String[] args) {

        A a = new A();
        a.order();

        B b = new B();
        b.order();

    }

}
