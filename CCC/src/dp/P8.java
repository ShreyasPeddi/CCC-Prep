package dp;
import java.util.Arrays;
import java.util.Scanner;

//https://dmoj.ca/problem/si17c1p8
public class P8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N=input.nextInt();
		int T=input.nextInt();
		
		int dp[][]=new int[N+1][T+1];
		int val[]=new int[N+1];
		
		for(int i=0;i<T;i++) {
			dp[0][i]=0;
		}
		
		for(int i=0;i<=N;i++) {
			dp[i][0]=1;
		}
		
		for(int i=1;i<=N;i++) {
			val[i]=input.nextInt();
		}
		
		//if arr item is equals or less than the target sum, add the number above it and the number 'item' units to the left

		
		for(int item=1;item<=N;item++) {
			
			for(int target=1;target<=T;target++) {
			
				if(val[item]>target)
					dp[item][target]=dp[item-1][target];
				
				else
					dp[item][target]=dp[item-1][target]+dp[item-1][target-val[item]];
				
			}
		}
		
		System.out.println(dp[N][T]);
	}

}
