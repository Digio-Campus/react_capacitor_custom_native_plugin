package com.react_capacitor_custom_native_plugin;

import android.content.Intent;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CustomPlugin")
public class CustomPlugin extends Plugin {

    @PluginMethod()
    public void openNativeView(PluginCall call) {
        Intent intent = new Intent(getContext(), NativeViewActivity.class);
        getActivity().startActivityForResult(intent, 1);
        call.success();
    }
}
