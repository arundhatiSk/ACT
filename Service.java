import java.util.concurrent.TimeUnit;

abstract class Service
{
	private EventType e = EventType.OP;
	abstract public void performService();

	public EventType getEventType()
	{
		return e;
	}
}

class Service1 extends Service
{
	private static final EventType e = EventType.OP1;
	public void performService() 
	{
		try
		{
			TimeUnit.SECONDS.sleep(3);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
		//singleton 
		Agent a = Agent.getInstance();
		a.notify(e);
	}

	public EventType getEventType()
	{
		return e;
	}
}

class Service2 extends Service
{
	private static final EventType e = EventType.OP2;
	public void performService()
	{
		Agent a = Agent.getInstance();
		a.notify(e);
	}

	public EventType getEventType()
	{
		return e;
	}
}