package others;

import java.io.*;
import java.util.*;

// 	1) http://naver.com �Է�
// 	2) http:// ���ֱ� -> naver.com
//	3)  '.'(�޸�)���� ���ֱ� ->naver
//	4)  naver���� �տ� 3���� ���� ->nav
//	5)  naver���� ���ڿ� ����+'e'�� ���� +! -> nav51! (�ϼ�)

public class StringPractice
{
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		//int num=Integer.parseInt (br.readLine ( ));
		
		String str = br.readLine ( );
		//char[] number=br.readLine().toCharArray ( );
		char [ ] number = str.toCharArray ( );
		
		str = str.replace ("http://", ""); // ���ڿ��� Ư�� ���ڿ� ã�ƾ� ���ֱ�
		str = str.substring (0, str.indexOf (".")); // 0���� .�ε��� ���������� ����
		System.out.println (str); // naver
		
		int str_cnt = str.length ( ); //naver ����
		int e_cnt = contCharIntString (str, 'e'); // ����� �Լ� 'e' ī��Ʈ
		
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
