package others;

import java.util.*;
import java.io.*;

public class ArrayListPractice
{
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args)
	{
		ArrayList<String> AL_str = new ArrayList<String> ( );
		AL_str.add ("유재석");
		AL_str.add ("조세호");
		AL_str.add ("박명수");
		
		System.out.println ("조세호 위치(index) : " + AL_str.indexOf ("조세호"));
		
		AL_str.add ("하하");
		System.out.println (AL_str);
		
		AL_str.add (1, "정형돈");
		System.out.println (AL_str);
		
		AL_str.remove (AL_str.size ( ) - 1); // pop
		System.out.println (AL_str);
		
		AL_str.add ("유재석");
		System.out.println (AL_str);
		System.out.println (countStirng (AL_str, "유재석"));
		
		// ArrayList  출력할때 [ ] , 가 걸리적 거리는 부분
		// 어짜피 출력은 sb로 담을것이니 담을때 내용물만 추출하여 담으면 됨
		for (String temp: AL_str)
		{
			sb.append (temp + " ");
		}
		System.out.println (sb);
		sb.delete (0, sb.length ( )); // 다음을 위한 비우기
		
		ArrayList<Integer> num_list = new ArrayList<Integer> ( );
		num_list.add (5);
		num_list.add (2);
		num_list.add (4);
		num_list.add (3);
		num_list.add (1);
		
		System.out.println (num_list);
		int [ ] ret = new int [ num_list.size ( ) ];
		int idx = 0;
		
		for (int temp: num_list)
		{
			ret [ idx++ ] = temp;
			sb.append (temp + " ");
		}
		for (int temp: ret)
		{
			System.out.print (temp + " ");
		}
		// 정수 배열로 만든후 다시 루프를 돌아 출력하는것 보다
		// sb에 담아서 출력하는게 더 빠르지 않을까 하는 궁금증이 있지만
		// 모르겠다. 그냥 맘편히 sb를 이용하는게 좋겠다.
		System.out.println ( );
		System.out.println (sb);
		
		Collections.sort (num_list); // ArrayList를 Collections.sort(ArrayList) 로 정렬
		System.out.println (num_list);
		
		// 다양한 자료형의 ArrayList는 불가능할 것 같다
		// Generic class 정의하는 방법
		
	} //// end main
	
	private static int countStirng(ArrayList<String> _str, String _find)
	{
		int ret = 0;
		for (int i = 0; i < _str.size ( ); i++)
		{
			if (_str.get (i) == _find) // 해당 인덱스의 문자열 추출
			{
				ret++;
			}
		}
		return ret;
	}
} //// end class
