import java.util.concurrent.TimeUnit;

abstract class Service
{
	private EVENT_TYPE e = EVENT_TYPE.OP;
	abstract public void performService();

	public EVENT_TYPE getEventType()
	{
		return e;
	}
}

class Service1 extends Service
{
	private static final EVENT_TYPE e = EVENT_TYPE.OP1;
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

	public EVENT_TYPE getEventType()
	{
		return e;
	}
}

class Service2 extends Service
{
	private static final EVENT_TYPE e = EVENT_TYPE.OP2;
	public void performService()
	{
		Agent a = Agent.getInstance();
		a.notify(e);
	}

	public EVENT_TYPE getEventType()
	{
		return e;
	}
}