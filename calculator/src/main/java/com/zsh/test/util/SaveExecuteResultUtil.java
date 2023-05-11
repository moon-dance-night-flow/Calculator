package com.zsh.test.util;

import java.math.BigDecimal;
import java.util.Stack;

public class SaveExecuteResultUtil {
	
	/**
	 * 存放计算后结果或者redo结果
	 */
	private static Stack<BigDecimal> undoStack;
	
	/**
	 * 存放每次撤销的结果，用于恢复
	 */
	private static Stack<BigDecimal> redoStack;
	
	/**
	 * 保存每次操作结果作为计算器屏幕显示，也作为下次操作的被操作数
	 */
	private static BigDecimal tmpResult;
	
	static{
		// 初始化
		undoStack = new Stack<BigDecimal>();
		redoStack = new Stack<BigDecimal>();
		tmpResult = new BigDecimal(String.valueOf(0.0));
	}
	
	
	/**
	 * 保存undo记录的大小，保证内存正常不溢出
	 */
	private static int stackSize;

	public static void initStackSize(int size) {
		stackSize = size;
	}

	public static BigDecimal getTmpResult() {
		return tmpResult;
	}

	public static void setTmpResult(BigDecimal tmpResult) {
		SaveExecuteResultUtil.tmpResult = tmpResult;
	}
	
	public static void saveExecuteResult(BigDecimal val) {
		if(val == null) {
			System.out.printf("value is illegal \n");
			return;
		}
		if (undoStack.size() >= stackSize) {
			System.out.printf("space is full,remove odleast value, save new valse: %s \n",val);
			undoStack.remove(0);
		}
		undoStack.push(val);
		tmpResult = val;
		// 每次进行了操作，那么恢复栈的数据要清空，只有前面是撤销操作，恢复才有意义。
		redoStack.clear();
		System.out.printf("saved val:%s \n",val);
	}
	
	public static BigDecimal cancel() {
		BigDecimal val = null;
		if(!undoStack.isEmpty()) {
			redoStack.push(undoStack.pop());
			tmpResult = undoStack.peek();
			System.out.printf("canceled,result: %s \n",tmpResult);
		} else {
			System.out.printf("no cancel data here! \n");
		}
		return val;
	}
	
	public static BigDecimal recover() {
		BigDecimal val = null;
		if (!redoStack.isEmpty()) {
			tmpResult = redoStack.pop();
			undoStack.push(tmpResult);
			System.out.printf("recovered, result: %s \n", tmpResult);
		} else {
			System.out.printf("no recover data here! \n");
		}
		return val;
	}

	public static void clear() {
		redoStack.clear();
		undoStack.clear();
		tmpResult = new BigDecimal(String.valueOf(0.0));
	}
	
	
}
