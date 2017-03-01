package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class HaveFunwithNumbers_1023 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub\
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string=reader.readLine();
		reader.close();
		int[] cmp=new int[10];
		for (char c : string.toCharArray()) {
			cmp[c-'0']++;
		}
		BigDecimal bigDecimal = new BigDecimal(string);
		bigDecimal=bigDecimal.multiply(BigDecimal.ONE.add(BigDecimal.ONE));
		String string2 = bigDecimal.toString();
		for (char c : string2.toCharArray()) {
			cmp[c-'0']--;
		}
		boolean flag=true;
		for (int i = 0; i < cmp.length; i++) {
			if (cmp[i]!=0) {
				flag=false;
				break;
			}
		}
		if (flag) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		System.out.println(string2);
	}

}
