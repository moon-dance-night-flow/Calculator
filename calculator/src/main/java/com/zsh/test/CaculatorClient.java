package com.zsh.test;

import com.zsh.test.command.impl.invoker.CaculatorInvoker;
import com.zsh.test.util.SaveExecuteResultUtil;

/**
 * @author Administrator
 * @description 计算器功能整体功能采用命令模式，请求者和响应者解耦，加减乘除功能独立封装，符合单一职责，利于后续功能变动时进行伸缩
 * @since 2023-05-11
 * @version 1.0
 */
public class CaculatorClient {
	public static void main(String[] args) {
		// 初始化存数空间大小，同时静态属性的访问会先触发类的加载，会执行内部定义的静态域。
		SaveExecuteResultUtil.initStackSize(10);
		CaculatorInvoker invoker = new CaculatorInvoker();
		invoker.add(5.0).subtract(1.0).undo().redo().multiply(5.0).undo().divide(2.0);
		System.out.println("===============================================");
		invoker.clear();
		invoker.add(1.0).subtract(7.0).add(10.0).add(2.0).add(3.0).add(4.0).undo().undo().undo().redo().redo().multiply(0.1);
	}

}
