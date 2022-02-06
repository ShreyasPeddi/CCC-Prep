package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_Golf {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {

		//INPUT
		int distance = readInt();
		int numOfClubs = readInt();
		int clubs[] = new int[numOfClubs+1];
		int[][]dp = new int[numOfClubs+1][distance+1];
		
		for(int i=1;i<=numOfClubs;i++) {
			clubs[i]=readInt();
		}
		
		//Initialize default values
		for(int i=1;i<=numOfClubs;i++)
			dp[i][clubs[i]]=1;
		
		//Start filling the dp array
		for(int row=1;row<=numOfClubs;row++) {
			
			for(int col=1;col<=distance;col++) {
				
				if(col==clubs[row])
					continue;
				
				if(col<clubs[row])
					dp[row][col]=dp[row-1][col];
				
				else if(dp[row][col-clubs[row]]!=0 && dp[row-1][col]!=0)
					dp[row][col]=Math.min(1+dp[row][col-clubs[row]], dp[row-1][col]);
				
				else if (dp[row][col-clubs[row]]!=0 && dp[row-1][col]==0)
					dp[row][col]=1+dp[row][col-clubs[row]];
				
				
				
				else
					dp[row][col]=dp[row-1][col];
			}
		}
		
		if(dp[numOfClubs][distance]==0)
			System.out.println("Roberta acknowledges defeat.");

		else
			System.out.println("Roberta wins in "+dp[numOfClubs][distance]+" strokes.");
		
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
