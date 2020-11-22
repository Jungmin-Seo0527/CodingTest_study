package DynamicProgramming;

import java.io.*;
import java.util.*;

//BOJ11055_����_ū_����_�κ�_����
public class BOJ11055_����_ū_����_�κ�_����
{
	private static int num;
	private static int [ ] arr;
	private static int [ ] dp;
	
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		arr = new int [ num ];
		dp = new int [ num ];
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < num; i++)
		{
			arr [ i ] = Integer.parseInt (st.nextToken ( ));
			dp [ i ] = arr [ i ];
		}
		
		solve ( );
		int ret = 0;
		for (int i = 0; i < num; i++)
		{
			if (ret < dp [ i ]) ret = dp [ i ];
		}
		System.out.println (ret);
	} //// end main
	
	private static void solve( )
	{
		for (int i = 1; i < num; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr [ i ] > arr [ j ])
				{
					dp [ i ] = Math.max (dp [ i ], dp [ j ] + arr [ i ]);
				}
			}
		}
	}
	
} //// end class
