package others;

import java.util.*;

// Priority Queue
// �Ϲ������� Queue��� �ڷ� ������ ���Լ����� ��⿭ ��Ģ�� ������ �ִ�.
// ������ java���� �����ϴ� PriorityQueue�� �켱������ �����Ͽ� ���� ������ �������
// �� �켱������ ���� ������Ʈ�� ������ �ȴ�. 

/*class Prisoner
{
	String name;
	int weight; // ����
	public Prisoner(String name, int weight)
	{
		super();
		this.name=name;
		this.weight=weight;
	}
}*/
// �� Ŭ������ name�� weight�� 2���� �ʵ尡 �ִ�. �� Prosoner Ŭ������ PriorityQUeue�� �ְ�, 
// ������ ���� ť���� ������ (����ϰ�) �Ϸ��� �Ѵ�.

// ���� �Ϲ������� ������ ������ ���� ����ϴ� �ؾ� �Ѵ�. 
// ���� Prisoner Ŭ������ Comparable �������̽��� ��������

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
// ���� Comparable �������̽��� ������ Prisoner Ŭ������ �ִ�. ������ ���� Prisoner ��ü�� ���� ������ ���� compareTo �޼ҵ带
// ������������ ���� �ǵ��� �����Ͽ���. 

// * PriorityQueue ���

// ���� �׽�Ʈ Ŭ������ getPriorityQueue �޼ҵ带 �����Ѵ�. �� �޼ҵ�� 5���� Prisoner ��ü�� �����Ͽ�
// PriorityQueue�� �ְ� �ش� PriorityQueue ��ü�� ��ȯ�Ѵ�. 

class Main
{
	// * PriorityQueue ���
	
	// ���� �׽�Ʈ Ŭ������ getPriorityQueue �޼ҵ带 �����Ѵ�. �� �޼ҵ�� 5���� Prisoner ��ü�� �����Ͽ�
	// PriorityQueue�� �ְ� �ش� PriorityQueue ��ü�� ��ȯ�Ѵ�. 
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
	// 5���� �˼� ��ü�� �����Ͽ� �켱���� ť�� �־���. �� �˼� ��ü���� ���� ������ �ٸ���
	
	// ���� Prisoner Ŭ������ Comparable �������̽��� �������� ����ä PriorityQueue�� ��������� ��� �ɱ�?
	// �켱����ť�� offer �� ť ���� ���� ������Ʈ�� �����ϴµ�, �̶� '������'�� �̿��Ͽ� �߰� �Ǵ� ������Ʈ ��ü�� Comparable �������̽��� Up casting �Ѵ�.
	// ������ Comparable �������̽��� ������ ��ü�� �ƴ϶�� �翬�� �Ʒ��� ���� ���� �޽����� ����ȴ�.
	// Exception in thread "main" java.lang.ClassCastException: Prisoner cannot be cast to java.lang.Comparable
	
	// ���� main �޼ҵ� ����
	
	public static void main(String [ ] args)
	{
		PriorityQueue<Prisoner> priorityQueue = getPriorityQueue ( );
		
		System.out.println ("=====================Normal Order");
		
		while (! priorityQueue.isEmpty ( ))
		{
			Prisoner prisoner = priorityQueue.poll ( );
			System.out.println (prisoner.name);
			// ��� -> thomson james silvia alex schofield
		}
		
		// ���� ���������� �ƴ� ������������ ����� �ϰ� �ʹٸ� ��� �ϴ°�?
		// compareTo �޼ҵ带 ���� ������������ ������������ �����ϴ� �� ���ٴ�
		// ������ �ڵ带 �״�� �ΰ� Order�� ������ ����� �ִ�. 
		
		PriorityQueue<Prisoner> priorityQueue2 = getPriorityQueue ( );
		
		PriorityQueue<Prisoner> reversedPriorityQueue = new PriorityQueue<Prisoner> (priorityQueue2.size ( ), Collections.reverseOrder ( ));
		reversedPriorityQueue.addAll (priorityQueue2);
		
		System.out.println ("======================= Reversed Order!");
		while (! reversedPriorityQueue.isEmpty ( ))
		{
			Prisoner prisoner = reversedPriorityQueue.poll ( );
			System.out.print (prisoner.name + " ");
		}
		
		// Collectons.reverseOrder() �޼ҵ带 ���캸�� �˰�����, �� Comparable ��ü�� ���ϴ� ������ ������ Comparator ��ü�� �����Ѵ�.
		// �̷ν� reversedPriorityQueue �����̳ʰ� ������ �ǰ�, �ٷ� ���� ������ ���������� priorityQueue2 �����̳ʸ� addAll �ϰ� �Ǹ�
		// reversedPriorityQueue �� �켱���� ��å���� ���ؼ� �����̳� ���� ������Ʈ�� �켱������ �ڹٲ��. 
	}
}
