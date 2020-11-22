package DynamicProgramming;

import java.io.*;
import java.util.*;

//BOJ11054_가장_긴_바이토닉_부분_수열
public class BOJ11054_가장_긴_바이토닉_부분_수열
{
	private static int num;
	private static int incDP[];
	private static int decDP[];
	private static int arr[];
	
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		incDP = new int [ num ];
		decDP = new int [ num ];
		arr = new int [ num ];
		st = new StringTokenizer (br.readLine ( ));
		
		for (int i = 0; i < num; i++)
		{
			arr [ i ] = Integer.parseInt (st.nextToken ( ));
			incDP [ i ] = 1;
			decDP [ i ] = 1;
		}
		
		solve ( );
		//show ( );
		int ret = 0;
		
		for (int i = 0; i < num - 1; i++)
		{
			if (ret < incDP [ i ] + decDP [ i ])
			{
				ret = incDP [ i ] + decDP [ i ];
			}
		}
		ret--;
		if (num == 1) ret = 1;
		System.out.println (ret);
	} /// end main
	
	private static void solve( )
	{
		for (int i = 1; i < num; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr [ i ] > arr [ j ])
				{
					incDP [ i ] = Math.max (incDP [ i ], incDP [ j ] + 1);
				}
				if (arr [ num - i - 1 ] > arr [ num - j - 1 ])
				{
					decDP [ num - i - 1 ] = Math.max (decDP [ num - i - 1 ], decDP [ num - j - 1 ] + 1);
				}
			}
		}
	}
	
	private static void show( )
	{
		for (int i = 0; i < num; i++)
		{
			System.out.print (incDP [ i ] + " ");
		}
		System.out.println ( );
		for (int i = 0; i < num; i++)
		{
			System.out.print (decDP [ i ] + " ");
		}
		System.out.println ( );
	}
	
} //// end class