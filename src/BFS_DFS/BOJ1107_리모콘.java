package BFS_DFS;

import java.io.*;
import java.util.*;

// BOJ1107_리모콘
public class BOJ1107_리모콘
{
	private static class Channel
	{
		int ch;
		int v;
		
		private Channel( )
		{
			
		}
		
		private Channel(int ch, int v)
		{
			this.ch = ch;
			this.v = v;
		}
		
	}
	
	private static int dist_ch;
	private static int fin_ch;
	private static boolean [ ] button = new boolean [ 10 ];
	
	private static Deque<Channel> que = new LinkedList<Channel> ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		dist_ch = Integer.parseInt (st.nextToken ( ));
		for (int i = 0; i < 10; i++)
		{
			button [ i ] = true;
		}
		st = new StringTokenizer (br.readLine ( ));
		int loop_button = Integer.parseInt (st.nextToken ( ));
		
		if (loop_button > 0)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int i = 0; i < loop_button; i++)
			{
				button [ Integer.parseInt (st.nextToken ( )) ] = false;
			}
		}
		
		if (dist_ch == 100)
		{
			System.out.println (0);
		}
		else
		{
			solve ( );
			String fin_ch_st = fin_ch + "";
			int fin_ch_len = fin_ch_st.length ( );
			if (Math.abs (fin_ch - 100) < fin_ch_len) // 번호 새로 치는것 보다 100에서 출발하는게 좋다. (100, 101, 102, 99)c
			{
				fin_ch_len = Math.abs (fin_ch - 100);
			}
			int ret = Math.abs (dist_ch - fin_ch) + fin_ch_len;
			System.out.println (ret);
			
		}
	} //// end main
	
	private static boolean check(int n)
	{
		String str_n = n + "";
		for (int i = 0; i < str_n.length ( ); i++)
		{
			if (! button [ str_n.charAt (i) - '0' ]) return false;
		}
		return true;
	}
	
	private static void solve( )
	{
		int c = dist_ch;
		Channel ch1 = new Channel (c, -1);
		Channel ch2 = new Channel (c, 1);
		que.addLast (ch1);
		que.addLast (ch2);
		while (! que.isEmpty ( ))
		{
			Channel cur = que.pollFirst ( );
			if (check (cur.ch))
			{
				fin_ch = cur.ch;
				return;
			}
			Channel next = new Channel (cur.ch + cur.v, cur.v);
			String temp = next.ch + "";
			int len = temp.length ( );
			if (next.ch >= 0 && Math.abs (dist_ch - 100) >= Math.abs (next.ch - dist_ch) + len) // 차라리 100에서 출발하는게 좋다(체널 길이도 고려!!!!!)
			{
				que.addLast (next);
			}
		}
		fin_ch = 100;
	}
	
} //// end class

/*
반례 모음
반례가 되는 부분이 굉장히 많다. 



1555
8
0 1 3 4 5 6 7 9
670
    
101
3
4 5 6
1
    
162
9
0 1 3 4 5 6 7 8 9
62
    
10
9
1 2 3 4 5 6 7 8 9
11
    
1
10
0 1 2 3 4 5 6 7 8 9  
99
    
1
1
1
2
    
0
9
1 2 3 4 5 6 7 8 9
1
    
101
0
1
    
100000
9
0 1 2 3 4 5 6 7 8
6
    
1
10
0 1 2 3 4 5 6 7 8 9
99
    
1111
9
1 2 3 4 5 6 7 8 9 
1011
    
2229
6
4 5 6 7 8 9
5
    
10
1
0
2
    
0
10
0 1 2 3 4 5 6 7 8 9
100
    
9
8
0 3 4 5 6 7 8 9
4
    
0
3
0 1 2
4*/