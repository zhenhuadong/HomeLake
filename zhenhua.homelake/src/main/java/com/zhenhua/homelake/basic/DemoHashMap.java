package com.zhenhua.homelake.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * HashMap 底层是由哈希表（数组+链表/红黑树）来实现的，先根据key的hash值找到数组对应的index, 然后如果由冲突则放入对应的链表。
 * 它兼有数组的查询速度快，和链表的插入速度快。 但问题的关键是key的hash值的散列程度。
 * key的hash值冲突剧烈时，导致链表过长，查询速度退化为遍历链表。 在JDK8中链表长度超过8时，变成红黑树，避免性能线性恶化。
 * 
 * HashMap的key必须实现 hashCode() 和 equals() 方法。 
 * Object默认的
 * 	- equals()方法： 简单判断对象地址
 * 	- hashCode()是native提供的，一般是对象地址。 考虑到垃圾回收，单纯的使用对象地址生成hash, 会导致垃圾回收过程中，hash值会改变。
 * 
 * 作为key的类，一般要覆盖Object的
 * 	- equals()方法: 往往是根据内容是否相等
 *  - hashCode()方法： 往往是通过内容来生成Hash值。 
 *  
 *  因为底层实现是基于数组的，那么初始容量默认是8， 默认负载因子是0.75， 也就是超过 当前容量*负载因子 容量增大一倍。
 *  JDK8之后， 扩容变得更高效，直接将链表中元素的hash值与原长度进行&运算。 
 *  比如初始容量为8的HashMap， hash值分别是15（1111）， 23（10111）， 31（11111）的元素，原本都在index为7 （111）的桶内。
 *  扩容到16时， 15（1111）和31（11111)分别与7=8-1=（111） & 操作 结果
 *  进而区别高位与低位，
 *  最后链表低位直接放在新数组中的原位置，高位放在原位置移动容量后的新位置。
 *  
 *  最大容量是：4字节的int型， 2的30-次方， 不是31次方的原因是整形最高位表示正负号。
 *  
 */

class Dog {
    String color;

    Dog(String c) {
        color = c;
    }

    /*
     * 作为HashMap的key, 应该实现如下两个方法
     */
//    public boolean equals(Object o) {
//        return ((Dog) o).color.equals(this.color);
//    }
//
//    public int hashCode() {
//        return color.hashCode();
//    }
}

public class DemoHashMap {
	
	//String作为key, String类使用内容来生成hash值和判断是否相等
	public void demoStringHashMap() {
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("red", 1);
		hashMap.put("black", 2);
		hashMap.put("white", 3);
		hashMap.put("white", 4); // 4覆盖3, 因为key相等（当然其hashCode也相等）
		// print size
		System.out.println("DemoStringHashMap: size = " + hashMap.size());
		// loop HashMap
		for (Entry<String, Integer> entry: hashMap.entrySet()) {
			System.out.println(entry.getKey().hashCode() + " - " + entry.getKey().toString() + " - " + entry.getValue());
		}
	}
	
	//Dog作为key, 该类使用默认的Object的hashCode和equals方法
	public void demoDogHashMap() {
		Map<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
		Dog d1 = new Dog("red");
		Dog d2 = new Dog("black");
		Dog d3 = new Dog("white");
		Dog d4 = new Dog("white");
		hashMap.put(d1, 1);
		hashMap.put(d2, 2);
		hashMap.put(d3, 3);
		hashMap.put(d4, 4); //d4与d3的hashCode不同, 不会覆盖
		// print size： 4 因为没有实现hashCode
		System.out.println("DemoDogHashMap: size = " + hashMap.size());
		System.out.println("d3: white, hashCode=" + d3.hashCode());
		System.out.println("d4: white, hashCode=" + d4.hashCode());

		// loop HashMap
		for (Entry<Dog, Integer> entry: hashMap.entrySet()) {
			System.out.println(entry.getKey().hashCode() + " - " + entry.getKey().color + " - " + entry.getValue());
		}
	}
	
	public void demoSizeHashMap() {
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		System.out.println(hashMap.size());
		hashMap.put(null, 1);
		System.out.println(hashMap.size() + " - " + hashMap.get(null));
		hashMap.put(null, 2);
		System.out.println(hashMap.size() + " - " + hashMap.get(null));
		hashMap.put("1", null);
		System.out.println(hashMap.size());

	}

	public static void main(String[] args) {
		DemoHashMap demo = new DemoHashMap();
		demo.demoStringHashMap();
		demo.demoDogHashMap();
		demo.demoSizeHashMap();
	}

}
