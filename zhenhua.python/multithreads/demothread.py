'''
Created on Nov 23, 2018

@author: ezhendo
'''


from threading import Thread
import multiprocessing
import time


def print_difference():
    print("https://timber.io/blog/multiprocessing-vs-multithreading-in-python-what-you-need-to-know/")
    multi_threads = '''
    For network bound or IO bound program, multi threads is a good choice. 
    multi threads share the same data space, work on the same CPU due ot GIC(Global interpreter lock)
    
    multi_threads is good at network bound program, for several threads can work in parallel. 
     
    you can use threading if your program is network bound or multiprocessing if it's CPU bound.
    '''
    multi_processes = '''
    For CPU bound program, multi processes is a good choice.
    multi processes can uses multi-CPUs.    
    '''
    print(multi_threads)
    print(multi_processes)

def demo_multi_threads():
    log_time(n_threads, cpu_bound_task,  1)
    log_time(n_threads, cpu_bound_task, 2)
    log_time(n_threads, cpu_bound_task, 10)
    print("cpu bound task should not choose multi-threads")
    pass


def demo_multi_processes():
    print("CPU number is {0}".format(multiprocessing.cpu_count()))
    log_time(n_process, cpu_bound_task, 1)
    log_time(n_process, cpu_bound_task, 2)
    log_time(n_process, cpu_bound_task, 4)
    pass


TOTAL_SLEEP=100

def io_bound_task(n):
    print(n)
    time.sleep(n)


COUNT=1000000000
def cpu_bound_task(n):
    print(n)
    while n>0:
        n-=1
    print("end.."+str(n))

def n_process(func, n):
    process_list=[]
    for i in range(n):
        p = multiprocessing.Process(target=func, args=(COUNT/n,))
        process_list.append(p)
        p.start()
    
    for i in process_list:
        p.join()
        
    c = True;
    while c:
        print(".. ")
        c=False
        for p in process_list:
            print(p.is_alive())
            if p.is_alive():
                c=True
                continue
    

def n_threads(func, n):
    thread_list=[]
    for i in range(n):
        t = Thread(target=func, name=i, args=(COUNT/n,))
        t.start()
        thread_list.append(t)
    
    for t in thread_list:
        t.join()

def log_time(func, *args):
    start = time.clock()
    func(*args)
    end = time.clock()
    print("The time was {}".format(end - start))

if __name__ == '__main__':
    demo_multi_threads()
    print("start...multi-processes")
    demo_multi_processes()
    pass