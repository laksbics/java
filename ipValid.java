    import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ipValid {

    // Regular expression for validating IPv4
    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    // Regular expression for validating IPv6
    private static final String IPV6_REGEX =
            "([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]{1,4})";

    private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
    private static final Pattern IPV6_PATTERN = Pattern.compile(IPV6_REGEX);

    public static boolean isValidIPv4(String ip) {
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPV4_PATTERN.matcher(ip);
        return matcher.matches();
    }

    public static boolean isValidIPv6(String ip) {
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPV6_PATTERN.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String ipv4 = "192.168.1.1";
        String ipv6 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        String invalidIP = "999.999.999.999";

        System.out.println("Is valid IPv4: " + ipv4 + " -> " + isValidIPv4(ipv4));
        System.out.println("Is valid IPv6: " + ipv6 + " -> " + isValidIPv6(ipv6));
        System.out.println("Is valid IP: " + invalidIP + " -> " +
                (isValidIPv4(invalidIP) || isValidIPv6(invalidIP)));
    }
}

