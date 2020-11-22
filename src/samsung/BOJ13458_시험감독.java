package samsung;

import java.io.*;
import java.util.*;

// BOJ13458_시험감독
public class BOJ13458_시험감독
{
	private static int classNum;
	private static int classArr[];
	private static int first_supervisor;
	private static int second_supervisor;
	
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		
		classNum = Integer.parseInt (st.nextToken ( ));
		classArr = new int [ classNum ];
		st = new StringTokenizer (br.readLine ( ));
		for (int i = 0; i < classNum; i++)
		{
			classArr [ i ] = Integer.parseInt (st.nextToken ( ));
		}
		st = new StringTokenizer (br.readLine ( ));
		first_supervisor = Integer.parseInt (st.nextToken ( ));
		second_supervisor = Integer.parseInt (st.nextToken ( ));
		
		long ret = classNum; // 자료형 주의
		for (int i = 0; i < classNum; i++)
		{
			classArr [ i ] -= first_supervisor;
			if (classArr [ i ] > 0)
			{
				ret += classArr [ i ] / second_supervisor;
				if (classArr [ i ] % second_supervisor != 0) ret++;
			}
		}
		
		sb.append (ret);
		System.out.println (sb);
		
	} //// end main
	
} //// end class
