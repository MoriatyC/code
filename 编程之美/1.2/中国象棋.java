package first_maven;

public class Main  {

    public static void main(String[] args) {
        byte s = 81;
        while (s-- > 0) {
            if (s % 9 % 3 == s / 9 % 3) {
                continue;
            }
            System.out.println(s % 9 + 1 + "   " + (s / 9 + 1));
        }
    }
}