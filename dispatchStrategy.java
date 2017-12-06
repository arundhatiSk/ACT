import java.util.*;

class dispatchStrategy
{
	public void dispatchService(Service s)
	{

	}
	public void notify1()
	{

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