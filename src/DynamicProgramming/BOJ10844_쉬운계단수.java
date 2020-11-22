package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ10844_쉬운계단수
public class BOJ10844_쉬운계단수
{

	private static int [ ] [ ] dp;
	private static int num;
	private static final int NUM = 1000000000;

	public static void main(String [ ] args) throws IOException
	{
		long sol = 0; // 자료형 확인!!!
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));

		dp = new int [ num ] [ 10 ];
		for (int i = 1; i < 10; i++)
		{
			dp [ 0 ] [ i ] = 1;
		}

		for (int r = 1; r < num; r++)
		{
			for (int c = 1; c < 9; c++)
			{
				dp [ r ] [ c ] = (dp [ r - 1 ] [ c - 1 ] + dp [ r - 1 ] [ c + 1 ]) % NUM;
			}
			dp [ r ] [ 0 ] = dp [ r - 1 ] [ 1 ] % NUM;
			dp [ r ] [ 9 ] = dp [ r - 1 ] [ 8 ] % NUM;

		}

		for (int i = 0; i < 10; i++)
		{
			sol += dp [ num - 1 ] [ i ];
		}
		System.out.println (sol % NUM);
	} //// end main

} //// end class