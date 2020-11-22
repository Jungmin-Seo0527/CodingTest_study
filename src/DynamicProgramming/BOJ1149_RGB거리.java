package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1149_RGB거리
// inner class 실습... -> class안에 class를 선언했는데 그 class는 다른 외부에서는 이용 불가
public class BOJ1149_RGB거리
{
	// global value
	private static int num;
	private static int small = Integer.MAX_VALUE;
	private static int [ ] [ ] graph;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		graph = new int [ num ] [ 3 ];

		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < 3; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		for (int i = 1; i < num; i++)
		{
			doDFS (i);
		}

		for (int i = 0; i < 3; i++)
		{
			if (small > graph [ num - 1 ] [ i ]) small = graph [ num - 1 ] [ i ];
		}
		minClass small1 = new minClass (graph [ num - 1 ] [ 0 ], graph [ num - 1 ] [ 1 ], graph [ num - 1 ] [ 2 ]);
		System.out.println (small1.findMin ( ));
	} //// end main

	private static void doDFS(int _home)
	{
		for (int i = 0; i < 3; i++)
		{
			graph [ _home ] [ i ] = min (_home - 1, i) + graph [ _home ] [ i ];
		}
	}

	private static int min(int _home, int _rgb)
	{
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++)
		{
			if (i != _rgb && ret > graph [ _home ] [ i ]) ret = graph [ _home ] [ i ];
		}
		return ret;
	}

	private static class minClass
	{
		int n1 = Integer.MAX_VALUE;
		int n2 = Integer.MAX_VALUE;
		int n3 = Integer.MAX_VALUE;

		/*		public  minClass(int _n1, int _n2)
				{
					this.n1=_n1;
					this.n2=_n2;
				}*/

		private minClass(int _n1, int _n2, int _n3)
		{
			this.n1 = _n1;
			this.n2 = _n2;
			this.n3 = _n3;
		}

		private int findMin( )
		{
			int ret = Integer.MAX_VALUE;
			ret = (ret > n1) ? n1 : ret;
			ret = ret > n2 ? n2 : ret;
			ret = ret > n3 ? n3 : ret;
			return ret;
		}
	}

} //// end class