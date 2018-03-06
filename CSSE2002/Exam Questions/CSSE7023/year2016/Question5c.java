package CSSE7023.year2016;

public class Question5c {

    public static void main(String[] args) {
        Foo x = new Foo("Blue");
        Bar y = new Bar("orange");
        Foo z = new Bar("pink");
        x.combine(y);
        y.combine(z);
        System.out.println(x);
        System.out.println(y);
        //System.out.println(" z is a type of " + z.getClass().getSimpleName());
    }

}
