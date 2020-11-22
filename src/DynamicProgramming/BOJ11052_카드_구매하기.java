package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ11052_카드_구매하기
public class BOJ11052_카드_구매하기
{
	private static int dp[];
	private static int arr[];
	private static int num;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num + 1 ];
		arr = new int [ num + 1 ];
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 1; i <= num; i++)
		{
			arr [ i ] = Integer.parseInt (st.nextToken ( ));
			dp [ i ] = arr [ i ];
		}
		
		solve ( );
		System.out.println (dp [ num ]);
	} //// end main
	
	private static void solve( )
	{
		for (int i = 2; i <= num; i++)
		{
			for (int j = 1; j < i; j++)
			{
				dp [ i ] = Math.max (dp [ i ], dp [ j ] + arr [ i - j ]);
			}
		}
	}
	
} //// end class
