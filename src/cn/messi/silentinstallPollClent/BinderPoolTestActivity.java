package cn.messi.silentinstallPollClent;

import cn.messi.silentinstallPoll.ISilentInstallManager;
import cn.messi.silentinstallPoll.ISilentUnInstallManager;
import cn.messi.silentinstallPoll.ISilentInstallObserver;
import cn.messi.silentinstallPoll.R;
import cn.messi.silentinstallPoll.SilentUninstallManagerImpl;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class BinderPoolTestActivity extends Activity {
    private static final String TAG = "BinderPoolTestActivity";
    public static final int BINDER_NONE = -1;
    public static final int BINDER_INSTALL = 0;
    public static final int BINDER_UNINSTALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Need do it in thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                TestBinder();
            }
        }).start();
    }

    private void TestBinder() {
        BinderPoolManager binderPool = BinderPoolManager.getInsance(BinderPoolTestActivity.this);
        IBinder uninstallBinder = binderPool.queryBinder(BINDER_UNINSTALL,null);
        IBinder installBinder = binderPool.queryBinder(BINDER_INSTALL,null);
        
        ISilentUnInstallManager mISilentUnInstallManager = ISilentUnInstallManager.Stub.asInterface(uninstallBinder);
        ISilentInstallManager mISilentInstallManager = ISilentInstallManager.Stub.asInterface(installBinder);
    }
}
