'''
Created on Nov 22, 2018

@author: ezhendo
'''
class datastructure:
    def __init__(self):
        self.list_data=[1,2,3,4,5,6]
        self.list_data_empty=[]
        
        self.tuple_data=(10,20,30,40,50,60)
        self.tuple_data_empty=()
        
        self.set_data={11,22,33,44,55,66}
        self.set_data_empty=set()
        
        self.dict_data={'name': 'tom', 'age': 11}
        self.dict_data_empty={}
        
    
    def help_ds(self):
        help(self.list_data)
        help(self.tuple_data)
        help(self.set_data)
        help(self.dict_data)
        
    def access_list(self):
        print(self.list_data[0])
        print(self.list_data[2:5])
        print(self.list_data[:-1])
        print(self.list_data[1:])
        print(self.list_data[:])
        print(self.list_data)
        
    def update_list(self):
        self.list_data.append(200)
        print(self.list_data)
        self.list_data.insert(0, 100)
        print(self.list_data)
        self.list_data.remove(3)
        print(self.list_data)
        print(self.list_data.pop())
        print(self.list_data.pop(0))
        self.list_data.insert(3, 3)
        print(self.list_data)
    
    def iterate_list(self):
        for i in self.list_data:
            print(i)
        for i in range(len(self.list_data)):
            print(self.list_data[i])
            i+=1
        j=0
        while j < len(self.list_data):
            print(self.list_data[j])
            j+=1
    
    def access_tuple(self):
        print(self.tuple_data[0])
        print(self.tuple_data[2:5])
        print(self.tuple_data[:-2])
        print(self.tuple_data[2:])
        print(self.tuple_data[:])
        print(self.tuple_data)
    def update_tuple(self):
        #self.tuple_data[0]="error_cannot_update_tuple"
        tuple_data2 = self.tuple_data[2:5]
        print(tuple_data2)
        
    def iterate_tuple(self):
        for i in self.tuple_data:
            print(i)
        for i in range(len(self.tuple_data)):
            print(self.tuple_data[i])
        
    def access_dict(self):
        print(self.dict_data['name'])
        print(self.dict_data.get('name'))
        print(self.dict_data.get('name2', "default_value_hello"))
        print(self.dict_data)
    def update_dict(self):
        self.dict_data['gender']='male'
        self.dict_data['age']='36'
        self.dict_data.update({'school':'kindergarten'})
        print(self.dict_data)
    
    def iterate_dict(self):
        for i in self.dict_data:
            print(i+"->" + str(self.dict_data[i]))
        
        for k, v in self.dict_data.items():
            print(k + "->" + str(v))
        
        for k, v in self.dict_data.iteritems():
            print(k + "->" + str(v))
        
        for v in self.dict_data.values():
            print(v)
        
    def access_set(self):
        print(self.set_data)
        #print(self.set_data.get())
        pass
    
    def update_set(self):
        self.set_data.add(36)
        print(self.set_data)
        self.set_data.discard(37)
        print(self.set_data)
        self.set_data.discard(36)
        print(self.set_data)
        #self.dict_data

    def iterate_set(self):
        for i in self.set_data:
            print(i)
        
        self.dict_data

if __name__ == '__main__':
    ds = datastructure()
    #ds.access_list()
    #ds.update_list()
    #ds.iterate_list()
    #ds.access_tuple()
    #ds.update_tuple()
    #ds.iterate_tuple()
    ds.access_dict()
    ds.update_dict()
    ds.iterate_dict()
    ds.access_set()
    ds.update_set()
    ds.iterate_set()
    
    pass