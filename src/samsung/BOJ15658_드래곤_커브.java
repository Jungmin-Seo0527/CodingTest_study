package samsung;

import java.io.*;
import java.util.*;

// BOJ15658_µå·¡°ï_Ä¿ºê
public class BOJ15658_µå·¡°ï_Ä¿ºê
{
	private static class dragon
	{
		int row, col, vector, generation;
		
		private dragon( )
		{
			
		}
		
		private dragon(int r, int c, int v, int g)
		{
			this.row = r;
			this.col = c;
			this.vector = v;
			this.generation = g;
		}
	}
	
	private static Deque<dragon> que = new LinkedList<> ( );
	private static boolean [ ] [ ] graph = new boolean [ 101 ] [ 101 ];
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int n = Integer.parseInt (st.nextToken ( ));
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int c = Integer.parseInt (st.nextToken ( ));
			int r = Integer.parseInt (st.nextToken ( ));
			int v = Integer.parseInt (st.nextToken ( ));
			int g = Integer.parseInt (st.nextToken ( ));
			que.addLast (new dragon (r, c, v, g));
		}
		solve ( );
		System.out.println (count ( ));
	} //// end main
	
	private static void solve( )
	{
		int [ ] vector_arr = null;
		while (! que.isEmpty ( ))
		{
			dragon cur = que.pollFirst ( );
			vector_arr = new int [ (int) Math.pow (2, cur.generation) ];
			vector_arr [ 0 ] = cur.vector;
			for (int i = 1; i <= cur.generation; i++)
			{
				operation (vector_arr, i);
			}
			
			initGraph (cur, vector_arr);
		}
	}
	
	private static int [ ] operation(int [ ] op, int g)
	{
		int startIdx = (int) Math.pow (2, g - 1);
		int endIdx = (int) Math.pow (2, g) - 1;
		int tempIdx = startIdx - 1;
		for (int i = startIdx; i <= endIdx; i++)
		{
			op [ i ] = (op [ tempIdx ] + 3) % 4;
			tempIdx--;
		}
		
		return op;
	}
	
	private static void initGraph(dragon start, int [ ] v_arr)
	{
		//System.out.println (v_arr.length);
		if (check (start)) graph [ start.row ] [ start.col ] = true;
		dragon cur = start;
		//System.out.print (cur.row+" "+cur.col+"//");
		for (int i = 0; i < v_arr.length; i++)
		{
			dragon next = movePoint (cur, v_arr [ i ], i);
			//System.out.print (next.row+" "+next.col+"//");
			if (check (next)) graph [ next.row ] [ next.col ] = true;
			cur = next;
		}
		//System.out.println ();
	}
	
	private static boolean check(dragon cur)
	{
		if (cur.row < 0 || cur.row >= 101) return false;
		if (cur.col < 0 || cur.col >= 101) return false;
		return true;
	}
	
	private static dragon movePoint(dragon cur, int v, int n)
	{
		int temp = -1;
		if (n % 2 == 0) temp = 1;
		dragon ret = null;
		switch (v)
		{
		case 0:
			ret = new dragon (cur.row, cur.col + temp, 0, 0);
			break;
		case 1:
			ret = new dragon (cur.row - temp, cur.col, 0, 0);
			break;
		case 2:
			ret = new dragon (cur.row, cur.col - temp, 0, 0);
			break;
		case 3:
			ret = new dragon (cur.row + temp, cur.col, 0, 0);
			break;
		
		default:
			break;
		}
		return ret;
	}
	
	private static int count( )
	{
		int ret = 0;
		for (int i = 0; i < 100; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				if (graph [ i ] [ j ] && graph [ i + 1 ] [ j ] && graph [ i ] [ j + 1 ] && graph [ i + 1 ] [ j + 1 ])
				{
					ret++;
				}
			}
		}
		return ret;
	}
	
} //// end class