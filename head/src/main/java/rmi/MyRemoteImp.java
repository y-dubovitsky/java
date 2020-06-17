package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImp extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteImp() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server Say Hello";
    }

    public static void main(String[] args) {
        try {
            MyRemoteImp myRemoteImp = new MyRemoteImp();
            Naming.rebind("Remote Hello", myRemoteImp);
        } catch (RemoteException | MalformedURLException r) {
            r.getStackTrace();
        }
    }
}
