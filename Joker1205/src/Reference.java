import java.io.*;
import java.util.*;

public class Reference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr); // Sort the array
        
        int zeroCount = 0;
        for(int num : arr) {
            if (num == 0) zeroCount++;
        }
        
        // If the array consists entirely of zeros
        if (zeroCount == arr.length) {
            System.out.println(arr.length);
            return;
        }
        
        int maxLen = 0, currentLen = 0, remainingZeros = zeroCount;
        
        for (int i = zeroCount; i < N; i++) {
            if (i == zeroCount || arr[i] == arr[i - 1] + 1) {
                currentLen++;
            } else if (arr[i] == arr[i - 1]) {
                continue; // Skip duplicate elements
            } else {
                int gap = arr[i] - arr[i - 1] - 1;
                if (gap <= remainingZeros) {
                    currentLen += gap + 1;
                    remainingZeros -= gap;
                } else {
                    maxLen = Math.max(maxLen, currentLen + remainingZeros);
                    remainingZeros = zeroCount;
                    currentLen = 1;
                }
            }
        }
        
        maxLen = Math.max(maxLen, currentLen + remainingZeros);
        
        System.out.println(maxLen);
    }
}
