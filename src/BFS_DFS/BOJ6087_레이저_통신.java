package BFS_DFS;

import java.io.*;
import java.util.*;

// BOJ6087_레이저_통신
public class BOJ6087_레이저_통신
{
	private static class Point
	{
		int row, col, vector, mirrorNum;
		
		private Point(int r, int c, int v, int mn)
		{
			this.row = r;
			this.col = c;
			this.vector = v;
			this.mirrorNum = mn;
		}
		
	}
	
	private static int [ ] v_r =
	{ 1 , 0 , -1 , 0 };
	private static int [ ] v_c =
	{ 0 , 1 , 0 , -1 };
	private static int [ ] [ ] graph;
	
	private static int rowSZ, colSZ;
	
	private static Deque<Point> que = new LinkedList<> ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		rowSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ ] [ colSZ ];
		for (int i = 0; i < rowSZ; i++)
		{
			String temp = br.readLine ( );
			for (int j = 0; j < colSZ; j++)
			{
				char input = temp.charAt (j);
				switch (input)
				{
				case '.': // 빈공간 -> 0
					graph [ i ] [ j ] = 0;
					break;
				case '*': // 벽 -> -1
					graph [ i ] [ j ] = -1;
					break;
				case 'C': // 레이저 -> -1
					graph [ i ] [ j ] = 0;
					que.addLast (new Point (i, j, -1, -1));
					break;
				
				default:
					break;
				}
			}
		}
		Point start = que.pollLast ( );
		Point end = que.pollLast ( );
		doBFS (start, end);
		
	} //// end main
	
	private static void doBFS(Point start, Point finish)
	{
		for (int i = 0; i < 4; i++)
		{
			int r = start.row + v_r [ i ];
			int c = start.col + v_c [ i ];
			Point next = new Point (r, c, i, 0);
			if (check (start, next)) que.addLast (next);
			//graph[r][c]=0;
		}
		
		while (! que.isEmpty ( ))
		{
			Point cur = que.pollFirst ( );
			//System.out.println (cur.row+" "+cur.col);
			if (cur.row == finish.row && cur.col == finish.col)
			{
				continue;
			}
			
			for (int i = 0; i < 4; i++)
			{
				if (i != (cur.vector + 2) % 4) // 백스텝은 불가 
				{
					int mir = 0;
					if (cur.vector != i) mir++; // 방향이 바뀌었으면 거울 수 +1
					Point next = new Point (cur.row + v_r [ i ], cur.col + v_c [ i ], i, cur.mirrorNum + mir);
					if (check (cur, next))
					{
						que.addLast (next);
					}
				}
			}
		}
		System.out.println (graph [ finish.row ] [ finish.col ]);
	}
	
	private static boolean check(Point cur, Point next)
	{
		if (next.row < 0 || next.row >= rowSZ) return false;
		if (next.col < 0 || next.col >= colSZ) return false;
		if (graph [ next.row ] [ next.col ] == -1) return false;
		if (graph [ next.row ] [ next.col ] < next.mirrorNum && graph [ next.row ] [ next.col ] != 0) return false;
		graph [ next.row ] [ next.col ] = next.mirrorNum;
		return true;
	}
	
} //// end class