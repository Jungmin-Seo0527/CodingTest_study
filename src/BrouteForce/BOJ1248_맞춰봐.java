package BrouteForce;

import java.io.*;

// BOJ1248_¸ÂÃçºÁ
public class BOJ1248_¸ÂÃçºÁ
{
	static int num;
	static char op[][];
	static int sol[];
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		for (int i = -10; i <= 10; i++)
		{
			if (check (i, num - 1, num - 1))
			{
				sol [ num - 1 ] = i;
				doDFS (num - 2);
			}
			
		}
	} //// end main
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		num = Integer.parseInt (br.readLine ( ));
		String temp_op = br.readLine ( );
		
		op = new char [ num ] [ num ];
		sol = new int [ num ];
		
		int idx = 0;
		for (int i = 0; i < num; i++)
		{
			for (int j = i; j < num; j++)
			{
				op [ i ] [ j ] = temp_op.charAt (idx++);
			}
		}
	}
	
	static void doDFS(int _idx)
	{
		if (_idx == -1)
		{
			StringBuilder sb = new StringBuilder ( );
			for (int i = 0; i < num; i++)
			{
				sb.append (sol [ i ] + " ");
			}
			System.out.println (sb);
			System.exit (0);
			
		}
		for (int i = -10; i <= 10; i++)
		{
			int sum = 0;
			int flag = 0;
			sol [ _idx ] = i;
			for (int j = _idx; j < num; j++)
			{
				sum += sol [ j ];
				if (check (sum, _idx, j) == false)
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0)
			{
				doDFS (_idx - 1);
			}
		}
	}
	
	static boolean check(int _n, int _r, int _c)
	{
		switch (op [ _r ] [ _c ])
		{
		case '+':
			if (_n > 0) return true;
			
			break;
		case '-':
			if (_n < 0) return true;
			break;
		
		case '0':
			if (_n == 0) return true;
			break;
		default:
			break;
		}
		return false;
	}
	
} //// end class