package dp;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		//Total number of Items
		int numOfItems=readInt();
		
		//Total weight allowed in the knapsack
		int sizeOfKnapsack=readInt();
		
		//value of each item
		int v[]=new int[numOfItems+1];
		
		//weight of each item
		int w[]= new int[numOfItems+1];
		
		//dp array stores max value given value and weight of an object
		long dp[][]=new long[numOfItems+1][sizeOfKnapsack+1];
		
		//Input: Value and weight for each item
		for(int item=1;item<=numOfItems;item++) {
			w[item]=readInt();
			v[item]=readInt();
		}
		
		//Iterate through each item
		for(int i=1;i<=numOfItems;i++) {
			
			//Iterate through each possible weight(0-size of knapsack)
			for(int j=1;j<=sizeOfKnapsack;j++) {
				
				//If it is possible to store the current item, then pick the max between 1.)the sum of current item value and 
				//value above it subtracted the weight or 2.)the value right above it
				if (j>=w[i])
					dp[i][j]=Math.max(dp[i-1][j],v[i]+dp[i-1][j-w[i]]);
				
				//If the current item's weight is greater than the max size of knapsack, do not include the current item
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		
		System.out.println(dp[numOfItems][sizeOfKnapsack]);


	}
	
	   static String next () throws IOException {
	       while (st == null || !st.hasMoreTokens())
	            st = new StringTokenizer(br.readLine().trim()); 
	        return st.nextToken();
	    }
	    static long readLong () throws IOException {
	        return Long.parseLong(next());
	    }
	    static int readInt () throws IOException {
	        return Integer.parseInt(next());
	    }
	    static double readDouble () throws IOException {
	        return Double.parseDouble(next());
	    }
	    static String readLine () throws IOException {
	        return br.readLine().trim();
	    }

}
