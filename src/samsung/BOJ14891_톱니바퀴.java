package samsung;

import java.io.*;
import java.util.*;

// BOJ14891_톱니바퀴
public class BOJ14891_톱니바퀴
{
	private static int [ ] list = new int [ 5 ];
	private static int [ ] [ ] op;
	private static int opNum;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		for (int i = 1; i <= 4; i++)
		{
			list [ i ] = Integer.parseInt (st.nextToken ( ), 2);
			st = new StringTokenizer (br.readLine ( ));
		}
		
		opNum = Integer.parseInt (st.nextToken ( ));
		op = new int [ opNum ] [ 2 ];
		for (int i = 0; i < opNum; i++)
		{
			st = new StringTokenizer (br.readLine ( ));
			op [ i ] [ 0 ] = Integer.parseInt (st.nextToken ( ));
			op [ i ] [ 1 ] = Integer.parseInt (st.nextToken ( ));
		}
		for (int i = 0; i < opNum; i++)
		{
			solve (i);
		}
		int ret = 0;
		for (int i = 1; i <= 4; i++)
		{
			if ((list [ i ] & 0x80) != 0)
			{
				switch (i)
				{
				case 1:
					ret = ret + 1;
					break;
				case 2:
					ret = ret + 2;
					break;
				case 3:
					ret = ret + 4;
					break;
				case 4:
					ret = ret + 8;
					break;
				
				default:
					break;
				}
			}
		}
		System.out.println (ret);
	}
	
	private static void solve(int idx)
	{
		int [ ] rot = new int [ 5 ];
		int wheelIdx = op [ idx ] [ 0 ];
		int oper = op [ idx ] [ 1 ];
		rot [ wheelIdx ] = oper;
		//System.out.println (rot[wheelIdx]);
		for (int i = wheelIdx - 1; i >= 1; i--)
		{
			if (rot [ i + 1 ] == 0)
			{
				rot [ i ] = 0;
				continue;
			}
			int temp = (list [ i ] & 0x20) | (list [ i + 1 ] & 0x2);
			if (temp == 0 || temp == 34) // 같은극 회전 안함
			{
				rot [ i ] = 0;
			}
			else // 다른극 반대방향으로 회전함
			{
				rot [ i ] = -rot [ i + 1 ];
			}
		}
		for (int i = wheelIdx + 1; i <= 4; i++)
		{
			if (rot [ i - 1 ] == 0)
			{
				rot [ i ] = 0;
				continue;
			}
			int temp = (list [ i ] & 0x2) | (list [ i - 1 ] & 0x20);
			if (temp == 0 || temp == 34)
			{
				rot [ i ] = 0;
			}
			else
			{
				rot [ i ] = -rot [ i - 1 ];
			}
		}
		for (int i = 1; i <= 4; i++)
		{
			list [ i ] = rotate (rot [ i ], list [ i ]);
		}
	}
	
	private static int rotate(int v, int n)
	{
		int temp = 0;
		switch (v)
		{
		case 1:
			if (n % 2 == 1)
			{
				temp = 0x80;
			}
			n = n >> 1;
			n = n | temp;
			break;
		case -1:
			int t = n & 0x80;
			n = n << 1;
			if (t == 128)
			{
				n = n & 0xff;
				n = n | 0x1;
			}
			
			break;
		
		default:
			break;
		}
		return n;
	}
	
} //// end class
