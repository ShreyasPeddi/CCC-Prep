package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_CombiningRiceballs {
	
	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		//Get user input
		long numOfRiceBalls = readInt();
		long[][]dp = new long[(int) (numOfRiceBalls+1)][(int) (numOfRiceBalls+3)];
		
		for(int i=1;i<=numOfRiceBalls;i++) {
			dp[1][i]= readInt();
			
		}
		
		int bottomPointer=1;
		int col=1;
		boolean combined=false;
		int lastRow=0;
		for(int row=1;row<numOfRiceBalls;row++) {
			
			while(col<=numOfRiceBalls) {
				
				if(dp[row][col]==0)
					col=(int) (numOfRiceBalls+1);
				
				else if(dp[row][col]==dp[row][col+2]) {
					
					dp[row+1][bottomPointer++]=(dp[row][col]*2)+dp[row][col+1];
					col+=3;
					combined=true;
				}
				
				else if (dp[row][col]==dp[row][col+1]) {
					dp[row+1][bottomPointer++]=dp[row][col]*2;
					col+=2;
					combined=true;
				}
				
				else {
					dp[row+1][bottomPointer++]=dp[row][col];
					col++;
				}
				
			}	//End of inner loop
			
			if(!combined) {
				lastRow=row;
				break;
			}
			combined=false;
			bottomPointer=1;
			col=1;
		}
		
		//System.out.println(Arrays.deepToString(dp));
		int max=0;
		for(int i=1;i<=numOfRiceBalls;i++) {
			if(dp[lastRow][i]>max)
				max=(int) dp[lastRow][i];
		}
		
		System.out.println(max);

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
