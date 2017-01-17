package pata;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductofPolynomials_1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int K1=scanner.nextInt();
		ArrayList<Double> list= new ArrayList<Double>();
		for (int i = 0; i < K1; i++) {
			int val = scanner.nextInt();
			while (val+1>list.size()) {
					list.add(0.0);
			}
			list.set(val, scanner.nextDouble());
		}
		int K2=scanner.nextInt();
		ArrayList<Double> list2= new ArrayList<Double>();
		for (int i = 0; i < K2; i++) {
			int index = scanner.nextInt();
			double val=scanner.nextDouble();
			for (int j = 0; j < list.size(); j++) {
				while (index+list.size()>list2.size()) {
					list2.add(0.0);
				}
				list2.set(index+j, list2.get(index+j)+list.get(j)*val);
			}
		}
		scanner.close();
		int count=0;
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i)!=0) {
				count++;
			}
		}
		System.out.print(count);
		for (int i = list2.size()-1; i >=0; i--) {
			if (list2.get(i)!=0) {
				System.out.print(" "+i+" "+String.format("%.1f", list2.get(i)));
			}
		}
	}

}
