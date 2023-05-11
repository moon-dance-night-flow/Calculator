package com.zsh.test.command.impl.invoker;

import com.zsh.test.command.ICommand;
import com.zsh.test.command.impl.command.AddCommand;
import com.zsh.test.command.impl.command.DivideCommand;
import com.zsh.test.command.impl.command.MultiplyCommand;
import com.zsh.test.command.impl.command.SubtractCommand;

public class CaculatorInvoker {
	
	private ICommand command;
	
	public CaculatorInvoker add(double d) {
		this.command = new AddCommand();
		command.execute(d);
		return this;
	}
	
	public CaculatorInvoker subtract(double d) {
		this.command = new SubtractCommand();
		command.execute(d);
		return this;
	}
	
	public CaculatorInvoker multiply(double d) {
		this.command = new MultiplyCommand();
		command.execute(d);
		return this;
	}
	
	public CaculatorInvoker divide(double d) {
		this.command = new DivideCommand();
		command.execute(d);
		return this;
	}
	
	public CaculatorInvoker undo() {
		if(this.command == null) {
			System.out.println("has not executed any commands yet");
		} else {
			command.undo();
		}
		return this;
	}
	
	public CaculatorInvoker redo() {
		if(this.command == null) {
			System.out.println("has not executed any commands yet");
		} else {
			command.redo();
		}
		return this;
	}
	
	public CaculatorInvoker clear() {
		if(this.command == null) {
			System.out.println("has not executed any commands yet");
		} else {
			command.clear();
		}
		return this;
	}

}
