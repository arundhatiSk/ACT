class Client
{
	public static void main(String[] args)
	{
		Agent agent = Agent.getInstance();
		Op1State act1 = new Op1State("Name");
		agent.register(act1 , EVENT_TYPE.OP1);

		Op2State act2 = new Op2State(345);
		agent.register(act2 , EVENT_TYPE.OP2);

		new Thread(new Runnable() {
		    public void run() {
		        (new Service1()).performService();
		    }
		}).start();

		new Thread(new Runnable() {
		    public void run() {
		        (new Service2()).performService();
		    }
		}).start();

		
	}
}