package web22.page814;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressShow {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        //
        System.out.println(address.getHostAddress());

        InetAddress address1 = InetAddress.getByName("www.google.com");
        System.out.println(address1);
    }
}
