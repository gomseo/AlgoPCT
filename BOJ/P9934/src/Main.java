import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int K;
	static int[] numarr;
	static List<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		numarr = new int[(int) Math.pow(2, K)];
		for(int i=0;i<Math.pow(2, K)-1;i++) {
			numarr[i]=sc.nextInt();
		}
		list = new ArrayList[K+1];
		for(int i=1;i<=K;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		dfs(0,(int)Math.pow(2, K)-2,1);
		
		for(int i=1;i<=K;i++) {
			for(int j : list[i]) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
	}
	public static void dfs(int start, int end, int depth) {
		if(start==end) {
			list[depth].add(numarr[start]);
			return;
		}
		else if(start<end) {
			int mid = (start+end)/2;
			list[depth].add(numarr[mid]);
			dfs(start,mid-1,depth+1);
			dfs(mid+1,end,depth+1);
		}
	}
}
