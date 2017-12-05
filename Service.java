import java.util.concurrent.TimeUnit;

interface Service
{
	public void performService();
}

class Service1 implements Service
{
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
		Agent a = Agent.getInstance();
		a.notify(EVENT_TYPE.OP1);
	}
}

class Service2 implements Service
{
	public void performService()
	{
		Agent a = Agent.getInstance();
		a.notify(EVENT_TYPE.OP2);
	}
}