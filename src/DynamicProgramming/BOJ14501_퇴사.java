package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ14501_Επ»η 
public class BOJ14501_Επ»η
{
	private static int num;
	private static int [ ] time;
	private static int [ ] money;
	private static int [ ] dp;
	
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		time = new int [ num + 1 ];
		money = new int [ num + 1 ];
		dp = new int [ num + 1 ];
		for (int i = 1; i <= num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			time [ i ] = Integer.parseInt (st.nextToken ( ));
			money [ i ] = Integer.parseInt (st.nextToken ( ));
			dp [ i ] = money [ i ];
		}
		solve ( );
		
		//showDP ( );
	} //// end main
	
	private static void solve( )
	{
		for (int i = 2; i <= num; i++)
		{
			for (int j = 1; j < i; j++)
			{
				if (i - j >= time [ j ])
				{
					dp [ i ] = Math.max (money [ i ] + dp [ j ], dp [ i ]);
				}
			}
		}
		int max = 0;
		
		for (int i = 1; i <= num; i++)
		{
			if (i + time [ i ] <= num + 1)
			{
				if (max < dp [ i ])
				{
					max = dp [ i ];
				}
			}
		}
		System.out.println (max);
		
	}
	
	private static void showDP( )
	{
		for (int i = 1; i <= num; i++)
		{
			System.out.print (dp [ i ] + " ");
		}
		System.out.println ( );
	}
	
} //// end class