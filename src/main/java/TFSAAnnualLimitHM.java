package main.java;

import java.util.HashMap;

public class TFSAAnnualLimitHM {

    private static HashMap <String,Double> tfsaALHM = new HashMap ();

    public void setTFSAAnnualLimitHM (){
        tfsaALHM.put("2009", 5000.0);
        tfsaALHM.put("2010", 5000.0);
        tfsaALHM.put("2011", 5000.0);
        tfsaALHM.put("2012", 5000.0);
        tfsaALHM.put("2013", 5500.0);
        tfsaALHM.put("2014", 5500.0);
        tfsaALHM.put("2015", 10000.0);
        tfsaALHM.put("2016", 5500.0);
        tfsaALHM.put("2017", 5500.0);
        tfsaALHM.put("2018", 5500.0);
    }

    public HashMap<String,Double> getTfsaALHM (){
        return tfsaALHM;
    }

}
