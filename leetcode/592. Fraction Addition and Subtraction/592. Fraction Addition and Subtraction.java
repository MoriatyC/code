public class Solution {
    public String fractionAddition(String expression) {
        int start = 0;
        int end = 0;
        int size = expression.length();
        int numer = 0;
        int den = 1;
        List<String[]> num = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (i == size || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                end = i;
                num.add(expression.substring(start, end).split("/"));
                start = i;
            }
        }
        for (String[] arr: num) {
            if (den % Integer.parseInt(arr[1]) != 0) {
                den *= Integer.parseInt(arr[1]);
            }
        }
        for (String[] arr: num) {
            numer += den / Integer.parseInt(arr[1]) * Integer.parseInt(arr[0]);
        }
        if (numer == 0) {
            return "0/1";
        }
        int gcd = gcd(Math.abs(numer), Math.abs(den));
        return numer/gcd + "/" + den/gcd;
    }
    int gcd(int a, int b) {
        int temp;
        while (a % b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }
}