


1. 什么是GMP？ GMP问题的核心是什么？

2. 无缓冲 chan 的发送和接收是否同步


ch := make(chan int)    无缓冲的channel由于没有缓冲发送和接收需要同步.

ch := make(chan int, 2) 有缓冲channel不要求发送和接收操作同步.

channel无缓冲时，发送阻塞直到数据被接收，接收阻塞直到读到数据。

channel有缓冲时，当缓冲满时发送阻塞，当缓冲空时接收阻塞。

3. 除了 mutex 以外还有那些方式安全读写共享变量？多线程读写共享变量的几种处理模式?https://www.jianshu.com/p/c804a5e70743
- sync.Mutex 是golang提供的互斥操作，通过lock/unlock来进行互斥操作。
- Goroutine 可以通过 Channel 进行安全读写共享变量。把共享变量放到一个线程里，然后通过 channel 进行读写操作。



CSP并发模型：
go 的 CSP 并发模型，是通过 Goroutine 和 Channel 来实现的。Goroutine 是 go 语言中并发的执行单位。有点抽象，其实就是和传统概念上的”线程“类似，可以理解为”线程“。Channel 是 go 语言中各个并发结构体(Goroutine)之前的通信机制。通常 Channel，是各个 Goroutine 之间通信的”管道“，有点类似于Linux中的管道。通信机制channel也很方便，传数据用channel <- data，取数据用<-channel。在通信过程中，传数据channel <- data和取数据<-channel必然会成对出现，因为这边传，那边取，两个goroutine之间才会实现通信。而且不管传还是取，必阻塞，直到另外的goroutine传或者取为止。
