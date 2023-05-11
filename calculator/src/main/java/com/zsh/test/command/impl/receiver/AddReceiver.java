package com.zsh.test.command.impl.receiver;

import java.math.BigDecimal;

import com.zsh.test.command.IReceiver;
import com.zsh.test.util.SaveExecuteResultUtil;

public class AddReceiver implements IReceiver {

	@Override
	public void execute(double b) {
		BigDecimal result = SaveExecuteResultUtil.getTmpResult().add(new BigDecimal(String.valueOf(b)));
		System.out.printf("add %s, result: %s \n",b, result.toString());
		SaveExecuteResultUtil.saveExecuteResult(result);
	}

	@Override
	public void undo() {
		SaveExecuteResultUtil.cancel();
	}

	@Override
	public void redo() {
		SaveExecuteResultUtil.recover();
	}

	@Override
	public void clear() {
		SaveExecuteResultUtil.clear();
	}

}
