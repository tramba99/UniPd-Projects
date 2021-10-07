import java.util.*;

public class TestList
{
	public static void main(String[] argv)
	{
		//aggiorna interfacce
		List l1 = null, l2 = null;
		ListIterator li = null;
		String[] args = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};

		if(argv.length < 6)
		{
			argv = args;
		}

		// aggiorna con adapter
		l1 = new ListAdapter();

		for(int i=0;i<argv.length;i++)
		{
			l1.add(argv[i]);
		}
		System.out.println("List.toString() ? " + l1);

		try
		{
			int dl0, dl1, dsl0, dsl1;

			iterate(l1.iterator());
			System.out.println(l1 + " " + l1.size());
			dl0 = l1.size();

			l2 = l1.subList(0, argv.length/2);
			dsl0 = l2.size();

			iterate(l2.iterator());
			System.out.println(l2 + " " + l2.size());

			l2.clear();
			dl1 = l1.size();
			dsl1 = l2.size();
			System.out.println(l1 + " " + l1.size());
			iterate(l1.iterator());
			System.out.println(l2 + " " + l2.size());
			iterate(l2.iterator());

			if(dsl0 == dl0/2 && dsl1 == 0 && dl1 == (dl0 - dsl0))
			{
				System.out.println("\n*** sublist is backed correctly ***\n");
			}
			else
			{
				System.out.println(dl0 + " " + dl1 + " " + dsl0 + " " + dsl1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			System.out.println("TestListIterator #1");
			iterate(l1.iterator());
			li = l1.listIterator(l1.size());
			while(li.hasPrevious())
			{
				System.out.print(li.previous() + " ");
				iterate(l1.iterator());
				li.remove();
			}
			iterate(l1.iterator());
			if(l1.size() == 0)
			{
				System.out.println("\n*** listiterator from end works and backward removal works ***\n");
			}
			else
			{
				System.out.println("\n*** listiterator from end not working ***\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			int dl0, dl1, dl2;
			System.out.println("TestListIterator #2");
			dl0 = l1.size();
			for(int i=0;i<argv.length;i++)
			{
				l1.add(argv[i]);
			}
			dl1 = l1.size();
			iterate(l1.iterator());
			li = l1.listIterator();
			while(li.hasNext())
			{
				System.out.print(li.next() + " ");
				iterate(l1.iterator());
				li.remove();
			}
			dl2 = l1.size();
			iterate(l1.iterator());

			if(dl1 == (dl0+argv.length) && dl2 == 0)
			{
				System.out.println("\n*** insertion and forward removal works ***\n");
			}
			else
			{
				System.out.println("\n*** insertion and forward removal not working ***\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		try
		{
			int dl0, dl1, dl2;

			System.out.println("TestListIterator #3");
			dl0 = l1.size();
			for(int i=0;i<argv.length;i++)
			{
				l1.add(argv[i]);
			}
			dl1 = l1.size();
			iterate(l1.iterator());
			li = l1.listIterator();
			while(li.hasNext())
				li.next();
			while(li.hasPrevious())
			{
				System.out.print(li.previous() + " ");
				iterate(l1.iterator());
				li.remove();
			}
			dl2 = l1.size();
			iterate(l1.iterator());
			if(dl1 == (dl0+argv.length) && dl2 == 0)
			{
				System.out.println("\n*** insertion and forward to end and backward removal works ***\n");
			}
			else
			{
				System.out.println("\n*** insertion and forward to end and backward removal not working ***\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//aggiorna interfaccia Iterator
	public static void iterate(Iterator iter)
	{
		System.out.print("{");
		while(iter.hasNext())
		{
			System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}
}
