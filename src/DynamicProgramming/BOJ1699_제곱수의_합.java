package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1699_제곱수의_합
public class BOJ1699_제곱수의_합
{
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int num = Integer.parseInt (st.nextToken ( ));
		int [ ] dp = new int [ num + 1 ];
		
		// 아슬아슬하게 시간 통과 (처리시간 평균 2초 안팎)
		//		for (int i = 1; i <= num; i++)
		//		{
		//			if (isSqrt (i))
		//			{
		//				dp [ i ] = 1;
		//				continue;
		//			}
		//			dp [ i ] = Integer.MAX_VALUE;
		//			for (int j = 1; j <= i / 2; j++)
		//			{
		//				dp [ i ] = Math.min (dp [ j ] + dp [ i - j ], dp [ i ]);
		//				
		//			}
		//		}
		//		System.out.println (dp [ num ]);
		
		// 시간 단축 (2496 -> 168) 매우 유의미
		dp [ 0 ] = 0;
		for (int i = 1; i <= num; i++)
		{
			dp [ i ] = i;
			if (isSqrt (i))
			{
				dp [ i ] = 1;
				continue;
			}
			solve (dp, i);
		}
		System.out.println (dp [ num ]);
		
	} //// end main
	
	private static boolean isSqrt(int _n)
	{
		double temp = Math.sqrt (_n);
		int temp2 = (int) temp;
		if (temp == temp2) return true;
		else return false;
	}

	// 기존에는 입력값 이전의 dp값 모두 확인함 c
	// dp를 채우는것은 같은 원리
	// but 확인하는것은 입력값 보다 작은 제곱수들로 나눈 몫+나머지에 해당하는 dp값 들중 최소값
	// for루프가 매우 단축됨
	private static void solve(int [ ] dp, int num)
	{
		//int sq=(int)Math.sqrt(num);
		for (int i = 2; i * i <= num; i++)
		{
			dp [ num ] = Math.min (num / (i * i) + dp [ num % (i * i) ], dp [ num ]);
		}
	}
	
} //// end class
