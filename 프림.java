package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.omg.CORBA.OMGVMCID;

import static java.lang.Integer.parseInt;



class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(BUFFERED_READER.readLine());
		int [][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		StringTokenizer stringTokenizer = null;
		for(int i=0; i < N; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for(int j=0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0;
		
		for(int c=0; c < N; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			// 신장트리에 연결되지 않은 정점중 minEdge 비용이 최소인 정점  
			for(int i=0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min =  minEdge[i];
					minVertex = i;
				}
			}
			result += min;
			visited[minVertex] = true;
			
			for(int i=0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		
		
	}
	
}
