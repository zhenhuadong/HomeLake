package com.zhenhua.homelake.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

	public static void main(String[] args) {
		Registry registry=null;
		
		try {
			registry = LocateRegistry.createRegistry(8088);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ServiceImpl server = new ServiceImpl();
			registry.rebind("Nicole", server);
			System.out.println("bind server");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
