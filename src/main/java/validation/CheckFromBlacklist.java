package validation;

import constants.Constants;
import container.IpAddressContainer;
import utils.WorkWithFile;

import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public final class CheckFromBlacklist {
    private static final IpAddressContainer container = IpAddressContainer.getInstance();

    public static boolean isIpAddressBlacklisted(String ipAddress) {
        Properties properties = WorkWithFile.readProperties(Constants.PROPERTIES);
        String fileName = properties.getProperty(Constants.BLACKLIST_PROPERTY);
        String blackListContent = WorkWithFile.readFromFile(fileName);

        if (!("").equals(blackListContent)) {
            container.clear();
            container.addAll(Arrays.stream(blackListContent.split(System.lineSeparator()))
                    .collect(Collectors.toSet()));
        }

        return container.getAllAddresses().contains(ipAddress);
    }
}
