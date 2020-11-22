package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ2293_동전1
public class BOJ2293_동전1
{
	static int dest, coin_num;
	static int [ ] coin_arr;
	static long [ ] [ ] dp;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		solve ( );
		showSolution ( );
	} //// end main
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		coin_num = Integer.parseInt (st.nextToken ( ));
		coin_arr = new int [ coin_num ];
		dest = Integer.parseInt (st.nextToken ( ));
		dp = new long [ dest + 1 ] [ coin_num ];
		
		for (int i = 0; i < coin_num; i++)
		{
			int coin = Integer.parseInt (br.readLine ( ));
			coin_arr [ i ] = coin;
			
		}
		Arrays.sort (coin_arr);
	}
	
	static void solve( )
	{
		int coin_idx = 0;
		for (int i = 1; i <= dest; i++)
		{
			if (coin_idx < coin_num)
			{
				if (i == coin_arr [ coin_idx ])
				{
					dp [ i ] [ coin_idx ]++;
					coin_idx++;
					
				}
			}
			
			for (int c = 0; c < coin_idx; c++)
			{
				int coin = coin_arr [ c ];
				for (int j = c; j < coin_num; j++)
				{
					if (i - coin > 0) dp [ i ] [ c ] += dp [ i - coin ] [ j ];
				}
				
			}
			
		}
	}
	
	static void showSolution( )
	{
		long cnt = 0;
		for (int i = 0; i < coin_num; i++)
		{
			cnt += dp [ dest ] [ i ];
		}
		System.out.println (cnt);
	}
	
} //// end class