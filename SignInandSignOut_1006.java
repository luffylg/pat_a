package pata;

import java.util.Scanner;

public class SignInandSignOut_1006 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		String in ="";
		String out="";
		String intime="23:59:59";
		String outtime="00:00:00";
		for (int i = 0; i < M; i++) {
			String cmp=scanner.next();
			String early=scanner.next();
			String late=scanner.next();
			if (cmptime(early,intime)<0) {
				intime=early;
				in=cmp;
			}
			if (cmptime(late,outtime)>0) {
				outtime=late;
				out=cmp;
			}
		}
		scanner.close();
		System.out.println(in +" "+out);
	}

	private static int cmptime(String early, String late) {
		// TODO Auto-generated method stub
		String[] split1 = early.split(":");
		String[] split2 = late.split(":");
		if (!split1[0].equals(split2[0])) {
			return Integer.parseInt(split1[0])-Integer.parseInt(split2[0]);
		}
		if (!split1[1].equals(split2[1])) {
			return Integer.parseInt(split1[1])-Integer.parseInt(split2[1]);
		}
		return Integer.parseInt(split1[2])-Integer.parseInt(split2[2]);
	}

}
