package cn.messi.silentinstallPoll;

import java.util.List;

import android.content.pm.IPackageInstallObserver;
import cn.messi.silentinstallPoll.ISilentUnInstallManager;
import cn.messi.silentinstallPoll.ISilentUnInstallObserver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public class SilentUninstallManagerImpl extends ISilentUnInstallManager.Stub{
	private static final String TAG = "SilentUninstallManagerImpl";
    private PackageManager mPm;
    private ISilentUnInstallObserver mObserver;
    private String packageName;
    private Context mContext;
    
    public SilentUninstallManagerImpl(Context context,Bundle bundle) {
		// TODO Auto-generated constructor stub
    	mContext = context;
	}
    
    @Override
    public void silentUninstallApk(String packageName,ISilentUnInstallObserver observer){
    	
    }
    
    class PackageDeleteObserver extends IPackageDeleteObserver.Stub {
        public void packageDeleted(String packageName, int returnCode) {
            try {
                mObserver.uninstalled(packageName, returnCode);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void setUninstallObserver(ISilentUnInstallObserver observer)
			throws RemoteException {
		// TODO Auto-generated method stub
		mObserver = observer;
	}

	public static boolean CheckValdate(Bundle bundle, Context mContext) {
        return false;
	}
}
