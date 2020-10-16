package bussiness.Balancing;

import java.util.HashMap;

public class IpMap {

    public static HashMap<String, Integer> serverWeightMap =
            new HashMap<String, Integer>();

    static
    {
        serverWeightMap.put("http://172.18.0.1:8087/add", 1);
        serverWeightMap.put("http://172.18.0.2:8088/add", 2);
        serverWeightMap.put("http://172.18.0.3:8089/add", 3);

    }
}
