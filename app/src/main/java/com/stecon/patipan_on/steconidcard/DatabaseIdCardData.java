package com.stecon.patipan_on.steconidcard;

/**
 * Created by patipan_on on 4/26/2018.
 */

public class DatabaseIdCardData {

    public static String TABLE_NAME = "ThaiIdCard";

    public static final String COL_ID = "_id";

    public static final String COLUMN_ID_CARD = "idCard";
    public static final String COLUMN_TITLE_NAME_TH = "titleNameTH";
    public static final String COLUMN_FIRST_NAME_TH = "firstNameTH";
    public static final String COLUMN_MIDDLE_NAME_TH = "middleNameTH";
    public static final String COLUMN_LAST_NAME_TH = "lastNameTH";
    public static final String COLUMN_TITLE_NAME_EN = "titleNameEN";
    public static final String COLUMN_MIDDLE_NAME_EN = "middleNameEN";
    public static final String COLUMN_LAST_NAME_EN = "lastNameEN";
    public static final String COLUMN_LOCATION_NUMBER = "locationAddress";

    public static final String COLUMN_SEX = "sex";
    public static final String COLUMN_BIRTH_OF_DATE = "birthOfDate";
    public static final String COLUMN_AGENCY_OF_LOCATION = "agencyOfLocation";
    public static final String COLUMN_DATE_OF_ISSUE = "dateOfIssue";
    public static final String COLUMN_DATE_OF_EXPIRY = "dateOfExpiry";
    public static final String COLUMN_REQUEST_NUMBER = "requestNumber";


    public static String strSqlCreate = "CREATE TABLE " + TABLE_NAME
            + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ID_CARD + " TEXT,"
            + COLUMN_TITLE_NAME_TH + " TEXT,"
            + COLUMN_FIRST_NAME_TH + " TEXT,"
            + COLUMN_LAST_NAME_TH + " TEXT,"
            + COLUMN_MIDDLE_NAME_TH + " TEXT,"
            + COLUMN_LAST_NAME_TH + " TEXT,"
            + COLUMN_TITLE_NAME_EN + " TEXT,"
            + COLUMN_MIDDLE_NAME_EN + " TEXT,"
            + COLUMN_LAST_NAME_EN + " TEXT,"
            + COLUMN_LOCATION_NUMBER + " TEXT,"
            + COLUMN_SEX + " TEXT,"
            + COLUMN_BIRTH_OF_DATE + " TEXT,"
            + COLUMN_AGENCY_OF_LOCATION + " TEXT,"
            + COLUMN_DATE_OF_ISSUE + " TEXT,"
            + COLUMN_DATE_OF_EXPIRY + " TEXT,"
            + COLUMN_REQUEST_NUMBER + " TEXT);";

}
