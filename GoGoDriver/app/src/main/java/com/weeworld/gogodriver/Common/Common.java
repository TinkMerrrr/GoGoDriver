package com.weeworld.gogodriver.Common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.location.Location;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.FirebaseDatabase;
import com.weeworld.gogodriver.Model.Request;
import com.weeworld.gogodriver.Model.Shipper;
import com.weeworld.gogodriver.Model.ShippingInformation;
import com.weeworld.gogodriver.Remote.IGeoCoodinates;
import com.weeworld.gogodriver.Remote.RetrofitClient;
import com.google.android.gms.tasks.OnFailureListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Common {
    public static final String SHIPPER_TABLE = "Users";
    public static final String ORDER_NEED_SHIP_TABLE = "OrderDetails";
    public static final String SHIPPER_INFO_TABLE = "OrderDetails";
    public static final int REQUEST_CODE = 1000;
    public static Shipper currentShipper;
    public static Request currentRequest;
    public static String currentKey;

    public static final String baseUrl = "https://maps.googleapis.com";

    public static String convertCodeToStatus(String status) {
        if (status.equals("0"))
            return "Đã đặt hàng";
        else if (status.equals("1"))
            return "Đang giao";
        else if (status.equals("2"))
            return "Đang Chuyển Hàng";
        else
            return "Đã Giao";
    }

    public static String getDate(long time) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(
                android.text.format.DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString());
        return date.toString();
    }

    //draw Routes
    public static IGeoCoodinates getIGeoCoodinates() {
        return RetrofitClient.getClient(baseUrl).create(IGeoCoodinates.class);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        Bitmap scaleBitmap = Bitmap.createBitmap(newWidth, newWidth, Bitmap.Config.ARGB_8888);
        float scaleX = newWidth / (float) bitmap.getWidth();
        float scaleY = newHeight / (float) bitmap.getHeight();
        float pivotX = 0, pivotY = 0;
        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX, scaleY, pivotX, pivotY);
        Canvas canvas = new Canvas(scaleBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));
        return scaleBitmap;
    }


    public static void createShippingOrder(String key, String numPhone, Location mLastLocation) {
        ShippingInformation shippingInformation = new ShippingInformation();
        shippingInformation.setOrderId(key);
        shippingInformation.setShipperPhone(numPhone);
        shippingInformation.setLat(mLastLocation.getLatitude());
        shippingInformation.setLng(mLastLocation.getLongitude());

        // create new item on ShipperInformation table;
        FirebaseDatabase.getInstance().getReference("OrderDetails").child(key).setValue(shippingInformation)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ERROR", e.getMessage());
                    }
                });

    }

    public static void updateShippingInformation(String currentKey, Location mLastLocation) {
        Map<String, Object> update_location = new HashMap<>();
        update_location.put("lat", mLastLocation.getLatitude());
        update_location.put("lng", mLastLocation.getLongitude());

        FirebaseDatabase.getInstance().getReference("OrderDetails").child(currentKey)
                .updateChildren(update_location).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR", e.getMessage());
            }
        });

    }
}
