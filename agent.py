from state import State
from enum import Enum

class Event(Enum):
	OP1 = 1
	OP2 = 2
	
class Agent:
	__instance = None
	class innerAgent:
		registrations = None
		def register(self,act,e):
			if self.registrations is None:
				self.registrations = {}
			if e not in self.registrations:
				self.registrations[e] = []
			self.registrations[e].append(act)
			
		def notify(self, e):
			print("Notify", id(self))
			print(self.registrations[e])
			for o in self.registrations[e]:
				o.handle_event()
	def __init__(self):
		if Agent.__instance is None:
			print("here")
			Agent.__instance = Agent.innerAgent()
		self.__dict__['_Agent__instance'] = Agent.__instance
	def __getattr__(self, attr):
		""" Delegate access to implementation """
		return getattr(self.__instance, attr)

	def __setattr__(self, attr, value):
		""" Delegate access to implementation """
		print("PAPA")
		return setattr(self.__instance, attr, value)