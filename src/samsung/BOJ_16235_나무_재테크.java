package samsung;

import java.io.*;
import java.util.*;

// BOJ_16235_����_����ũ
public class BOJ_16235_����_����ũ
{
	
	static class Point
	{
		int row, col;
		
		Point(int r, int c)
		{
			this.row = r;
			this.col = c;
		}
	}
	
	static int SZ, num_tree, year, cnt;
	static LinkedList<Integer> [ ] tree_graph;
	static int [ ] nutrient, cur_state;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		for (int i = 0; i < year; i++)
		{
			rotation ( );
		}
		System.out.println (cnt);
		//show ( );
	}
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		SZ = Integer.parseInt (st.nextToken ( ));
		num_tree = Integer.parseInt (st.nextToken ( ));
		year = Integer.parseInt (st.nextToken ( ));
		tree_graph = new LinkedList [ SZ * SZ ];
		nutrient = new int [ SZ * SZ ];
		cur_state = new int [ SZ * SZ ];
		
		for (int i = 0; i < SZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < SZ; j++)
			{
				tree_graph [ i * SZ + j ] = new LinkedList<> ( );
				nutrient [ i * SZ + j ] = Integer.parseInt (st.nextToken ( ));
				cur_state [ i * SZ + j ] = 5;
			}
		}
		for (int i = 0; i < num_tree; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			int row = Integer.parseInt (st.nextToken ( ));
			int col = Integer.parseInt (st.nextToken ( ));
			int age = Integer.parseInt (st.nextToken ( ));
			tree_graph [ (row - 1) * SZ + (col - 1) ].add (age);
		}
	}
	
	static void rotation( )
	{
		cnt = 0;
		Deque<Point> que = new LinkedList<> ( );
		
		// ��
		for (int i = 0; i < SZ; i++)
		{
			for (int j = 0; j < SZ; j++)
			{
				int dead_tree = 0;
				int cur_graph_tree_num = tree_graph [ i * SZ + j ].size ( );
				for (int k = 0; k < cur_graph_tree_num; k++)
				{
					// ���� ������ ���̿� �����ִ� ����� ���� ��
					int cur_tree_age = tree_graph [ i * SZ + j ].get (k);
					if (cur_state [ i * SZ + j ] >= cur_tree_age) // ����� ���
					{
						// ������ ���̸�ŭ ��� ���� & ������ ���� �ѻ� ����
						cur_state [ i * SZ + j ] -= cur_tree_age;
						tree_graph [ i * SZ + j ].set (k, cur_tree_age + 1);
						
						// �� ������ ������ ���� %5==0 �϶��� ������ ������ ��
						// �̸� �� ��ǥ�� �����س���
						if ((cur_tree_age + 1) % 5 == 0)
						{
							que.add (new Point (i, j));
						}
					}
					else // ��� ���� 
					{
						// ������ �������� ������ ���� ���
						int last = tree_graph [ i * SZ + j ].size ( );
						for (int t = k; t < last; t++)
						{
							dead_tree = dead_tree + tree_graph [ i * SZ + j ].pollLast ( ) / 2;
						}
						break;
					}
				}
				
				// ���� -> ���� �������� ������� ��
				cur_state [ i * SZ + j ] += dead_tree;
				
				// �ܿ� -> ��� ����
				cur_state [ i * SZ + j ] += nutrient [ i * SZ + j ];
				cnt += tree_graph [ i * SZ + j ].size ( );
			}
		}
		
		// ����
		
		// ���� -> ���� ���� 8����
		int v_r[] =
		{ 1 , 1 , 1 , -1 , -1 , -1 , 0 , 0 };
		int v_c[] =
		{ -1 , 0 , 1 , -1 , 0 , 1 , -1 , 1 };
		
		while (! que.isEmpty ( ))
		{
			Point cur = que.poll ( );
			for (int i = 0; i < 8; i++)
			{
				Point next = new Point (cur.row + v_r [ i ], cur.col + v_c [ i ]);
				check (next);
			}
		}
	}
	
	static void check(Point cur)
	{
		if (cur.row < 0 || cur.row >= SZ) return;
		if (cur.col < 0 || cur.col >= SZ) return;
		tree_graph [ cur.row * SZ + cur.col ].addFirst (1);
		cnt++;
	}
	
} //// end class