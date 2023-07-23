package validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IPValidation {

    private static final String IP_ADDRESS_REGEX = "([0-9]{1,3}\\.){3}([0-9]{1,3})";

    public static boolean isValidIpAddress(String ipAddress) {
        ipAddress = ipAddress.replaceFirst("^0+(?!$)", "");
        Pattern pattern = Pattern.compile(IP_ADDRESS_REGEX);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }
}
