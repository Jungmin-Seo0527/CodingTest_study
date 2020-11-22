package others;

import java.util.*;
import java.io.*;

public class ArrayListPractice
{
	private static StringBuilder sb = new StringBuilder ( );
	
	public static void main(String [ ] args)
	{
		ArrayList<String> AL_str = new ArrayList<String> ( );
		AL_str.add ("���缮");
		AL_str.add ("����ȣ");
		AL_str.add ("�ڸ��");
		
		System.out.println ("����ȣ ��ġ(index) : " + AL_str.indexOf ("����ȣ"));
		
		AL_str.add ("����");
		System.out.println (AL_str);
		
		AL_str.add (1, "������");
		System.out.println (AL_str);
		
		AL_str.remove (AL_str.size ( ) - 1); // pop
		System.out.println (AL_str);
		
		AL_str.add ("���缮");
		System.out.println (AL_str);
		System.out.println (countStirng (AL_str, "���缮"));
		
		// ArrayList  ����Ҷ� [ ] , �� �ɸ��� �Ÿ��� �κ�
		// ��¥�� ����� sb�� �������̴� ������ ���빰�� �����Ͽ� ������ ��
		for (String temp: AL_str)
		{
			sb.append (temp + " ");
		}
		System.out.println (sb);
		sb.delete (0, sb.length ( )); // ������ ���� ����
		
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
		// ���� �迭�� ������ �ٽ� ������ ���� ����ϴ°� ����
		// sb�� ��Ƽ� ����ϴ°� �� ������ ������ �ϴ� �ñ����� ������
		// �𸣰ڴ�. �׳� ������ sb�� �̿��ϴ°� ���ڴ�.
		System.out.println ( );
		System.out.println (sb);
		
		Collections.sort (num_list); // ArrayList�� Collections.sort(ArrayList) �� ����
		System.out.println (num_list);
		
		// �پ��� �ڷ����� ArrayList�� �Ұ����� �� ����
		// Generic class �����ϴ� ���
		
	} //// end main
	
	private static int countStirng(ArrayList<String> _str, String _find)
	{
		int ret = 0;
		for (int i = 0; i < _str.size ( ); i++)
		{
			if (_str.get (i) == _find) // �ش� �ε����� ���ڿ� ����
			{
				ret++;
			}
		}
		return ret;
	}
} //// end class
