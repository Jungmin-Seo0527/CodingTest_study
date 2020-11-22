package others;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

// HashMap
public class study_HashMap
{
	public static void main(String [ ] args) throws IOException
	{
		HashMap<String, String> map1 = new HashMap<String, String> ( ); // HashMap 생성
		HashMap<String, String> map2 = new HashMap<> ( );// new 에서 타입 파라미터 생략 가능
		HashMap<String, String> map3 = new HashMap<> (map1); // map1의 모든 값을 가진 HashMap 생성
		HashMap<String, String> map4 = new HashMap<> (10); // 초기 용량 (capacity) 지정
		HashMap<String, String> map5 = new HashMap<> (10, 0.7f); // 초기 capacity, load factor 지정 (load factor가 무엇인감?)
		HashMap<String, String> map6 = new HashMap<String, String> ( )
		{
			{
				put ("a", "b"); // 초기값 지정
			}
		};
		//		HashMap을 생성하려면 키 타입과 값 타입을 파라미터로 주고 기본 생성자를 호출하면 된다.
		//		HashMap은 저장공간보다 값이 추가로 들어오면 List처럼 저장공간을 추가로 늘리는데 List 처럼 저장공간을 한 칸씩 늘리지 않고 약 두배로 늘린다.
		//		여기서 과부하가 많이 발생한다. 그렇기에 초기에 저장할 데이터 갯수를 알고 있다면 Map의 초기 용량을 지정해주는 것이 좋다.
		
		// HashMap 값 추가
		HashMap<Integer, String> map = new HashMap<> ( );
		map.put (1, "사과"); // 값 추가
		map.put (2, "바나나");
		map.put (3, "포도");
		
		// HshMap 값 삭제
		map.remove (1); // key값 1 제거
		map.clear ( ); // 모든 값 제거
		
		// HashMap 값 출력
		HashMap<Integer, String> test_map = new HashMap<> ( );
		test_map.put (1, "사과");
		test_map.put (2, "바나나");
		test_map.put (3, "포도");
		
		System.out.println (test_map); // 전체 출력 : {1=사과, 2=바나나, 3=포도}
		System.out.println (test_map.get (1));
		
		// entrySet() 활용
		for (Entry<Integer, String> entry: test_map.entrySet ( ))
		{
			System.out.println ("[Key]: " + entry.getKey ( ) + " [value]: " + entry.getValue ( ));
		}
		// [Key]: 1 [Value]: 사과
		// [Key]: 2 [Value]: 바나나
		// [Key]: 3 [Value]: 포도
		
		// keyset() 활용
		System.out.println ("KeySet() 활용");
		for (Integer i: test_map.keySet ( ))
		{
			System.out.println ("[Key]: " + i + " [Value]: " + test_map.get (i));
		}
		
		/*HashMap을 출력하는 방법에는 다양한 방법이 있다. 그냥 print하게 되면 {}로 묶여 Map의 전체 key값, value가 출력된다.
		특정 key값의 value를 가져오고 싶다면 get(key)를 사용하면 되고 전체를 출력하려면 entrySet()이나 keySet() 메소드를
		활용하여 Map의 객체를 반환받은 후 출력하면 된다.
		entrySet()은 key와 value 모두가 필요할 경우 사용하며 keySet()은 key 값만 필요할 경우 사용하는데 key값만 받아서 get(key)를
		활용하여 value도 출력할 수도 있기에 어떤 메소드를 선택하든지 간에 큰 상관이 없어 대부분 코드가 간편한 keySet을 활용한다.
		허나 key값을 이용해서 value를 찾는 과정에서 시간이 많이 소모되므로 많은 양의 데이터를 가져와야 한다면 entrySet()이 좋다(약 20%~200% 성능 저하가 있음)
		*/
		
		// Iterator 사용
		// HashMap의 전체 출력시 반복문을 사용하지 않고 Iterator를 사용할 수 있다. 
		
		System.out.println ("\n---Iterator 사용---");
		HashMap<Integer, String> test2 = new HashMap<Integer, String> ( )
		{
			{
				put (1, "사과");
				put (2, "바나나");
				put (3, "포도");
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