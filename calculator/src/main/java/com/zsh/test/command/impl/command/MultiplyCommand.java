package com.zsh.test.command.impl.command;

import com.zsh.test.command.ICommand;
import com.zsh.test.command.IReceiver;
import com.zsh.test.command.impl.receiver.MultiplyReceiver;

public class MultiplyCommand implements ICommand {
	
	
	private IReceiver receiver;
	
	public MultiplyCommand() {
		this.receiver = new MultiplyReceiver();
	}

	@Override
	public void execute(double b) {
		receiver.execute(b);
	}

	@Override
	public void undo() {
		receiver.undo();
	}

	@Override
	public void redo() {
		receiver.redo();
	}

	@Override
	public void clear() {
		receiver.clear();
	}
}
