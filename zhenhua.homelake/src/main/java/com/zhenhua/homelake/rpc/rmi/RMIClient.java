package com.zhenhua.homelake.rpc.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

	public static void main(String[] args) {
		Registry registry=null;
		
		try {
			// get service registry manager
			registry = LocateRegistry.getRegistry("127.0.0.1", 8088);
			String[] list = registry.list();
			System.out.println("length " + list.length);
			for(String s : list) {
				System.out.println(s);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			IService server = (IService) registry.lookup("Nicole");
			String result = server.queryName("new world");
			System.out.println("result from remote :" + result);
			Thread.sleep(100);
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
