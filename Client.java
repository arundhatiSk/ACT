import java.util.Queue;
import java.util.*;
import java.util.concurrent.TimeUnit;


class Client
{

	private static dispatchStrategy dis_strat;

	public static void notify1()
	{
		dis_strat.notify1();
	}

	public static void main(String[] args)
	{
		Agent agent = Agent.getInstance();
		Op1State act1 = new Op1State("Name");
		agent.register(act1 , EVENT_TYPE.OP1);

		Op2State act2 = new Op2State(345);
		agent.register(act2 , EVENT_TYPE.OP2);

		

		Service s1 = new Service1();
		Service s2 = new Service2();
		dis_strat = new FIFO();

		dis_strat.dispatchService(s1);
		try
		{
			TimeUnit.SECONDS.sleep(7);
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
		dis_strat.dispatchService(s2);
		while(true)
		{

		}
	}
}