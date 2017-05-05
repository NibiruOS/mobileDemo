package org.nibiru.mobile.demo.client.android.app;

import com.mobile.demo.client.android.R;

import org.nibiru.ui.android.style.ReflectionStyleResolver;
import org.nibiru.ui.android.style.StyleResolver;

import dagger.Module;
import dagger.Provides;

@Module
public class DemoAndroidModule {
    @Provides
    public StyleResolver styleResolver() {
        return new ReflectionStyleResolver(R.style.class);
    }
}
