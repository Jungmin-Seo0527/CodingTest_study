package samsung;

import java.io.*;
import java.util.*;

// BOJ3190_뱀
public class BOJ3190_뱀
{
	private static class map
	{
		int row_v;
		int col_v;
		boolean snake;
		boolean apple;
	}
	
	private static class com
	{
		int time;
		char rotate;
	}
	
	private static class points
	{
		int row;
		int col;
		
		private points( )
		{
			
		}
		
		private points(int _r, int _c)
		{
			row = _r;
			col = _c;
		}
	}
	
	private static int SZ;
	private static map [ ] [ ] graph;
	
	private static com [ ] command;
	private static int comNum;
	private static int comIdx;
	
	private static points head = new points ( );
	private static points tail = new points ( );
	private static int timer;
	
	private static int [ ] vector_r =
	{ 0 , -1 , 0 , 1 };
	private static int [ ] vector_c =
	{ 1 , 0 , -1 , 0 };
	private static int vectorIdx;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		
		// graph생성
		graph = new map [ SZ + 1 ] [ SZ + 1 ];
		for (int i = 0; i < SZ + 1; i++)
		{
			for (int j = 0; j < SZ + 1; j++)
			{
				graph [ i ] [ j ] = new map ( );
			}
		}
		
		// grpah 시작점 선언
		graph [ 1 ] [ 1 ].row_v = 0;
		graph [ 1 ] [ 1 ].col_v = 1;
		graph [ 1 ] [ 1 ].snake = true;
		
		// graph에 사과 배치
		st = new StringTokenizer (br.readLine ( ));
		int appleNum = Integer.parseInt (st.nextToken ( ));
		for (int i = 0; i < appleNum; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int r = Integer.parseInt (st.nextToken ( ));
			int c = Integer.parseInt (st.nextToken ( ));
			graph [ r ] [ c ].apple = true;
		}
		
		// 명령표 생성
		st = new StringTokenizer (br.readLine ( ));
		comNum = Integer.parseInt (st.nextToken ( ));
		command = new com [ comNum ];
		for (int i = 0; i < comNum; i++)
		{
			command [ i ] = new com ( );
			st = new StringTokenizer (br.readLine ( ));
			command [ i ].time = Integer.parseInt (st.nextToken ( ));
			command [ i ].rotate = st.nextToken ( ).charAt (0);
		}
		
		head.row = 1;
		head.col = 1;
		tail.row = 1;
		tail.col = 1;
		
		moveSnake ( );
		
	} //// end main
	
	private static void moveSnake( )
	{
		while (true)
		{
			
			//System.out.println (graph[1][6].snake);
			points cur_vector = new points (graph [ head.row ] [ head.col ].row_v, graph [ head.row ] [ head.col ].col_v);
			// 머리 이동
			head.row += cur_vector.row;
			head.col += cur_vector.col;
			timer++;
			
			// 현재 머리 위치 확인 후 종료 여부 확인 (벽 밖 or 자신의 몸통)
			if (! checkState ( ))
			{
				//System.out.println (graph[head.row][head.col].snake);
				System.out.println (timer);
				break;
			}
			graph [ head.row ] [ head.col ].snake = true;
			graph [ head.row ] [ head.col ].row_v = cur_vector.row;
			graph [ head.row ] [ head.col ].col_v = cur_vector.col;
			
			// 사과 여부에 따른 꼬리 이동 -> 현재 꼬리칸의 벡터값을 저장후 꼬리칸 이동!!!!!!!! (먼저 갱신된 꼬리 row 값으로 col의 벡터값을 구해서 틀렸었음!!!!! 중요
			points tail_vector = new points (graph [ tail.row ] [ tail.col ].row_v, graph [ tail.row ] [ tail.col ].col_v);
			if (! graph [ head.row ] [ head.col ].apple) // 사과 없음
			{
				graph [ tail.row ] [ tail.col ].snake = false;
				tail.row += tail_vector.row;
				tail.col += tail_vector.col;
			}
			else // 사과 있음 -> 꼬리는 제자리
			{
				graph [ head.row ] [ head.col ].apple = false;
			}
			
			// 명령 확인
			if (comIdx < comNum)
			{
				if (command [ comIdx ].time == timer)
				{
					switch (command [ comIdx ].rotate)
					{
					case 'L': // 왼쪽 -> 현제 머리위치의 벡터를 변경함 -> idx++;
						vectorIdx = (vectorIdx + 1) % 4;
						
						graph [ head.row ] [ head.col ].row_v = vector_r [ vectorIdx ];
						graph [ head.row ] [ head.col ].col_v = vector_c [ vectorIdx ];
						break;
					case 'D': // 오른쪽 -> idx--;
						vectorIdx--;
						if (vectorIdx == -1) vectorIdx = 3;
						graph [ head.row ] [ head.col ].row_v = vector_r [ vectorIdx ];
						graph [ head.row ] [ head.col ].col_v = vector_c [ vectorIdx ];
					default:
						
						break;
					}
					
					comIdx++;
				}
			}
			
		}
		
	}
	
	private static boolean checkState( )
	{
		if (head.row < 1 || head.row > SZ) return false;
		if (head.col < 1 || head.col > SZ) return false;
		if (graph [ head.row ] [ head.col ].snake) return false;
		
		return true;
	}
	
} //// end class
