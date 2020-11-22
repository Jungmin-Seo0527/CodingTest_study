package others;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;



//Dijkstra_priority que
public class study_Dijkstra_priorityQue
{
	private static class Edge implements Comparable<Edge>
	{
		int v, weight;
		
		private Edge(int v, int weight)
		{
			this.v = v;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o)
		{
			// TODO Auto-generated method stub
			return Integer.compare (this.weight, o.weight); // o.weight�� �����ΰ�???
		}
		
		// Override �� �ƴѰ�?
		/*		private String toString()
				{
					return weight+"";
				}*/
	}
	
	public static void main(String [ ] args)
	{
		Scanner sc = new Scanner (System.in);
		int V = sc.nextInt ( );
		int E = sc.nextInt ( );
		List<Edge> [ ] adj = new ArrayList [ V ];
		for (int i = 0; i < V; i++)
		{
			adj [ i ] = new ArrayList<> ( );
		}
		for (int i = 0; i < E; i++)
		{
			// ù��°�� �����, �ι�°�� ������, ����°�� ����ġ
			adj [ sc.nextInt ( ) ].add (new Edge (sc.nextInt ( ), sc.nextInt ( )));
		}
		
		// dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<> ( );
		boolean [ ] check = new boolean [ V ];
		Edge [ ] D = new Edge [ V ];
		
		// 0������ ����ϴ� �ɷ�
		for (int i = 0; i < V; i++)
		{
			// ���ϴ� �����
			if (i == 3)
			{
				D [ i ] = new Edge (i, 0);
			}
			else
			{
				D [ i ] = new Edge (i, Integer.MAX_VALUE);
			}
			pq.add (D [ i ]);
		}
		
		while (! pq.isEmpty ( ))
		{
			Edge edge = pq.poll ( );
			
			for (Edge next: adj [ edge.v ])
			{
				// check ���� �ʾ����鼭, D[next.v]�� D[edge.v] + next.weight���� �� ũ�ٸ� ����
				if (! check [ next.v ] && D [ next.v ].weight > D [ edge.v ].weight + next.weight)
				{
					D [ next.v ].weight = D [ edge.v ].weight + next.weight;
					
					//decrease key
					pq.remove (D [ next.v ]);
					pq.add (D [ next.v ]);
				}
			}
			check [ edge.v ] = true;
		}
		for (int i = 0; i < D.length; i++)
		{
			System.out.print (D [ i ].weight + " ");
		}
	} //// end main
	
} //// end class

