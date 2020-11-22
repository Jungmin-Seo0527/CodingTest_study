package DynamicProgramming;

import java.io.*;
import java.util.*;

public class BOJ2565_ภüฑ๊มู
{
	private static final int SZ = 501;
	private static int num;
	private static int end = 0;
	private static int [ ] arr;
	private static int [ ] dp;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		arr = new int [ SZ ];
		dp = new int [ SZ ];
		
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int idx = Integer.parseInt (st.nextToken ( ));
			int n = Integer.parseInt (st.nextToken ( ));
			arr [ idx ] = n;
			dp [ idx ] = 1;
			end = end > idx ? end : idx;
		}
		dp [ 0 ] = 1;
		solve ( );
		//show();
		int big = 0;
		int zero = 0;
		for (int i = 1; i <= end; i++)
		{
			big = big > dp [ i ] ? big : dp [ i ];
			if (dp [ i ] == 0) zero++;
		}
		System.out.println (end - big - zero);
	} //// end main
	
	private static void solve( )
	{
		for (int i = 2; i <= end; i++)
			for (int j = 1; j < i; j++)
			{
				if (arr [ j ] < arr [ i ])
				{
					dp [ i ] = Math.max (dp [ i ], dp [ j ] + 1);
				}
			}
	}
	
	private static void show( )
	{
		for (int i = 1; i <= end; i++)
		{
			System.out.print (dp [ i ] + " ");
		}
		System.out.println ( );
	}
	
} //// end class