abstract class State
{
	abstract public void handle_event();
}

class Op1State extends State
{
	private String name;
	private final EventType e = EventType.OP1;

	public Op1State(String name)
	{
		this.name = name;
	}

	public void handle_event()
	{
		System.out.println(name);
		Dispatch.notify1();
	}
}

class Op2State extends State
{
	private int price;
	private final EventType e = EventType.OP2;

	public Op2State(int price)
	{
		this.price = price;
	}

	public void handle_event()
	{
		System.out.println(price);
		Dispatch.notify1();
	}
}