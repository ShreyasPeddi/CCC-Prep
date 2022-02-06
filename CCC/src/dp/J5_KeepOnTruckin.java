package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class J5_KeepOnTruckin {

	static InputStreamReader is = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(is);
    static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> motelSpots = new ArrayList<Integer>();
		
		motelSpots.add(0);
		motelSpots.add(990);
		motelSpots.add(1010);
		motelSpots.add(1970);
		motelSpots.add(2030);
		motelSpots.add(2940);
		motelSpots.add(3060);
		motelSpots.add(3930);
		motelSpots.add(4060);
		motelSpots.add(4970);
		motelSpots.add(5030);
		motelSpots.add(5990);
		motelSpots.add(6010);
		motelSpots.add(7000);
		
		
		
		int A=readInt();
		int B=readInt();
		int numOfExtraMotels = readInt();
		
		for(int i=0;i<numOfExtraMotels;i++) {
			motelSpots.add(readInt());
		}
		
		Collections.sort(motelSpots);
		
		long dp[] = new long[motelSpots.size()];
		long diff;
		
		//Base Case
		dp[0]=1;
		
		
		for(int index=1;index<motelSpots.size();index++) {
			
			for(int j=0;j<index;j++) {
				diff=motelSpots.get(index)-motelSpots.get(j);
				
				if(diff<=0)
					continue;
				if(diff>=A && diff<=B)
					dp[index]+=dp[j];
				
			}	//End of inner loop
			
		}	//End of outer loop
		
		System.out.println(dp[motelSpots.size()-1]);
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
