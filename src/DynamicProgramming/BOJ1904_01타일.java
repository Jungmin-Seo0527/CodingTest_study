package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1904_01타일
public class BOJ1904_01타일
{
	//global values
	private static final int n = 15746;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		short [ ] graph = new short [ num + 1 ];

		if (num == 1)
		{
			System.out.println ("1");
			return;
		}

		if (num == 2)
		{
			System.out.println ("2");
			return;
		}
		graph [ 1 ] = 1;
		graph [ 2 ] = 2;
		for (int i = 3; i <= num; i++)
		{
			graph [ i ] = (short) ((graph [ i - 1 ] + graph [ i - 2 ]) % n);
		}
		StringBuilder sb = new StringBuilder ( );
		sb.append (graph [ num ]);
		System.out.println (sb);
		br.close ( );

	} //// end main

} //// end class