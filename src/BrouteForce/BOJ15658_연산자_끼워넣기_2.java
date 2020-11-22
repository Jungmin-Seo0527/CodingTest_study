package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ15658_연산자_끼워넣기_2
public class BOJ15658_연산자_끼워넣기_2
{
	private static int [ ] graph;
	private static int [ ] visited = new int [ 4 ];
	private static int max = Integer.MIN_VALUE;
	private static int min = Integer.MAX_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int num = Integer.parseInt (st.nextToken ( ));
		graph = new int [ num ];
		
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < num; i++)
		{
			graph [ i ] = Integer.parseInt (st.nextToken ( ));
		}
		
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < 4; i++)
		{
			visited [ i ] = Integer.parseInt (st.nextToken ( ));
		}
		
		doDFS (graph [ 0 ], 1, num);
		System.out.println (max + "\n" + min);
	} //// end main
	
	private static void doDFS(int curNum, int calNumIdx, int endIdx)
	{
		if (calNumIdx == endIdx)
		{
			max = Math.max (max, curNum);
			min = Math.min (min, curNum);
			return;
		}
		for (int j = 0; j < 4; j++)
		{
			if (visited [ j ] > 0)
			{
				visited [ j ]--;
				int cal = doCal (curNum, graph [ calNumIdx ], j);
				doDFS (cal, calNumIdx + 1, endIdx);
				visited [ j ]++;
			}
		}
		
	}
	
	private static int doCal(int n1, int n2, int op)
	{
		int ret = 0;
		switch (op)
		{
		case 0:
			ret = n1 + n2;
			break;
		case 1:
			ret = n1 - n2;
			break;
		case 2:
			ret = n1 * n2;
			break;
		case 3:
			ret = n1 / n2;
			break;
		
		default:
			break;
		}
		return ret;
	}
	
} //// end class