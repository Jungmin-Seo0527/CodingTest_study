package BFS_DFS;

import java.io.*;
import java.util.*;

// BOJ9019_DSLR
public class BOJ9019_DSLR
{
	
	private static class Num
	{
		int num;
		String com;
		
		private Num( )
		{
			
		}
		
		private Num(int num, String com)
		{
			this.num = num;
			this.com = com;
		}
	}
	
	private static char [ ] command =
	{ 'D' , 'S' , 'L' , 'R' };
	
	private static boolean [ ] visited;
	
	private static Deque<Num> que = new LinkedList<> ( );
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int testCase = Integer.parseInt (st.nextToken ( ));
		for (int t = 0; t < testCase; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int cur = Integer.parseInt (st.nextToken ( ));
			//cur=changeStr (cur);
			int end = Integer.parseInt (st.nextToken ( ));
			//end=changeStr (end);
			visited = new boolean [ 10000 ];
			doBFS (cur, end);
		}
		System.out.println (sb);
		
	} //// end main
	
	private static void doBFS(int start, int end)
	{
		int cnt = 0;
		Num cur = new Num (start, "");
		que.addLast (cur);
		while (! que.isEmpty ( ))
		{
			Num next = que.pollFirst ( );
			//System.out.println (next.num+" "+next.com+" "+end);
			if (next.num == end)
			{
				sb.append (next.com + "\n");
				que.clear ( );
				break;
			}
			for (int i = 0; i < 4; i++)
			{
				comFun (next, i);
			}
		}
	}
	
	private static void comFun(Num node, int i)
	{
		int ret = node.num;
		switch (command [ i ])
		{
		case 'D':
			ret = (2 * ret) % 10000;
			break;
		case 'S':
			ret = (ret + 9999) % 10000;
			break;
		case 'L':
			int last = ret / 1000;
			ret = ret % 1000 * 10 + last;
			break;
		case 'R':
			int first = ret % 10;
			ret = first * 1000 + ret / 10;
			break;
		
		default:
			break;
		}
		if (visited [ ret ] == false && ret <= 9999)
		{
			que.addLast (new Num (ret, node.com + command [ i ]));
			visited [ ret ] = true;
		}
	}
	
} //// end class
