package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1463_1로_만들기
public class BOJ1463_1로_만들기
{

	private static int [ ] dp;
	private static int num;

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));

		dp = new int [ num + 1 ];
		for (int i = 2; i <= num; i++)
		{
			dp [ i ] = findMin (i) + 1;
		}
		System.out.println (dp [ num ]);

	} //// end main

	private static int findMin(int _num)
	{
		int ret;
		int num1 = Integer.MAX_VALUE;
		int num2 = Integer.MAX_VALUE;
		int num3 = Integer.MAX_VALUE;
		if (_num % 3 == 0) num1 = dp [ _num / 3 ];
		if (_num % 2 == 0) num2 = dp [ _num / 2 ];
		num3 = dp [ _num - 1 ];
		ret = num1 < num2 ? num1 : num2;
		ret = ret < num3 ? ret : num3;
		return ret;
	}

} //// end class