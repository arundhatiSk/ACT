abstract class State
{
	abstract public void handle_event();
}

class Op1State extends State
{
	private String name;
	public Op1State(String name)
	{
		this.name = name;
	}

	public void handle_event()
	{
		System.out.println(name);
	}
}

class Op2State extends State
{
	private int price;
	public Op2State(int price)
	{
		this.price = price;
	}

	public void handle_event()
	{
		System.out.println(price);
	}
}