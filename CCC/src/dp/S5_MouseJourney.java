package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_MouseJourney {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		
		//Input
		int rowSize=readInt();
		int colSize=readInt();
		
		int[][] dp = new int[rowSize+1][colSize+1];
		
		int numOfCats=readInt();
		
		int row,col;
		for(int i=1;i<=numOfCats;i++) {
			
			row=readInt();
			col=readInt();
			
			//Set the location of cat as 0
			dp[row][col]=-1;
		}
		
		
		//Base case
		dp[1][1]=1;
		
		//Processing
		//Iterate through the dp array and fill values by adding the element above it and beside it(left)
		for(int r=1;r<=rowSize;r++) {
			
			for(int c=1;c<=colSize;c++) {
				
				//If current element does not have a cat
				if(dp[r][c]!=-1) {
			
					//If the element beside does not have a cat, there is a way to come to this box
					if(dp[r][c-1]!=-1)
						dp[r][c]+=dp[r][c-1];
					
					//If the element above does not have a cat, there is a way to come to this box
					if(dp[r-1][c]!=-1)
						dp[r][c]+=dp[r-1][c];
				}
			}
		}
		
		//Output
		System.out.println(dp[rowSize][colSize]);
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
