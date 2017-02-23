package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class WaitinginLine_1014 {
	public static class line{
		Queue<Integer> people=new LinkedList<Integer>();
		int poptime;
		int endtime;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		int N=Integer.parseInt(split[0]);
		int M=Integer.parseInt(split[1]);
		int K=Integer.parseInt(split[2]);
		int Q=Integer.parseInt(split[3]);
		String[] split2 = reader.readLine().split("\\s");
		int[] customers=new int[K];
		for (int i = 0; i < K; i++) {
			customers[i]=Integer.parseInt(split2[i]);
		}
		int[] result=new int[K];
		boolean[] islate=new boolean[K];
		line[] window=new line[N];
		for (int i = 0; i < window.length; i++) {
			window[i]=new line();
		}
		int count=0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (count<K) {
					if (window[j].endtime>=540) {
						islate[count]=true;
					}
					window[j].endtime+=customers[count];
					result[count]=window[j].endtime;
					window[j].people.add(customers[count]);
					if (i==0) {
						window[j].poptime=customers[count];
					}
				}
				count++;
			}
		}
		while (count<K) {
			int minwindow=0;
			for (int i = 1; i < N; i++) {
				if (window[i].poptime<window[minwindow].poptime) {
					minwindow=i;
				}
			}
//			System.out.println(minwindow);
//			System.out.println(window[minwindow].poptime);
//			System.out.println(window[minwindow].endtime);
			if (window[minwindow].endtime>=540) {
				islate[count]=true;
			}
			window[minwindow].endtime+=customers[count];
			result[count]=window[minwindow].endtime;
			window[minwindow].people.poll();
			window[minwindow].people.add(customers[count]);
			window[minwindow].poptime+=window[minwindow].people.peek();
			count++;
		}
		
		String[] split3 = reader.readLine().split("\\s");
		for (int i = 0; i < Q; i++) {
			int query=Integer.parseInt(split3[i]);
			if (islate[query-1]) {
				System.out.println("Sorry");
			}else {
				System.out.println(totime(result[query-1]));
			}
		}
		reader.close();
	}

	private static String totime(int i) {
		// TODO Auto-generated method stub
		String minute=String.valueOf(i%60);
		String hour=String.valueOf(i/60+8);
		if (minute.length()==1) {
			minute="0"+minute;
		}
		if (hour.length()==1) {
			hour="0"+hour;
		}
		return hour+":"+minute;
	}

}
