package DynamicProgramming;

import java.io.*;
import java.util.*;

// BOJ1699_��������_��
public class BOJ1699_��������_��
{
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		int num = Integer.parseInt (st.nextToken ( ));
		int [ ] dp = new int [ num + 1 ];
		
		// �ƽ��ƽ��ϰ� �ð� ��� (ó���ð� ��� 2�� ����)
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
		
		// �ð� ���� (2496 -> 168) �ſ� ���ǹ�
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

	// �������� �Է°� ������ dp�� ��� Ȯ���� c
	// dp�� ä��°��� ���� ����
	// but Ȯ���ϴ°��� �Է°� ���� ���� ��������� ���� ��+�������� �ش��ϴ� dp�� ���� �ּҰ�
	// for������ �ſ� �����
	private static void solve(int [ ] dp, int num)
	{
		//int sq=(int)Math.sqrt(num);
		for (int i = 2; i * i <= num; i++)
		{
			dp [ num ] = Math.min (num / (i * i) + dp [ num % (i * i) ], dp [ num ]);
		}
	}
	
} //// end class
