import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] xrange = new int[101];
		int[] yrange = new int[101];
		
		// 색종이 한장 붙여놓고 시작
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		for(int i=x;i<=x+10;i++) {
			xrange[i]=1;
		}
		for(int i=y;i<=y+10;i++) {
			yrange[i]=1;
		}
		
		// 뺄 범위 선택
		int sum=0;
		for(int n=1;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int xmin=101, ymin=101, xmax=-1, ymax=-1;
			int xsum=0, ysum=0;
			boolean xstart=false, ystart=false;
			for(int i=x;i<=x+10;i++) {
				if(xrange[i]==1) {
					xmin = i<xmin? i:xmin;
					xmax = i>xmax? i:xmax;
					xstart=true;
				} else if(xrange[i]==0 && xstart==true) {
					xsum+=(xmax-xmin);
					xstart=false;
					xmin=101; xmax=-1;
				} if(i==x+10 && xstart==true) {
					xsum+=xmax-xmin;
					}
				
				xrange[i]=1;
			}
			for(int i=y;i<=y+10;i++) {
				if(yrange[i]==1) {
					ymin = i<ymin? i:ymin;
					ymax = i>ymax? i:ymax;
					ystart=true;
				} else if(yrange[i]==0 && ystart==true) {
					ysum+=(ymax-ymin);
					ystart = false;
					ymin=101; ymax=-1;
				} if(i==y+10 && ystart==true) {
					ysum+=ymax-ymin;
					}
				
				yrange[i]=1;
			}
			sum += xsum+ysum;
		}
		
		System.out.println(40*N-sum*2); 
		
	}

}
