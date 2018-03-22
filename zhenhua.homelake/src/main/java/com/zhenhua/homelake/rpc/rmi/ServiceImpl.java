package com.zhenhua.homelake.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

	protected ServiceImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String queryName(String no) throws RemoteException {
		//hello will print in server terminator
		System.out.println("hello ...");
		//return String.valueOf(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		
		//hello new world will return to client result	
		return sb.append("hello ").append(no).toString();
	}

}
