package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ14889_스타트와_링크
public class BOJ14889_스타트와_링크
{
	private static int num;
	private static int [ ] [ ] graph;
	private static int [ ] start;
	private static int [ ] link;
	private static boolean [ ] visited;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		num = Integer.parseInt (st.nextToken ( ));
		graph = new int [ num ] [ num ];
		start = new int [ num ];
		link = new int [ num ];
		visited = new boolean [ num ];
		
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < num; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		for (int i = 0; i < num; i++)
		{
			visited [ i ] = true;
			doDFS (i, 0);
			visited [ i ] = false;
		}
		System.out.println (min);
	} //// end main
	
	private static void doDFS(int s, int idx)
	{
		start [ idx ] = s;
		if (idx == num / 2 - 1)
		{
			doCal ( );
			//showStart ( );
			return;
		}
		for (int i = s + 1; i < num; i++)
		{
			visited [ i ] = true;
			doDFS (i, idx + 1);
			visited [ i ] = false;
		}
	}
	
	private static void doCal( )
	{
		int idx = 0;
		for (int i = 0; i < num; i++)
		{
			if (! visited [ i ])
			{
				link [ idx ] = i;
				idx++;
			}
		}
		int startSum = 0;
		int linkSum = 0;
		for (int i = 0; i < num / 2 - 1; i++)
		{
			for (int j = i + 1; j < num / 2; j++)
			{
				
				startSum += (graph [ start [ i ] ] [ start [ j ] ] + graph [ start [ j ] ] [ start [ i ] ]);
				linkSum += (graph [ link [ i ] ] [ link [ j ] ] + graph [ link [ j ] ] [ link [ i ] ]);
			}
		}
		min = Math.min (min, Math.abs (startSum - linkSum));
	}
	
	private static void showStart( )
	{
		StringBuilder sb = new StringBuilder ( );
		for (int i = 0; i < num / 2; i++)
		{
			sb.append (start [ i ] + " ");
		}
		sb.append ("\n");
		for (int i = 0; i < num / 2; i++)
		{
			sb.append (link [ i ] + " ");
		}
		sb.append ("\n");
		System.out.println (sb);
	}
	
} //// end class