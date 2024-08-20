import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] arr = new int[10];
		for(int t=1;t<=T;t++) {
			
			for(int i=0;i<10;i++) {
				arr[i] = sc.nextInt();
			}
			
			int max=arr[0], min=arr[0], maxidx=0, minidx=0; 
			for(int i=1;i<10;i++) {
				if(arr[i]>max) {max=arr[i]; maxidx=i;}
				if(arr[i]<min) {min=arr[i]; minidx=i;}
			}
			double sum=0; // double형으로 지정해놔야 반올림 값 산출 가능
			for(int i=0;i<10;i++) {
				if(i!=maxidx &&i!=minidx) sum+=arr[i];
			}
			System.out.printf("#"+t+" "+Math.round(sum/8));
			System.out.println();
			
		}
		
	}

}
