package pata;

import java.util.Scanner;

public class SpellItRight_1005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] search=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
		Scanner scanner = new Scanner(System.in);
		String target = scanner.next();
		scanner.close();
		int sum=0;
		for (char ch : target.toCharArray()) {
			sum+=ch-'0';
		}
		String val=String.valueOf(sum);
		System.out.print(search[val.charAt(0)-'0']);
		for (int i = 1; i < val.length(); i++) {
			System.out.print(" "+search[val.charAt(i)-'0']);
		}
	}

}
