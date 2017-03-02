package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OnlineMap_1111 {
	static int[][] time;
	static int[][] matrix;
	static boolean[] visited;
	static int INF=Integer.MAX_VALUE;
	static int st;
	static int end;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		matrix=new int[N][N];
		time=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j]=time[i][j]=INF;
			}
		}
		for (int i = 0; i < M; i++) {
			String[] split2 = reader.readLine().split("\\s");
			int V1=Integer.parseInt(split2[0]);
			int V2=Integer.parseInt(split2[1]);
			if (Integer.parseInt(split2[2])==0) {
				matrix[V1][V2]=matrix[V2][V1]=Integer.parseInt(split2[3]);
				time[V1][V2]=time[V2][V1]=Integer.parseInt(split2[4]);
			}else {
				matrix[V1][V2]=Integer.parseInt(split2[3]);
				time[V1][V2]=Integer.parseInt(split2[4]);
			}
		}
		String[] strings = reader.readLine().split("\\s");
		st=Integer.parseInt(strings[0]);
		end=Integer.parseInt(strings[1]);
		reader.close();
		int[] pre=new int[N];
		visited=new boolean[N];
		int[] distance=new int[N];
		int[] shijian=new int[N];
		for (int i = 0; i < distance.length; i++) {
			distance[i]=INF;
		}
		distance[st]=0;
		int current=st;
		while (true) {
			//System.out.println(current);
			visited[current]=true;
			int mindis=INF;
			//int next=INF;
			for (int i = 0; i < N; i++) {
				if (!visited[i]&&matrix[current][i]!=INF) {
					if (distance[i]>distance[current]+matrix[current][i]) {
						distance[i]=distance[current]+matrix[current][i];
						pre[i]=current;
						shijian[i]=shijian[current]+time[current][i];
					}else if (distance[i]==distance[current]+matrix[current][i]&&shijian[i]>shijian[current]+time[current][i]) {
						pre[i]=current;
						shijian[i]=shijian[current]+time[current][i];
					}
					//System.out.println(i+" "+distance[i]);
				}
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i]&&distance[i]<INF) {
					if (distance[i]<mindis) {
						mindis=distance[i];
						current=i;
					}
				}		
			}
			//current=next;
			if (current==end) {
				break;
			}
		}
		ArrayList<Integer> rs1=new ArrayList<Integer>();
		rs1=dfs(pre,end,rs1);
		pre=new int[N];
		visited=new boolean[N];
		shijian=new int[N];
		int[] nodecount=new int[N];
		for (int i = 0; i < shijian.length; i++) {
			shijian[i]=nodecount[i]=INF;
		}
		shijian[st]=0;
		current=st;
		nodecount[st]=1;
		while (true) {
			visited[current]=true;
			int mindis=INF;
			for (int i = 0; i < N; i++) {
				if (!visited[i]&&time[current][i]!=INF) {
					if (shijian[i]>shijian[current]+time[current][i]) {
						shijian[i]=shijian[current]+time[current][i];
						pre[i]=current;
						nodecount[i]=nodecount[current]+1;
					}else if (shijian[i]==shijian[current]+time[current][i]&&nodecount[i]>nodecount[current]+1) {
						pre[i]=current;
						nodecount[i]=nodecount[current]+1;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i]&&shijian[i]<INF) {
					if (shijian[i]<mindis) {
						mindis=shijian[i];
						current=i;
					}
				}		
			}
			//current=next;
			if (current==end) {
				break;
			}
		}
		ArrayList<Integer> rs2=new ArrayList<Integer>();
		rs2=dfs(pre,end,rs2);
		if (rs1.equals(rs2)) {
			System.out.print("Distance = "+distance[end]+"; Time = "+shijian[end]+": ");
			for (int i = 0; i < rs1.size(); i++) {
				if (i!=0) {
					System.out.print(" -> ");
				}
				System.out.print(rs1.get(i));
			}
		}else {
			System.out.print("Distance = "+distance[end]+": ");
			for (int i = 0; i < rs1.size(); i++) {
				if (i!=0) {
					System.out.print(" -> ");
				}
				System.out.print(rs1.get(i));
			}
			System.out.println();
			System.out.print("Time = "+shijian[end]+": ");
			for (int i = 0; i < rs2.size(); i++) {
				if (i!=0) {
					System.out.print(" -> ");
				}
				System.out.print(rs2.get(i));
			}
		}
	}
	private static ArrayList<Integer> dfs(int[] pre, int node, ArrayList<Integer> rs1) {
		// TODO Auto-generated method stub
		rs1.add(0, node);
		if (node==st) {
			return rs1;
		}
		return dfs(pre, pre[node],rs1);
	}

}
