package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ11723_집합
public class BOJ11723_집합
{
	private static boolean [ ] list = new boolean [ 21 ];
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int num = Integer.parseInt (st.nextToken ( ));
		
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			String op = st.nextToken ( );
			int n = 0;
			if (! op.equals ("all") && ! op.equals ("empty")) n = Integer.parseInt (st.nextToken ( ));
			doCal (op, n);
		}
		System.out.println (sb);
	} /// end main
	
	private static void doCal(String op, int n)
	{
		switch (op)
		{
		case "add":
			list [ n ] = true;
			break;
		case "remove":
			if (list [ n ]) list [ n ] = false;
			break;
		case "check":
			if (list [ n ])
			{
				sb.append ("1\n");
			}
			else
			{
				sb.append ("0\n");
			}
			break;
		case "toggle":
			if (list [ n ]) list [ n ] = false;
			else list [ n ] = true;
			break;
		case "all":
			for (int i = 1; i < 21; i++)
			{
				list [ i ] = true;
			}
			break;
		case "empty":
			for (int i = 1; i < 21; i++)
			{
				list [ i ] = false;
			}
			break;
		
		default:
			break;
		}
	}
	
} //// end class