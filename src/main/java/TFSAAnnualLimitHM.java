package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TFSAAnnualLimitHM {

        private static Map<String, ArrayList<Double>> tfsaALHM = new HashMap();

        public static void main (String[]args){
            TFSAAnnualLimitHM tfsa = new TFSAAnnualLimitHM();
            tfsa.setTFSAALHM();
            System.out.println(tfsa.getTFSAValue("2011", "Cumulative"));
            System.out.println(tfsa.getTFSAValue("2018", "Cumulative"));
        }

        public static Double getTFSAValue (String year, String AnnOrCum) {
            TFSAAnnualLimitHM tfsa = new TFSAAnnualLimitHM();
            tfsa.setTFSAALHM();
            Double temp = 0.0;

            if (year.equals("2009")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList oNine = tfsaALHM.get("2009");
                    temp = (Double) oNine.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList oNine = tfsaALHM.get("2009");
                    temp = (Double) oNine.get(1);
                }
            } else if (year.equals("2010")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList ten = tfsaALHM.get("2010");
                    temp = (Double) ten.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList ten = tfsaALHM.get("2010");
                    temp = (Double) ten.get(1);
                }
            }else if (year.equals("2011")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList eleven = tfsaALHM.get("2011");
                    temp = (Double) eleven.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList eleven = tfsaALHM.get("2011");
                    temp = (Double) eleven.get(1);
                }
            }else if (year.equals("2012")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList twelve = tfsaALHM.get("2012");
                    temp = (Double) twelve.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList twelve = tfsaALHM.get("2012");
                    temp = (Double) twelve.get(1);
                }
            }else if (year.equals("2013")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList thirteen = tfsaALHM.get("2013");
                    temp = (Double) thirteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList thirteen = tfsaALHM.get("2013");
                    temp = (Double) thirteen.get(1);
                }
            }else if (year.equals("2014")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList thirteen = tfsaALHM.get("2014");
                    temp = (Double) thirteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList thirteen = tfsaALHM.get("2014");
                    temp = (Double) thirteen.get(1);
                }
            }else if (year.equals("2015")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList fifteen = tfsaALHM.get("2015");
                    temp = (Double) fifteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList fifteen = tfsaALHM.get("2015");
                    temp = (Double) fifteen.get(1);
                }
            }else if (year.equals("2016")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList sixteen = tfsaALHM.get("2016");
                    temp = (Double) sixteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList sixteen = tfsaALHM.get("2016");
                    temp = (Double) sixteen.get(1);
                }
            }else if (year.equals("2017")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList seventeen = tfsaALHM.get("2017");
                    temp = (Double) seventeen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList seventeen = tfsaALHM.get("2017");
                    temp = (Double) seventeen.get(1);
                }
            }else if (year.equals("2018")) {
                if (AnnOrCum.equals("Annual")) {
                    ArrayList eighteen = tfsaALHM.get("2018");
                    temp = (Double) eighteen.get(0);
                } else if (AnnOrCum.equals("Cumulative")) {
                    ArrayList eighteen = tfsaALHM.get("2018");
                    temp = (Double) eighteen.get(1);
                }
            }
            return temp;
        }

        public void setTFSAALHM(){
            ArrayList<Double> oNine = new ArrayList();
            oNine.add(5000.0);
            oNine.add(57500.0);
            tfsaALHM.put("2009", oNine);

            ArrayList<Double> ten = new ArrayList();
            ten.add(5000.0);
            ten.add(52500.0);
            tfsaALHM.put("2010", ten);

            ArrayList<Double> eleven = new ArrayList();
            eleven.add(5000.0);
            eleven.add(47500.0);
            tfsaALHM.put("2011", eleven);

            ArrayList<Double> twelve = new ArrayList();
            twelve.add(5000.0);
            twelve.add(42500.0);
            tfsaALHM.put("2012", twelve);

            ArrayList<Double> thirteen = new ArrayList();
            thirteen.add(5500.0);
            thirteen.add(37500.0);
            tfsaALHM.put("2013", thirteen);

            ArrayList<Double> fourteen = new ArrayList();
            fourteen.add(5500.0);
            fourteen.add(32000.0);
            tfsaALHM.put("2014", fourteen);

            ArrayList<Double> fifteen = new ArrayList();
            fifteen.add(10000.0);
            fifteen.add(26500.0);
            tfsaALHM.put("2015", fifteen);

            ArrayList<Double> sixteen = new ArrayList();
            sixteen.add(5500.0);
            sixteen.add(16500.0);
            tfsaALHM.put("2016", sixteen);

            ArrayList<Double> seventeen = new ArrayList();
            seventeen.add(5500.0);
            seventeen.add(11000.0);
            tfsaALHM.put("2017", seventeen);

            ArrayList<Double> eighteen = new ArrayList();
            eighteen.add(5500.0);
            eighteen.add(5500.0);
            tfsaALHM.put("2018", eighteen);
        }
}
