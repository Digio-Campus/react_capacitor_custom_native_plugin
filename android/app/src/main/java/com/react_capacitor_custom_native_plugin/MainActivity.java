package com.react_capacitor_custom_native_plugin;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.BridgeActivity;
import android.os.Bundle;


public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(CustomPlugin.class);
        super.onCreate(savedInstanceState);
    }
}