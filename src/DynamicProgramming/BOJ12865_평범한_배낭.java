package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ12865_�����_�賶
public class BOJ12865_�����_�賶
{
	private static class arrThings
	{
		int weight;
		int value;
		
		private arrThings( )
		{
			
		}
		
		private arrThings(int _w, int _v)
		{
			this.weight = _w;
			this.value = _v;
		}
	}
	
	private static arrThings [ ] things;
	private static int [ ] [ ] dp;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int num_thing = Integer.parseInt (st.nextToken ( ));
		int weight_bag = Integer.parseInt (st.nextToken ( ));
		
		things = new arrThings [ num_thing + 1 ];
		dp = new int [ weight_bag + 1 ] [ num_thing + 1 ];
		
		for (int i = 1; i <= num_thing; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int w = Integer.parseInt (st.nextToken ( ));
			int v = Integer.parseInt (st.nextToken ( ));
			things [ i ] = new arrThings (w, v);
		}
		
		solve (num_thing, weight_bag);
		System.out.println (dp [ weight_bag ] [ num_thing ]);
	} //// end main
	
	private static void solve(int _n, int _w)
	{
		for (int i = 1; i <= _w; i++) // ���� ũ��
		{
			for (int j = 1; j <= _n; j++) // ����
			{
				dp [ i ] [ j ] = dp [ i ] [ j - 1 ];
				if (i >= things [ j ].weight) // ������ ���濡 ���� �ִ� -> �����ܰ�, i-things[j].weight�� ��ġ ��
				{
					dp [ i ] [ j ] = Math.max (dp [ i ] [ j ], dp [ i - things [ j ].weight ] [ j - 1 ] + things [ j ].value);
					//dp [ i ] [ j ] = Math.max (dp [ i ] [ j ], dp [ i - things [ j ].weight ] [ j  ] + things [ j ].value);
					// �� -1?? -> j��°�� ������ �������� j-1������ �ִ뿡�� j�� �־����...!!!
				}
			}
		}
	}
	
} //// end class

