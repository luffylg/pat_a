package pata;

import java.util.Scanner;

public class solution_001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int val = scanner.nextInt()+scanner.nextInt();
		scanner.close();
		if (val==0) {
			System.out.println("0");
		}
		if (val<0) {
			System.out.print("-");
			val=-val;
		}
		StringBuilder sb = new StringBuilder();
		int count=1;
		while (val>0) {
			sb.append(val%10);
			val/=10;
			if (count%3==0&&val!=0) {
				sb.append(",");
			}
			count++;
		}
		System.out.println(sb.reverse().toString());
	}
}
