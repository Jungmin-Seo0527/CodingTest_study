package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ2193_이친수
public class BOJ2193_이친수
{
	private static long [ ] [ ] dp;
	
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		dp = new long [ num + 1 ] [ 2 ];
		dp [ 1 ] [ 1 ] = 1;
		solve (num);
		System.out.println (sb);
	} //// end main
	
	private static void solve(int _n)
	{
		long ret = 1;
		for (int i = 2; i <= _n; i++)
		{
			dp [ i ] [ 0 ] = dp [ i - 1 ] [ 0 ] + dp [ i - 1 ] [ 1 ];
			dp [ i ] [ 1 ] = dp [ i - 1 ] [ 0 ];
			ret = dp [ i ] [ 0 ] + dp [ i ] [ 1 ];
		}
		sb.append (dp [ _n ] [ 0 ] + dp [ _n ] [ 1 ]);
	}
	
} //// end class