package com.stecon.patipan_on.steconidcard;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import rd.TDA.TDA;

public class MainActivity extends AppCompatActivity {

    private ImageView imgIdCard;
    private TextView tvIdCard;
    private Button btnRead;
    private Button btnExit;

    private TDA tda;

    private String app_name;
    private MyIDCard myIDCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindWidget();

        myIDCard = new MyIDCard();
        tda = new TDA(MainActivity.this);
        app_name = getResources().getString(R.string.app_name);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRead();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExit();
            }
        });

        startProcess();
        testProcress();


//        String info2 = tda.infoTA("2");
//        String info3 = tda.infoTA("3");
//        String info5 = tda.infoTA("5");

        //Toast.makeText(this, "in2 => " + info2 + " / in3 => " + info3, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "info5 => " + info5, Toast.LENGTH_SHORT).show();


    }

    private void testProcress() {

//        String strTemp = "1249900358658#นาย#ปฏิภาณ##องอาจ#Mr.#Patipan##Ongarj#111/8#หมู่ที่ 16####ตำบลบางเสาธง#อำเภอบางเสาธง#จังหวัดสมุทรปราการ#1#25380216#อำเภอบางเสาธง/สมุทรปราการ#25551012#25640215#11060210121431";
//        MyDataIdCard myDataIdCard = new MyDataIdCard(strTemp);

    }

    private void onRead() {

        MyOnRead myOnRead = new MyOnRead();
        myOnRead.execute();

    }

    private void onExit() {
        Intent intent = new Intent(Intent.ACTION_MAIN);                 //Initial Intent
        intent.addCategory(Intent.CATEGORY_HOME);                       //Add Category for Intent
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);                 //Set Flag for Intent
        startActivity(intent);                                          //Start Activity by intent //go to Main
        finish();                                                       //finish for this App //Close App
        tda.serviceTA("0");                                             //Close service before exit

    }

    private void bindWidget() {
        imgIdCard = findViewById(R.id.imgIdCard);
        tvIdCard = findViewById(R.id.tvIdCard);
        btnRead = findViewById(R.id.btnReadCard);
        btnExit = findViewById(R.id.btnExit);
    }


    public boolean isNetworkConnect() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        Boolean status = networkInfo != null && networkInfo.isConnected();

        return status;
    }

    private void startProcess() {
        tda.serviceTA("0");
        while (tda.serviceTA("9").compareTo("00") != 0){
            Log.d("startProcess => ", " 00");

        }
        tda.serviceTA("1," + app_name);
        while (tda.serviceTA("9").compareTo("01") != 0) {
            Log.d("startProcess => ", "01");
        }

        //Check license file
        String check = tda.infoTA("4");
        Log.i("startProcessCheck", " => " + check);
        if (check.compareTo("-2") == 0 || check.compareTo("-12") == 0) {
            if (isNetworkConnect()) {
                Log.d("startProcessCheck => ", "update Service");
                tda.serviceTA("2");
            }
        }

    }

    private class MyOnRead extends AsyncTask<Void, Void, String> {
        byte[] photo;
        Bitmap nPhoto;
        String data;
        String tempt;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setTitle("On Load");
            progressDialog.setMessage("Load Data Id Card");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {


            data = tda.nidTextTA("0");

            if (data.compareTo("-2") == 0) {
                tda.serviceTA("2");
                data = tda.nidTextTA("0");

            }
            if (!myIDCard.isOk(data)) {
                return "";
            }
//
//            data = data.replace('#', ' ');
            photo = tda.nidPhotoTA("0");


            nPhoto = BitmapFactory.decodeByteArray(photo, 0, photo.length);
//
//
//            tempt = bytesToHex(photo);
//
//            Log.d("MyPhoto => ", photo + "");
//            Log.d("nPhoto => ", nPhoto.toString() + "");
//            Log.d("tempt => ", tempt + "");
//
//            byte[] encodeValue = Base64.encode(photo, Base64.DEFAULT);
//            byte[] decodeValue = Base64.decode(encodeValue, Base64.DEFAULT);
//
//            Log.d("numCard => ", new String(photo));
//            Log.d("encodeValue => ", new String(encodeValue));
//            Log.d("decodeValue => ", new String(decodeValue));


            return "1";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (s.equals("1")) {

                MyDataIdCard myDataIdCard = new MyDataIdCard(data);
                tvIdCard.setText(myDataIdCard.getDataAll());
                imgIdCard.setImageBitmap(nPhoto);
            } else {
                tvIdCard.setText("No Data");
                imgIdCard.setImageResource(R.drawable.ic_launcher_background);

                Toast.makeText(MainActivity.this, "มีข้อผิดพลาด", Toast.LENGTH_SHORT).show();
            }


            progressDialog.dismiss();

        }
    }

    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 3 + 4];
        if (bytes.length < 10) {
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 3] = hexArray[v >>> 4];
                hexChars[j * 3 + 1] = hexArray[v & 0x0F];
                hexChars[j * 3 + 2] = ' ';
            }
        } else {
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 3] = hexArray[v >>> 4];
                hexChars[j * 3 + 1] = hexArray[v & 0x0F];
                hexChars[j * 3 + 2] = ' ';
            }
//            if (bytes.length > 10) {
//                hexChars[bytes.length * 3] = ' ';
//                hexChars[bytes.length * 3 + 1] = '.';
//                hexChars[bytes.length * 3 + 2] = '.';
//                hexChars[bytes.length * 3 + 3] = '.';
//            }
        }

        return new String(hexChars);
    }
}
