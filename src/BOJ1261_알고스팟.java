import java.io.*;
import java.util.*;

public class BOJ1261_알고스팟
{
	// struct
	private static class Node
	{
		int row, col;

		Node(int row, int col)
		{
			this.row = row;
			this.col = col;
		}
	}

	//global value
	private static int rowSZ, colSZ;
	private static boolean [ ] [ ] wall;
	private static boolean [ ] [ ] visited;
	private static int [ ] [ ] dist;

	private static Deque<Node> queue = new LinkedList<> ( );

	public static void main(String [ ] arg) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String size = br.readLine ( ); // readLine(); Read a line of text
		//System.out.println(size);
		StringTokenizer st = new StringTokenizer (size); //StringTokenizer(string str, delim) delim=구분자
		//System.out.println(st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( )); // 첫번째 토큰 정수형으로 변환후 반환
		rowSZ = Integer.parseInt (st.nextToken ( )); //SZ는 모두 global value

		wall = new boolean [ rowSZ ] [ colSZ ];
		visited = new boolean [ rowSZ ] [ colSZ ];
		dist = new int [ rowSZ ] [ colSZ ];
		
		for (int i = 0; i < rowSZ; i++)
		{
			String input = br.readLine ( ); // info on map(wall), one line 

			for (int j = 0; j < colSZ; j++)
			{
				if (input.charAt (j) == '1')
				{
					wall [ i ] [ j ] = true;
				} else
				{
					wall [ i ] [ j ] = false;
				}
			}
		}

		doDFS ( );
		System.out.print (dist [ rowSZ - 1 ] [ colSZ - 1 ]);
	}

	private static  void  doDFS()
	{
		queue.addLast (new Node (0, 0));
		visited [ 0 ] [ 0 ] = true;

		while (! queue.isEmpty ( ))
		{
			int [ ] v_r =
			{ 1 , -1 , 0 , 0 };
			int [ ] v_c =
			{ 0 , 0 , 1 , -1 };
			Node cur = queue.pollLast ( ); // cur=deque();

			for (int i = 0; i < 4; i++)
			{
				Node next = new Node (cur.row + v_r [ i ], cur.col + v_c [ i ]);
				check(cur, next);

			}

		}
	}

	private static void check(Node _cur, Node _next)
	{
		if (_next.row < 0 || _next.row >= rowSZ)
			return;
		if (_next.col < 0 || _next.col >= colSZ)
			return;
		if (visited [ _next.row ] [ _next.col ])
			return;

		if (! wall [ _next.row ] [ _next.col ])
		{
			dist [ _next.row ] [ _next.col ] = dist [ _cur.row ] [ _cur.col ];
			queue.addLast (new Node (_next.row, _next.col));
		} else
		{
			dist [ _next.row ] [ _next.col ] = dist [ _cur.row ] [ _cur.col ] + 1;
			queue.addFirst (new Node (_next.row, _next.col));
		}
		visited [ _next.row ] [ _next.col ] = true;
	}

}
