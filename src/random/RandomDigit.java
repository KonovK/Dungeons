package random;

public class RandomDigit {
    public static int randomizer(int min, int max) {
        max = max - min;
        return (int) (Math.random() * ++(max)) + min;
    }
}
