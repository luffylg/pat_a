package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeepestRoot_1021 {
	static ArrayList[] Matrix;
	static boolean[] visited;
	static boolean isconn=true;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(reader.readLine());
		Matrix=new ArrayList[N+1];
		for (int i = 0; i < Matrix.length; i++) {
			Matrix[i]=new ArrayList<Integer>();
		}
		for (int i = 1; i < N; i++) {
			String[] split = reader.readLine().split("\\s");
			int int1 = Integer.parseInt(split[0]);
			int int2 = Integer.parseInt(split[1]);
			Matrix[int1].add(int2);
			Matrix[int2].add(int1);
		}
		reader.close();
		int K=0;
		visited=new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i,0);
				K++;
			}
		}
		if (!isconn||K>1) {
			System.out.println("Error: "+K+" components");
		}else {
			int maxdeep=0;
			Queue<Integer> list = new LinkedList<Integer>();
			for (int i = 1; i <= N; i++) {
				int depth=getdepth(i,0);
				if (depth<maxdeep) {
					continue;
				}
				if (depth>maxdeep) {
					maxdeep=depth;
					list.clear();
				}
				list.add(i);
			}
			while (!list.isEmpty()) {
				System.out.println(list.poll());
			}
		}
	}
	private static int getdepth(int i,int pre) {
		// TODO Auto-generated method stub
		int depth=1;
		ArrayList<Integer> list = Matrix[i];
		for (int k = 0; k < list.size(); k++) {
			int j=list.get(k);
			if (j==pre||j==i) {
				continue;
			}
			depth=Math.max(depth, getdepth(j,i)+1);
		}
		
		return depth;
	}
	private static void DFS(int i,int pre) {
		// TODO Auto-generated method stub
		visited[i]=true;
		//System.out.println(i);
		ArrayList<Integer> list = Matrix[i];
		for (int k = 0; k < list.size(); k++) {
			int j=list.get(k);
			if (j==pre||j==i) {
				continue;
			}
			if (visited[j]) {
				isconn=false;
				continue;
			}
			DFS(j,i);
		}
	}
}
