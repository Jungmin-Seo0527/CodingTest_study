package BrouteForce;

import java.io.*;
import java.util.*;

// 참고 코드 (시간 단축)
public class BOJ1339_단어수학_lowTime
{
	private static int num;
	private static int [ ] alpha = new int [ 26 ];
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		num = Integer.parseInt (br.readLine ( ));
		for (int i = 0; i < num; i++)
		{
			String temp = br.readLine ( );
			for (int j = 0; j < temp.length ( ); j++)
			{
				alpha [ temp.charAt (j) - 'A' ] += Math.pow (10, temp.length ( ) - j - 1);
			}
		}
		Arrays.sort (alpha);
		int n = 9;
		int ret = 0;
		for (int i = 25; i >= 0; i--)
		{
			if (alpha [ i ] != 0)
			{
				ret += (alpha [ i ] * n);
				n--;
			}
		}
		System.out.println (ret);
	}
}
