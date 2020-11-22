package samsung;

import java.io.*;
import java.util.*;

// BOJ14500_테트로미노
public class BOJ14500_테트로미노
{
	private static int ret;
	private static boolean [ ] [ ] visited;
	private static int [ ] [ ] graph;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int rowSZ = Integer.parseInt (st.nextToken ( ));
		int colSZ = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ ] [ colSZ ];
		visited = new boolean [ rowSZ ] [ colSZ ];
		
		for (int i = 0; i < rowSZ; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < colSZ; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		
		for (int i = 0; i < rowSZ; i++)
		{
			for (int j = 0; j < colSZ; j++)
			{
				doDFS (rowSZ, colSZ, i, j, graph [ i ] [ j ], 1);
			}
		}
		System.out.println (ret);
		
	} //// end main
	
	private static void doDFS(int rowSZ, int colSZ, int r, int c, int cur, int cnt)
	{
		visited [ r ] [ c ] = true;
		
		if (cnt == 4)
		{
			ret = cur > ret ? cur : ret;
			visited [ r ] [ c ] = false;
			return;
		}
		int [ ] v_r =
		{ -1 , 0 , 1 , 0 };
		int [ ] v_c =
		{ 0 , -1 , 0 , 1 };
		
		for (int i = 0; i < 4; i++)
		{
			int next_r = r + v_r [ i ];
			int next_c = c + v_c [ i ];
			
			if (check (next_r, next_c, rowSZ, colSZ))
			{
				doDFS (rowSZ, colSZ, next_r, next_c, cur + graph [ next_r ] [ next_c ], cnt + 1);
			}
			
		}
		
		if (cnt == 1) //ㅗㅏㅓㅜ
		{
			for (int i = 0; i < 4; i++)
			{
				int temp = cur;
				boolean flag = true;
				for (int j = 0; j < 3; j++)
				{
					int next_r = r + v_r [ (i + j) % 4 ];
					int next_c = c + v_c [ (i + j) % 4 ];
					if (check (next_r, next_c, rowSZ, colSZ))
					{
						temp += graph [ next_r ] [ next_c ];
					}
					else
					{
						flag = false;
						break;
					}
				}
				if (flag) ret = temp > ret ? temp : ret;
			}
		}
		
		visited [ r ] [ c ] = false;
	}
	
	private static boolean check(int r, int c, int rowSZ, int colSZ)
	{
		if (r < 0 || r >= rowSZ) return false;
		if (c < 0 || c >= colSZ) return false;
		if (visited [ r ] [ c ]) return false;
		return true;
	}
	
} //// end class