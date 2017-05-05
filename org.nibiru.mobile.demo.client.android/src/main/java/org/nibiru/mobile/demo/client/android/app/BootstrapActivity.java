package org.nibiru.mobile.demo.client.android.app;

import android.app.Activity;
import android.os.Bundle;

import static org.nibiru.mobile.demo.client.android.app.ComponentHelper.component;

public class BootstrapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component(this).getBootstrap().onBootstrap();
        finish();
    }
}
