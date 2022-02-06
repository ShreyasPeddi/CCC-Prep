package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class S4_BridgeCrossing {

	
	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
    
	public static void main(String[] args) throws IOException {
		
		int M = readInt();
		int Q = readInt();
		HashMap<String,Integer> nameTime = new HashMap<String,Integer>();
		ArrayList<String> queue = new ArrayList<String>();		
		int dp[][] = new int[M+1][Q+1];
		queue.add("default");
		
		//INPUT
		for(int i=1;i<=Q;i++) {
			String name= next();
			int time = readInt();
			nameTime.put(name, time);
			queue.add(name);
		}
		
		boolean alternate=true;
		//Fill out the dp array. Choose the minimum of 1) value of the current person+ previous person 2)value of current person+ value of 2nd previous person
		for(int i=1;i<=M;i++) {
			
			for(int k=1;k<=Q;k++) {
				
				
				if(k<=i) {
					dp[i][k]=Math.max(dp[i][k-1],nameTime.get(queue.get(k)));
					
				}
				
				else if(k==i+1) {
					dp[i][k]= nameTime.get(queue.get(k))+dp[i][k-i];
					
					alternate=false;
				}
				else {
					if(!alternate) {
						dp[i][k]=nameTime.get(queue.get(k))+dp[i][k-1];
						alternate=true;
					}
					
					else
						dp[i][k]=nameTime.get(queue.get(k))+dp[i][k-i];
					
				}
				
			}
		}
		
		System.out.println(Arrays.deepToString(dp));
		
		
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
