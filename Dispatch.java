import java.util.*;

class Dispatch
{
	private static dispatchStrategy strategy;
	public Dispatch(String strategy)
	{
		if(strategy == "FIFO")
		{
			this.strategy = new FIFO();
		}
		else if(strategy == "PQ")
		{
			this.strategy = new PQueue();
		}
	}
	public static void notify1()
	{
		strategy.notify1();
	}
	public void setPriority(int p, Service s)
	{
		this.strategy.setPriority(p,s);
	}
	public void dispatchService(Service s)
	{
		this.strategy.dispatchService(s);
	}
	public void dispatchService(Service[] s)
	{
		for(Service service : s)
			this.strategy.dispatchService(service);
	}
}