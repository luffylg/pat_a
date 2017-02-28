package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GeneralPalindromicNumber_1019 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub\
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		reader.close();
		int N=Integer.parseInt(split[0]);
		int b=Integer.parseInt(split[1]);
		if (N==0) {
			System.out.println("Yes");
			System.out.println(0);
			return;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (N>0) {
			list.add(0, N%b);
			N/=b;
		}
		if (ispand(list)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		for (int i = 0; i < list.size()-1; i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println(list.get(list.size()-1));
		
	}

	private static boolean ispand(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size()/2; i++) {
			if (list.get(i)!=list.get(list.size()-i-1)) {
				return false;
			}
		}
		return true;
	}

}
