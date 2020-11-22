package others;

public class VarargsFunc
{
	
	public static void main(String [ ] args)
	{
		test("Java");
		test("python", "Java");
		
	}
	private static void test(String ...lang)
	{
		for(String out:lang)
		{
			System.out.print (out+" ");
		}
		System.out.println ();
	}
}
