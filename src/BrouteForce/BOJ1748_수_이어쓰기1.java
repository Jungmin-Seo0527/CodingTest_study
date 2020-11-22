package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ1748_수_이어쓰기1
public class BOJ1748_수_이어쓰기1
{
	private static long cnt;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		int num = Integer.parseInt (st.nextToken ( ));
		doDFS (1, num);
		
	}
	
	private static void doDFS(int cur, int end)
	{
		int plus = 1;
		int ten = 10;
		while (cur <= end)
		{
			if (cur / ten == 1)
			{
				plus++;
				ten = ten * 10;
			}
			cnt = cnt + plus;
			cur++;
		}
		System.out.println (cnt);
	}
}