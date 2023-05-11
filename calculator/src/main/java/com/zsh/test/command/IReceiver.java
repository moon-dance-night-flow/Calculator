package com.zsh.test.command;

public interface IReceiver {
	
	public void execute(double b);
	
	public void undo();
	
	public void redo();

	public void clear();

}
