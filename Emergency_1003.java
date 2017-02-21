package pata;

import java.util.HashMap;
import java.util.Scanner;

public class Emergency_1003 {
	static int count;
	static int maxres;
	static int INF=Integer.MAX_VALUE;
	static int mind;
	static int N;
	static boolean[] visited;
	static int[][] mMatrix;
	static int[] rescuenum;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		int M = scanner.nextInt();
		int C1 = scanner.nextInt();
		int C2 = scanner.nextInt();
		mind=INF;
		rescuenum=new int[N];
		for (int i = 0; i < rescuenum.length; i++) {
			rescuenum[i]=scanner.nextInt();
		}
		mMatrix=new int[N][N];
		visited=new boolean[N];
		for (int i = 0; i < N; i++) {
			visited[i]=false;
			for (int j = 0; j < N; j++) {
				mMatrix[i][j]=INF;
			}
		}
		for (int i = 0; i < M; i++) {
			int from=scanner.nextInt();
			int to=scanner.nextInt();
			mMatrix[to][from]=mMatrix[from][to]=scanner.nextInt();
		}
		scanner.close();
		dfs(C1,C2,0,rescuenum[C1]);
		System.out.println(count+" "+maxres);
	}

	private static void dfs(int start, int end, int distance, int rescuesum) {
		// TODO Auto-generated method stub
		if (distance>mind) {
			return;
		}
		if (start!=end) {
			for (int i = 0; i < N; i++) {
				if (!visited[i]&&mMatrix[start][i]!=INF) {
					visited[i]=true;
					dfs(i, end, distance+mMatrix[start][i], rescuesum+rescuenum[i]);
					visited[i]=false;
				}
			}
		}else {
			if (distance<mind) {
				count=1;
				mind=distance;
				maxres=rescuesum;
			}else if (distance==mind) {
				count++;
				maxres=Math.max(rescuesum, maxres);
			}
		}
	}

}
