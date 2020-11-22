package others;

import java.io.*;
import java.util.*;

// 	1) http://naver.com 입력
// 	2) http:// 없애기 -> naver.com
//	3)  '.'(콤마)이후 없애기 ->naver
//	4)  naver에서 앞에 3개만 따기 ->nav
//	5)  naver에서 문자열 길이+'e'의 갯수 +! -> nav51! (완성)

public class StringPractice
{
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		//int num=Integer.parseInt (br.readLine ( ));
		
		String str = br.readLine ( );
		//char[] number=br.readLine().toCharArray ( );
		char [ ] number = str.toCharArray ( );
		
		str = str.replace ("http://", ""); // 문자열내 특정 문자열 찾아어 없애기
		str = str.substring (0, str.indexOf (".")); // 0부터 .인덱스 이전가지만 추출
		System.out.println (str); // naver
		
		int str_cnt = str.length ( ); //naver 길이
		int e_cnt = contCharIntString (str, 'e'); // 사용자 함수 'e' 카운트
		
		str = str.substring (0, 2) + str_cnt + e_cnt + "!"; // concat
		System.out.println (str);
		
	}
	
	private static int contCharIntString(String _input, char _find)
	{
		int ret = 0;
		for (int i = 0; i < _input.length ( ); i++)
		{
			if (_input.charAt (i) == _find)
			{
				ret++;
			}
		}
		return ret;
	}
}
