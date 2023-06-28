package d6;

/* Find square root using Babylonian method */
public class Babylonian {
    public static void main(String[] args) {
        float result = squareRoot(2.0f);
        System.out.println(result);
    }

    public static float squareRoot(float n) {
        float x = n;
        float y = 1;
        float e = 0.0001f; // accuracy
        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }
        return x;
    }
}
