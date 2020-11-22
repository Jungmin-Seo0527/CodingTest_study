  import java.io.*;
import java.util.*;

public class BOJ3055_탈출
{
	private static class Node
	{
		int row, col;

		Node(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}

	// global value
	private static int rowSZ, colSZ;
	private static int [ ] [ ] graph;
	private static Node start, end;
	private static Deque<Node> que = new LinkedList<Node> ( );
	private static Deque<Node> queW = new LinkedList<Node> ( );
	private static int water, num;

	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		rowSZ = Integer.parseInt (st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ ] [ colSZ ];

		for (int i = 0; i < rowSZ; i++)
		{
			String input = br.readLine ( );
			for (int j = 0; j < colSZ; j++)
			{
				switch (input.charAt (j))
				{
				case 'D':
					graph [ i ] [ j ] = 0;
					end = new Node (i, j);
					break;
				case 'S':
					graph [ i ] [ j ] = 0;
					start = new Node (i, j);
					num++;
					break;
				case '.':
					graph [ i ] [ j ] = 0;
					break;
				case '*':
					graph [ i ] [ j ] = -1;
					queW.addLast (new Node (i, j));
					water++;
					break;
				case 'X':
					graph [ i ] [ j ] = -2;
					break;
				default:
				}
			}
		}
		doDFS (start);
		//// end of main
	}

	private static void doDFS(Node _start)
	{
		int [ ] v_r =
		{ 1 , -1 , 0 , 0 };
		int [ ] v_c =
		{ 0 , 0 , 1 , -1 };
		Node cur = null;
		Node next = null;
		Node cw = null;
		Node cn = null;
		que.addLast (_start);

		while (! que.isEmpty ( ))
		{
			int temp = num;
			num = 0;

			// 이동도...
			for (int n = 0; n < temp; n++)
			{
				cur = que.pollFirst ( );
				if (cur.row == end.row && cur.col == end.col)
				{
					System.out.println (graph [ cur.row ] [ cur.col ]);
					return;
				}

				for (int i = 0; i < 4; i++)
				{
					next = new Node (cur.row + v_r [ i ], cur.col + v_c [ i ]);
					check (cur, next);
				}
			}

			// 현재 상태에서 큐의 마지막 인덱스를 확인후 그 인덱스까지만 poll 
			temp = water;
			water = 0;
			for (int w = 0; w < temp; w++)
			{
				cw = queW.pollFirst ( );
				for (int i = 0; i < 4; i++)
				{
					next = new Node (cw.row + v_r [ i ], cw.col + v_c [ i ]);
					checkWater (next);
				}
			}
		}

		System.out.println ("KAKTUS");
	}

	private static void check(Node cur, Node next)
	{
		if (next.row < 0 || next.row >= rowSZ) return;
		if (next.col < 0 || next.col >= colSZ) return;
		if (graph [ next.row ] [ next.col ] != 0) return;
		if (graph [ cur.row ] [ cur.col ] == -1) return;

		graph [ next.row ] [ next.col ] = graph [ cur.row ] [ cur.col ] + 1;
		que.addLast (next);
		num++;
	}

	private static void checkWater(Node n)
	{
		if (n.row < 0 || n.row >= rowSZ) return;
		if (n.col < 0 || n.col >= colSZ) return;
		if (graph [ n.row ] [ n.col ] == -2) return;
		if (graph [ n.row ] [ n.col ] == -1) return;
		if (n.row == end.row && n.col == end.col) return;

		graph [ n.row ] [ n.col ] = -1;
		queW.addLast (n);
		water++;
	}

	//// end of class
}