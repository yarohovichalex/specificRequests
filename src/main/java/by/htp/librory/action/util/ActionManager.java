package by.htp.librory.action.util;

import by.htp.librory.action.BaseAction;
import by.htp.librory.action.console.HelloWorldConsoleImpl;

public class ActionManager {
	public static BaseAction defineAction(int action) {
		BaseAction act = null;
		
		switch(action) {
		case 1:
			act = new HelloWorldConsoleImpl();
			break;
		case 2:
			act = new HelloWorldConsoleImpl();
			break;
		}
		return act;
	}
}
