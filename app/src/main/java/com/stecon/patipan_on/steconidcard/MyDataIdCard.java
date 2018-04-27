package com.stecon.patipan_on.steconidcard;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by patipan_on on 4/25/2018.
 */

public class MyDataIdCard {

    private String idCard;
    private String titleNameTH;
    private String firstNameTH;
    private String middleNameTH;
    private String lastNameTH;
    private String titleNameEN;
    private String firstNameEN;
    private String middleNameEN;
    private String lastNameEN;
    private String locationNumber;
    private String locationVillageNo;
    private String locationAlley;
    private String locationSoi;
    private String locationRoad;
    private String locationSubDistrict;
    private String locationDistrict;
    private String locationProvince;

    private String sex;
    private String birthOfDate;
    private String agencyOfLocation;
    private String dateOfIssue;
    private String dateOfExpiry;
    private String requestNumber;

    public MyDataIdCard() {
    }

    public MyDataIdCard(String data) {
        String[] dataArray = new String[23];
        for(int i = 0 ; i < dataArray.length; i++) {

            if (i == dataArray.length - 1) {
                dataArray[i] = data.substring(0);
            } else {
                dataArray[i] = data.substring(0, data.indexOf('#'));
                data = data.substring(data.indexOf('#')+1);
            }
            if (dataArray[i].equals("")) {
                dataArray[i] = " ";
            }
        }
        this.idCard = dataArray[0];
        this.titleNameTH = dataArray[1];
        this.firstNameTH = dataArray[2];
        this.middleNameTH = dataArray[3];
        this.lastNameTH = dataArray[4];
        this.titleNameEN = dataArray[5];
        this.firstNameEN = dataArray[6];
        this.middleNameEN = dataArray[7];
        this.lastNameEN = dataArray[8];
        this.locationNumber = dataArray[9];
        this.locationVillageNo = dataArray[10];
        this.locationAlley = dataArray[11];
        this.locationSoi = dataArray[12];
        this.locationRoad = dataArray[13];
        this.locationSubDistrict = dataArray[14];
        this.locationDistrict = dataArray[15];
        this.locationProvince = dataArray[16];
        this.sex = dataArray[17];
        this.birthOfDate = dataArray[18];
        this.agencyOfLocation = dataArray[19];
        this.dateOfIssue = dataArray[20];
        this.dateOfExpiry = dataArray[21];
        this.requestNumber = dataArray[22];
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTitleNameTH() {
        return titleNameTH;
    }

    public void setTitleNameTH(String titleNameTH) {
        this.titleNameTH = titleNameTH;
    }

    public String getFirstNameTH() {
        return firstNameTH;
    }

    public void setFirstNameTH(String firstNameTH) {
        this.firstNameTH = firstNameTH;
    }

    public String getLastNameTH() {
        return lastNameTH;
    }

    public void setLastNameTH(String lastNameTH) {
        this.lastNameTH = lastNameTH;
    }

    public String getTitleNameEN() {
        return titleNameEN;
    }

    public String getMiddleNameTH() {
        return middleNameTH;
    }

    public void setMiddleNameTH(String middleNameTH) {
        this.middleNameTH = middleNameTH;
    }

    public String getMiddleNameEN() {
        return middleNameEN;
    }

    public void setMiddleNameEN(String middleNameEN) {
        this.middleNameEN = middleNameEN;
    }

    public String getLocationAlley() {
        return locationAlley;
    }

    public void setLocationAlley(String locationAlley) {
        this.locationAlley = locationAlley;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setTitleNameEN(String titleNameEN) {
        this.titleNameEN = titleNameEN;
    }

    public String getFirstNameEN() {
        return firstNameEN;
    }

    public void setFirstNameEN(String firstNameEN) {
        this.firstNameEN = firstNameEN;
    }

    public String getLastNameEN() {
        return lastNameEN;
    }

    public void setLastNameEN(String lastNameEN) {
        this.lastNameEN = lastNameEN;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getLocationVillageNo() {
        return locationVillageNo;
    }

    public void setLocationVillageNo(String locationVillageNo) {
        this.locationVillageNo = locationVillageNo;
    }

    public String getLocationLane() {
        return locationAlley;
    }

    public void setLocationLane(String locationLane) {
        this.locationAlley = locationLane;
    }

    public String getLocationSoi() {
        return locationSoi;
    }

    public void setLocationSoi(String locationSoi) {
        this.locationSoi = locationSoi;
    }

    public String getLocationRoad() {
        return locationRoad;
    }

    public void setLocationRoad(String locationRoad) {
        this.locationRoad = locationRoad;
    }

    public String getLocationSubDistrict() {
        return locationSubDistrict;
    }

    public void setLocationSubDistrict(String locationSubDistrict) {
        this.locationSubDistrict = locationSubDistrict;
    }

    public String getLocationDistrict() {
        return locationDistrict;
    }

    public void setLocationDistrict(String locationDistrict) {
        this.locationDistrict = locationDistrict;
    }

    public String getLocationProvince() {
        return locationProvince;
    }

    public void setLocationProvince(String locationProvince) {
        this.locationProvince = locationProvince;
    }


    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getAgencyOfLocation() {
        return agencyOfLocation;
    }

    public void setAgencyOfLocation(String agencyOfLocation) {
        this.agencyOfLocation = agencyOfLocation;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpry() {
        return dateOfExpiry;
    }

    public void setDateOfExpry(String dateOfExpry) {
        this.dateOfExpiry = dateOfExpry;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getFirstLastFullNameTH() {
        String name = this.titleNameTH + " " + this.firstNameTH + " " + this.lastNameTH;
        return name;
    }

    public String getFirstLastFullNameEN() {
        String name = this.titleNameEN + " " + this.firstNameEN + " " + this.lastNameEN;
        return name;
    }

    public String getLocationFull() {
        String strAddress = "";
        strAddress += this.locationNumber + " " + this.locationVillageNo + " " + this.locationAlley + " " + this.locationSoi;
        strAddress += " " + this.locationRoad + " " + this.locationSubDistrict + " " + this.locationDistrict + " " + this.locationProvince;

        return strAddress;
    }

    public String getDataAll() {
        String result = "";
        result += getIdCard() + " " + getFirstLastFullNameTH() + " " + getBirthOfDate() + " " + getLocationFull();

        return result;
    }



}
