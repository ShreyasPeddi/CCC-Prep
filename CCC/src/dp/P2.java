package dp;
import java.util.Arrays;
import java.util.Scanner;

//https://dmoj.ca/problem/dmopc19c2p2
public class P2 {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		//Input
		int N=input.nextInt();
		int M=input.nextInt();
		
		int grid[][]=new int[N+1][M+1];
		int dp[][]=new int[N+1][M+1];
		
		//Input
		for(int row=1;row<=N;row++) 
			for(int col=1;col<=M;col++) 
				grid[row][col]=input.nextInt();
			
		
		//Base Case: Accumulate the first row with the minimum cost to get there(accumulate sums)
		int accum=0;
		for(int i=1;i<=M;i++) {
			dp[1][i]=accum+grid[1][i];
			accum+=grid[1][i];
		}
		
		accum=0;
		
		//Base Case: Accumulate the first col with the minimum cost to get there(accumulate sums)
		for(int i=1;i<=N;i++) {
			dp[i][1]=accum+grid[i][1];
			accum+=grid[i][1];
		}
		
		//Populate the rest of the dp array
		for(int row=2;row<=N;row++) {
			
			for(int col=2;col<=M;col++) {
				
				//Mimimum cost of current cell is the minimum cost of the cell above/right + cost of current cell
				dp[row][col]=min(dp[row-1][col], dp[row][col-1])+grid[row][col];
			}
		}
		
		System.out.println(dp[N][M]);

	}
	
	public static int min(int x, int y) {
		if(x>y) return y;
		else return x;
	}

}
