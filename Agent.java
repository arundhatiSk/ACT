import java.util.*;

class Agent
{
	private static Agent agent;
	private HashMap<EventType, ArrayList<State>> registrations;
	public static Agent getInstance()
	{
		if (agent == null)
			agent = new Agent();
		return agent;

	}
	private Agent()
	{

	}

	public void register(State act, EventType e)
	{
		if (registrations == null)
			registrations = new HashMap<EventType, ArrayList<State>>();
		if (registrations.get(e) == null){
			registrations.put(e, new ArrayList<State>());

		}
		registrations.get(e).add(act);
	}

	public void notify(EventType e)
	{
		for(State s: registrations.get(e))
		{
			System.out.println("Handling");
			s.handle_event();
		}
	}
}