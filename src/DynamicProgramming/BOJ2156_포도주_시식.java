package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ2156_포도주_시식
public class BOJ2156_포도주_시식
{
	private static int num;
	private static int [ ] dp;
	private static int [ ] graph;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		dp = new int [ num ];
		graph = new int [ num ];

		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			graph [ i ] = Integer.parseInt (st.nextToken ( ));
		}

		System.out.println (initDP ( ));
		br.close ( );
	} //// end main

	private static int initDP( )
	{
		int ret = 0;
		dp [ 0 ] = graph [ 0 ];
		if (num == 1) return dp [ 0 ];

		dp [ 1 ] = dp [ 0 ] + graph [ 1 ];
		if (num == 2) return dp [ 1 ];

		dp [ 2 ] = Integer.max(dp[1], Integer.max (graph [ 0 ], graph [ 1 ]) + graph [ 2 ]);
		if (num == 3) return Integer.max (dp [ 1 ], dp [ 2 ]);

		for (int i = 3; i < num; i++)
		{
			dp [ i ] = Integer.max (dp [ i - 2 ], dp [ i - 3 ] + graph [ i - 1 ]) + graph [ i ];
			dp [ i ] = Integer.max (dp [ i ], dp [ i - 1 ]);
		}
		ret = (dp [ num - 1 ]);
		return ret;
	}

} //// end class