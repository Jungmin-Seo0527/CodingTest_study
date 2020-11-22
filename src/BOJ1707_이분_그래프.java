import java.io.*;
import java.util.*;

public class BOJ1707_이분_그래프
{
	public static class Node
	{
		int vertex;
		Node next;

		public Node(int _v, Node _next)
		{
			this.vertex = _v;
			this.next = _next;
		}
	}

	//global value
	private static int num_vertex, visited[];

	static Node [ ] graph;
	static boolean result;
	private static Deque<Integer> que = new LinkedList<> ( );

	public static void main(String [ ] arg) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

		int testCase = Integer.parseInt (br.readLine ( ));

		for (int t = 0; t < testCase; t++)
		{
			StringTokenizer st = new StringTokenizer (br.readLine ( ));
			num_vertex = Integer.parseInt (st.nextToken ( ));
			int num_edge = Integer.parseInt (st.nextToken ( ));
			graph = new Node [ num_vertex + 1 ];
			visited = new int [ num_vertex + 1 ];
			result=true;

			int from, to;
			for (int i = 0; i < num_edge; i++)
			{
				st = new StringTokenizer (br.readLine ( ));
				from = Integer.parseInt (st.nextToken ( ));
				to = Integer.parseInt (st.nextToken ( ));
				graph [ from ] = new Node (to, graph [ from ]);
				graph [ to ] = new Node (from, graph [ to ]);

			}
			for (int i = 1; i <= num_vertex; i++)
			{
				if (visited [ i ] == 0 && result)
				{
					doBFS (i);
				}
			}
			if (result) System.out.println ("YES");
			else System.out.println ("NO");
			result = true;
		}
	}

	private static void doBFS(int _cur)
	{
		visited [ _cur ] = 1;
		Node temp = graph [ _cur ];
		while (temp != null)
		{
			visited [ temp.vertex ] = -1;
			que.addLast (temp.vertex);
			temp = temp.next;
		}
		while (! que.isEmpty ( ))
		{
			int cur = que.pollLast ( );
			temp = graph [ cur ];
			while (temp != null)
			{
				if (visited [ temp.vertex ] == 0 && result)
				{
					visited [ temp.vertex ] = visited [ cur ] * (-1);
					que.addLast (temp.vertex);
				}
				else
				{
					if (visited [ cur ] == visited [ temp.vertex ])
					{
						result = false;
						return;
					}
				}
				temp = temp.next;
			}
		}
	}

	////end of class
}