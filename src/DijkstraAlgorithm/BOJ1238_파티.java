package DijkstraAlgorithm;

import java.io.*;
import java.util.*;

// BOJ1238_파티
public class BOJ1238_파티
{
	public static class Node implements Comparable<Node>
	{
		int vertex, weight;
		
		public Node(int v, int w)
		{
			this.vertex = v;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Node o)
		{
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	
	static int num_vertex, num_edge, X_vertex;
	static List<Node> [ ] list;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		
		int [ ] fromX_dist = doDijkstra (X_vertex, -1);
		for (int i = 1; i <= num_vertex; i++)
		{
			int [ ] toX_dist = doDijkstra (i, X_vertex);
			fromX_dist [ i ] += toX_dist [ X_vertex ];
		}
		
		outputData (fromX_dist);
	} //// end main
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num_vertex = Integer.parseInt (st.nextToken ( ));
		num_edge = Integer.parseInt (st.nextToken ( ));
		X_vertex = Integer.parseInt (st.nextToken ( ));
		list = new ArrayList [ num_vertex + 1 ];
		for (int i = 1; i <= num_vertex; i++)
		{
			list [ i ] = new ArrayList<> ( );
		}
		for (int i = 0; i < num_edge; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int from = Integer.parseInt (st.nextToken ( ));
			int to = Integer.parseInt (st.nextToken ( ));
			int weight = Integer.parseInt (st.nextToken ( ));
			list [ from ].add (new Node (to, weight));
		}
		
	}
	
	static int [ ] doDijkstra(int start_vertex, int end_vertex) // end로 부터 출발하여 각자의 집으로 가는 최단경로 -> from_dist 채우기
	{
		PriorityQueue<Node> que = new PriorityQueue<> ( );
		boolean [ ] check = new boolean [ num_vertex + 1 ];
		int [ ] dist = new int [ num_vertex + 1 ];
		Arrays.fill (dist, INF);
		que.add (new Node (start_vertex, 0));
		dist [ start_vertex ] = 0;
		
		while (! que.isEmpty ( ))
		{
			Node cur = que.poll ( );
			
			if (check [ cur.vertex ]) continue;
			check [ cur.vertex ] = true;
			if (cur.vertex == end_vertex) return dist;
			
			for (Node next: list [ cur.vertex ])
			{
				if (dist [ next.vertex ] > dist [ cur.vertex ] + next.weight)
				{
					dist [ next.vertex ] = dist [ cur.vertex ] + next.weight;
					que.add (new Node (next.vertex, dist [ next.vertex ]));
				}
			}
			
			if (cur.vertex == end_vertex) return dist;
		}
		
		return dist;
	}
	
	static void outputData(int [ ] dist)
	{
		int ret = -1;
		for (int i = 1; i <= num_vertex; i++)
		{
			if (dist [ i ] != INF && i != X_vertex)
			{
				ret = ret < dist [ i ] ? dist [ i ] : ret;
			}
			
		}
		System.out.println (ret);
	}
	
} //// end class