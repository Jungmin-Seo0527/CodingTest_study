package BrouteForce;

import java.io.*;
import java.util.*;

// BOJ1062_가르침
public class BOJ1062_가르침
{
	static int num_words, num_alpha;
	static String [ ] words;
	static boolean [ ] visited = new boolean [ 26 ];
	static int solution;
	
	public static void main(String [ ] args) throws IOException
	{
		inputAndSettingData ( );
		
		if (num_alpha > 5)
		{
			for (int i = 0; i < 26; i++)
			{
				if (visited [ i ] == false)
				{
					visited [ i ] = true;
					doDFS (i, 6);
					visited [ i ] = false;
				}
			}
		}
		else if (num_alpha == 5)
		{
			solution = countReadableWords ( );
		}
		
		System.out.println (solution);
	} //// end main
	
	static void inputAndSettingData( ) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num_words = Integer.parseInt (st.nextToken ( ));
		num_alpha = Integer.parseInt (st.nextToken ( ));
		
		words = new String [ num_words ];
		for (int i = 0; i < num_words; i++)
		{
			words [ i ] = br.readLine ( );
		}
		visited [ 'a' - 'a' ] = true;
		visited [ 'c' - 'a' ] = true;
		visited [ 'i' - 'a' ] = true;
		visited [ 'n' - 'a' ] = true;
		visited [ 't' - 'a' ] = true;
	}
	
	static void doDFS(int curAlpha, int _curCnt)
	{
		if (_curCnt == num_alpha)
		{
			int retCnt = countReadableWords ( );
			solution = solution > retCnt ? solution : retCnt;
			return;
		}
		
		for (int i = curAlpha + 1; i < 26; i++)
		{
			if (! visited [ i ])
			{
				visited [ i ] = true;
				doDFS (i, _curCnt + 1);
				visited [ i ] = false;
			}
		}
	}
	
	static int countReadableWords( )
	{
		int ret = 0;
		for (int i = 0; i < num_words; i++)
		{
			String temp_word = words [ i ];
			int temp_word_length = temp_word.length ( );
			int flag = 0;
			for (int j = 4; j < temp_word_length - 4; j++)
			{
				if (visited [ temp_word.charAt (j) - 'a' ] == false)
				{
					flag = 1;
					break;
				}
			}
			if (flag == 0) ret++;
		}
		return ret;
	}
	
} //// end class
