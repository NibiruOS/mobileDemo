package org.nibiru.mobile.demo.client.android.app;


import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.demo.client.android.R;

import org.nibiru.mobile.android.ui.mvp.PresenterAdapter;
import org.nibiru.mobile.core.api.ui.place.PlaceManager;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.nibiru.mobile.demo.client.android.app.ComponentHelper.component;

/**
 * A simple {@link Fragment} subclass.
 */
public class PresenterFragment extends Fragment {
    private PresenterAdapter adapter;
    private String placeId;

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        TypedArray a = getActivity().obtainStyledAttributes(attrs, R.styleable.PlaceFragment);
        placeId = checkNotNull(a.getText(R.styleable.PlaceFragment_place_id),
                "Place ID not specifed for fragment")
                .toString();
        a.recycle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = getPresenterAdapter();
        return adapter.onCreate(getPlaceManager().createPlace(placeId));
    }

    private PresenterAdapter getPresenterAdapter() {
        return component(this.getActivity())
                .getPresenterAdapter();
    }

    private PlaceManager getPlaceManager() {
        return component(this.getActivity())
                .getPlaceManager();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.onStop();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        adapter.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        adapter.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return adapter.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        adapter.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return adapter.onContextItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        adapter.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.onStart();
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.onActivityResult(requestCode, resultCode, data);
    }
}
