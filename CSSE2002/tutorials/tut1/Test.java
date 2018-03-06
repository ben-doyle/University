package tut1;

public class Test {
    public static void main(String[] args) {
        Tutorial1 t1 = new Tutorial1();
        int [] a = {1,2,3};
        System.out.print(t1.sum(a));
        System.out.print(t1.sum(new int[] {1,2,3}));
    }
}
