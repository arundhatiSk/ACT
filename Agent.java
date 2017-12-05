import java.util.*;

enum EVENT_TYPE
{
    OP1, OP2;
}

class Agent
{
	private static Agent agent;
	private HashMap<EVENT_TYPE, ArrayList<State>> registrations;
	public static Agent getInstance()
	{
		if (agent == null)
			agent = new Agent();
		return agent;

	}
	private Agent()
	{

	}

	public void register(State act, EVENT_TYPE e)
	{
		if (registrations == null)
			registrations = new HashMap<EVENT_TYPE, ArrayList<State>>();
		if (registrations.get(e) == null){
			registrations.put(e, new ArrayList<State>());

		}
		registrations.get(e).add(act);
	}

	public void notify(EVENT_TYPE e)
	{
		for(State s: registrations.get(e))
		{
			s.handle_event();
		}
	}
}