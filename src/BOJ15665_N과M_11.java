import java.io.*;
import java.util.*;

public class BOJ15665_N��M_11
{
	private static final int SZ = 10001;
	private static int num, end, big;
	private static boolean [ ] graph;
	private static int [ ] ret;
	private static StringBuilder sb = new StringBuilder ( );

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));

		num = Integer.parseInt (st.nextToken ( ));
		end = Integer.parseInt (st.nextToken ( ));

		graph = new boolean [ SZ ];
		ret = new int [ end ];

		st = new StringTokenizer (br.readLine ( ));
		while (st.hasMoreTokens ( ))
		{
			int input = Integer.parseInt (st.nextToken ( ));
			graph [ input ] = true;
			big = (big < input) ? input : big;
		}

		for (int i = 1; i <= big; i++)
		{
			if (graph [ i ]) doDFS (0, i);
		}
		System.out.println (sb);
		br.close ( );
		//// end main
	}

	public static void doDFS(int _idx, int _num)
	{
		ret [ _idx ] = _num;
		if (_idx == end - 1)
		{
			for (int i = 0; i < end; i++)
			{
				sb.append (ret [ i ] + " ");
			}
			sb.append ("\n");
			return;
		}
		for (int i = 1; i <= big; i++)
		{
			if (graph [ i ]) doDFS (_idx + 1, i);
		}

	}

	//// end class
}