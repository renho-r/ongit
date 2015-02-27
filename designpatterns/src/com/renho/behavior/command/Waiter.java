package com.renho.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

	public List<ICommand> list = new ArrayList<ICommand>();
	
	public void addCommand(ICommand iCommand) {
		list.add(iCommand);
	}
	
	public void removeCommand(ICommand iCommand) {
		list.remove(iCommand);
	}
	
	public void exeNotify() {
		for(ICommand i:list) {
			i.execute();
		}
	}
	
}
