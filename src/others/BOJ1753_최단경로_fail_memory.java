package others;

import java.io.*;
import java.util.*;

// BOJ1753_최단경로 
// Dijkstra -> arr로 풀었지만 메모리 초과
// vertex_num의 최대값이 20,000이라서 graph를 만드는데 엄청난 용량을 잡아먹어 버린다.
// graph 정보를 SLL로 만들어 보면 어떨까? 시간 초과가 일어날까?
// 대부분의 풀이는 우선순위 큐를 사용하는 듯 하다. 
public class BOJ1753_최단경로_fail_memory
{
	private static int vertex_num, edge_num;
	private static int [ ] [ ] graph;
	private static int [ ] dijkstra_table;
	private static boolean [ ] check;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		vertex_num = Integer.parseInt (st.nextToken ( ));
		edge_num = Integer.parseInt (st.nextToken ( ));
		graph = new int [ vertex_num ] [ vertex_num ];
		dijkstra_table = new int [ vertex_num ];
		check = new boolean [ vertex_num ];
		
		st = new StringTokenizer (br.readLine ( ));
		int start_vertex = Integer.parseInt (st.nextToken ( )) - 1;
		
		for (int i = 0; i < edge_num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int from_vertex = Integer.parseInt (st.nextToken ( ));
			int to_vertex = Integer.parseInt (st.nextToken ( ));
			int weight = Integer.parseInt (st.nextToken ( ));
			graph [ from_vertex - 1 ] [ to_vertex - 1 ] = weight;
		}
		
		Arrays.fill (dijkstra_table, Integer.MAX_VALUE); // table을 초기 무한대 값으로 초기화
		
		doDijkstra (start_vertex);
		for (int i = 0; i < dijkstra_table.length; i++)
		{
			if (dijkstra_table [ i ] != Integer.MAX_VALUE)
			{
				System.out.println (dijkstra_table [ i ]);
			}
			else
			{
				System.out.println ("INF");
			}
		}
	} //// end main
	
	private static void doDijkstra(int _start_vertex)
	{
		dijkstra_table [ _start_vertex ] = 0;
		for (int i = 0; i < vertex_num - 1; i++)
		{
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 0; j < vertex_num; j++)
			{
				if (! check [ j ] && min > dijkstra_table [ j ])
				{
					idx = j;
					min = dijkstra_table [ j ];
				}
			}
			
			for (int j = 0; j < vertex_num; j++)
			{
				if (! check [ j ] && graph [ idx ] [ j ] != 0 && dijkstra_table [ idx ] != Integer.MAX_VALUE
				                && dijkstra_table [ idx ] + graph [ idx ] [ j ] < dijkstra_table [ j ])
				{
					dijkstra_table [ j ] = dijkstra_table [ idx ] + graph [ idx ] [ j ];
				}
			}
			check [ idx ] = true;
		}
	}
	
} //// end class
