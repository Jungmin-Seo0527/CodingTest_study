package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ13707_합분해2
public class BOJ13707_합분해2
{
	private static int [ ] [ ] dp;
	private static final int N = 1000000000;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		int k = Integer.parseInt (st.nextToken ( ));
		
		dp = new int [ k + 1 ] [ num + 1 ];
		
		long temp = 0;
		for (int i = 1; i <= k; i++)
		{
			for (int j = 0; j <= num; j++)
			{
				if (i == 1 || j == 0)
				{
					dp [ i ] [ j ] = 1;
				}
				else
				{
					temp = dp [ i ] [ j - 1 ] + dp [ i - 1 ] [ j ];
					temp %= N;
					dp [ i ] [ j ] = (int) temp;
				}
				
			}
		}
		System.out.println (dp [ k ] [ num ]);
	} //// end main
} //// end class

