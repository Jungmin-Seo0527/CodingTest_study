package samsung;

import java.io.*;
import java.util.*;

// BOJ_14499_주사위_굴리기
public class BOJ_14499_주사위_굴리기
{
	private static int rowSZ, colSZ, curRow, curCol, comNum;
	private static int [ ] [ ] graph;
	private static int [ ] comArr;
	
	private static int [ ] dice = new int [ 7 ];
	private static int [ ] ewDice =
	{ 1 , 3 , 6 , 4 };
	private static int [ ] nsDice =
	{ 1 , 5 , 6 , 2 };
	
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		rowSZ = Integer.parseInt (st.nextToken ( ));
		colSZ = Integer.parseInt (st.nextToken ( ));
		curRow = Integer.parseInt (st.nextToken ( ));
		curCol = Integer.parseInt (st.nextToken ( ));
		comNum = Integer.parseInt (st.nextToken ( ));
		graph = new int [ rowSZ ] [ colSZ ];
		comArr = new int [ comNum ];
		
		/*		for (int i = 0; i < rowSZ; i++)
				{
					st = new StringTokenizer (br.readLine ( ));
					for (int j = 0; j < colSZ; j++)
					{
						graph [ i ] [ j ] = Integer.parseInt (st.nextToken ( ));
					}
				}*/
		
		// 시간단축1
		for (int i = 0; i < rowSZ; i++)
		{
			String str = br.readLine ( );
			for (int j = 0; j < colSZ; j++)
			{
				graph [ i ] [ j ] = str.charAt (j * 2) - '0';
			}
		}
		
		// 본래 내가 한 코드 -> StringTokenizer
		
		/*		st = new StringTokenizer (br.readLine ( ));
				for (int i = 0; i < comNum; i++)
				{
					comArr [ i ] = Integer.parseInt (st.nextToken ( ));
				}*/
		
		// 시간단축 2
		String stb = br.readLine ( );
		for (int i = 0; i < comNum; i++)
		{
			comArr [ i ] = stb.charAt (i * 2) - '0';
		}
		
		//showGraph ( );
		for (int i = 0; i < comNum; i++)
		{
			if (check (comArr [ i ]))
			{
				//System.out.print (comArr[i]+" ");
				moveDice (comArr [ i ]);
				change ( );
				//showCur ( );
			}
		}
		System.out.println (sb);
	} //// end main
	
	private static void moveDice(int _com)
	{
		int temp = 0;
		switch (_com)
		{
		case 1:
			temp = ewDice [ 3 ];
			for (int i = 3; i > 0; i--)
			{
				ewDice [ i ] = ewDice [ i - 1 ];
			}
			ewDice [ 0 ] = temp;
			nsDice [ 0 ] = ewDice [ 0 ];
			nsDice [ 2 ] = ewDice [ 2 ];
			
			break;
		
		case 2:
			
			temp = ewDice [ 0 ];
			for (int i = 1; i < 4; i++)
			{
				ewDice [ i - 1 ] = ewDice [ i ];
			}
			ewDice [ 3 ] = temp;
			nsDice [ 0 ] = ewDice [ 0 ];
			nsDice [ 2 ] = ewDice [ 2 ];
			
			break;
		case 3:
			temp = nsDice [ 0 ];
			for (int i = 1; i < 4; i++)
			{
				nsDice [ i - 1 ] = nsDice [ i ];
			}
			nsDice [ 3 ] = temp;
			ewDice [ 0 ] = nsDice [ 0 ];
			ewDice [ 2 ] = nsDice [ 2 ];
			
			break;
		case 4:
			temp = nsDice [ 3 ];
			for (int i = 3; i > 0; i--)
			{
				nsDice [ i ] = nsDice [ i - 1 ];
			}
			nsDice [ 0 ] = temp;
			ewDice [ 0 ] = nsDice [ 0 ];
			ewDice [ 2 ] = nsDice [ 2 ];
			
			break;
		default:
			break;
		}
	}
	
	private static boolean check(int _com)
	{
		switch (_com)
		{
		case 1: //동
			if (curCol + 1 >= colSZ) return false;
			curCol++;
			break;
		case 2: // 서
			if (curCol - 1 < 0) return false;
			curCol--;
			break;
		case 3: // 북
			if (curRow - 1 < 0) return false;
			curRow--;
			break;
		case 4: // 남
			if (curRow + 1 >= rowSZ) return false;
			curRow++;
			break;
		default:
			break;
		}
		return true;
	}
	
	private static void change( )
	{
		int cur_dice_bottom = ewDice [ 2 ];
		if (graph [ curRow ] [ curCol ] == 0)
		{
			graph [ curRow ] [ curCol ] = dice [ cur_dice_bottom ];
		}
		else
		{
			dice [ cur_dice_bottom ] = graph [ curRow ] [ curCol ];
			graph [ curRow ] [ curCol ] = 0;
		}
		sb.append (dice [ ewDice [ 0 ] ] + "\n");
	}
	
} /// end class
