package pata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;



public class DigitalLibrary_1022 {
	static HashMap<String,HashSet<Integer>>[] select;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		select=new HashMap[6];
		for (int i = 1; i <= 5; i++) {
			select[i]=new HashMap<String,HashSet<Integer>>();
			//System.out.println(select[i]);
			//select[i].put("cao", null);
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		for (int i = 0; i < N; i++) {
			int id=Integer.parseInt(reader.readLine());
			for (int j = 1; j < 6; j++) {
				if (j==3) {
					String[] split = reader.readLine().split("\\s");
					for (int k = 0; k < split.length; k++) {
						String title=split[k];
						if (!select[j].containsKey(title)) {
							select[j].put(title, new HashSet<Integer>());
						}
						select[j].get(title).add(id);
					}
				}else {
					String title=reader.readLine();
					if (!select[j].containsKey(title)) {
						select[j].put(title, new HashSet<Integer>());
					}
					select[j].get(title).add(id);
				}	
			}
		}
		int K=Integer.parseInt(reader.readLine());
		for (int i = 0; i < K; i++) {
			String target=reader.readLine();
			System.out.println(target);
			String[] split = target.split(":\\s");
			int num=Integer.parseInt(split[0]);
			if (!select[num].containsKey(split[1])) {
				System.out.println("Not Found");
				continue;
			}
			HashSet<Integer> result = select[num].get(split[1]);
			while (!result.isEmpty()) {
				int min=9999999;
				for (Integer integer : result) {
					if (integer<min) {
						min=integer;
					}
				}
				System.out.println(String.format("%07d", min));
				result.remove(min);
			}
		}
		reader.close();
	}

}
