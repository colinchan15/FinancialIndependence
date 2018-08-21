package main.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFSAAnnualLimitHM {

        private static Map<String, ArrayList<Integer>> tfsaALHM = new HashMap<String, ArrayList<Integer>>();

        public static void main (String[]args){
            TFSAAnnualLimitHM tfsa = new TFSAAnnualLimitHM();
            tfsa.setTFSAALHM();
            System.out.println(tfsa.getTFSAValue("2011", "Cumulative"));
            System.out.println(tfsa.getTFSAValue("2018", "Cumulative"));
        }

        public static int getTFSAValue (String year, String AnnOrCum) {
            TFSAAnnualLimitHM tfsa = new TFSAAnnualLimitHM();
            tfsa.setTFSAALHM();
            int temp = 0;

            if (year.equals("2009")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList oNine = tfsaALHM.get("2009");
                    temp = (int) oNine.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList oNine = tfsaALHM.get("2009");
                    temp = (int) oNine.get(1);
                }
            } else if (year.equals("2010")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList ten = tfsaALHM.get("2010");
                    temp = (int) ten.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList ten = tfsaALHM.get("2010");
                    temp = (int) ten.get(1);
                }
            }else if (year.equals("2011")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList eleven = tfsaALHM.get("2011");
                    temp = (int) eleven.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList eleven = tfsaALHM.get("2011");
                    temp = (int) eleven.get(1);
                }
            }else if (year.equals("2012")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList twelve = tfsaALHM.get("2012");
                    temp = (int) twelve.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList twelve = tfsaALHM.get("2012");
                    temp = (int) twelve.get(1);
                }
            }else if (year.equals("2013")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList thirteen = tfsaALHM.get("2013");
                    temp = (int) thirteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList thirteen = tfsaALHM.get("2013");
                    temp = (int) thirteen.get(1);
                }
            }else if (year.equals("2014")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList thirteen = tfsaALHM.get("2014");
                    temp = (int) thirteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList thirteen = tfsaALHM.get("2014");
                    temp = (int) thirteen.get(1);
                }
            }else if (year.equals("2015")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList fifteen = tfsaALHM.get("2015");
                    temp = (int) fifteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList fifteen = tfsaALHM.get("2015");
                    temp = (int) fifteen.get(1);
                }
            }else if (year.equals("2016")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList sixteen = tfsaALHM.get("2016");
                    temp = (int) sixteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList sixteen = tfsaALHM.get("2016");
                    temp = (int) sixteen.get(1);
                }
            }else if (year.equals("2017")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList seventeen = tfsaALHM.get("2017");
                    temp = (int) seventeen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList seventeen = tfsaALHM.get("2017");
                    temp = (int) seventeen.get(1);
                }
            }else if (year.equals("2018")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList eighteen = tfsaALHM.get("2018");
                    temp = (int) eighteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList eighteen = tfsaALHM.get("2018");
                    temp = (int) eighteen.get(1);
                }
            }
            return temp;
        }

        public void setTFSAALHM(){
            ArrayList<Integer> oNine = new ArrayList<Integer>();
            oNine.add(5000);
            oNine.add(5000);
            tfsaALHM.put("2009", oNine);

            ArrayList<Integer> ten = new ArrayList<Integer>();
            ten.add(5000);
            ten.add(10000);
            tfsaALHM.put("2010", ten);

            ArrayList<Integer> eleven = new ArrayList<Integer>();
            eleven.add(5000);
            eleven.add(15000);
            tfsaALHM.put("2011", eleven);

            ArrayList<Integer> twelve = new ArrayList<Integer>();
            twelve.add(5000);
            twelve.add(20000);
            tfsaALHM.put("2012", twelve);

            ArrayList<Integer> thirteen = new ArrayList<Integer>();
            thirteen.add(5500);
            thirteen.add(25500);
            tfsaALHM.put("2013", thirteen);

            ArrayList<Integer> fourteen = new ArrayList<Integer>();
            fourteen.add(5500);
            fourteen.add(31000);
            tfsaALHM.put("2014", fourteen);

            ArrayList<Integer> fifteen = new ArrayList<Integer>();
            fifteen.add(10000);
            fifteen.add(41000);
            tfsaALHM.put("2015", fifteen);

            ArrayList<Integer> sixteen = new ArrayList<Integer>();
            sixteen.add(5500);
            sixteen.add(46500);
            tfsaALHM.put("2016", sixteen);

            ArrayList<Integer> seventeen = new ArrayList<Integer>();
            seventeen.add(5500);
            seventeen.add(52000);
            tfsaALHM.put("2017", seventeen);

            ArrayList<Integer> eighteen = new ArrayList<Integer>();
            eighteen.add(5500);
            eighteen.add(57500);
            tfsaALHM.put("2018", eighteen);
        }
}
