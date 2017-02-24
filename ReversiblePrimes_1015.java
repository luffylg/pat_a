package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversiblePrimes_1015 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] split = reader.readLine().split("\\s");
			if (split.length==1) break;
			int N=Integer.parseInt(split[0]);
			if (!issu(N)) {
				System.out.println("No");
				continue;
			}
			int D=Integer.parseInt(split[1]);
			int N2=getreverse(N,D);
			if (issu(N2)) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
		reader.close();
	}
	private static boolean issu(int n) {
		// TODO Auto-generated method stub
		if (n==2) {
			return true;
		}
		if (n<2||n%2==0) {
			return false;
		}
		double sqrt=Math.floor(Math.sqrt(n));
		for (int i = 3; i <= sqrt; i+=2) {
			if (n%i==0) {
				return false;
			}
		}
		return true;
	}
	private static int getreverse(int n, int d) {
		// TODO Auto-generated method stub
		int reverse=0;
		while (n>0) {
			reverse=d*reverse+(n%d);
			n/=d;
		}
		//System.out.println(reverse);
		return reverse;
	}

}
