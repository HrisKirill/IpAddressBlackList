## IpAddressBlacklist application
Program implements:
- writing a welcome message to the user in the console and prompt for an IP address for verification. 
- checking IP address for validity and blacklisting:
  1. If the entered IP address is invalid, the program displays the message "Invalid IP address".
  2. If there is an IP address in the black list, the program displays the message "Access disallowed". 
  3. If the IP address is not in the black list, the program displays the phrase "Access allowed". 

- picking up updates in the file with IP addresses without restarting the program.
- storing content from file in container.
- reading file only after updating.

Blacklist content is in file "blacklist.txt".