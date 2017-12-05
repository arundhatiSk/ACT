class State:
	def handle_event(self):
		print("event completed")
		
class Op1_state(State):
	def __init__(self, name):
		self.name = name
	def handle_event(self):
		print(self.name)
		
class Op2_state(State):
	def __init__(self, price):
		self.price = price
	def handle_event(self):
		print("op2")