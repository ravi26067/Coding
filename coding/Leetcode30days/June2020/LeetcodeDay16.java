class Solution {
    public String validIPAddress(String IP) {

		String res = "Neither";

		if (IP.length() >= 7 && IP.length() <= 15 && IP.contains(".") && !IP.contains(":") && !IP.contains("..")) {
            if(IP.startsWith(".")||IP.endsWith("."))
				return res;
			String[] ips = IP.split("[.]");
			
			if (ips.length != 4) {
				System.out.println("Short len" + ips.length);
				return res;
			}
			else {
				for (int i = 0; i < ips.length; i++) {
					String str = ips[i];
					
					for(int j=0;j<str.length();j++) {
						int n = str.charAt(j);
						if ((n > 47 && n < 59)) {

						} else {
							//System.out.println(str.charAt(j));
							return res;
						}
					}
					
					int num = Integer.parseInt(str);
					if (str.startsWith("0")) {
						if (str.length()>1)
							return res;
					}
					if (num < 0 || num > 255)
						return res;
				}
				res = "IPv4";
				return res;
			}
			// 0:0:0:0:0:0:0:0

		} else if (IP.length() >= 15 && IP.length() <= 39 && IP.contains(":") && !IP.contains(".") && !IP.contains("::")) {
			String[] ips = IP.split("[:]");
			if (ips.length != 8)
				return res;
			else {
                for(int i=0;i<ips.length;i++) {
					String str = ips[i];
					if(str.length()>4)
						return res;
				}
				for (int i = 0; i < IP.length(); i++) {
					int n = IP.charAt(i);
					if ((n > 47 && n < 59) || (n >= 64 && n <= 70) || (n >= 97 && n <= 102)) {

					} else {
						//System.out.println(IP.charAt(i));
						return res;
					}
				}

				if (IP.contains("::") || IP.contains("..") || IP.startsWith(":") || IP.endsWith(":"))
					return res;
			}

			res = "IPv6";
			return res;
		} else
			return res;
	}
}