package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ15989_123더하기4
public class BOJ15989_123더하기4
{
	private static final int SZ = 10001;
	private static int [ ] dp = new int [ SZ ];
	
	//private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int testCase = Integer.parseInt (st.nextToken ( ));
		
		dp [ 0 ] = 1;
		for (int t = 0; t < testCase; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int input = Integer.parseInt (st.nextToken ( ));
			solve (input);
			reset (input);
		}
	} //// end main;
	
	private static void solve(int end)
	{
		for (int i = 1; i <= 3; i++)
		{
			for (int j = i; j <= end; j++)
			{
				dp [ j ] += dp [ j - i ];
			}
		}
		System.out.println (dp [ end ]);
	}
	
	private static void reset(int end)
	{
		for (int i = 1; i <= end; i++)
		{
			dp [ i ] = 0;
		}
	}
	
} //// end class
