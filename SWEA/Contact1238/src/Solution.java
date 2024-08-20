import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static List<Integer>[] link;
	static boolean[] people;
	
	static Queue<Integer> contact;
	static PriorityQueue<Integer> answer;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//BFS 구현
		for(int t=1;t<=10;t++) {
			int N = sc.nextInt();
			int start = sc.nextInt();

			link = new ArrayList[101];
			for(int i=0;i<link.length;i++) {
				link[i] = new ArrayList<>();
			}
			
			for(int n=0;n<N/2;n++) {
				link[sc.nextInt()].add(sc.nextInt());
			}
			
			people = new boolean[101];
			contact = new LinkedList<>();
			answer = new PriorityQueue<>(Collections.reverseOrder());
			
			contact.offer(start);
			bfs(start);
			System.out.println("#"+t+" "+answer.poll());
			
		}
	}
	
	static void bfs(int i) {
		// 종료 조건 -> contact.isEmpty()
		while(!contact.isEmpty()) {
			int l = contact.size();
			for(int j=0;j<l;j++) {
				if(!link[contact.peek()].isEmpty()) {
					for(int k=0;k<link[contact.peek()].size();k++) {
						if(!people[link[contact.peek()].get(k)]) {
							people[link[contact.peek()].get(k)]=true;
							contact.offer(link[contact.peek()].get(k));
						}
					}
					contact.poll();
				}else { // 마지막 노드면 answer에 넣기
					people[contact.peek()]=true;
					answer.offer(contact.poll());
					
				}
			}
		}		
	}
	
}
