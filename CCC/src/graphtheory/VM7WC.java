package graphtheory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VM7WC {

	static ArrayList<Integer> adj[];
	static boolean vis[];
	static int dis[];
	static int prev[];
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int A = input.nextInt();
		int B = input.nextInt();
		
		adj = new ArrayList[N+1];
		vis = new boolean[N+1];
		dis= new int[N+1];
		prev = new int[N+1];
		
		for(int i=0;i<=N;i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			int k = input.nextInt();
			int j = input.nextInt();
			adj[k].add(j);
			adj[j].add(k);
		}
		
		if(A==B) {
			System.out.println("GO SHAHIR!");
		}
		else if(bfs(A,B))
			System.out.println("GO SHAHIR!");
		else
			System.out.println("NO SHAHIR!");
	}

	private static boolean bfs(int start, int end) {
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.add(start);
		vis[start]=true;
		
		
		while(!Q.isEmpty()) {
			
			int curr = Q.poll();

			for(int node: adj[curr]) {
				
				if(node==end)
					return true;
				
				if(!vis[node]) {
					
					vis[node] = true;
					Q.add(node);
					dis[node]=dis[curr]+1;
					prev[node] = curr;
				}
			}
			
		}
		return false;
		
		
	}

}
