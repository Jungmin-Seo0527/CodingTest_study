package math;

import java.io.*;
import java.util.*;

public class BOJ1934_최소공배수
{
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int testCase = Integer.parseInt (st.nextToken ( ));
		for (int t = 0; t < testCase; t++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int n1 = Integer.parseInt (st.nextToken ( ));
			int n2 = Integer.parseInt (st.nextToken ( ));
			sb.append (lcm (n1, n2) + "\n");
		}
		System.out.println (sb);
	} //// end main
	
	private static int gcd(int a, int b)
	{
		while (b != 0)
		{
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	
	private static int lcm(int a, int b)
	{
		return a * b / gcd (a, b);
	}
	
} //// end class