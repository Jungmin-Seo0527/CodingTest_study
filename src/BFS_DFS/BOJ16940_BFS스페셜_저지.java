package BFS_DFS;

import java.io.*;
import java.util.*;

// 좋은 문제는 아닌것 같다.
// 문제의 설명이 부족하다고 느낌

public class BOJ16940_BFS스페셜_저지
{
	static Queue<Integer> q = new LinkedList<Integer> ( );
	static int N;
	static int ans[];
	static boolean is_visit[];
	static int ansnow = 1;
	static ArrayList<Integer> al[];
	static boolean answer = true;
	
	public static void main(String [ ] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		N = Integer.parseInt (br.readLine ( ));
		
		is_visit = new boolean [ N + 1 ];
		al = new ArrayList [ N + 1 ];
		ans = new int [ N ];
		
		for (int i = 1; i <= N; i++)
			al [ i ] = new ArrayList<> ( );
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int s = Integer.parseInt (st.nextToken ( ));
			int e = Integer.parseInt (st.nextToken ( ));
			al [ s ].add (e);
			al [ e ].add (s);
			
		}
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < N; i++)
		{
			ans [ i ] = Integer.parseInt (st.nextToken ( ));
		}
		is_visit [ 1 ] = true;
		q.add (1);
		if (ans [ 0 ] != 1) answer = false;
		while (! q.isEmpty ( ) && answer && ansnow != N)
		{
			int now = q.poll ( );
			//			System.out.println(now);
			for (int i = 0; i < al [ now ].size ( ); i++)
			{
				if (ansnow == N) break;
				if (ans [ ansnow ] == al [ now ].get (i))
				{
					is_visit [ al [ now ].get (i) ] = true;
					ansnow++;
					q.add (al [ now ].get (i));
					i = -1;
				}
			}
			if (ansnow == N) break;
			for (int i = 0; i < al [ now ].size ( ); i++)
			{
				if (! is_visit [ al [ now ].get (i) ])
				{
					//					System.out.println(al[now].get(i));
					answer = false;
					break;
				}
			}
		}
		//		for(int i=1;i<=N;i++) if(!is_visit[i]) answer = false;
		
		if (answer && ansnow == N) System.out.println (1);
		else System.out.println (0);
	}
}

