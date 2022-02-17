import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 14002 가장 긴 증가하는 부분수열4 (dp)

public class B14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = -1;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		int m = max;
		for(int i = n-1; i >= 0; i--) {
			if(dp[i] == m) {
				sb.insert(0, arr[i] + " ");
				m--;
			}
		}		
		sb.insert(0, max + "\n");
		
		System.out.print(sb);		
	}
}
