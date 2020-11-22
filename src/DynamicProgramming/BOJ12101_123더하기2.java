package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ12101_123더하기2
public class BOJ12101_123더하기2
{
	private static int num, end;
	private static int [ ] arr;
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		num = Integer.parseInt (st.nextToken ( ));
		end = Integer.parseInt (st.nextToken ( ));
		arr = new int [ num ];
		
		for (int i = 1; i <= 3; i++)
		{
			doDFS (0, i, i);
		}
		System.out.println ("-1");
	} //// end main;
	
	private static void doDFS(int idx, int inputNum, int sum)
	{
		arr [ idx ] = inputNum;
		if (sum == num)
		{
			end--;
			if (end == 0)
			{
				for (int i = 0; i < idx; i++)
				{
					sb.append (arr [ i ] + "+");
				}
				sb.append (arr [ idx ] + "");
				System.out.println (sb);
				System.exit (0);
			}
			return;
		}
		if (sum > num) return;
		
		for (int i = 1; i <= 3; i++)
		{
			doDFS (idx + 1, i, sum + i);
		}
	}
	
} //// end class
