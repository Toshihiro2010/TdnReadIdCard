package com.stecon.patipan_on.steconidcard;

/**
 * Created by patipan_on on 4/27/2018.
 */

public class MyIDCard {

    public MyIDCard() {
    }

    public Boolean isOk(String data) {

        if (data.equals("-1") || data.equals("-3") || data.equals("-4") || data.equals("-5") || data.equals("-6")
                || data.equals("-7") || data.equals("-8") || data.equals("-9") || data.equals("-10")
                || data.equals("-11") || data.equals("-12") || data.equals("-13") || data.equals("-14")
                || data.equals("-15") || data.equals("-16") || data.equals("-17") || data.equals("-19") || data.equals("-18")) {
            return false;
        }
        return true;
    }
}
