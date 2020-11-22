package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ11722_가장_긴_감소하는_부분_수열
public class BOJ11722_가장_긴_감소하는_부분_수열
{
	private static int num;
	private static int dp[];
	private static int arr[];
	
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num ];
		arr = new int [ num ];
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < num; i++)
		{
			arr [ i ] = Integer.parseInt (st.nextToken ( ));
			dp [ i ] = 1;
		}
		
		solve ( );
		int ret = 0;
		for (int i = 0; i < num; i++)
		{
			if (dp [ i ] > ret) ret = dp [ i ];
		}
		System.out.println (ret);
	} /// end main
	
	private static void solve( )
	{
		for (int i = num - 2; i >= 0; i--)
		{
			for (int j = num - 1; j > i; j--)
			{
				if (arr [ i ] > arr [ j ])
				{
					dp [ i ] = Math.max (dp [ i ], dp [ j ] + 1);
				}
			}
		}
	}
	
} //// end class