package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ2529_부등호
public class BOJ2529_부등호
{
	private static char [ ] op;
	private static long max = Long.MIN_VALUE;
	private static long min = Long.MAX_VALUE;
	private static int num;
	private static boolean [ ] visited = new boolean [ 11 ];
	private static String retMax;
	private static String retMin;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		op = new char [ num ];
		String temp = br.readLine ( );
		for (int i = 0; i < num; i++)
		{
			op [ i ] = temp.charAt (i * 2);
		}
		
		for (int i = 0; i < 10; i++)
		{
			visited [ i ] = true;
			doDFS (i + "", i, 0);
			visited [ i ] = false;
		}
		System.out.println (retMax);
		System.out.println (retMin);
	} //// end main
	
	private static void doDFS(String ret, int cur_n, int cnt)
	{
		//System.out.println (ret);
		if (cnt == num)
		{
			long temp = Long.parseLong (ret);
			if (temp > max)
			{
				retMax = ret;
				max = temp;
			}
			if (temp < min)
			{
				retMin = ret;
				min = temp;
			}
			return;
		}
		for (int i = 0; i < 10; i++)
		{
			if (check (cur_n, i, cnt) && visited [ i ] == false)
			{
				visited [ i ] = true;
				doDFS (ret + i, i, cnt + 1);
				visited [ i ] = false;
			}
		}
	}
	
	private static boolean check(int n1, int n2, int opIdx)
	{
		switch (op [ opIdx ])
		{
		case '<':
			if (n1 < n2) return true;
			break;
		case '>':
			if (n1 > n2) return true;
			break;
		default:
			break;
		}
		return false;
	}
	
} //// end class
