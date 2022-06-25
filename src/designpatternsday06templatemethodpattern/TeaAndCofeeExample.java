package designpatternsday06templatemethodpattern;

abstract class Preapare {

    public void boilWater() {
        System.out.println("Boil Water.");
    }

    public void pourInCup() {
        System.out.println("Pour In Cup.");
    }

    public abstract void step2();

    public abstract void step4();

    public final void templateMethod() {
        boilWater();
        step2();
        pourInCup();
        if (hookStep4()) {
            step4();
        }
    }

    public boolean hookStep4() {
        return true;
    }

}

class PreapreTea extends Preapare {

    @Override
    public void step2() {
        System.out.println("Steep Tea Bag.");
    }

    @Override
    public void step4() {
        System.out.println("Add Ginger.");
    }

}

class PreapreCofee extends Preapare {

    @Override
    public void step2() {
        System.out.println("Brew Coffee Grinds.");
    }

    @Override
    public void step4() {
        System.out.println("Add Sugar And Milk.");
    }

}

public class TeaAndCofeeExample {

    public static void main(String[] args) {

        PreapreTea preapreTea1 = new PreapreTea() {
            @Override
            public boolean hookStep4() {
                return true;
            }
        };

        PreapreTea preapreTea2 = new PreapreTea() {
            @Override
            public boolean hookStep4() {
                return false;
            }
        };

        PreapreCofee preapreCofee1 = new PreapreCofee();

        System.out.println("Make Tea1.....");
        preapreTea1.templateMethod();

        System.out.println("Make Tea2.....");
        preapreTea2.templateMethod();

        System.out.println("Make Coffee.....");
        preapreCofee1.templateMethod();
        
    }

}
