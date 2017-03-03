package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HeadofaGang_1034 {
	static int[][] Matrix;
	static int[] minutes;
	static HashMap<String, Integer> stringtoint=new HashMap<String,Integer>();
	static ArrayList<String> inttostring=new ArrayList<String>();
	static int count=0;
	static boolean[] visited;
	static int max;
	static int leader;
	static int geshu;
	static int zongshu;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		int N=Integer.parseInt(split[0]);
		int K=Integer.parseInt(split[1]);
		Matrix=new int[2000][2000];
		minutes=new int[2000];
		for (int i = 0; i < N; i++) {
			String[] split2 = reader.readLine().split("\\s");
			int a=getindex(split2[0]);
			int b=getindex(split2[1]);
			int time=Integer.parseInt(split2[2]);
			Matrix[a][b]+=time;
			Matrix[b][a]+=time;
			minutes[a]+=time;
			minutes[b]+=time;
		}
		reader.close();
		visited=new boolean[count];
		int numgangs=0;
		HashMap<String, Integer> result=new HashMap<String,Integer>();
		for (int i = 0; i < count; i++) {
			if (!visited[i]) {
				max=0;
				leader=0;
				geshu=0;
				zongshu=0;
				dfs(i);
				if (zongshu>K&&geshu>2) {
					numgangs++;
					result.put(inttostring.get(leader),geshu);
				}
			}
		}
		System.out.println(numgangs);
		ArrayList<String> list = new ArrayList<String>(result.keySet());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)+" "+result.get(list.get(i)));
		}
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		if (visited[i]) {
			return;
		}
		if (max<minutes[i]) {
			max=minutes[i];
			leader=i;
		}
		geshu+=1;
		visited[i]=true;
		for (int j = 0; j < count; j++) {
			if (Matrix[i][j]>0) {
				//System.out.println(i+" "+j);
				zongshu+=Matrix[i][j];
				Matrix[i][j]=Matrix[j][i]=0;
				dfs(j);
			}
		}
	}
	private static int getindex(String string) {
		// TODO Auto-generated method stub
		if (!stringtoint.containsKey(string)) {
			inttostring.add(string);
			stringtoint.put(string, count++);
		}
		return stringtoint.get(string);
	}

}
