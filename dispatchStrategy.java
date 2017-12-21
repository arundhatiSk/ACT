import java.util.*;

class dispatchStrategy
{
	public void dispatchService(Service s)
	{

	}
	public void notify1()
	{

	}
	public void setPriority(int p, Service s)
	{
		
	}
}
class PQueue extends dispatchStrategy
{
	private static int cores;
	private static HashMap<Integer,ArrayList<Service>> PQ = new HashMap<Integer,ArrayList<Service>>();
	private static HashMap<Service,Integer> processPriorities = new HashMap<Service,Integer>();
	private static int current_running;
	
	public PQueue()
	{
		cores = 1;
	}
	public void dispatchService(Service s)
	{
		int p = processPriorities.get(s);
		if (PQ.get(p) == null){
			PQ.put(p, new ArrayList<Service>());
		}
		PQ.get(p).add(s);
		if (current_running < cores)
		{
			for(int i:PQ.keySet())
			{
				System.out.println(i);
			}
			int maxPrior = 0;
			for(int i : PQ.keySet())
			{
				if(i>maxPrior)
				{
					maxPrior = i;
				}
			}
			Service current = PQ.get(maxPrior).get(0);
			//PQ.get(maxPrior).remove(0);
			PQ.remove(maxPrior);
			System.out.println("starting service "+maxPrior);
			new Thread(new Runnable() {
					public void run() {
						System.out.println("Starting service");
						current.performService();
					}
				}).start();
			current_running++;
		}
		
		
	}
	public void setPriority(int p, Service s)
	{
		processPriorities.put(s,p);
	}
	public void notify1()
	{
		current_running--;
		if (!PQ.isEmpty())
		{
			System.out.println("Removing from queue");
			int ind = (int)PQ.keySet().toArray()[0];
			Service toStart = PQ.get(ind).get(0);
			PQ.remove(ind);
			dispatchService(toStart);
		}
	}
}
class FIFO extends dispatchStrategy
{
	private static Queue<Service> queue = new LinkedList<Service>();
	private static int current_running;
	private static int cores;

	public FIFO()
	{
		cores = 1;
	}
	public void dispatchService(Service s)
	{
		if (current_running < cores)
		{
			new Thread(new Runnable() {
			    public void run() {
			    	System.out.println("Starting service");
			        s.performService();
			    }
			}).start();
			current_running++;
		}
		else
		{
			System.out.println("Adding to queue");
			queue.add(s);
			System.out.println();
		}
	}

	public void notify1()
	{
		current_running--;
		if (!queue.isEmpty())
		{
			System.out.println("Removing from queue");
			dispatchService(queue.remove());
		}
	}
}