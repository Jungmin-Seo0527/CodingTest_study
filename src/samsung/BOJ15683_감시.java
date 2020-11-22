package samsung;

import java.io.*;
import java.util.*;

// 2차원 배열 복사
public class BOJ15683_감시
{
	public static class Cam
	{
		int row;
		int col;
		char cam;
		
		public Cam( )
		{
			
		}
		
		public Cam(int row, int col, char cam)
		{
			this.row = row;
			this.col = col;
			this.cam = cam;
		}
		
	}
	
	private static class InitGraph
	{
		
		char [ ] [ ] graph;
		int rowSZ, colSZ;
		Cam cur;
		public int cnt;
		
		private InitGraph( )
		{
			
		}
		
		private InitGraph(char [ ] [ ] graph, int rowSZ, int colSZ, Cam cur)
		{
			this.graph = graph;
			this.rowSZ = rowSZ;
			this.colSZ = colSZ;
			this.cur = cur;
		}
		
		void init(int v)
		{
			switch (v)
			{
			case 1: // 동
				for (int i = cur.col - 1; i >= 0; i--)
				{
					if (graph [ cur.row ] [ i ] == '0')
					{
						graph [ cur.row ] [ i ] = '#';
						cnt++;
					}
					else if (graph [ cur.row ] [ i ] == '6')
					{
						return;
					}
				}
				break;
			case 2: // 서
				for (int i = cur.col + 1; i < colSZ; i++)
				{
					if (graph [ cur.row ] [ i ] == '0')
					{
						graph [ cur.row ] [ i ] = '#';
						cnt++;
					}
					else if (graph [ cur.row ] [ i ] == '6')
					{
						return;
					}
				}
				break;
			case 3: // 남
				for (int i = cur.row + 1; i < rowSZ; i++)
				{
					if (graph [ i ] [ cur.col ] == '0')
					{
						graph [ i ] [ cur.col ] = '#';
						cnt++;
					}
					else if (graph [ i ] [ cur.col ] == '6')
					{
						return;
					}
				}
				break;
			case 4: // 북
				for (int i = cur.row - 1; i >= 0; i--)
				{
					if (graph [ i ] [ cur.col ] == '0')
					{
						graph [ i ] [ cur.col ] = '#';
						cnt++;
					}
					else if (graph [ i ] [ cur.col ] == '6')
					{
						return;
					}
				}
				break;
			
			default:
				break;
			}
			
		}
		
	}
	
	private static ArrayList<Cam> camList = new ArrayList<Cam> ( );
	private static int ret, maxIdx, total;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		String st = br.readLine ( );
		int rowSZ = st.charAt (0) - '0';
		int colSZ = st.charAt (2) - '0';
		char [ ] [ ] graph = new char [ rowSZ ] [ colSZ ];
		for (int i = 0; i < rowSZ; i++)
		{
			st = br.readLine ( );
			for (int j = 0; j < colSZ; j++)
			{
				graph [ i ] [ j ] = st.charAt (j * 2);
				if (graph [ i ] [ j ] != '0' && graph [ i ] [ j ] != '6')
				{
					camList.add (new Cam (i, j, graph [ i ] [ j ]));
					maxIdx++;
				}
				if (graph [ i ] [ j ] == '0')
				{
					total++;
				}
			}
		}
		
		doDFS (graph, rowSZ, colSZ, 0, 0);
		System.out.println (total - ret);
		
	} //// end main
	
	private static void doDFS(char [ ] [ ] _graph, int rowSZ, int colSZ, int idx, int cnt)
	{
		
		//System.out.println ("==========================");
		//showGraph (_graph, rowSZ, colSZ);
		if (idx == maxIdx)
		{
			ret = ret > cnt ? ret : cnt;
			return;
		}
		if (cnt == total)
		{
			ret = total;
			return;
		}
		
		Cam cur = camList.get (idx);
		//System.out.println (cur.cam);
		switch (cur.cam)
		{
		case '1': // 4가지, 한방향
			for (int i = 1; i <= 4; i++)
			{
				char [][] temp=copyArray (_graph);
				InitGraph test = new InitGraph (temp, rowSZ, colSZ, cur);
				test.init (i);
				doDFS (temp, rowSZ, colSZ, idx + 1, cnt + test.cnt);
			}
			break;
		case '2': // 2가지, 평행
			for (int i = 1; i <= 3; i += 2)
			{
				char [ ] [ ] temp = copyArray (_graph);
				InitGraph test = new InitGraph (temp, rowSZ, colSZ, cur);
				test.init (i);
				test.init (i + 1);
				doDFS (temp, rowSZ, colSZ, idx + 1, cnt + test.cnt);
			}
			break;
		case '3': // 4가지,  수직
			for (int i = 1; i <= 2; i++)
			{
				for (int j = 3; j <= 4; j++)
				{
					char [ ] [ ] temp = copyArray (_graph);
					InitGraph test = new InitGraph (temp, rowSZ, colSZ, cur);
					test.init (i);
					test.init (j);
					doDFS (temp, rowSZ, colSZ, idx + 1, cnt + test.cnt);
				}
			}
			break;
		case '4': // 4가지, ㅗ
			for (int i = 1; i <= 4; i++)
			{
				char [ ] [ ] temp = copyArray (_graph);
				InitGraph test = new InitGraph (temp, rowSZ, colSZ, cur);
				for (int j = 1; j <= 4; j++)
				{
					if (i != j)
					{
						test.init (j);
					}
				}
				doDFS (temp, rowSZ, colSZ, idx + 1, cnt + test.cnt);
			}
			break;
		case '5': // 1가지,  +
			char [ ] [ ] temp = copyArray (_graph);
			InitGraph test = new InitGraph (temp, rowSZ, colSZ, cur);
			for (int i = 1; i <= 4; i++)
			{
				test.init (i);
			}
			doDFS (temp, rowSZ, colSZ, idx + 1, cnt + test.cnt);
			break;
		
		default:
			break;
		}
		
	}
	
	private static char [ ] [ ] copyArray(char [ ] [ ] graph)
	{
		char [ ] [ ] ret = new char [ graph.length ] [ ];
		for (int i = 0; i < graph.length; i++)
		{
			ret [ i ] = graph [ i ].clone ( );
		}
		return ret;
	}
	
	private static void showGraph(char [ ] [ ] graph, int _r, int _c)
	{
		StringBuilder show = new StringBuilder ( );
		for (int i = 0; i < _r; i++)
		{
			for (int j = 0; j < _c; j++)
			{
				show.append (graph [ i ] [ j ] + " ");
			}
			show.append ("\n");
		}
		show.append ("\n\n");
		System.out.println (show);
	}
} //// end class
