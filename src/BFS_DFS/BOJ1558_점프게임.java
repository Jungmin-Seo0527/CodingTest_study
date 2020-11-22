package BFS_DFS;

import java.io.*;
import java.util.*;

// BOJ1558_점프게임
public class BOJ1558_점프게임
{
	private static class node
	{
		int position;
		int number;
		int time;
		
		private node( )
		{
			
		}
		
		private node(int p, int n, int t)
		{
			this.position = p;
			this.number = n;
			this.time = t;
		}
	}
	
	private static int num;
	private static int jp;
	private static boolean [ ] [ ] graph;
	private static Deque<node> que = new LinkedList<> ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		jp = Integer.parseInt (st.nextToken ( ));
		graph = new boolean [ num ] [ 2 ];
		String left_input = br.readLine ( );
		String right_input = br.readLine ( );
		for (int i = 0; i < num; i++)
		{
			if (left_input.charAt (i) == '1') graph [ i ] [ 0 ] = true;
			if (right_input.charAt (i) == '1') graph [ i ] [ 1 ] = true;
		}
		
		System.out.println (doBFS ( ));
	} //// end main
	
	private static int doBFS( )
	{
		int time = 0;
		node s = new node (0, 0, 0);
		graph [ 0 ] [ 0 ] = false;
		que.addLast (s);
		while (! que.isEmpty ( ))
		{
			node cur = que.pollFirst ( );
			//System.out.println (cur.position+" "+cur.number);
			if (cur.number >= num)
			{
				return 1;
			}
			
			// 1. 1칸 전진
			node next = new node (cur.position, cur.number + 1, cur.time + 1);
			if (check (next)) que.addLast (next);
			
			// 2. 1칸 후진
			next = new node (cur.position, cur.number - 1, cur.time + 1);
			if (check (next)) que.addLast (next);
			
			// 3. 점프
			next = new node ((cur.position + 1) % 2, cur.number + jp, cur.time + 1);
			if (check (next)) que.addLast (next);
		}
		return 0;
	}
	
	private static boolean check(node cur)
	{
		if (cur.number < 0) return false;
		if (cur.number < cur.time) return false;
		if (cur.number >= num) return true;
		if (! graph [ cur.number ] [ cur.position ]) return false;
		graph [ cur.number ] [ cur.position ] = false;
		return true;
	}
	
} //// end class
