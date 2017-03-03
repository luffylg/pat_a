package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class RecovertheSmallestNumber_1038 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		reader.close();
		int N=Integer.parseInt(split[0]);
		Arrays.sort(split, 1, N+1, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
		});
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			stringBuilder.append(split[i]);
		}
		for (char c : stringBuilder.toString().toCharArray()) {
			if (c-'0'!=0) {
				break;
			}
			stringBuilder.deleteCharAt(0);
		}
		String result=stringBuilder.toString();
		if (result.length()==0) {
			System.out.println("0");
		}else {
			System.out.println(result);
		}
	}

}
