package pata;

import java.util.Scanner;

public class MaximumSubsequenceSum_1007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int K=scanner.nextInt();
		int thissum=0;
		int sum=0;
		int[] rs=new int[K];
		for (int i = 0; i < K; i++) {
			rs[i]=scanner.nextInt();
		}
		scanner.close();
		int start=rs[0];
		int newstart=rs[0];
		int end=rs[K-1];
		for (int i = 0; i < K; i++) {
			if (thissum==0) {
				newstart = rs[i];
			}
			thissum+=rs[i];
			if (thissum<0) {
				thissum=0;
			}else {
				if (thissum>sum||sum==0&&rs[i]==0){
					start=newstart;
					sum=thissum;
					end=rs[i];
				}
			}
		}
		System.out.println(sum+" "+start+" "+end);
	}

}
