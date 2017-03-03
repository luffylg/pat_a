package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SocialClusters_1107 {
	static int[] father;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		father=new int[N+1];
		int[] hobby=new int[1001];
		for (int i = 1; i <=N; i++) {
			father[i]=i;
		}
		for (int i = 1; i <= N; i++) {
			String[] split = reader.readLine().split(":\\s");
			int p=Integer.parseInt(split[0]);
			String[] split2 = split[1].split("\\s");
			for (int j = 0; j < split2.length; j++) {
				int habit=Integer.parseInt(split2[j]);
				if (hobby[habit]==0) {
					hobby[habit]=i;
				}else {
					union(findfather(hobby[habit]),i);
				}
			}
		}
		reader.close();
		int[] isroot=new int[N+1];
		for (int i = 1; i <=N; i++) {
			isroot[findfather(i)]++;
		}
		int count=0;
		for (int i = 1; i <= N; i++) {
			if (isroot[i]!=0) {
				count++;
			}
		}
		System.out.println(count);
		Arrays.sort(isroot);
		for (int i = N; i >0; i--) {
			if (isroot[i]==0) {
				break;
			}
			if (i!=N) {
				System.out.print(" ");
			}
			System.out.print(isroot[i]);
		}
	}

	private static void union(int a, int p) {
		// TODO Auto-generated method stub
		int afather = findfather(a);
		int pfather=findfather(p);
		if (afather!=pfather) {
			father[pfather]=afather;
		}
	}

	private static int findfather(int x) {
		// TODO Auto-generated method stub
		int tmp=x;
		while (x!=father[x]) {
			x=father[x];
		}
		while (father[tmp]!=x) {
			int index=father[tmp];
			father[tmp]=x;
			tmp=index;
		}
		return x;
	}

}
