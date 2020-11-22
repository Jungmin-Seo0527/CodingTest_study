package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1932_Á¤¼ö_»ï°¢Çü
public class BOJ1932_Á¤¼ö_»ï°¢Çü
{
	private static int num;
	private static int [ ] [ ] dp;
	private static int big = Integer.MIN_VALUE;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num ] [ num ];
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j <= i; j++)
			{
				dp [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		for (int i = 1; i < num; i++)
		{
			doSol (i);
		}
		for (int i = 0; i < num; i++)
		{
			big = (big < dp [ num - 1 ] [ i ]) ? dp [ num - 1 ] [ i ] : big;
		}
		System.out.println (big);
	} // end main

	private static void doSol(int _idx)
	{
		dp [ _idx ] [ 0 ] += dp [ _idx - 1 ] [ 0 ];
		dp [ _idx ] [ _idx ] += dp [ _idx - 1 ] [ _idx - 1 ];
		if (_idx > 1)
		{
			for (int i = 1; i < _idx; i++)
			{
				dp [ _idx ] [ i ] += Integer.max (dp [ _idx - 1 ] [ i - 1 ], dp [ _idx - 1 ] [ i ]);
			}
		}
	}

} //// end class