package pata;

import java.util.Scanner;

public class Elevator_1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int pre=0;
		int plus=0;
		int minus=0;
		for (int i = 0; i < N; i++) {
			int val=scanner.nextInt();
			if (val>pre) {
				plus+=val-pre;
			}else {
				minus+=pre-val;
			}
			pre=val;
		}
		scanner.close();
		System.out.println(plus*6+minus*4+N*5);
	}

}
