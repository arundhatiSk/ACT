import java.util.Queue;
import java.util.*;
import java.util.concurrent.TimeUnit;


class Client
{

	private static Dispatch dispatch = new Dispatch("FIFO");

	public static void main(String[] args)
	{
		Agent agent = Agent.getInstance();
		Op1State act1 = new Op1State("Name");
		agent.register(act1 , EventType.OP1);

		Op2State act2 = new Op2State(345);
		agent.register(act2 , EventType.OP2);

		

		Service s1 = new Service1();
		Service s2 = new Service2();
		Service s3 = new Service2();
		dispatch.setPriority(1,s1);
		dispatch.setPriority(3,s2);
		dispatch.setPriority(4,s3);
		
		Service[] services = {s1,s2,s3};
		dispatch.dispatchService(services);
		while(true)
		{

		}
	}
}