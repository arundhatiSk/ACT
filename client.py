from state import *
from multiprocessing import Pool
import tkinter as tk
from Service import Service1
from Service import Service2
from agent import Agent as A
from agent import Event

if __name__ == '__main__' :
	eventLoop = True
	a = A()	
	act1 = Op1_state("Anu")
	a.register(act1, Event.OP1)
	a.notify(Event.OP1)
	b = A()
	b.notify(Event.OP1)
	act2 = Op2_state(23)
	a.register(act2, Event.OP2)
	
	act3 = Op1_state("blha")
	a.register(act3, Event.OP1)
	
	pool = Pool(processes=2)
	s1 = Service1()
	s2 = Service2()
	print("Helooooooooooo")
	result = pool.apply_async(s1.perform_service,[a])
	#event1(a)
	result = pool.apply_async(s2.perform_service, [a])
	while eventLoop:
		pass

		
		
		
		
		
		
		
		