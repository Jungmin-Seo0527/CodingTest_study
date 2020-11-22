import java.io.*;
import java.util.*;

public class BOJ15664_N��M_10
{
	private static final int SZ = 10001;
	private static int num, end, big;
	private static int [ ] graph = new int [ SZ ];
	private static int [ ] ret;
	private static StringBuilder sb = new StringBuilder ( );

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		end = Integer.parseInt (st.nextToken ( ));
		ret = new int [ end ];

		st = new StringTokenizer (br.readLine ( ));
		while (st.hasMoreTokens ( ))
		{
			int idx = Integer.parseInt (st.nextToken ( ));
			graph [ idx ]++;
			big = (big < idx) ? idx : big;
		}
		for (int i = 1; i <= big; i++)
		{
			if (graph [ i ] != 0) doDFS (0, i);
		}
		System.out.println (sb);
		br.close ( );
		//// end main
	}

	public static void doDFS(int _idx, int _n)
	{
		ret [ _idx ] = _n;
		if (_idx == end - 1)
		{
			for (int i = 0; i < end; i++)
			{
				sb.append (ret [ i ] + " ");
			}
			sb.append ("\n");
			return;
		}
		graph [ _n ]--;
		for (int i = _n; i <= big; i++)
		{
			if (graph [ i ] != 0) doDFS (_idx + 1, i);
		}
		graph [ _n ]++;
	}

	//// end class
}