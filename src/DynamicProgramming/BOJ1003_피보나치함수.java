package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1003_피보나치함수
public class BOJ1003_피보나치함수
{
	private static int zero, one;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		StringBuilder sb = new StringBuilder ( );
		int testCase = Integer.parseInt (st.nextToken ( ));
		int [ ] [ ] fibo = new int [ 2 ] [ 41 ];
		fibo [ 0 ] [ 0 ] = 1;
		fibo [ 1 ] [ 0 ] = 0;
		fibo [ 0 ] [ 1 ] = 0;
		fibo [ 1 ] [ 1 ] = 1;
		for (int i = 2; i <= 40; i++)
		{
			fibo [ 0 ] [ i ] = fibo [ 0 ] [ i - 1 ] + fibo [ 0 ] [ i - 2 ];
			fibo [ 1 ] [ i ] = fibo [ 1 ] [ i - 1 ] + fibo [ 1 ] [ i - 2 ];
		}
		for (int i = 0; i < testCase; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int input = Integer.parseInt (st.nextToken ( ));
			sb.append (fibo [ 0 ] [ input ] + " " + fibo [ 1 ] [ input ] + "\n");
		}
		System.out.println (sb);
		br.close ( );

	} //// end main

} //// end class