import java.io.*;
import java.util.*;

public class BOJ
{
	public static class Node
	{
		int vertex;
		Node next;

		public Node(int vertex, Node next)
		{
			this.vertex = vertex;
			this.next = next;
		}

		public String toString( )
		{
			return "Node [vertex =" + vertex + ", next=" + next + "]";
		}
	}

	static int num_vertex, visited[];
	static Node [ ] graph;
	static boolean result;

	public static void main(String [ ] arg) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

		int testCase = Integer.parseInt (br.readLine ( )); //num of testCase

		for (int t = 1; t <= testCase; t++)
		{
			// vertex갯수, edge갯수 받기
			StringTokenizer st = new StringTokenizer (br.readLine ( )); //공백있는 입력받을때 token!!
			num_vertex = Integer.parseInt (st.nextToken ( ));
			int num_edge = Integer.parseInt (st.nextToken ( ));

			graph = new Node [ num_vertex + 1 ];
			visited = new int [ num_vertex + 1 ];
			result = true;

			// graph 채우기
			int from, to;
			for (int j = 0; j < num_edge; j++)
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
					doDFS (i);
					visited [ i ] = 1;
				}
				else if (! result)
				{
					break;
				}
			}
			//System.out.println();
			System.out.println (result ? "YES" : "NO");
		}
	}

	private static void doDFS(int _cur_r)
	{
		if (result)
		{
			Node temp = graph [ _cur_r ];

			while (temp != null)
			{
				if (visited [ temp.vertex ] == 0)
				{
					if (visited [ _cur_r ] == 1)
					{
						visited [ temp.vertex ] = 2;
					}
					else visited [ temp.vertex ] = 1;
					doDFS (temp.vertex);
				}
				else
				{
					if (visited [ temp.vertex ] == visited [ _cur_r ])
					{
						result = false;
						return;
					}
					temp = temp.next;
				}
			}
		}
		else return;
	}

}
