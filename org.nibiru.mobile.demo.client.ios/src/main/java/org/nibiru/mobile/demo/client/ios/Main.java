package org.nibiru.mobile.demo.client.ios;

import org.moe.natj.general.Pointer;
import org.moe.natj.objc.ann.Selector;
import org.nibiru.mobile.demo.client.ios.app.DaggerInjector;

import apple.NSObject;
import apple.foundation.NSDictionary;
import apple.uikit.UIApplication;
import apple.uikit.UIWindow;
import apple.uikit.c.UIKit;
import apple.uikit.protocol.UIApplicationDelegate;

public class Main extends NSObject implements UIApplicationDelegate {
    public static void main(String[] args) {
        UIKit.UIApplicationMain(0, null, null, Main.class.getName());
    }

    @Override
    public void applicationDidFinishLaunching(UIApplication application) {
    }

    @Selector("alloc")
    public static native Main alloc();

    protected Main(Pointer peer) {
        super(peer);
    }

    private UIWindow window;

    @Override
    public boolean applicationDidFinishLaunchingWithOptions(UIApplication application, NSDictionary launchOptions) {
        DaggerInjector.create().getBootstrap().onBootstrap();
        return true;
    }

    @Override
    public void setWindow(UIWindow value) {
        window = value;
    }

    @Override
    public UIWindow window() {
        return window;
    }

}
