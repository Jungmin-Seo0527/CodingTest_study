package others;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

// HashMap
public class study_HashMap
{
	public static void main(String [ ] args) throws IOException
	{
		HashMap<String, String> map1 = new HashMap<String, String> ( ); // HashMap ����
		HashMap<String, String> map2 = new HashMap<> ( );// new ���� Ÿ�� �Ķ���� ���� ����
		HashMap<String, String> map3 = new HashMap<> (map1); // map1�� ��� ���� ���� HashMap ����
		HashMap<String, String> map4 = new HashMap<> (10); // �ʱ� �뷮 (capacity) ����
		HashMap<String, String> map5 = new HashMap<> (10, 0.7f); // �ʱ� capacity, load factor ���� (load factor�� �����ΰ�?)
		HashMap<String, String> map6 = new HashMap<String, String> ( )
		{
			{
				put ("a", "b"); // �ʱⰪ ����
			}
		};
		//		HashMap�� �����Ϸ��� Ű Ÿ�԰� �� Ÿ���� �Ķ���ͷ� �ְ� �⺻ �����ڸ� ȣ���ϸ� �ȴ�.
		//		HashMap�� ����������� ���� �߰��� ������ Listó�� ��������� �߰��� �ø��µ� List ó�� ��������� �� ĭ�� �ø��� �ʰ� �� �ι�� �ø���.
		//		���⼭ �����ϰ� ���� �߻��Ѵ�. �׷��⿡ �ʱ⿡ ������ ������ ������ �˰� �ִٸ� Map�� �ʱ� �뷮�� �������ִ� ���� ����.
		
		// HashMap �� �߰�
		HashMap<Integer, String> map = new HashMap<> ( );
		map.put (1, "���"); // �� �߰�
		map.put (2, "�ٳ���");
		map.put (3, "����");
		
		// HshMap �� ����
		map.remove (1); // key�� 1 ����
		map.clear ( ); // ��� �� ����
		
		// HashMap �� ���
		HashMap<Integer, String> test_map = new HashMap<> ( );
		test_map.put (1, "���");
		test_map.put (2, "�ٳ���");
		test_map.put (3, "����");
		
		System.out.println (test_map); // ��ü ��� : {1=���, 2=�ٳ���, 3=����}
		System.out.println (test_map.get (1));
		
		// entrySet() Ȱ��
		for (Entry<Integer, String> entry: test_map.entrySet ( ))
		{
			System.out.println ("[Key]: " + entry.getKey ( ) + " [value]: " + entry.getValue ( ));
		}
		// [Key]: 1 [Value]: ���
		// [Key]: 2 [Value]: �ٳ���
		// [Key]: 3 [Value]: ����
		
		// keyset() Ȱ��
		System.out.println ("KeySet() Ȱ��");
		for (Integer i: test_map.keySet ( ))
		{
			System.out.println ("[Key]: " + i + " [Value]: " + test_map.get (i));
		}
		
		/*HashMap�� ����ϴ� ������� �پ��� ����� �ִ�. �׳� print�ϰ� �Ǹ� {}�� ���� Map�� ��ü key��, value�� ��µȴ�.
		Ư�� key���� value�� �������� �ʹٸ� get(key)�� ����ϸ� �ǰ� ��ü�� ����Ϸ��� entrySet()�̳� keySet() �޼ҵ带
		Ȱ���Ͽ� Map�� ��ü�� ��ȯ���� �� ����ϸ� �ȴ�.
		entrySet()�� key�� value ��ΰ� �ʿ��� ��� ����ϸ� keySet()�� key ���� �ʿ��� ��� ����ϴµ� key���� �޾Ƽ� get(key)��
		Ȱ���Ͽ� value�� ����� ���� �ֱ⿡ � �޼ҵ带 �����ϵ��� ���� ū ����� ���� ��κ� �ڵ尡 ������ keySet�� Ȱ���Ѵ�.
		�㳪 key���� �̿��ؼ� value�� ã�� �������� �ð��� ���� �Ҹ�ǹǷ� ���� ���� �����͸� �����;� �Ѵٸ� entrySet()�� ����(�� 20%~200% ���� ���ϰ� ����)
		*/
		
		// Iterator ���
		// HashMap�� ��ü ��½� �ݺ����� ������� �ʰ� Iterator�� ����� �� �ִ�. 
		
		System.out.println ("\n---Iterator ���---");
		HashMap<Integer, String> test2 = new HashMap<Integer, String> ( )
		{
			{
				put (1, "���");
				put (2, "�ٳ���");
				put (3, "����");
			}
		};
		
		// entrySet().iterator();
		System.out.println ("entrySet().iteator()");
		Iterator<Entry<Integer, String>> entries = test2.entrySet ( ).iterator ( );
		while (entries.hasNext ( ))
		{
			Map.Entry<Integer, String> entry = entries.next ( );
			System.out.println ("[Key]: " + entry.getKey ( ) + " [Value]: " + entry.getValue ( ));
		}
		
		System.out.println ("KeySet().iterator");
		Iterator<Integer> keys = test2.keySet ( ).iterator ( );
		while (keys.hasNext ( ))
		{
			int key = keys.next ( );
			System.out.println ("[Key]: " + key + " [Value]: " + test2.get (key));
		}
		
	} //// end main
	
} //// end class