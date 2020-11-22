package DynamicProgramming;

import java.io.*;
import java.util.*;

//BOJ9461_파도반_수열
public class BOJ9461_파도반_수열
{
	private static final int SZ = 101;
	private static long [ ] dp = new long [ SZ ];
	private static StringBuilder sb = new StringBuilder ( );

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));

		int testCase = Integer.parseInt (st.nextToken ( ));

		createdp ( );

		for (int i = 0; i < testCase; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int input = Integer.parseInt (st.nextToken ( ));
			sb.append (dp [ input ] + "\n");
		}
		System.out.println (sb);
		br.close ( );
	} //// end main

	public static void createdp( )
	{
		dp [ 1 ] = 1;
		dp [ 2 ] = 1;
		dp [ 3 ] = 1;
		dp [ 4 ] = 2;
		dp [ 5 ] = 2;
		for (int i = 6; i < SZ; i++)
		{
			dp [ i ] = dp [ i - 1 ] + dp [ i - 5 ];
		}
	}

} //// end class