package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ11726_2xnŸ�ϸ�
public class BOJ11726_2xnŸ�ϸ�
{
	private static int num;
	private static int [ ] dp;
	private static final int N = 10007;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		
		dp = new int [ num ];
		
		solve ( );
		System.out.println (dp [ num - 1 ] % N);
	} //// end main
	
	private static void solve( )
	{
		dp [ 0 ] = 1;
		if (num == 1) return;
		dp [ 1 ] = 2;
		if (num == 2) return;
		for (int i = 2; i < num; i++)
		{
			dp [ i ] = (dp [ i - 1 ] + dp [ i - 2 ]) % N;
		}
	}
} //// end class