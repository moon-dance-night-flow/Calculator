package com.zsh.test.command.impl.receiver;

import java.math.BigDecimal;

import com.zsh.test.command.IReceiver;
import com.zsh.test.util.SaveExecuteResultUtil;

public class DivideReceiver implements IReceiver {


	@Override
	public void execute(double b) {
		if(b == 0d) {
			System.out.println("divisor cannot be 0!");
			return;
		}
		BigDecimal result = SaveExecuteResultUtil.getTmpResult().divide(new BigDecimal(String.valueOf(b)));
		System.out.printf("divide %s, result: %s \n",b, result.toString());
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
