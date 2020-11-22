package others;

import java.util.*;

// Priority Queue
// 일반적으로 Queue라는 자료 구조는 선입선출의 대기열 규칙을 가지고 있다.
// 하지만 java에서 제공하는 PriorityQueue는 우선순위를 결정하여 들어온 순서와 상관없이
// 그 우선순위가 높은 엘리먼트가 나가게 된다. 

/*class Prisoner
{
	String name;
	int weight; // 형량
	public Prisoner(String name, int weight)
	{
		super();
		this.name=name;
		this.weight=weight;
	}
}*/
// 이 클래스는 name와 weight의 2가지 필드가 있다. 이 Prosoner 클래스를 PriorityQUeue에 넣고, 
// 형량에 따라 큐에서 나오게 (출소하게) 하려고 한다.

// 물론 일반적으로 형량이 낮으면 먼저 출소하는 해야 한다. 
// 이제 Prisoner 클래서에 Comparable 인터페이스를 구현하자

class Prisoner implements Comparable<Prisoner>
{
	String name;
	int weight;
	
	public Prisoner(String name, int weight)
	{
		super ( );
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Prisoner target)
	{
		// TODO Auto-generated method stub
		if (this.weight > target.weight)
		{
			return 1;
		}
		else if (this.weight < target.weight)
		{
			return -1;
		}
		return 0;
	}
}
// 위에 Comparable 인터페이스를 구현한 Prisoner 클래스에 있다. 형량이 낮은 Prisoner 객체를 먼저 꺼내기 위해 compareTo 메소드를
// 오름차순으로 정렬 되도록 구현하였다. 

// * PriorityQueue 사용

// 먼저 테스트 클래스에 getPriorityQueue 메소드를 구현한다. 이 메소드는 5개의 Prisoner 객체를 생성하여
// PriorityQueue에 넣고 해당 PriorityQueue 객체를 반환한다. 

class Main
{
	// * PriorityQueue 사용
	
	// 먼저 테스트 클래스에 getPriorityQueue 메소드를 구현한다. 이 메소드는 5개의 Prisoner 객체를 생성하여
	// PriorityQueue에 넣고 해당 PriorityQueue 객체를 반환한다. 
	private static PriorityQueue<Prisoner> getPriorityQueue( )
	{
		Prisoner prisoner1 = new Prisoner ("james", 5);
		Prisoner prisoner2 = new Prisoner ("schofield", 99);
		Prisoner prisoner3 = new Prisoner ("alex", 14);
		Prisoner prisoner4 = new Prisoner ("silvia", 10);
		Prisoner prisoner5 = new Prisoner ("thomson", 1);
		
		PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner> ( );
		
		priorityQueue.offer (prisoner1);
		priorityQueue.offer (prisoner2);
		priorityQueue.offer (prisoner3);
		priorityQueue.offer (prisoner4);
		priorityQueue.offer (prisoner5);
		
		return priorityQueue;
	}
	// 5명의 죄수 객체를 생성하여 우선순위 큐에 넣었다. 이 죄수 객체들은 각각 형량이 다르다
	
	// 만약 Prisoner 클래스에 Comparable 인터페이스를 구현하지 않은채 PriorityQueue에 집어넣으면 어떻게 될까?
	// 우선순위큐의 offer 는 큐 한쪽 끝에 엘리먼트를 저장하는데, 이때 '다형성'을 이용하여 추가 되는 엘리먼트 객체를 Comparable 인터페이스로 Up casting 한다.
	// 하지만 Comparable 인터페이스를 구현한 객체가 아니라면 당연히 아래와 같은 에러 메시지가 노출된다.
	// Exception in thread "main" java.lang.ClassCastException: Prisoner cannot be cast to java.lang.Comparable
	
	// 이제 main 메소드 구현
	
	public static void main(String [ ] args)
	{
		PriorityQueue<Prisoner> priorityQueue = getPriorityQueue ( );
		
		System.out.println ("=====================Normal Order");
		
		while (! priorityQueue.isEmpty ( ))
		{
			Prisoner prisoner = priorityQueue.poll ( );
			System.out.println (prisoner.name);
			// 결과 -> thomson james silvia alex schofield
		}
		
		// 만약 오른차순이 아닌 내림차순으로 출력을 하고 싶다면 어떻게 하는가?
		// compareTo 메소드를 기존 오름차순에서 내림차순으로 구현하는 것 보다는
		// 기존의 코드를 그대로 두고 Order를 뒤집는 방법이 있다. 
		
		PriorityQueue<Prisoner> priorityQueue2 = getPriorityQueue ( );
		
		PriorityQueue<Prisoner> reversedPriorityQueue = new PriorityQueue<Prisoner> (priorityQueue2.size ( ), Collections.reverseOrder ( ));
		reversedPriorityQueue.addAll (priorityQueue2);
		
		System.out.println ("======================= Reversed Order!");
		while (! reversedPriorityQueue.isEmpty ( ))
		{
			Prisoner prisoner = reversedPriorityQueue.poll ( );
			System.out.print (prisoner.name + " ");
		}
		
		// Collectons.reverseOrder() 메소드를 살펴보면 알겠지만, 두 Comparable 객체를 비교하는 순서를 뒤집은 Comparator 객체를 리턴한다.
		// 이로써 reversedPriorityQueue 컨테이너가 생성이 되고, 바로 위에 생성한 오름차순의 priorityQueue2 컨테이너를 addAll 하게 되면
		// reversedPriorityQueue 의 우선순위 정책으로 인해서 컨테이너 안의 엘리먼트의 우선순위가 뒤바뀐다. 
	}
}
