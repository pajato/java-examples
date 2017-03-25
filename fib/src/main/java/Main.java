public class Main {

    public static void main(String[] args) {
        fib(5);
    }

    static int fib(int n) {
        if (n == 0) {
            //System.out.println(0);
            return 0;
        }
        if (n == 1) {
            //System.out.println(1);
            return 1;
        }
        int sum = fib(n-1) + fib(n-2);
        System.out.println(sum);
        return sum;
    }
}
