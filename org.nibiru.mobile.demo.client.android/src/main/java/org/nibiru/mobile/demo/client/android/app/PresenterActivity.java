package org.nibiru.mobile.demo.client.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.nibiru.mobile.android.ui.mvp.PresenterAdapter;
import org.nibiru.mobile.android.ui.place.IntentPlace;

import javax.annotation.Nullable;

import static org.nibiru.mobile.demo.client.android.app.ComponentHelper.component;

/**
 * Presenter activity.
 */
public class PresenterActivity extends AppCompatActivity {
    private PresenterAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = getPresenterAdapter();
        setContentView(adapter.onCreate(new IntentPlace(getIntent())));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.onStop();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return adapter.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return adapter.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return adapter.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenuInfo menuInfo) {
        adapter.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return adapter.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.onActivityResult(requestCode, resultCode, data);
    }

    private PresenterAdapter getPresenterAdapter() {
        return component(this)
                .getPresenterAdapter();
    }
}
