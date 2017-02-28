package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeTraversals_1020 {
	static int[] post;
	static int[] in;
	static int[] level;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		post=new int[N];
		in=new int[N];
		String[] split1 = reader.readLine().split("\\s");
		String[] split2 = reader.readLine().split("\\s");
		for (int i = 0; i < N; i++) {
			post[i]=Integer.parseInt(split1[i]);
			in[i]=Integer.parseInt(split2[i]);
		}
		reader.close();
		level=new int[100000];
		for (int i = 0; i < level.length; i++) {
			level[i]=-1;
		}
		getpre(N-1,0,N-1,0);
		int count=0;
		for (int i = 0; i < level.length; i++) {
			if (level[i]!=-1) {
				count++;
				if (count!=N) {
					System.out.print(level[i]+" ");
				}else {
					System.out.println(level[i]);
					break;
				}
			}
		}
	}

	private static void getpre(int root, int start, int end, int index) {
		// TODO Auto-generated method stub
		if (start>end) {
			return;
		}
		int root4in=-1;
		for (int i = start; i <=end; i++) {
			if (in[i]==post[root]) {
				root4in=i;
				break;
			}
		}
		level[index]=in[root4in];
		getpre(root-end+root4in-1, start, root4in-1, 2*index+1);
		getpre(root-1, root4in+1, end,2*index+2);
	}

}
