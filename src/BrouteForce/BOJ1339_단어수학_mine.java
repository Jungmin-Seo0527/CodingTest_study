package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ1339_단어수학
// 순수한 broute force(DFS) -> 아슬아슬한 시간 
public class BOJ1339_단어수학_mine
{
	private static String [ ] words;
	private static int num;
	private static boolean [ ] visitedNum = new boolean [ 10 ];
	private static boolean [ ] alphaCheck = new boolean [ 26 ];
	private static int [ ] alphaNum = new int [ 26 ];
	private static int [ ] numArr;
	private static int alphaCnt;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		words = new String [ num ];
		for (int i = 0; i < num; i++)
		{
			words [ i ] = br.readLine ( );
		}
		for (int i = 0; i < num; i++)
		{
			for (int j = 0; j < words [ i ].length ( ); j++)
			{
				alphaCheck [ words [ i ].charAt (j) - 'A' ] = true;
			}
		}
		for (int i = 0; i < 26; i++)
		{
			if (alphaCheck [ i ]) alphaCnt++;
		}
		numArr = new int [ alphaCnt ];
		for (int i = 9; i > 9 - alphaCnt; i--)
		{
			visitedNum [ i ] = true;
			doDFS (i, 0);
			visitedNum [ i ] = false;
		}
		System.out.println (max);
	} //// end main
	
	private static void doDFS(int n, int idx)
	{
		numArr [ idx ] = n;
		if (idx == alphaCnt - 1)
		{
			doCal ( );
			return;
		}
		for (int i = 9; i > 9 - alphaCnt; i--)
		{
			if (visitedNum [ i ] == false)
			{
				visitedNum [ i ] = true;
				doDFS (i, idx + 1);
				visitedNum [ i ] = false;
			}
		}
	}
	
	private static void doCal( )
	{
		int idx = 0;
		for (int i = 0; i < 26; i++)
		{
			if (alphaCheck [ i ])
			{
				alphaNum [ i ] = numArr [ idx ];
				idx++;
			}
		}
		int ret = 0;
		for (int i = 0; i < num; i++)
		{
			int ten = 1;
			int temp = 0;
			for (int j = words [ i ].length ( ) - 1; j >= 0; j--)
			{
				temp = temp + alphaNum [ words [ i ].charAt (j) - 'A' ] * ten;
				ten = ten * 10;
			}
			ret += temp;
		}
		max = Math.max (max, ret);
	}
	
} ////end class