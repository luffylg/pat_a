package pata;

import java.util.Scanner;

public class WorldCupBetting_1011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double result=1.0;
		for (int i = 0; i < 3; i++) {
			double w=scanner.nextDouble();
			double t=scanner.nextDouble();
			double l=scanner.nextDouble();
			if (w>t&&w>l) {
				System.out.print("W ");
				result*=w;
			}else if (t>w&&t>l) {
				System.out.print("T ");
				result*=t;
			}else {
				System.out.print("L ");
				result*=l;
			}
		}
		scanner.close();
		System.out.println(String.format("%.2f", 2*(result*0.65-1)));
	}

}
