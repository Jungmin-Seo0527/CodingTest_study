package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ11048_이동하기
public class BOJ11048_이동하기
{
	private static class node
	{
		int row, col;
		
		private node( )
		{
			
		}
		
		private node(int r, int c)
		{
			this.row = r;
			this.col = c;
		}
	}
	
	private static int [ ] [ ] graph;
	private static int [ ] [ ] dp;
	private static boolean [ ] [ ] visited;
	private static int rowSZ, colSZ;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		rowSZ = Integer.parseInt (st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ + 1 ] [ colSZ + 1 ];
		dp = new int [ rowSZ + 1 ] [ colSZ + 1 ];
		visited = new boolean [ rowSZ + 1 ] [ colSZ + 1 ];
		
		for (int i = 1; i <= rowSZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 1; j <= colSZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
				
			}
		}
		doBFS ( );
		System.out.println (dp [ rowSZ ] [ colSZ ]);
		
	} //// end main
	
	private static boolean check(node cur, node next)
	{
		if (next.row <= 0 || next.row > rowSZ) return false;
		if (next.col <= 0 || next.col > colSZ) return false;
		if (dp [ cur.row ] [ cur.col ] + graph [ next.row ] [ next.col ] < dp [ next.row ] [ next.col ]) return false;
		dp [ next.row ] [ next.col ] = dp [ cur.row ] [ cur.col ] + graph [ next.row ] [ next.col ];
		return true;
	}
	
	private static void doBFS( )
	{
		dp [ 1 ] [ 1 ] = graph [ 1 ] [ 1 ];
		for (int i = 1; i <= rowSZ; i++)
		{
			for (int j = 1; j <= colSZ; j++)
			{
				node cur = new node (i, j);
				
				node next = new node (i + 1, j);
				check (cur, next);
				
				next = new node (i, j + 1);
				check (cur, next);
				
				next = new node (i + 1, j + 1);
				check (cur, next);
			}
		}
	}
} //// end class
