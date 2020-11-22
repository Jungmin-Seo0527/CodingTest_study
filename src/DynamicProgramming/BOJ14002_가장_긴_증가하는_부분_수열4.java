package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ14002_가장_긴_증가하는_부분_수열4
public class BOJ14002_가장_긴_증가하는_부분_수열4
{
	private static int num;
	private static int dp[];
	private static int arr[];
	private static StringBuilder sb = new StringBuilder ( );
	
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
		int lastIdx = 0;
		for (int i = 0; i < num; i++)
		{
			if (dp [ i ] >= ret)
			{
				ret = dp [ i ];
				lastIdx = i;
			}
			
		}
		System.out.println (ret);
		int f = ret;
		//sb.append (arr [ lastIdx ] + " ");
		int [ ] root = new int [ ret ];
		root [ ret - 1 ] = arr [ lastIdx ];
		ret--;
		int temp = arr [ lastIdx ];
		int big = -1;
		
		// ret부터 ret이 0이 될때까지
		// 현재 값보다는 작은수중 가장 큰 값 골라내기
		for (int i = lastIdx - 1; i >= 0; i--)
		{
			big = -1;
			for (int j = i; j >= 0; j--)
			{
				if (arr [ i ] < temp && dp [ i ] == ret)
				{
					big = Math.max (big, arr [ i ]);
				}
			}
			if (big != -1)
			{
				ret--;
				root [ ret ] = big;
				temp = big;
			}
		}
		
		for (int i = 0; i < f; i++)
		{
			sb.append (root [ i ] + " ");
		}
		System.out.println (sb);
		
	} /// end main
	
	private static void solve( )
	{
		for (int i = 1; i < num; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr [ i ] > arr [ j ])
				{
					dp [ i ] = Math.max (dp [ i ], dp [ j ] + 1);
				}
			}
		}
	}
	
} //// end class
