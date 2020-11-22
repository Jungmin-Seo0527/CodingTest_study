package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ15990_123더하기5
public class BOJ15990_123더하기5
{
	private static final int N = 1000000009;
	private static final int SZ = 100001;
	private static int [ ] [ ] dp = new int [ SZ ] [ 3 ];
	private static boolean [ ] visited = new boolean [ SZ ];
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int testCase = Integer.parseInt (st.nextToken ( ));
		for (int t = 0; t < testCase; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int input = Integer.parseInt (st.nextToken ( ));
			
			dp [ 0 ] [ 1 ] = 1;
			dp [ 1 ] [ 0 ] = 1;
			dp [ 2 ] [ 1 ] = 1;
			
			solve (input);
		}
		System.out.println (sb);
	} //// end main
	
	private static void solve(int _n)
	{
		for (int i = 3; i <= _n; i++)
		{
			if (! visited [ i ])
			{
				for (int j = 0; j < 3; j++)
				{
					dp [ i ] [ j ] = (dp [ i - j - 1 ] [ (j + 1) % 3 ] + dp [ i - j - 1 ] [ (j + 2) % 3 ]) % N;
				}
				visited [ i ] = true;
			}
		}
		
		int ret = ((dp [ _n ] [ 0 ] + dp [ _n ] [ 1 ]) % N + dp [ _n ] [ 2 ]) % N;
		sb.append (ret + "\n");
	}
	
} //// end class