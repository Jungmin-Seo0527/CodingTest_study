package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ13398_연속합2
public class BOJ13398_연속합2
{
	private static int num;
	private static int [ ] [ ] dp;
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num + 1 ] [ 2 ];
		dp [ 0 ] [ 0 ] = 0;
		dp [ 0 ] [ 1 ] = 0;
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 1; i <= num; i++)
		{
			dp [ i ] [ 0 ] = Integer.parseInt (st.nextToken ( ));
			
		}
		solve (num);
		System.out.println (sb);
	} //// end main
	
	private static void solve(int _n)
	{
		int ret = dp [ 1 ] [ 0 ];
		for (int i = 2; i <= _n; i++)
		{
			int temp = dp [ i ] [ 0 ];
			if (dp [ i - 1 ] [ 0 ] + dp [ i ] [ 0 ] > dp [ i ] [ 0 ])
			{
				dp [ i ] [ 0 ] = dp [ i - 1 ] [ 0 ] + dp [ i ] [ 0 ];
			}
			dp [ i ] [ 1 ] = Math.max (dp [ i - 2 ] [ 0 ], dp [ i - 1 ] [ 1 ]) + temp;
			
			ret = Math.max (dp [ i ] [ 0 ], ret);
			ret = Math.max (dp [ i ] [ 1 ], ret);
		}
		sb.append (ret);
	}
	
} //// end class
