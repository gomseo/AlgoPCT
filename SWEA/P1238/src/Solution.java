//import java.util.ArrayList;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.Scanner;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Solution {
//	
//	static List<Integer>[] link;
//	static boolean[] people;
//	
//	static Queue<Integer> contact;
//	static PriorityQueue<Integer> answer;
//		
//	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("src/input.txt"));
//		
//		//BFS 구현
//		for(int t=1;t<=10;t++) {
//			int N = sc.nextInt();
//			int start = sc.nextInt();
//
//			link = new ArrayList[101];
//			for(int i=0;i<link.length;i++) {
//				link[i] = new ArrayList<>();
//			}
//			
//			for(int n=0;n<N/2;n++) {
//				link[sc.nextInt()].add(sc.nextInt());
//			}
//			
//			people = new boolean[101];
//			contact = new LinkedList<>();
//						
//			contact.offer(start);
//			bfs(start);
//			System.out.println("#"+t+" "+answer.poll());
//			
//		}
//	}
//	
//	static void bfs(int i) {
//		// 종료 조건 -> contact.isEmpty()
//		while(!contact.isEmpty()) {
//			int l = contact.size();
//			answer = new PriorityQueue<>(Collections.reverseOrder());  // 매 레벨마다 새로운 큐 생성
//			for(int j=0;j<l;j++) {
//				int node = contact.poll();
//				people[node]=true; // 부모 노드 방문 처리
//				if(!link[node].isEmpty()) {
//					//자식 노드가 있으면
//					for(int k=0;k<link[node].size();k++) {
//						// 방문 안 한 노드에 대해서(boolean값이 false)
//						int node2 = link[node].get(k);
//						if(!people[node2]) {
//							people[node2]=true; // 연결 노드 방문처리 후
//							contact.offer(node2); // 큐에 넣기
//						}
//					}
//				}else{ 
//					// 연결 노드가 없으면(마지막 노드)
//					answer.offer(node);
//					
//				}
//			}
//		}		
//	}
//	
//}

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    
    static List<Integer>[] link;
    static boolean[] people;
    
    static Queue<Integer> contact;
    static PriorityQueue<Integer> answer;
        
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/input.txt"));
        
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
                        
            contact.offer(start);
            people[start] = true;  // 시작 노드를 방문처리
            bfs();
            System.out.println("#"+t+" "+answer.poll());
        }
        sc.close();
    }
    
    static void bfs() {
        while(!contact.isEmpty()) {
            int l = contact.size();
            answer = new PriorityQueue<>(Collections.reverseOrder());  // 매 레벨마다 새로운 큐 생성
            for(int j=0;j<l;j++) {
                int node = contact.poll();
                answer.offer(node);  // 현재 레벨의 모든 노드를 answer 큐에 추가
                for(int neighbor : link[node]) {
                    if(!people[neighbor]) {
                        people[neighbor] = true;
                        contact.offer(neighbor);
                    }
                }
            }
        }        
    }
}

