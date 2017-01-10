package pata;

import java.util.ArrayList;
import java.util.Scanner;

public class solution_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		Scanner scanner = new Scanner(System.in);
		int K1 = scanner.nextInt();
		int num=scanner.nextInt();
		while (num>=list.size()) {
			list.add(0.0);
		}
		list.set(num, scanner.nextDouble());
		for (int i = 1; i < K1; i++) {	
			list.set(scanner.nextInt(), scanner.nextDouble());
		}
		int K2 = scanner.nextInt();
		num = scanner.nextInt();
		while (num>=list.size()) {
			list.add(0.0);
		}
		list.set(num,list.get(num)+ scanner.nextDouble());
		for (int i = 1; i < K2; i++) {
			int index=scanner.nextInt();
			list.set(index, list.get(index)+scanner.nextDouble());
		}
		scanner.close();
		int count=0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)!=0) {
				count++;
			}
		}
		System.out.print(count);
		for (int i = list.size()-1; i >=0; i--) {
			if (list.get(i)!=0) {
				System.out.print(" "+i+" "+String.format("%.1f", list.get(i)));
			}
		}
	}

}
