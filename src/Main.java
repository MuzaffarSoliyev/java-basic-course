import java.math.*;
import java.lang.Integer;
import java.lang.String;
import java.util.Locale;
import java.lang.StringBuilder;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;


public class Main {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return !a & !b & c & d | !a & b & !c & d | !a & b & c & !d | a & !b & !c & d | a & !b & c & !d | a & b & !c & !d;
    }

    public static int leapYearCount(int year) {
        return year / 4 - year / 100 + year / 400;
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs((a + b) - c) < 0.0001;
    }

    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        if (value < 0) {
            value = -value;
        }
        return (value != 0) && ((value & (value - 1)) == 0);
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String new_string = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        StringBuilder tmp = new StringBuilder(new_string).reverse();
        String reversed = tmp.toString();
        return new_string.equals(reversed);
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger res = new BigInteger("1");
        for (int i = 2; i <= value; i++)
            res = res.multiply(BigInteger.valueOf(i));
        return res;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int i = 0, j = 0, n = a1.length, m = a2.length, k = 0;
        int[] res = new int[n + m];
        while (i + j < n + m){
            if(j == m || (i < n && a1[i] < a2[j])){
                res[k] = a1[i];
                i++;
            }else{
                res[k] = a2[j];
                j++;
            }
            k++;
        }
        return res;
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int n = 100000000;
        double h = (b - a) / 100000000, s = 0.0, x = 0.0;
        for(int i = 0; i < n; i++){
            x = a + i * h;
            s += f.applyAsDouble(x);
        }
        return h * s;
    }

    public static void main(String[] args) {
        // boolean a = false, b = true, c = false, d = true;
        // double a = 0.1, b = 0.2, c = 0.3;
        // System.out.println(doubleExpression(a, b, c));
        // System.out.println(flipBit(13, 3));
        // System.out.println(charExpression(29));
        // System.out.println(isPowerOfTwo(0));
        // System.out.println(isPowerOfTwo(1));
        // System.out.println(isPowerOfTwo(-2));
        // System.out.println(isPowerOfTwo(32));
        // System.out.println(isPowerOfTwo(31));
        //System.out.println(isPalindrome("Madam, I'm Adama!"));
        // System.out.println(factorial(3));
        // int[] a1 = {0, 2, 2}, a2 = {1, 3}, res;
        // res = mergeArrays(a1, a2);
        // System.out.println(Arrays.toString(res));
        // System.out.println(integrate(x -> 1, 0, 10));
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence ans = new AsciiCharSequence(example);
        System.out.println(ans.toString());
        System.out.println(ans.length());
        System.out.println(ans.charAt(1));
        System.out.println(ans.subSequence(1, 5));
        System.out.println(ans.toString());//Hello!
        example[0] = 74;
        System.out.println(ans.toString());//Hello!

    }
}
