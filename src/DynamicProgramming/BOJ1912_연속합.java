package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1912_연속합
// 지금까지 더한 값 vs 현재 값
public class BOJ1912_연속합
{
	private static int num;
	private static int [ ] dp;
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num ];
		
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < num; i++)
		{
			dp [ i ] = Integer.parseInt (st.nextToken ( ));
		}
		solve (num);
		System.out.println (sb);
	} //// end main
	
	private static void solve(int _n)
	{
		int ret = dp [ 0 ];
		for (int i = 1; i < _n; i++)
		{
			if (dp [ i - 1 ] + dp [ i ] > dp [ i ])
			{
				dp [ i ] = dp [ i - 1 ] + dp [ i ];
			}
			ret = Math.max (dp [ i ], ret);
		}
		sb.append (ret);
	}
	
} //// end class
