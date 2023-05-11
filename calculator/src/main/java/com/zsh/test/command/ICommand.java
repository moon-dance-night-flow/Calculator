package com.zsh.test.command;

public interface ICommand {
	
	public void undo();
	
	public void redo();
	
	public void clear();
	
	public void execute(double b);

}
