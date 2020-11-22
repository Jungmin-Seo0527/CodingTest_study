package samsung;

import java.io.*;
import java.util.*;

// BOJ3190_��
public class BOJ3190_��
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
		
		// graph����
		graph = new map [ SZ + 1 ] [ SZ + 1 ];
		for (int i = 0; i < SZ + 1; i++)
		{
			for (int j = 0; j < SZ + 1; j++)
			{
				graph [ i ] [ j ] = new map ( );
			}
		}
		
		// grpah ������ ����
		graph [ 1 ] [ 1 ].row_v = 0;
		graph [ 1 ] [ 1 ].col_v = 1;
		graph [ 1 ] [ 1 ].snake = true;
		
		// graph�� ��� ��ġ
		st = new StringTokenizer (br.readLine ( ));
		int appleNum = Integer.parseInt (st.nextToken ( ));
		for (int i = 0; i < appleNum; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int r = Integer.parseInt (st.nextToken ( ));
			int c = Integer.parseInt (st.nextToken ( ));
			graph [ r ] [ c ].apple = true;
		}
		
		// ���ǥ ����
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
			// �Ӹ� �̵�
			head.row += cur_vector.row;
			head.col += cur_vector.col;
			timer++;
			
			// ���� �Ӹ� ��ġ Ȯ�� �� ���� ���� Ȯ�� (�� �� or �ڽ��� ����)
			if (! checkState ( ))
			{
				//System.out.println (graph[head.row][head.col].snake);
				System.out.println (timer);
				break;
			}
			graph [ head.row ] [ head.col ].snake = true;
			graph [ head.row ] [ head.col ].row_v = cur_vector.row;
			graph [ head.row ] [ head.col ].col_v = cur_vector.col;
			
			// ��� ���ο� ���� ���� �̵� -> ���� ����ĭ�� ���Ͱ��� ������ ����ĭ �̵�!!!!!!!! (���� ���ŵ� ���� row ������ col�� ���Ͱ��� ���ؼ� Ʋ�Ⱦ���!!!!! �߿�
			points tail_vector = new points (graph [ tail.row ] [ tail.col ].row_v, graph [ tail.row ] [ tail.col ].col_v);
			if (! graph [ head.row ] [ head.col ].apple) // ��� ����
			{
				graph [ tail.row ] [ tail.col ].snake = false;
				tail.row += tail_vector.row;
				tail.col += tail_vector.col;
			}
			else // ��� ���� -> ������ ���ڸ�
			{
				graph [ head.row ] [ head.col ].apple = false;
			}
			
			// ��� Ȯ��
			if (comIdx < comNum)
			{
				if (command [ comIdx ].time == timer)
				{
					switch (command [ comIdx ].rotate)
					{
					case 'L': // ���� -> ���� �Ӹ���ġ�� ���͸� ������ -> idx++;
						vectorIdx = (vectorIdx + 1) % 4;
						
						graph [ head.row ] [ head.col ].row_v = vector_r [ vectorIdx ];
						graph [ head.row ] [ head.col ].col_v = vector_c [ vectorIdx ];
						break;
					case 'D': // ������ -> idx--;
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
