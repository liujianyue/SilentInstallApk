package cn.messi.silentinstallPoll;

import cn.messi.silentinstallPoll.IBinderPool;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class BinderPoolManagerService extends Service {

    private static final String TAG = "BinderPoolManagerService";
    public static final int BINDER_NONE = -1;
    public static final int BINDER_INSTALL = 0;
    public static final int BINDER_UNINSTALL = 1;
    private Binder mBinderPool = new BinderPoolImpl(this);	
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        int check = checkCallingOrSelfPermission("cn.kt.remote.silenet.install");
        if(check == PackageManager.PERMISSION_DENIED)
        	return null;
        return mBinderPool;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    
    public static class BinderPoolImpl extends IBinderPool.Stub {
    	
    	private Context mContext;
        public BinderPoolImpl(Context context) {
        	super();
        	mContext = context;
        }

        @Override
        public IBinder queryBinder(int binderCode,Bundle bundle) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
            case BINDER_UNINSTALL: {
            	if(!SilentUninstallManagerImpl.CheckValdate(bundle, mContext))
            		binder = new SilentUninstallManagerImpl(mContext,bundle);
                break;
            }
            case BINDER_INSTALL: {
            	if(!SilentInstallManagerImpl.CheckValdate(bundle, mContext))
            		binder = new SilentInstallManagerImpl(mContext);
                break;
            }
            default:
                break;
            }
            return binder;
        }
    }
}
