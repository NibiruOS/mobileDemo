package org.nibiru.mobile.demo.client.android.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

import org.nibiru.mobile.demo.client.core.api.business.security.Session;
import org.nibiru.mobile.demo.client.core.impl.ui.UiMessages;

import dagger.Component;

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = AppComponent.class)
public interface ActivityComponent {
    Activity activity();

    Context context();

    Resources resources();

    ////
    Session session();

    UiMessages uiMessages();
}
