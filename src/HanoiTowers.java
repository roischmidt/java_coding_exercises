/**
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 */
public class HanoiTowers {

    public static void play(int n, String from, String to, String using) {
        if (n == 1) {
            System.out.println("moving 1 from " + from + " to " + to);
            return;
        }
        play(n - 1, from, using, to);
        System.out.println("moving " + Integer.toString(n) + " from " + from + " to " + to);
        play(n - 1, using, to, from);
    }

    public static void main(String[] args) {
        play(5, "A", "C", "B");
    }
}
