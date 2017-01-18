package pata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TheBestRank_1012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N=scanner.nextInt();
		int M=scanner.nextInt();
		HashMap<String,int[]> map = new HashMap<String,int[]>();
		String[] course=new String[]{"A","C","M","E"};
		int[] A=new int[N];
		int[] C=new int[N];
		int[] Ma=new int[N];
		int[] E=new int[N];
		for (int i = 0; i < N; i++) {
			int[] grade=new int[4];
			String xuehao=scanner.next();
			C[i]=grade[1]=scanner.nextInt();
			Ma[i]=grade[2]=scanner.nextInt();
			E[i]=grade[3]=scanner.nextInt();
			A[i]=grade[0]=(int) Math.round((grade[1]+grade[2]+grade[3])/3.0);
			map.put(xuehao, grade);
		}
		Arrays.sort(A);
		Arrays.sort(C);
		Arrays.sort(Ma);
		Arrays.sort(E);
		for (int i = 0; i < M; i++) {
			String key=scanner.next();
			if (!map.containsKey(key)) {
				System.out.println("N/A");
			}else {
				int[] grade=map.get(key);
				grade[0]=getrank(grade[0],A);
				grade[1]=getrank(grade[1],C);
				grade[2]=getrank(grade[2],Ma);
				grade[3]=getrank(grade[3],E);
				String c="";
				int rank=N+1;
				for (int j = 0; j < grade.length; j++) {
					if (grade[j]<rank) {
						rank=grade[j];
						c=course[j];
					}
				}
				System.out.println(rank+" "+c);
			}
		}
		scanner.close();
	}

	private static int getrank(int i, int[] a) {
		// TODO Auto-generated method stub
		for (int j = a.length-1; j >=0; j--) {
			if (i==a[j]) {
				return a.length- j;
			}
		}
		return -1;
	}


}
