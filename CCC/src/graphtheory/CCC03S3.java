package graphtheory;

import java.util.Arrays;
import java.util.Scanner;

public class CCC03S3 {

	private static char floorPlan[][];
	private static int adj[][];
	private static int ROWS;
	private static int COLS;
	private static boolean vis[][];
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int flooring = input.nextInt();
		ROWS = input.nextInt();
		COLS = input.nextInt();
		adj = new int[ROWS][COLS];
		vis = new boolean[ROWS][COLS];
		
		floorPlan = new char[ROWS][COLS];
		int roomsInstalled=0;
		
		//Input the floor plan
		for(int row=0; row<14;row++) {
			String line = input.next();
			
			for(int col=0;col<16;col++) {
				
				floorPlan[row][col]=line.charAt(col);
				
			}
		}
		
		//Traverse through the floor
		for(int row=0; row<14;row++) {
			
			for(int col=0;col<16;col++) {
				
				if(floorPlan[row][col]=='.') {
					
					
					
					checkConnectivity(row,col);
					
					
				}
				
			}
		}
		
	
		
		System.out.println(Arrays.deepToString(adj));
	}
	private static void checkConnectivity(int row, int col) {
		
		if(isValid(row+1,col) && floorPlan[row+1][col]=='.') 
			adj[row+1][col]=1;
		
		if(isValid(row-1,col) && floorPlan[row-1][col]=='.') 
			adj[row-1][col]=1;
		
		if(isValid(row,col+1) && floorPlan[row][col+1]=='.') 
			adj[row][col+1]=1;
		
		if(isValid(row,col-1) && floorPlan[row][col-1]=='.') 
			adj[row][col-1]=1;
		
		
		
	}
	private static boolean isValid(int row, int col) {
		
		return (row<=ROWS) && (row>=0) && (col<=COLS) && (col>=0);
	}

}
