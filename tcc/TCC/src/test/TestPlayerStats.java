
package test;

import data.storage.PlayerStats;

public class TestPlayerStats {

    
    public static void main(String[] args) {
        PlayerStats ps = PlayerStats.getInstance();
        
        //ps.setFasePoints(1, "30");
        //ps.setFasePoints(2, "20");
        
        System.out.println(ps.getProperty("total"));
        
    }
}
