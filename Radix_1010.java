package pata;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;


public class Radix_1010 {
	static HashMap<Character, Integer> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map=new HashMap<Character, Integer>();
		for (char i = '0'; i-'9'<=0 ; i++) {
			map.put(i, i-'0');
		}
		for (char i = 'a'; i <= 'z'; i++) {
			map.put(i, 10+i-'a');
		}
		Scanner scanner = new Scanner(System.in);
		String N1=scanner.next();
		String N2=scanner.next();
		int tag=scanner.nextInt();
		BigInteger radix=scanner.nextBigInteger();
		scanner.close();
		if (tag==2) {
			String tmp=N1;
			N1=N2;
			N2=tmp;
		}
		BigInteger target=todec(N1,radix);
		//System.out.println(target);
		BigInteger max,min=BigInteger.ONE;
		for (char c : N2.toCharArray()) {
			BigInteger bigInteger = new BigInteger(String.valueOf(map.get(c)));
			min=bigInteger.compareTo(min)>0?bigInteger:min;
		}
		min=min.add(BigInteger.ONE);
		max=target.compareTo(min)>0?target:min;
		BigInteger result=binarysearch(N2,target,min,max);
		if (result.equals(new BigInteger(String.valueOf("-1")))) {
			System.out.println("Impossible");
		}else {
			System.out.println(result);
		}
	}
	private static BigInteger binarysearch(String n2, BigInteger target, BigInteger min, BigInteger max) {
		// TODO Auto-generated method stub
		while (min.compareTo(max)<=0) {
			BigInteger middle=min.add(max).divide(new BigInteger(String.valueOf("2")));
			//System.out.println(min+" "+max);
			//System.out.println(middle);
			long cmp=cmp(n2,target,middle);
			if (cmp==0) {
				return middle;
			}
			if (cmp>0) {
				max=middle.subtract(BigInteger.ONE);
			}else {
				min=middle.add(BigInteger.ONE);
			}
		}
		return new BigInteger(String.valueOf("-1"));
	}
	private static long cmp(String n2, BigInteger target, BigInteger middle) {
		// TODO Auto-generated method stub
		BigInteger sum=BigInteger.ZERO;
		for (char c : n2.toCharArray()) {
			sum=sum.multiply(middle).add(new BigInteger(String.valueOf(map.get(c))));
			if (sum.compareTo(target)>0) {
				return 1;
			}
		}
		return sum.compareTo(target);
	}
	private static BigInteger todec(String n1, BigInteger radix) {
		// TODO Auto-generated method stub
		BigInteger sum=BigInteger.ZERO;
		for (char c : n1.toCharArray()) {
			sum=sum.multiply(radix).add(new BigInteger(String.valueOf(map.get(c))));
		}
		return sum;
	}

}
