
count=0

def incr():
    global count
    count+=1

def is_lucky26(a):
    #       a[1]             a[7]
    #                a[5]
    #       a[2]             a[8]
    # a[0]                         a[11]
    #       a[3]             a[9]
    #                a[6]
    #       a[4]             a[10]
    if a[0] + a[2]+a[5] + a[7] == 26 and \
        a[0] + a[3]+a[6] + a[10] == 26 and \
            a[1] + a[5]+a[8] + a[11] == 26 and \
                a[1] + a[2]+a[3] + a[4] == 26 and \
                    a[4] + a[6]+a[9] + a[11] == 26 and \
                        a[7] + a[8]+a[9] + a[10] == 26 :
                        incr()
                        return True
    else:
        return False

def print_lucky26(a):
    if is_lucky26(a):
        print("lucky 26 ===> {0:3d}".format(count))
        print("       {0:2d}             {1:2d}       ".format(a[1],a[7])) 
        print("                {0:2d}               ".format(a[5]))
        print("       {0:2d}             {1:2d}       ".format(a[2], a[8]))
        print("{0:2d}                           {1:2d}".format(a[0],a[11]))
        print("       {0:2d}             {1:2d}       ".format(a[3],a[9]))
        print("                {0:2d}               ".format(a[6]))
        print("       {0:2d}             {1:2d}       ".format(a[4],a[10]))

def rank(data_array, step):
    if len(data_array)==step+1:
        #if is_lucky26(data_array):
        #    print(data_array)
        print_lucky26(data_array)
    else:
        for i in range(step, len(data_array)):
            data_array[i], data_array[step] = data_array[step], data_array[i]
            rank(data_array, step+1)
            data_array[i], data_array[step] = data_array[step], data_array[i]


if __name__ == '__main__':
    #data=['judy','lunar', 'baby', 'nicole', 'pikacho','tiger']
    #data=['a','b', 'c']
    data=[1,2,3,4,5,6,7,8,9,10,11,12]
    rank(data, 0)
    print(count)