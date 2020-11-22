package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ1987_¾ËÆÄºª
public class BOJ1987_¾ËÆÄºª
{
	static class Point
	{
		int row, col, cnt;
		
		Point(int _row, int _col, int _cnt)
		{
			this.row = _row;
			this.col = _col;
			this.cnt = _cnt;
		}
	}
	
	static int rowSZ, colSZ;
	static char [ ] [ ] graph;
	static boolean [ ] visited = new boolean [ 26 ];
	static int [ ] v_r =
	{ 1 , -1 , 0 , 0 };
	static int [ ] v_c =
	{ 0 , 0 , 1 , -1 };
	static int solution = 0;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		doDFS (new Point (0, 0, 1));
		System.out.println (solution);
	} //// end main
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		rowSZ = Integer.parseInt (st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		graph = new char [ rowSZ ] [ colSZ ];
		
		for (int i = 0; i < rowSZ; i++)
		{
			String input = br.readLine ( );
			for (int j = 0; j < colSZ; j++)
			{
				graph [ i ] [ j ] = input.charAt (j);
			}
		}
	}
	
	static void doDFS(Point _cur)
	{
		visited [ graph [ _cur.row ] [ _cur.col ] - 'A' ] = true;
		for (int i = 0; i < 4; i++)
		{
			Point next = new Point (_cur.row + v_r [ i ], _cur.col + v_c [ i ], _cur.cnt + 1);
			if (check (next))
			{
				doDFS (next);
				visited [ graph [ next.row ] [ next.col ] - 'A' ] = false;
			}
		}
		solution = solution > _cur.cnt ? solution : _cur.cnt;
	}
	
	static boolean check(Point _p)
	{
		if (_p.row < 0 || _p.row >= rowSZ) return false;
		if (_p.col < 0 || _p.col >= colSZ) return false;
		if (visited [ graph [ _p.row ] [ _p.col ] - 'A' ]) return false;
		return true;
	}
	
} //// end class
