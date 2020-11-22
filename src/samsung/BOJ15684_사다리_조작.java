package samsung;

import java.io.*;
import java.util.*;

// BOJ15684_사다리_조작
public class BOJ15684_사다리_조작
{
	private static class Point
	{
		int row, col;
		
		private Point( )
		{
			
		}
		
		private Point(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}
	
	private static int rowSZ, colSZ, n;
	private static int [ ] [ ] graph;
	private static int ret = -1;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		colSZ = Integer.parseInt (st.nextToken ( ));
		n = Integer.parseInt (st.nextToken ( ));
		rowSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ + 2 ] [ colSZ + 2 ];
		for (int i = 0; i < n; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int r = Integer.parseInt (st.nextToken ( ));
			int c = Integer.parseInt (st.nextToken ( ));
			graph [ r ] [ c ] = c + 1;
			graph [ r ] [ c + 1 ] = c;
		}
		
		//showGraph ( );
		solution (0, 1, 1);
		System.out.println (ret);
	} //// end main
	
	private static void solution(int cnt, int r, int c)
	{
		if (ret == 1) return;
		if (ret != -1 && cnt >= ret) return;
		if (clear ( ))
		{
			if (ret == -1)
			{
				ret = cnt;
			}
			else
			{
				ret = cnt > ret ? ret : cnt;
			}
			return;
		}
		if (cnt == 3) return;
		for (int i = r; i <= rowSZ; i++)
		{
			for (int j = c; j <= colSZ; j++)
			{
				for (int k = -1; k < 2; k = k + 2)
				{
					if (check (i, j, j + k))
					{
						graph [ i ] [ j ] = j + k;
						graph [ i ] [ j + k ] = j;
						solution (cnt + 1, i, j);
						graph [ i ] [ j ] = 0;
						graph [ i ] [ j + k ] = 0;
					}
				}
			}
		}
	}
	
	private static void showGraph( )
	{
		StringBuilder sb = new StringBuilder ( );
		for (int i = 1; i <= rowSZ; i++)
		{
			for (int j = 1; j <= colSZ; j++)
			{
				if (graph [ i ] [ j ] != 0)
				{
					sb.append ("1");
				}
				else
				{
					sb.append ("0");
				}
			}
			sb.append ("\n");
		}
		System.out.println (sb);
	}
	
	private static int doLadder(int col)
	{
		int curCol = col;
		for (int i = 1; i <= rowSZ; i++)
		{
			if (graph [ i ] [ curCol ] != 0)
			{
				Point ret = move (i, curCol);
				curCol = ret.col;
			}
		}
		return curCol;
	}
	
	private static Point move(int row, int col)
	{
		int curRow = row;
		int curCol = col;
		
		curCol = graph [ row ] [ col ];
		Point ret = new Point (curRow, curCol);
		return ret;
	}
	
	private static boolean check(int row, int col, int nextCol)
	{
		if (graph [ row ] [ col ] != 0) return false;
		if (graph [ row ] [ nextCol ] != 0) return false;
		if (nextCol < 1) return false;
		if (nextCol > colSZ) return false;
		
		return true;
	}
	
	private static boolean clear( )
	{
		for (int i = 1; i <= colSZ; i++)
		{
			if (i != doLadder (i))
			{
				return false;
			}
		}
		return true;
	}
	
} //// end class