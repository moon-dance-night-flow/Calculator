package com.zsh.test.command.impl.command;

import com.zsh.test.command.ICommand;
import com.zsh.test.command.IReceiver;
import com.zsh.test.command.impl.receiver.AddReceiver;

public class AddCommand implements ICommand {
	
	private IReceiver receiver;
	
	public AddCommand() {
		this.receiver = new AddReceiver();
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
