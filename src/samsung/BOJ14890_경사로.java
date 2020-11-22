package samsung;

import java.io.*;
import java.util.*;

// BOJ14890_경사로
public class BOJ14890_경사로
{
	private static int num, len;
	private static int [ ] [ ] graph;
	private static boolean [ ] [ ] slopeRow;
	private static boolean [ ] [ ] slopeCol;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		len = Integer.parseInt (st.nextToken ( ));
		graph = new int [ num ] [ num ];
		slopeRow = new boolean [ num ] [ num ];
		slopeCol = new boolean [ num ] [ num ];
		
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			for (int j = 0; j < num; j++)
			{
				graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
			}
		}
		int cnt = 0;
		for (int i = 0; i < num; i++)
		{
			if (checkRow (i))
			{
				cnt++;
			}
		}
		for (int i = 0; i < num; i++)
		{
			if (checkCol (i))
			{
				cnt++;
			}
		}
		System.out.println (cnt);
		
	} //// end main
	
	private static boolean checkRow(int r)
	{
		for (int i = 0; i < num - 1; i++)
		{
			int temp = graph [ r ] [ i ] - graph [ r ] [ i + 1 ];
			switch (temp)
			{
			case 1: // ㄴ
				for (int j = i + 1; j < i + 1 + len; j++)
				{
					if (j >= num) return false;
					if (graph [ r ] [ i ] - graph [ r ] [ j ] != 1)
					{
						return false;
					}
					if (slopeRow [ r ] [ j ]) return false;
					slopeRow [ r ] [ j ] = true;
				}
				i = i + len - 1;
				break;
			case -1: // )
				for (int j = i; j > i - len; j--)
				{
					if (j < 0) return false;
					if (graph [ r ] [ i + 1 ] - graph [ r ] [ j ] != 1) return false;
					if (slopeRow [ r ] [ j ]) return false;
					slopeRow [ r ] [ j ] = true;
				}
				break;
			case 0:
				
				break;
			
			default:
				return false;
			//break;
			}
		}
		
		return true;
	}
	
	private static boolean checkCol(int c)
	{
		for (int i = 0; i < num - 1; i++)
		{
			int temp = graph [ i ] [ c ] - graph [ i + 1 ] [ c ];
			switch (temp)
			{
			case 1: // ㄴ
				for (int j = i + 1; j < i + 1 + len; j++)
				{
					if (j >= num) return false;
					if (graph [ i ] [ c ] - graph [ j ] [ c ] != 1)
					{
						return false;
					}
					if (slopeCol [ j ] [ c ]) return false;
					slopeCol [ j ] [ c ] = true;
				}
				i = i + len - 1;
				break;
			case -1: // )
				for (int j = i; j > i - len; j--)
				{
					if (j < 0) return false;
					if (graph [ i + 1 ] [ c ] - graph [ j ] [ c ] != 1) return false;
					if (slopeCol [ j ] [ c ]) return false;
					slopeCol [ j ] [ c ] = true;
				}
				break;
			case 0:
				
				break;
			
			default:
				return false;
			//break;
			}
		}
		
		return true;
	}
	
} //// end class
