package BFS_DFS;

import java.io.*;
import java.util.*;

// BOJ2251_물통
public class BOJ2251_물통
{
	
	private static class bottle
	{
		int a, b, c;
		
		private bottle( )
		{
			
		}
		
		private bottle(int a, int b, int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	private static Deque<bottle> list = new LinkedList<bottle> ( );
	private static boolean [ ] [ ] [ ] visited;
	private static int aMax, bMax, cMax;
	private static ArrayList<Integer> ret = new ArrayList<Integer> ( );
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		aMax = Integer.parseInt (st.nextToken ( ));
		bMax = Integer.parseInt (st.nextToken ( ));
		cMax = Integer.parseInt (st.nextToken ( ));
		visited = new boolean [ aMax + 1 ] [ bMax + 1 ] [ cMax + 1 ];
		doBFS ( );
		ret.sort (null);
		for (int i = 0; i < ret.size ( ); i++)
		{
			sb.append (ret.get (i) + " ");
		}
		System.out.println (sb);
		
	} //// end main
	
	private static void doBFS( )
	{
		bottle cur = new bottle (0, 0, cMax);
		boolean first = false;
		list.addLast (cur);
		while (! list.isEmpty ( ))
		{
			bottle next = list.pollFirst ( );
			if (next.a == 0 && first)
			{
				ret.add (next.c);
			}
			first = true;
			for (int i = 0; i < 6; i++)
			{
				swapWater (next, i);
			}
		}
	}
	
	private static void swapWater(bottle cur, int op)
	{
		int next_a = cur.a;
		int next_b = cur.b;
		int next_c = cur.c;
		switch (op)
		{
		case 0: // c->a
			next_c = cur.c - (aMax - cur.a);
			if (next_c < 0) next_c = 0;
			next_a = cur.a + cur.c;
			if (next_a > aMax) next_a = aMax;
			break;
		case 1: // c -> b
			next_c = cur.c - (bMax - cur.b);
			if (next_c < 0) next_c = 0;
			next_b = cur.b + cur.c;
			if (next_b > bMax) next_b = bMax;
			break;
		case 2: // b ->a
			next_b = cur.b - (aMax - cur.a);
			if (next_b < 0) next_b = 0;
			next_a = cur.a + cur.b;
			if (next_a > aMax) next_a = aMax;
			break;
		case 3: // b->c
			next_b = cur.b - (cMax - cur.c);
			if (next_b < 0) next_b = 0;
			next_c = cur.c + cur.b;
			if (next_c > cMax) next_c = cMax;
			break;
		case 4: // a->c
			next_a = cur.a - (cMax - cur.c);
			if (next_a < 0) next_a = 0;
			next_c = cur.c + cur.a;
			if (next_c > cMax) next_c = cMax;
			break;
		case 5: // a->b
			next_a = cur.a - (bMax - cur.b);
			if (next_a < 0) next_a = 0;
			next_b = cur.b + cur.a;
			if (next_b > bMax) next_b = bMax;
			break;
		
		default:
			break;
		}
		if (! visited [ next_a ] [ next_b ] [ next_c ])
		{
			visited [ next_a ] [ next_b ] [ next_c ] = true;
			list.addLast (new bottle (next_a, next_b, next_c));
		}
	}
	
} //// end class