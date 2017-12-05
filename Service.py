import time
import sys
from agent import Event
from agent import Agent

class Service:
	def perform_service(self, agent_handler):
		pass
		
class Service1(Service):
	def perform_service(self, agent_handler):
		#performs some service
		print("Performing service 1")
		time.sleep(5)
		a = Agent()
		print(a)
		a.notify(Event.OP1)
		
class Service2(Service):
	def perform_service(self, agent_handler):
		#performs some service 
		time.sleep(10)
		agent_handler.notify(Event.OP2)