public class ArmstrongNumbers {

    public static boolean armstrongNumber(int n) {

        int len = String.valueOf(n).length();
        int ans = 0;
        int original = n;

        while (n > 0) {

            int val = n % 10;
            int multiplied = 1;

            for (int i = 0; i < len; i++) {
                multiplied *= val;
            }

            ans += multiplied;
            n /= 10;
        }

        return ans == original;
    }

    public static void main(String[] args) {

        int n = 153;

        if (armstrongNumber(n)) {
            System.out.println(n + " is an Armstrong Number");
        } else {
            System.out.println(n + " is NOT an Armstrong Number");
        }
    }
}