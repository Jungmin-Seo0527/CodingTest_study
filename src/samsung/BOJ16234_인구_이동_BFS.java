package samsung;

import java.io.*;
import java.util.*;

// BOJ16234_인구_이동_BFS
public class BOJ16234_인구_이동_BFS
{
	private static class Point
	{
		int row, col;
		
		private Point(int r, int c)
		{
			this.row = r;
			this.col = c;
		}
	}
	
	private static int SZ, smallest, biggest, finish_flag;
	private static int [ ] [ ] graph;
	private static boolean [ ] [ ] visited;
	private static Deque<Point> que = new LinkedList<> ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		smallest = Integer.parseInt (st.nextToken ( ));
		biggest = Integer.parseInt (st.nextToken ( ));
		graph = new int [ SZ ] [ SZ ];
		visited = new boolean [ SZ ] [ SZ ];
		
		for (int i = 0; i < SZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < SZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		
		System.out.println (solve ( ));
	} //// end main
	
	private static int solve( )
	{
		int ret = 0;
		while (! finish ( ))
		{
			int flag = 0;
			for (int i = 0; i < SZ; i++)
			{
				for (int j = 0; j < SZ; j++)
				{
					if (! visited [ i ] [ j ])
					{
						doDFS (i, j);
					}
				}
			}
			if (finish_flag == 0) break;
			finish_flag = 0;
			visited = new boolean [ SZ ] [ SZ ];
			ret++;
		}
		return ret;
	}
	
	private static void doDFS(int _r, int _c)
	{
		int cnt = 0;
		int sum = 0;
		int [ ] v_r =
		{ 1 , -1 , 0 , 0 };
		int [ ] v_c =
		{ 0 , 0 , 1 , -1 };
		LinkedList<Point> list = new LinkedList<> ( );
		
		visited [ _r ] [ _c ] = true;
		que.addLast (new Point (_r, _c));
		while (! que.isEmpty ( ))
		{
			Point cur = que.pollFirst ( );
			cnt++;
			sum += graph [ cur.row ] [ cur.col ];
			list.add (cur);
			for (int i = 0; i < 4; i++)
			{
				Point next = new Point (cur.row + v_r [ i ], cur.col + v_c [ i ]);
				if (check (cur, next))
				{
					que.addLast (next);
				}
				
			}
		}
		if (cnt == 1) return;
		
		int n = sum / cnt;
		for (Point cur: list)
		{
			graph [ cur.row ] [ cur.col ] = n;
		}
	}
	
	private static boolean check(Point prev, Point cur)
	{
		if (cur.row < 0 || cur.row >= SZ) return false;
		if (cur.col < 0 || cur.col >= SZ) return false;
		if (visited [ cur.row ] [ cur.col ]) return false;
		int temp = Math.abs (graph [ cur.row ] [ cur.col ] - graph [ prev.row ] [ prev.col ]);
		if (temp < smallest || temp > biggest) return false;
		visited [ cur.row ] [ cur.col ] = true;
		finish_flag = 1;
		return true;
	}

	private static boolean finish( )
	{
		for (int i = 0; i < SZ; i++)
		{
			for (int j = 0; j < SZ; j++)
			{
				if (graph [ 0 ] [ 0 ] != graph [ i ] [ j ]) return false;
			}
		}
		return true;
	}
	
} //// end class