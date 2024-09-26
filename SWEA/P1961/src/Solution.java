import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			int[][] arr1 = rotate(arr, N);
			int[][] arr2 = rotate(arr1, N);
			int[][] arr3 = rotate(arr2, N);
			
			// 출력
//			System.out.printf("#%d",tc);
//            System.out.println();
//			for(int i=0;i<arr.length;i++) {
//				System.out.print(Arrays.toString(arr1[i])+" "+Arrays.toString(arr2[i])+" "+Arrays.toString(arr3[i]));
//				System.out.println();
//			}				
			
			
			System.out.printf("#%d",tc);
			System.out.println();
			StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < arr1.length; i++) {
	            sb.append(arrayToString(arr1[i])).append(" ")
	              .append(arrayToString(arr2[i])).append(" ")
	              .append(arrayToString(arr3[i])).append("\n");
	        }

	        System.out.print(sb.toString());
	    }
	}

	    private static String arrayToString(int[] array) {
	        StringBuilder sb = new StringBuilder();
	        for (int num : array) {
	            sb.append(num);
	        }
	        return sb.toString();
			
			
		
}
	public static int[][] rotate(int[][] arr, int N){
		int[][] arrcopy = new int[N][N];
		// 90도
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				 arrcopy[j][arr.length-1-i] = arr[i][j];
			}	
		}
		return arrcopy;
	}
}
