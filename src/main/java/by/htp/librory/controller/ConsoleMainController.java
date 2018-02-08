package by.htp.librory.controller;

import by.htp.librory.action.BaseAction;
import by.htp.librory.action.util.ActionManager;

public class ConsoleMainController {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		BaseAction action = ActionManager.defineAction(1);
		//action.doSmth();

	}

}
