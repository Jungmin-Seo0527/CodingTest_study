import java.io.*;
import java.util.*;

public class BOJ15657_N°úM_8
{
	private static int num, end;
	private static int [ ] graph;
	private static int [ ] ret;
	private static StringBuilder sb = new StringBuilder ( );

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));

		num = Integer.parseInt (st.nextToken ( ));
		end = Integer.parseInt (st.nextToken ( ));
		graph = new int [ num ];
		ret = new int [ end ];

		st = new StringTokenizer (br.readLine ( ));
		int i = 0;
		while (st.hasMoreTokens ( ))
		{
			graph [ i++ ] = Integer.parseInt (st.nextToken ( ));
		}
		Arrays.sort (graph);

		for (i = 0; i < num; i++)
		{
			doDFS (0, graph [ i ], i);
		}
		//System.out.println (sb.toString ( ));
		System.out.println (sb);
		br.close ( );
		//// end main
	}

	private static void doDFS(int _idx, int _input, int _inputIdx)
	{
		ret [ _idx ] = _input;
		if (_idx + 1 == end)
		{
			for (int i = 0; i < end; i++)
			{
				sb.append (ret [ i ] + " ");
			}
			sb.append ("\n");
			return;
		}
		for (int i = _inputIdx; i < num; i++)
		{
			doDFS (_idx + 1, graph [ i ], i);
		}
	}

	//// end class
}