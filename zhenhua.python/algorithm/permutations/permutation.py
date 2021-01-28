
count=0

def incr():
    global count
    count+=1
class Lucky26:
    def __init__(self, data_array):
        self.data_array = data_array

    def is_lucky26(self):
        a = self.data_array
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
                            return True
        else:
            return False

    def __str__(self):
        a = self.data_array
        return " \n".join(["       {0:2d}             {1:2d}       ".format(a[1],a[7]), 
            "                {0:2d}               ".format(a[5]),
            "       {0:2d}             {1:2d}       ".format(a[2], a[8]),
            "{0:2d}                           {1:2d}".format(a[0],a[11]),
            "       {0:2d}             {1:2d}       ".format(a[3],a[9]),
            "                {0:2d}               ".format(a[6]),
            "       {0:2d}             {1:2d}       ".format(a[4],a[10])])

def rank(data_array, step):
    if len(data_array)==step+1:
        yield data_array
    else:
        for i in range(step, len(data_array)):
            data_array[i], data_array[step] = data_array[step], data_array[i]
            yield from rank(data_array, step+1)
            data_array[i], data_array[step] = data_array[step], data_array[i]

def rank_r(data_array, step):
    if len(data_array)==step+1:
        print(data_array)
    else:
        for i in range(step, len(data_array)):
            data_array[i], data_array[step] = data_array[step], data_array[i]
            rank_r(data_array, step+1)
            data_array[i], data_array[step] = data_array[step], data_array[i]
if __name__ == '__main__':
    # data=['judy','lunar', 'baby', 'nicole', 'pikacho','tiger']
    # rank_r(data, 0)

    data=['a','b', 'c']
    for i in rank(data, 0):
        print(i)

    # data=[1,2,3,4,5,6,7,8,9,10,11,12]    
    # for i in rank(data, 0):
    #     obj = Lucky26(i)
    #     if obj.is_lucky26():
    #         incr()
    #         print("lucky 26 ===> {0:3d}".format(count))
    #         print(obj)
    # print(count)