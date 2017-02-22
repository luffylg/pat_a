package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class BattleOverCities_1013 {
	static boolean[][] Matrix;
	static boolean[] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scanner = new Scanner(System.in);
		String[] split = reader.readLine().split("\\s");
		N = Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		int K=Integer.parseInt(split[2]);
		Matrix=new boolean[N+1][N+1];
		for (int i = 1; i <= M; i++) {
			String[] split2 = reader.readLine().split("\\s");
			int city1 = Integer.parseInt(split2[0]);
			int city2 = Integer.parseInt(split2[1]);
			Matrix[city1][city2]=Matrix[city2][city1]=true;
		}
//		visited=new boolean[N+1];
		String[] split3 = reader.readLine().split("\\s");
		for (int i = 0; i < K; i++) {
			int check=Integer.parseInt(split3[i]);
			visited=new boolean[N+1];
//			Arrays.fill(visited, false);
			int count=0;
			visited[check]=true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					count++;
					dfs(j);
				}
			}
			System.out.println(count-1);
//			Matrix=clone.clone();
		}
		
	}

	private static void dfs(int check) {
		// TODO Auto-generated method stub
		visited[check]=true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]&&Matrix[check][i]) {
				dfs(i);
			}
		}
	}

}
