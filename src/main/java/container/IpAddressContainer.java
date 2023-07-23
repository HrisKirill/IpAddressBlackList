package container;

import java.util.HashSet;
import java.util.Set;

public class IpAddressContainer {

    private static IpAddressContainer instance;
    private Set<String> ipAddressContainer = new HashSet<>();

    private IpAddressContainer() {
    }

    public void add(String ipAddress) {
        ipAddressContainer.add(ipAddress);
    }

    public Set<String> getAllAddresses() {
        return ipAddressContainer;
    }

    public void clear() {
        ipAddressContainer.clear();
    }

    public void addAll(Set<String> newList) {
        ipAddressContainer.addAll(newList);
    }

    public static IpAddressContainer getInstance() {
        if (instance == null) {
            return new IpAddressContainer();
        }

        return instance;
    }
}
