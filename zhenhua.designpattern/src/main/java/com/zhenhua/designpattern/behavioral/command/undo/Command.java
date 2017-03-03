package com.zhenhua.designpattern.behavioral.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
