package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ9465_스티커
public class BOJ9465_스티커
{
	private static int [ ] [ ] dp;
	
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int tc = Integer.parseInt (st.nextToken ( ));
		for (int t = 0; t < tc; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int colSZ = Integer.parseInt (st.nextToken ( ));
			dp = new int [ 2 ] [ colSZ + 1 ];
			for (int j = 0; j < 2; j++)
			{
				st = new StringTokenizer (br.readLine ( ));
				for (int i = 1; i <= colSZ; i++)
				{
					dp [ j ] [ i ] = Integer.parseInt (st.nextToken ( ));
				}
			}
			solve (colSZ);
		}
		System.out.println (sb);
	} //// end main
	
	private static void solve(int _colSZ)
	{
		if (_colSZ == 1)
		{
			sb.append (Math.max (dp [ 0 ] [ 1 ], dp [ 1 ] [ 1 ]));
			return;
		}
		dp [ 0 ] [ 2 ] += dp [ 1 ] [ 1 ];
		dp [ 1 ] [ 2 ] += dp [ 0 ] [ 1 ];
		if (_colSZ == 2)
		{
			sb.append (Math.max (dp [ 0 ] [ 2 ], dp [ 1 ] [ 2 ]));
			return;
		}
		
		for (int i = 3; i <= _colSZ; i++)
		{
			for (int r = 0; r < 2; r++)
			{
				int temp = dp [ r ] [ i ] + Math.max (dp [ r ] [ i - 2 ], dp [ (r + 1) % 2 ] [ i - 2 ]);
				dp [ r ] [ i ] += dp [ (r + 1) % 2 ] [ i - 1 ];
				dp [ r ] [ i ] = Math.max (temp, dp [ r ] [ i ]);
			}
			
		}
		
		sb.append (Math.max (dp [ 0 ] [ _colSZ ], dp [ 1 ] [ _colSZ ]) + "\n");
	}
	
} //// end class