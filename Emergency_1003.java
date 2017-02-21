package pata;

import java.util.Scanner;

public class Emergency_1003 {
	static int[] distance;
	static int[] count=new int[500];
	static int[] maxres=new int[500];
	static int INF=Integer.MAX_VALUE;
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
		rescuenum=new int[N];
		for (int i = 0; i < rescuenum.length; i++) {
			rescuenum[i]=scanner.nextInt();
		}
		mMatrix=new int[N][N];
		visited=new boolean[N];
		distance=new int[N];
		for (int i = 0; i < N; i++) {
			visited[i]=false;
			distance[i]=INF;
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
		dijkstra(C1,C2);
		System.out.println(count[C2]+" "+maxres[C2]);
	}

	private static void dijkstra(int start, int end) {
		// TODO Auto-generated method stub
		int current=start;
		int next=start;
		maxres[current]=rescuenum[current];
		count[current]=1;
		while (true) {
			if (current==end) {
				break;
			}
			visited[current]=true;
			int min=INF;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					continue;
				}
				if (mMatrix[current][i]!=INF) {
					int tmp=distance[current]+mMatrix[current][i];
					if (tmp<distance[i]) {
						distance[i]=tmp;
						maxres[i]=maxres[current]+rescuenum[i];
						count[i]=count[current];
					}else if (tmp==distance[i]) {
						maxres[i]=Math.max(maxres[current]+rescuenum[i],maxres[i]);
						count[i]+=count[current];
					}
				}
				if (distance[i]<min) {
					min=distance[i];
					next=i;
				}
			}
			current=next;
		}
	}

}
