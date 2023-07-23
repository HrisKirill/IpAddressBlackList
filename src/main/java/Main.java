import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validation.CheckFromBlacklist;
import validation.IPValidation;

import java.util.Scanner;

import static constants.Constants.TEXT_TO_EXIT_PROGRAM;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Glad to see you again!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            LOGGER.info("Enter address or 'quit' to exit");

            String ipAddress = scanner.nextLine();

            if (TEXT_TO_EXIT_PROGRAM.equals(ipAddress)) {
                break;
            }

            if (!IPValidation.isValidIpAddress(ipAddress)) {
                LOGGER.error("Invalid IP address");
            } else if (CheckFromBlacklist.isIpAddressBlacklisted(ipAddress)) {
                LOGGER.error("Access disallowed");
            } else {
                LOGGER.info("Access allowed");
            }

        }
    }

}
