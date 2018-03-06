package week6;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(numberOfDigits(120));
        System.out.println(factorial(5));
    }

    public static int numberOfDigits(int n) {
        /*int count = 1;
	     	while (n >= 10) {
	     		n = n/10;
	      	count++;
	     }
	     return count;*/
        if ((-10 < n) && (n < 10)){
            return 1;
        }
        return 1 + numberOfDigits(n / 10);
    }

    public static int factorial(int n) {
		/*int result = n;
		while (n > 1) {
			n--;
			result = result*n; 
		}
		return result;*/
        if (n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
