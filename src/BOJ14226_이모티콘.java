import java.io.*;
import java.util.*;

public class BOJ14226_이모티콘
{
	public static class Node
	{
		int emo, clip, depth;

		public Node(int emo, int clip, int depth)
		{
			this.emo = emo;
			this.clip = clip;
			this.depth = depth;
		}
	}

	private static int end;
	private static Deque<Node> que = new LinkedList<> ( );
	private static boolean [ ] visited = new boolean [ 2001 ];

	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		end = Integer.parseInt (br.readLine ( ));
		Node first = new Node (1, 0, 0);
		que.addLast (first);
		int result = doBFS ( );
		System.out.println (result);

		//// end of main
	}

	private static int doBFS( )
	{
		que.addLast (new Node (1, 0, 0));
		Node cur = null;
		while (! que.isEmpty ( ))
		{
			cur = que.pollFirst ( );
			//System.out.println(cur.emo+" " +cur.clip+" "+cur.depth);
			if (cur.emo == end) break;

			que.addLast (new Node (cur.emo, cur.clip + cur.emo, cur.depth + 1)); //복사

			if (cur.emo + cur.clip < 2000)
			{
				if (cur.clip != 0 && ! visited [ cur.emo + cur.clip ])
				{
					que.addLast (new Node (cur.emo + cur.clip, 0, cur.depth + 1)); //복붙
					visited [ cur.emo + cur.clip ] = true;
				}
			}

			if (cur.emo > 0 && ! visited [ cur.emo - 1 ]) //-1
			{
				que.addLast (new Node (cur.emo - 1, cur.clip, cur.depth + 1));
				visited [ cur.emo - 1 ] = true;
			}
		}

		return cur.depth;
	}

	//// end of class
}