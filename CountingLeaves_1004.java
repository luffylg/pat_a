package pata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountingLeaves_1004 {
	public static HashMap<String,String[]> map;
	public static ArrayList<Integer> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		map = new HashMap<String,String[]>();
		for (int i = 0; i < M; i++) {
			String key=scanner.next();
			String[] val=new String[scanner.nextInt()];
			for (int j = 0; j < val.length; j++) {
				val[j]=scanner.next();
			}
			map.put(key, val);
		}
		scanner.close();
		result = new ArrayList<Integer>();
		result.add(0);
		countleaveoflevel(0,"01");
		System.out.print(result.get(0));
		for (int i = 1; i < result.size(); i++) {
			System.out.print(" "+result.get(i));
		}
	}

	private static void countleaveoflevel(int level, String node) {
		// TODO Auto-generated method stub
		while (result.size()<level+1) {
			result.add(0);
		}
		if (!map.containsKey(node)) {
			result.set(level, result.get(level)+1);
		}else {
			String[] strings = map.get(node);
			for (int i = 0; i < strings.length; i++) {
				countleaveoflevel(level+1, strings[i]);
			}
		}
	}

}
