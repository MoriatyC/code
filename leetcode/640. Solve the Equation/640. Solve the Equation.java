public class Solution {
    public String solveEquation(String equation) {
        String[] formula = equation.split("=");
	        int flag = 1;
	        List<String> left = new ArrayList<>();
	        List<String> leftSymbol = new ArrayList<>();
	        List<String> right = new ArrayList<>();
	        List<String> rightSymbol = new ArrayList<>();
	        if (formula[0].charAt(0) != '-') {
	            formula[0] = "+" + formula[0];
	            leftSymbol.add("+");
	        } else {
	            leftSymbol.add("-");
	        }
	        if (formula[1].charAt(0) != '-') {
	            formula[1] = "+" + formula[1];
	            rightSymbol.add("-");
	        } else {
	            rightSymbol.add("+");
	        }
	        for (int i = 1; i < formula[0].length(); i++) {
	            if (formula[0].charAt(i) == '+' || formula[0].charAt(i) == '-') {
	                left.add(formula[0].substring(flag, i));
	                leftSymbol.add(String.valueOf(formula[0].charAt(i)));
	                flag = i + 1;
	            }
	            if (i == formula[0].length() - 1) {
	                left.add(formula[0].substring(flag));
	            }
	        }
	        flag = 1;
	        for (int i = 1; i < formula[1].length(); i++) {
	            if (formula[1].charAt(i) == '+' || formula[1].charAt(i) == '-') {
	                right.add(formula[1].substring(flag, i));
	                if (formula[1].charAt(i) == '+') {
	                	rightSymbol.add("-");
	                } else {
	                	rightSymbol.add("+");
	                }
	                flag = i + 1;
	            }
	            if (i == formula[1].length() - 1) {
	                right.add(formula[1].substring(flag));
	            }
	        }
	        int num = 0;
	        int x = 0;
	        for (int i = 0; i < left.size(); i++) {
	            if (!left.get(i).contains("x")) {
	                num += Integer.valueOf(leftSymbol.get(i) + left.get(i));
	            } else {
	            	if (left.get(i).length() == 1) {
	            		x += Integer.valueOf(leftSymbol.get(i) + 1);
	            	} else
	            	x += Integer.valueOf(leftSymbol.get(i) + left.get(i).substring(0, left.get(i).length() - 1));
	            } 
	        }
	        for (int i = 0; i < right.size(); i++) {
	            if (!right.get(i).contains("x")) {
	                num += Integer.valueOf(rightSymbol.get(i) + right.get(i));
	            } else {
	            	if (right.get(i).length() == 1) {
	            		x += Integer.valueOf(rightSymbol.get(i) + 1);
	            	} else
	            	x += Integer.valueOf(rightSymbol.get(i) + right.get(i).substring(0, right.get(i).length() - 1));
	            } 
	        }
	        num *= -1;
	        if (x == 0 && num != 0) {
	        	return "No solution";
	        }
	        if (num == 0 && x == 0) {
	        	return "Infinite solutions";
	        }
	        return "x=" + String.valueOf(num / x);
        
    }
}