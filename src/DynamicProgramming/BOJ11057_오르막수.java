package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ11057_오르막수
public class BOJ11057_오르막수
{
	private static int [ ] [ ] dp;
	private static final int N = 10007;
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num + 1 ] [ 10 ];
		dp [ 0 ] [ 9 ] = 1;
		solve (num);
		
		System.out.println (sb);
		
	} //// end main
	
	private static void solve(int _n)
	{
		for (int i = 1; i <= _n; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = j; k < 10; k++)
				{
					dp [ i ] [ j ] = (dp [ i ] [ j ] + dp [ i - 1 ] [ k ]) % N;
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < 10; i++)
		{
			ret = (ret + dp [ _n ] [ i ]) % N;
		}
		sb.append (ret);
	}
	
} //// end class