package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1890_점프
public class BOJ1890_점프
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
	
	private static int SZ;
	private static int [ ] [ ] graph;
	private static long [ ] [ ] dp;
	private static long cnt;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ SZ ] [ SZ ];
		dp = new long [ SZ ] [ SZ ];
		for (int i = 0; i < SZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < SZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		dp [ 0 ] [ 0 ] = 1;
		doDFS (new Point (0, 0));
		//showDP ( );
		System.out.println (cnt);
	} //// end main
	
	private static void doDFS(Point cur)
	{
		int [ ] v_r =
		{ 1 , 0 };
		int [ ] v_c =
		{ 0 , 1 };
		for (int i = 0; i < SZ; i++)
		{
			for (int j = 0; j < SZ; j++)
			{
				for (int v = 0; v < 2; v++)
				{
					int next_row = i + v_r [ v ] * graph [ i ] [ j ];
					int next_col = j + v_c [ v ] * graph [ i ] [ j ];
					check (i, j, next_row, next_col);
				}
			}
		}
		cnt = dp [ SZ - 1 ] [ SZ - 1 ];
	}
	
	private static void check(int curRow, int curCol, int nextRow, int nextCol)
	{
		if (nextRow < 0 || nextRow >= SZ) return;
		if (nextCol < 0 || nextCol >= SZ) return;
		if (curRow == SZ - 1 && curCol == SZ - 1) return;
		dp [ nextRow ] [ nextCol ] += dp [ curRow ] [ curCol ];
		
		return;
	}
	
} //// end class
