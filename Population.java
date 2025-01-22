//import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Population
{
	private int size;
	private ArrayList<HashSet<Integer>> pop;
	private Random generator;
	
	public Population(int size, Random generator)
	{
		this.size = size;
		this.pop = new ArrayList<HashSet<Integer>>();
		for(int i = 0; i < size; i++)
		{
			HashSet<Integer> s = new HashSet<Integer>();
			pop.add(s);
		}
		this.generator = generator;
	}
	
	public void display()
	{
		for(int i = 0; i < size; i++)
		{
			System.out.println(pop.get(i));
		}
	}
	
	public void initial()
	{
		for(int i = 0; i < size; i++)
		{
			int mother = generator.nextInt(size);
			int father = generator.nextInt(size);
			pop.get(mother).add(i);
			pop.get(father).add(i);
		}
	}

	public Population generation()
	{
		Population previous = new Population(size, generator);
		for(int i = 0; i < size; i++)
		{
			// pick random parents
			int mother = generator.nextInt(size);
			int father = generator.nextInt(size);
			
			// update previous generation
			previous.pop.get(mother).addAll(pop.get(i));
			previous.pop.get(father).addAll(pop.get(i));
		}
		return previous;
	}
	
	public int max()
	{
		int result = 0;
		for(int i = 0; i < size; i++)
		{
			int s = pop.get(i).size();
			if(s > result)
			{
				result = s;
			}
		}
		return result;
	}
	
	public Population mostRecent()
	{
		if(max() == size)
		{
			return this;
		}
		else
		{
			return generation().mostRecent();
		}
	}
	
	public int mostRecent(int current)
	{
		if(max() == size)
		{
//			display();
			return current;
		}
		else
		{
			return generation().mostRecent(current+1);
		}
	}
	
}