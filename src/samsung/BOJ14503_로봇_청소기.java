package samsung;

import java.io.*;
import java.util.*;

// BOJ14503_로봇_청소기
public class BOJ14503_로봇_청소기
{
	private static int rowSZ, colSZ, cur_r, cur_c, cur_d;
	private static int [ ] [ ] graph;
	
	// 북 동 남 서 (왼쪽 회전은 idx--)
	private static int [ ] v_r =
	{ -1 , 0 , 1 , 0 };
	private static int [ ] v_c =
	{ 0 , 1 , 0 , -1 };
	private static int cnt = 1;
	
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		rowSZ = Integer.parseInt (st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ ] [ colSZ ];
		
		st = new StringTokenizer (br.readLine ( ));
		cur_r = Integer.parseInt (st.nextToken ( ));
		cur_c = Integer.parseInt (st.nextToken ( ));
		cur_d = Integer.parseInt (st.nextToken ( ));
		
		for (int i = 0; i < rowSZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < colSZ; j++)
			{
				int input = Integer.parseInt (st.nextToken ( ));
				graph [ i ] [ j ] = input;
			}
		}
		graph [ cur_r ] [ cur_c ] = 2;
		fourCheckAndMove ( );
		System.out.println (cnt);
		//showGraph ( );
	} //// end main
	
	private static void showGraph( )
	{
		for (int i = 0; i < rowSZ; i++)
		{
			for (int j = 0; j < colSZ; j++)
			{
				System.out.print (graph [ i ] [ j ] + "   ");
			}
			System.out.println ( );
		}
		System.out.println ( );
	}
	
	private static void fourCheckAndMove( )
	{
		//showGraph ( );
		int check_r = cur_r;
		int check_c = cur_c;
		int check_d = cur_d;
		int flag = 0;
		// 현 방향 기준 왼쪽으로 순차적으로 확인후 청소할 곳이 있으면 전진, 
		for (int i = 0; i < 4; i++)
		{
			if (checkLeftSpace (check_r, check_c, check_d))
			{
				moveLeftSpace (check_r, check_c, check_d);
				flag = 1;
				break;
			}
			else
			{
				check_d = (check_d + 3) % 4;
			}
		}
		if (flag == 1)
		{
			fourCheckAndMove ( ); // 이동 한 지점에 다시 check
			return;
		}
		
		// 4방향 모두 청소 완료 -> 후진
		int move_d = (cur_d + 2) % 4;
		cur_r += v_r [ move_d ];
		cur_c += v_c [ move_d ];
		
		if (cur_r < 0 || cur_r >= rowSZ) return;
		if (cur_c < 0 || cur_c >= colSZ) return;
		if (graph [ cur_r ] [ cur_c ] == 1) return;
		
		fourCheckAndMove ( );
	}
	
	private static boolean checkLeftSpace(int _r, int _c, int _d)
	{
		int check_d = (_d + 3) % 4;
		int check_r = _r + v_r [ check_d ];
		int check_c = _c + v_c [ check_d ];
		
		if (check_r < 0 || check_r >= rowSZ) return false;
		if (check_c < 0 || check_c >= colSZ) return false;
		if (graph [ check_r ] [ check_c ] != 0) return false;
		
		return true;
	}
	
	private static void moveLeftSpace(int _r, int _c, int _d)
	{
		int move_d = (_d + 3) % 4;
		int move_r = _r + v_r [ move_d ];
		int move_c = _c + v_c [ move_d ];
		
		cur_r = move_r;
		cur_c = move_c;
		cur_d = move_d;
		cnt++;
		graph [ cur_r ] [ cur_c ] = 2;
	}
	
}//// end class
