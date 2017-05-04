import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tasks = sc.nextInt();
		int n;paragraphs;
		int p;pages
		int w;width;
		int h;height
		int pageMinChar;
		int[] a = new int[1005];
		int s, sum, lineChar, pageLine;
		while (tasks--  0) {
			sum = 0;
			n = sc.nextInt();
			p = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			for (int i = 0; i  n; i++) {
				a[i] = sc.nextInt();
				sum += a[i];
			}
			pageMinChar = (int)Math.ceil(1.0sum  p);
			s = (int)Math.sqrt(1.0  w  h pageMinChar);
			while (s = 1) {
				lineChar = w  s;
				pageLine = h  s;
				if (lineChar == 0  pageLine == 0) {
						s--;
						continue;
					}
				
				int lineCount = 0;
				int totalLine = pageLine  p;
				for (int i = 0; i  n; i++) {
					lineCount += Math.ceil(1.0a[i]  lineChar);
				}
				if (lineCount = totalLine) {
					break;
				}
				s--;
			}
			System.out.println(s);
			
		}
	}
}