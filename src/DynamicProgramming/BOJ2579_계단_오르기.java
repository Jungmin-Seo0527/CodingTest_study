package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ2579_계단_오르기
public class BOJ2579_계단_오르기
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
			dp [ i ] = graph [ i ];
		}
		if (num > 1) dp [ 1 ] += dp [ 0 ];
		if (num > 2) dp [ 2 ] += Integer.max (graph [ 0 ], graph [ 1 ]);
		for (int i = 3; i < num; i++)
		{
			dp [ i ] += Integer.max (dp [ i - 2 ], dp [ i - 3 ] + graph [ i - 1 ]);
		}
		System.out.println (dp [ num - 1 ]);

	} //// end main
} //// end class