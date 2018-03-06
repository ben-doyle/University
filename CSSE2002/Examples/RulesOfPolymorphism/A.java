package RulesOfPolymorphism;

public class A {
    public int move() {
        return 1;
    }
}

class B extends A {
    public int move(){
        return super.move();
    }
}