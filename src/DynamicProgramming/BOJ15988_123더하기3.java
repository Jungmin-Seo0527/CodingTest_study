package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ15988_123더하기3
public class BOJ15988_123더하기3
{
	private static long [ ] dp;
	private static final int N = 1000000009;
	private static final int SZ = 1000000;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int testCase = Integer.parseInt (st.nextToken ( ));
		dp = new long [ SZ ];
		dp [ 0 ] = 1;
		dp [ 1 ] = 2;
		dp [ 2 ] = 4;
		for (int t = 0; t < testCase; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int input = Integer.parseInt (st.nextToken ( ));
			solve (input);
			System.out.println (dp [ input - 1 ] % N);
		}
		
	} //// end main
	
	private static void solve(int _n)
	{
		for (int i = 3; i < _n; i++)
		{
			if (dp [ i ] == 0)
			{
				dp [ i ] = (dp [ i - 1 ] + dp [ i - 2 ] + dp [ i - 3 ]) % N;
			}
		}
	}
} //// end class
