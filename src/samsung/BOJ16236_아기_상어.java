package samsung;

import java.io.*;
import java.util.*;

// BOJ16236_아기_상어
public class BOJ16236_아기_상어
{
	static class Point
	{
		int row, col, size, eat_fish_num, time_cnt;
		
		Point(int row, int col, int size, int eat_fish_num, int time_cnt)
		{
			this.row = row;
			this.col = col;
			this.size = size;
			this.eat_fish_num = eat_fish_num;
			this.time_cnt = time_cnt;
		}
	}
	
	static int SZ;
	static int [ ] [ ] graph;
	static Point start;
	static int finish_flag = 0;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		
		Point temp_start = start;
		while (true)
		{
			Point cur = doBFS (temp_start);
			//System.out.println (cur.row+" "+cur.col+" "+cur.size+" "+cur.eat_fish_num+" "+cur.time_cnt);
			if (cur.row == Integer.MAX_VALUE)
			{
				System.out.println (temp_start.time_cnt);
				break;
			}
			temp_start = cur;
		}
	}
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ SZ ] [ SZ ];
		for (int i = 0; i < SZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < SZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
				if (graph [ i ] [ j ] == 9)
				{
					start = new Point (i, j, 2, 0, 0);
				}
			}
		}
	}
	
	static Point doBFS(Point _start)
	{
		boolean [ ] [ ] visited = new boolean [ SZ ] [ SZ ];
		int [ ] v_r =
		{ -1 , 0 , 0 , 1 };
		int [ ] v_c =
		{ 0 , -1 , 1 , 0 };
		
		Deque<Point> que = new LinkedList<> ( );
		Deque<Point> que2 = new LinkedList<> ( );
		
		que.addLast (_start);
		visited [ _start.row ] [ _start.col ] = true;
		graph [ _start.row ] [ _start.col ] = 0;
		
		int min_dist = Integer.MAX_VALUE;
		while (! que.isEmpty ( ))
		{
			Point cur = que.pollFirst ( );
			
			if (graph [ cur.row ] [ cur.col ] > 0 && graph [ cur.row ] [ cur.col ] <= 6)
			{
				if (graph [ cur.row ] [ cur.col ] < cur.size && cur.time_cnt <= min_dist)
				{
					int ret_size = cur.size;
					int ret_eat_fish_num = cur.eat_fish_num + 1;
					if (ret_eat_fish_num == ret_size)
					{
						ret_eat_fish_num = 0;
						ret_size++;
					}
					min_dist = cur.time_cnt;
					//graph [ cur.row ] [ cur.col ] = 0;
					que2.addLast (new Point (cur.row, cur.col, ret_size, ret_eat_fish_num, cur.time_cnt));
					//System.out.println (cur.row+" "+cur.col);
					continue;
				}
			}
			
			for (int i = 0; i < 4; i++)
			{
				Point next = new Point (cur.row + v_r [ i ], cur.col + v_c [ i ], cur.size, cur.eat_fish_num, cur.time_cnt + 1);
				if (check (cur, next, visited, min_dist))
				{
					que.addLast (next);
				}
			}
		}
		// row 가 가장 작은것 -> col이 가장 적은것
		int ret_row = Integer.MAX_VALUE;
		int ret_col = Integer.MAX_VALUE;
		
		int ret_size = 0;
		int ret_time_cnt = 0;
		int ret_eat_fish_num = 0;
		
		while (! que2.isEmpty ( ))
		{
			Point cur = que2.pollFirst ( );
			ret_size = cur.size;
			ret_time_cnt = cur.time_cnt;
			ret_eat_fish_num = cur.eat_fish_num;
			
			//System.out.println (cur.row+" "+cur.col);
			if (ret_row > cur.row)
			{
				ret_row = cur.row;
				ret_col = cur.col;
			}
			else if (ret_row == cur.row)
			{
				if (ret_col > cur.col)
				{
					ret_col = cur.col;
				}
			}
		}
		
		return new Point (ret_row, ret_col, ret_size, ret_eat_fish_num, ret_time_cnt);
	}
	
	static boolean check(Point _cur, Point _next, boolean [ ] [ ] _visited, int _min_dist)
	{
		if (_next.row < 0 || _next.row >= SZ) return false;
		if (_next.col < 0 || _next.col >= SZ) return false;
		if (graph [ _next.row ] [ _next.col ] > _cur.size) return false;
		if (_visited [ _next.row ] [ _next.col ]) return false;
		if (_next.time_cnt > _min_dist) return false;
		
		_visited [ _next.row ] [ _next.col ] = true;
		return true;
	}
	
} //// end class