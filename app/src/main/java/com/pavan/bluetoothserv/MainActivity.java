package com.pavan.bluetoothserv;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    BluetoothManager bm;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> bluetoothDeviceSet;
    ArrayList<String> list = new ArrayList<String>();
    ListView l;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView)findViewById(R.id.listView);
        bm = (BluetoothManager)getSystemService(BLUETOOTH_SERVICE);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
        for(BluetoothDevice bd :bluetoothDeviceSet){
            list.add(bd.getName());
        }
        l.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list));

    }
}
