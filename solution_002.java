package pata;

import java.util.Scanner;

public class solution_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int K1 = scanner.nextInt();
		int L1 = scanner.nextInt();
		double[] val1=new double[L1+1];
		val1[L1]=scanner.nextDouble();
		for (int i = 1; i < K1; i++) {
			val1[scanner.nextInt()]=scanner.nextDouble();
		}
		int K2 = scanner.nextInt();
		int L2 = scanner.nextInt();
		double[] val2=new double[Math.max(L1+1, L2+1)];
		val2[L2]=scanner.nextDouble();
		for (int i = 1; i < K2; i++) {
			val2[scanner.nextInt()]=scanner.nextDouble();
		}
		for (int i = 0; i < val1.length; i++) {
			val2[i]+=val1[i];
		}
		int count=0;
		for (int i = 0; i < val2.length; i++) {
			if (val2[i]!=0) {
				count++;
			}
		}
		System.out.print(count);
		for (int i = val2.length-1; i >=0; i--) {
			if (val2[i]!=0) {
				System.out.print(" "+i+" "+String.format("%.1f", val2[i]));
			}
		}
	}

}
