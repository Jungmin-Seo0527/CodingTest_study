package DijkstraAlgorithm;

import java.io.*;
import java.util.*;

public class BOJ1753_최단거리
{
	private static class Node implements Comparable<Node>
	{
		int vertex, weight;
		
		private Node(int vertex, int weight)
		{
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o)
		{
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	
	private static int num_vertex, num_edge, start_vertex;
	private static ArrayList<Node> [ ] list;
	private static int [ ] dist;
	private static final int INF = Integer.MAX_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		doDijkstra ( );
		outPutDate ( );
	} //// end main
	
	private static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num_vertex = Integer.parseInt (st.nextToken ( ));
		num_edge = Integer.parseInt (st.nextToken ( ));
		start_vertex = Integer.parseInt (br.readLine ( ));
		list = new ArrayList [ num_vertex + 1 ];
		dist = new int [ num_vertex + 1 ];
		Arrays.fill (dist, INF);
		
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
		br.close ( );
	}
	
	private static void doDijkstra( )
	{
		PriorityQueue<Node> que = new PriorityQueue<> ( );
		boolean [ ] check = new boolean [ num_vertex + 1 ];
		que.add (new Node (start_vertex, 0));
		dist [ start_vertex ] = 0;
		
		while (! que.isEmpty ( ))
		{
			Node cur = que.poll ( );
			
			if (check [ cur.vertex ]) continue;
			check [ cur.vertex ] = true;
			
			for (Node next: list [ cur.vertex ])
			{
				if (dist [ next.vertex ] > dist [ cur.vertex ] + next.weight)
				{
					dist [ next.vertex ] = dist [ cur.vertex ] + next.weight;
					que.add (new Node (next.vertex, dist [ next.vertex ]));
				}
			}
		}
	}
	
	private static void outPutDate( )
	{
		StringBuilder sb = new StringBuilder ( );
		for (int i = 1; i <= num_vertex; i++)
		{
			if (dist [ i ] == INF)
			{
				sb.append ("INF\n");
			}
			else
			{
				sb.append (dist [ i ] + "\n");
			}
		}
		System.out.println (sb);
	}
	
} //// end class