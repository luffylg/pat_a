package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QueueingatBank_1017 {
	public static class customer implements Comparable<customer>{
		int arrivetime=0;
		int handlingtime=0;
		@Override
		public int compareTo(customer o) {
			// TODO Auto-generated method stub
			return this.arrivetime-o.arrivetime;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = reader.readLine().split("\\s");
		int N=Integer.parseInt(split[0]);
		int K=Integer.parseInt(split[1]);
		customer[] customers=new customer[N];
		for (int i = 0; i < customers.length; i++) {
			customers[i]=new customer();
		}
		int[] window=new int[K];
		for (int i = 0; i < N; i++) {
			String[] split2 = reader.readLine().split("\\s");
			customers[i].arrivetime=getseconds(split2[0]);
			customers[i].handlingtime=Integer.parseInt(split2[1])*60;
		}
		reader.close();
		Arrays.sort(customers);
//		for (int i = 0; i < customers.length; i++) {
//			System.out.print(customers[i].arrivetime+" ");
//		}
//		System.out.println();
//		System.out.println(customers[50].arrivetime);
//		System.out.println(customers[51].arrivetime);
		int waitseconds=0;
		int count=0;
		for (int i = 0; i < N; i++) {
			int minwindow=0;
			for (int j = 0; j < K; j++) {
				if (window[j]<window[minwindow]) {
					minwindow=j;
				}
			}
			//System.out.println(window[minwindow]);
			if (customers[i].arrivetime>=32401) {
				break;
			}
//			if (window[minwindow]>=32401) {
//				waitseconds+=32400-customers[i].arrivetime;
//				count++;
//				continue;
//			}
			if (customers[i].arrivetime<window[minwindow]) {
				waitseconds+=(window[minwindow]-customers[i].arrivetime);
				window[minwindow]+=customers[i].handlingtime;
			}else {
				window[minwindow]=customers[i].arrivetime+customers[i].handlingtime;
			}
			count++;
		}
		double average=(double)waitseconds/60.0/count;
		System.out.println(String.format("%.1f", average));
//		System.out.println(count);
//		System.out.println(average);
//		System.out.println(waitseconds);
	}

	private static int getseconds(String string) {
		// TODO Auto-generated method stub
		String[] sp=string.split(":");
		//System.out.println((Integer.parseInt(sp[0])-8)*3600+Integer.parseInt(sp[1])*60+Integer.parseInt(sp[2]));
		return (Integer.parseInt(sp[0])-8)*3600+Integer.parseInt(sp[1])*60+Integer.parseInt(sp[2]);
	}


}
