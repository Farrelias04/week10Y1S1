import java.util.Random;

public class Ancestors
{
	public static void main(String[] args)
	{
		Random generator = new Random();
		
		Population pop = new Population(10, generator);

		System.out.println("Initial population");
		pop.initial();
		pop.display();
		System.out.println();
		Population previous = pop.generation();
		previous.display();
		System.out.println(previous.max());

		System.out.println("Most recent common ancestor population");
		Population recent = pop.mostRecent();
		recent.display();
				
	}
}