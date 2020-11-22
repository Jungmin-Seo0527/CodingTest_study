package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ2748_피보나치_수2
public class BOJ2748_피보나치_수2
{
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		long [ ] graph = new long [ num + 1 ];
		graph [ 0 ] = 0;
		graph [ 1 ] = 1;
		for (int i = 2; i <= num; i++)
		{
			graph [ i ] = graph [ i - 1 ] + graph [ i - 2 ];
		}
		StringBuffer sb = new StringBuffer ( );
		sb.append (graph [ num ]);
		System.out.println (sb);
		br.close ( );
	}
}