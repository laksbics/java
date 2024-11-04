public class IPAddressValidator {
    public static boolean isValidIPv4(String ip)
    {
        if(ip == null || ip.isEmpty()  )
        {
            return false;
        }

        String[] parts = ip.split("\\.");

        if(parts.length != 4)
        {
            return false;
        }

        for(String part:parts)
        {
            try
            {
                int num = Integer.parseInt(part);
                if(num <0 || num > 255 || (part.length() > 1 && part.charAt(0) == '0'))
                {
                    return false;
                }
            }
            catch(Exception ex)
            {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidIPv6(String ip)
    {
        if(ip == null || ip.isEmpty())
        {
            return false;
        }

        String[] parts = ip.split(":");

        for(String part : parts)
        {
            if(part.length() ==0 || part.length() > 4)
            {
                return false;
            }

            try{
                int num =   Integer.parseInt(part, 16);
                if(num < 0 || num > 0xFFFF)
                {
                    return false;
                }
            }
            catch(Exception ex)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String opv4 = "192.168.1.1";
        String ipv6 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";// "2001:0db8:85a3:0000:0000:8a2e:0370:7374";
        String invalidIp = "999.12.12.12";


        System.out.println("Is Valid IPV4:" + opv4 + "->" + isValidIPv4(opv4));
        System.out.println("Is V alid IPV6:" + ipv6 + "->" + isValidIPv6(ipv6));
        System.out.println("Is Valid Ip" + invalidIp + "->" + (isValidIPv4(invalidIp)));
    }

}
