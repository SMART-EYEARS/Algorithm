package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder STRING_BUILDER = new StringBuilder();
	private static StringTokenizer stringTokenizer;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.valueOf(BUFFERED_READER.readLine());
		int[][] adjMatrix = new int[n][n];
		boolean[] visited = new boolean[n];
		int[] minEdge = new int[n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = Integer.valueOf(stringTokenizer.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result = 0;
		minEdge[0] = 0;

		for (int c = 0; c < n; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int i = 0; i < n; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			result += min;
			visited[minVertex] = true;

			for (int i = 0; i < n; i++) {
				if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}

}
