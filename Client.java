import java.util.Queue;
import java.util.*;
import java.util.concurrent.TimeUnit;


class Client
{

	private static Dispatch dispatch;

	public static void main(String[] args)
	{
		Agent agent = Agent.getInstance();

		Service s1 = new Service1();
		Service s2 = new Service2();
		Service s3 = new Service2();
		
		Op1State act1 = new Op1State("abc");
		agent.register(act1 , EventType.OP1);

		Op2State act2 = new Op2State(345);
		agent.register(act2 , EventType.OP2);

		
		int dispatchType;
		
		Scanner sc = new Scanner(System.in);
		
		
		do
		{
			System.out.println("Dispatch Strategy \n1. FIFO\n2. Priority Queue\n");
			dispatchType = sc.nextInt();
			switch(dispatchType)
			{
				case 1:
					dispatch = new Dispatch("FIFO");
					break;
				case 2:
					dispatch = new Dispatch("PQ");
					dispatch.setPriority(1,s1);
					dispatch.setPriority(3,s2);
					dispatch.setPriority(4,s3);
					break;
				default :
					System.out.println("Please enter a valid Strategy");
			}	
		}while(dispatchType != 1 && dispatchType != 2);

		Service[] services = {s1,s2,s3};
		dispatch.dispatchService(services);
		while(true)
		{

		}
	}
}