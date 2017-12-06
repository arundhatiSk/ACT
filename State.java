abstract class State
{
	abstract public void handle_event();
}

class Op1State extends State
{
	private String name;
	private final EVENT_TYPE e = EVENT_TYPE.OP1;

	public Op1State(String name)
	{
		this.name = name;
	}

	public void handle_event()
	{
		System.out.println(name);
		Client.notify1();
	}
}

class Op2State extends State
{
	private int price;
	private final EVENT_TYPE e = EVENT_TYPE.OP2;

	public Op2State(int price)
	{
		this.price = price;
	}

	public void handle_event()
	{
		System.out.println(price);
		Client.notify1();
	}
}