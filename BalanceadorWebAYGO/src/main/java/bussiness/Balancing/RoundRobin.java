package bussiness.Balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RoundRobin {
    private static Integer pos = 0;

    public static String getServer()
    {

        Map<String, Integer> serverMap =
                new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);

        // trae lista ips
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);

        String server = null;
        synchronized (pos)
        {
            if (pos > keySet.size())
                pos = 0;
            server = keyList.get(pos);
            pos ++;
        }

        return server;
    }
}
