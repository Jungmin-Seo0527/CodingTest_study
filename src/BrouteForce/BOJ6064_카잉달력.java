package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ6064_Ä«À×´Þ·Â
public class BOJ6064_Ä«À×´Þ·Â
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
			int last_x = Integer.parseInt (st.nextToken ( ));
			int last_y = Integer.parseInt (st.nextToken ( ));
			int dest_x = Integer.parseInt (st.nextToken ( ));
			int dest_y = Integer.parseInt (st.nextToken ( ));
			solve2 (last_x, last_y, dest_x, dest_y);
		}
		System.out.println (sb);
	} //// end main
	
	private static void solve2(int last_x, int last_y, int dest_x, int dest_y)
	{
		int cur_x = dest_x;
		int cur_y = dest_x % (last_y);
		if (cur_y == 0) cur_y = last_y;
		if (cur_y == 0) cur_y++;
		int cnt = cur_x;
		int last = lcm (last_x, last_y);
		
		while (true)
		{
			//System.out.println (cur_x+"   "+cur_y+"    "+cnt);
			if (cur_y == dest_y)
			{
				break;
			}
			cur_y = (cur_y + last_x) % last_y;
			if (cur_y == 0) cur_y = last_y;
			
			cnt = cnt + last_x;
			
			if (cnt > last)
			{
				cnt = -1;
				break;
			}
		}
		sb.append (cnt + "\n");
	}
	
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