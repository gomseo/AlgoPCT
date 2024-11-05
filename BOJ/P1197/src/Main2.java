import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
	public class Node {
		int from;
		int to;
		int point;
		Node(){}
		Node(int from, int to, int point){
			this.from=from;
			this.to=to;
			this.point=point;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0;i<E;i++) {
			Node n = new Node(sc.nextInt(),sc.nextInt(),sc.nextInt());
			list.add(n);
		}
	}
}
