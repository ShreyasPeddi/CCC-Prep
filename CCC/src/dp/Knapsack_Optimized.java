package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Knapsack_Optimized {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		//Read the input
		int N = readInt();
		int W = readInt();
		
		//Store the value of each item
		int[] v = new int[N + 1];
		
		//Store the weight of each item
		int[] w = new int[W + 1];
		
		//DP to compute the problem and store the solution
		long[] dp = new long[W + 1];
		
		
		//reads the values and weights of each item
		for (int i = 1; i <= N; i++) { 
		            w[i] = readInt();
		            v[i] = readInt();
		}
		
		//Outer loop starting from each item 1
		for (int i = 1; i <= N; i++) {
			
			//Reuse the same dp array to store values
            for (int j = W; j>=w[i]; j--) {
            		
            	//If it is possible to store the current item, then pick the max between 1.)the sum of current item value and 
				//value above it subtracted the weight or 2.)the value right above it
            		dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            		
            }
		}
		System.out.println(dp[W]); //Prints the maximum value that the knapsack can hold


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
