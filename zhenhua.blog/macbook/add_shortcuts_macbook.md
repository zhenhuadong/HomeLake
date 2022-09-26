# 如何添加一个快捷键

## 目标
使用 "cmd + option + T" 打开MacBook终端。

## 步骤

### 使用automator.app 

使用 "cmd + space" 打开 spotlight。搜索"automator.app"。

双击“快速操作”, 左侧变量搜素 “运行AppleScript”, 并双击“运行AppleScript". 在“工程流程收到“下拉框选择”没有输入“。
然后编写如下脚本
```
on run {input, parameters}

	(* Your script goes here *)
	tell application "Terminal"
		reopen
		activate
	end tell

end run
```

使用 “cmd + s" 保存脚本并命名为“OpenTerminal". 

### 绑定快捷键
打开系统偏好设置 -> 键盘 -> 快捷键 -> 左侧栏点开服务 -> 右侧栏找到 OpenTerminal
双击“OpenTerminal"，点解右侧“添加快捷键”输入框，同时按住“cmd + option + t", 点击添加快捷键。


## 测试
使用 “cmd + option + t" 打开Macbook终端。

