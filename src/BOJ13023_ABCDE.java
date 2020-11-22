import java.io.*;
import java.util.*;

/*5 4 -> num, lp 먼저 읽어 낸다. readLine();
   0 1
   1 2
   2 3
   3 4*/

public class BOJ13023_ABCDE
{
	public static class Node
	{
		int friend;
		Node next;

		public Node(int _f, Node _next)
		{
			this.friend = _f;
			this.next = _next;
		}
	}

	private static int num, lp;
	private static Node [ ] graph;
	private static boolean visited[];

	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( )); // token : 5, 4
		num = Integer.parseInt (st.nextToken ( )); // 5
		lp = Integer.parseInt (st.nextToken ( )); // 4
		graph = new Node [ num ];
		visited = new boolean [ num ];

		int from, to;
		for (int i = 0; i < lp; i++)
		{
			st = new StringTokenizer (br.readLine ( )); // 2번째줄 부터 -> token
			from = Integer.parseInt (st.nextToken ( ));
			to = Integer.parseInt (st.nextToken ( ));
			graph [ from ] = new Node (to, graph [ from ]);
			graph [ to ] = new Node (from, graph [ to ]);
		}

		for (int i = 0; i < num; i++)
		{
			doDFS (i, 0);
		}
		System.out.print ("0");
		//// end of main
	}

	private static void doDFS(int _idx, int _depth)
	{
		if (_idx < 0 || _idx >= num) return;
		if (_depth == 4)
		{
			System.out.print ("1");
			System.exit (0);
		}
		visited [ _idx ] = true;
		Node temp = graph [ _idx ];
		while (temp != null)
		{
			if (! visited [ temp.friend ]) doDFS (temp.friend, _depth + 1);
			temp = temp.next;
		}
		visited [ _idx ] = false;
	}

	//// end of class
}