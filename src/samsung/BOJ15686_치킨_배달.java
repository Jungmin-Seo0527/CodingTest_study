package samsung;

import java.io.*;
import java.util.*;

// BOJ15686_치킨_배달
public class BOJ15686_치킨_배달
{
	private static class Point
	{
		int row, col;
		
		private Point(int r, int c)
		{
			this.row = r;
			this.col = c;
		}
	}
	
	private static int SZ, minChickenNum, maxChickenNum;
	private static int [ ] [ ] graph;
	private static ArrayList<Point> chickenList = new ArrayList<> ( );
	private static ArrayList<Point> houseList = new ArrayList<> ( );
	private static LinkedList<Point> que = new LinkedList<> ( );
	private static int ret = Integer.MAX_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		maxChickenNum = Integer.parseInt (st.nextToken ( ));
		graph = new int [ SZ + 1 ] [ SZ + 1 ];
		for (int i = 0; i < SZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < SZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
				if (graph [ i ] [ j ] == 2)
				{
					chickenList.add (new Point (i, j));
					//maxChickenNum++;
				}
				if (graph [ i ] [ j ] == 1)
				{
					houseList.add (new Point (i, j));
				}
			}
		}
		doBFS (-1, 0);
		System.out.println (ret);
	} //// end main
	
	private static void doBFS(int s, int cnt)
	{
		if (cnt == maxChickenNum)
		{
			int temp = 0;
			for (Point curHome: houseList)
			{
				int min = Integer.MAX_VALUE;
				for (Point chicken: que)
				{
					min = Math.min (min, distanceFromHouseToChicken (curHome, chicken));
				}
				temp += min;
			}
			ret = Math.min (ret, temp);
			return;
		}
		for (int i = s + 1; i < chickenList.size ( ); i++)
		{
			que.addLast (chickenList.get (i));
			doBFS (i, cnt + 1);
			que.pollLast ( );
		}
	}
	
	private static int distanceFromHouseToChicken(Point home, Point Chicken)
	{
		int ret_r = Math.abs (home.row - Chicken.row);
		int ret_c = Math.abs (home.col - Chicken.col);
		return ret_r + ret_c;
	}
	
} //// end class
