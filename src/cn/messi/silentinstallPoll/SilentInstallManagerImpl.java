package cn.messi.silentinstallPoll;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.messi.silentinstallPoll.ISilentInstallManager;
import cn.messi.silentinstallPoll.ISilentInstallObserver;
import cn.messi.silentinstallUtil.SilentInstallUtil;
import android.util.Log;
import android.app.Service;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageUserState;
import android.content.pm.VerificationParams;

public class SilentInstallManagerImpl extends ISilentInstallManager.Stub{
	private static final String TAG="SilentInstallManagerImpl";

	private static List<String> WhitePackages = new ArrayList<String>(10);
	private static List<Integer> WhitePackageUids = new ArrayList<Integer>(10);
	static {
		//innt secrityPackages,secrityPackageUids
	}
    private ISilentInstallObserver mObserver;
    private String packageName;
    private Context mContext;
    
    public SilentInstallManagerImpl(Context context) {
		// TODO Auto-generated constructor stub
    	mContext = context;
	}
    
	@Override
	public void installPackageByPath(String apkFilePath,
			ISilentInstallObserver observer) throws RemoteException {
		
	}

	@Override
	public void setInstallObserver(ISilentInstallObserver observer)
			throws RemoteException {
		// TODO Auto-generated method stub
		mObserver = observer;
	}
	

    class PackageInstallObserver extends IPackageInstallObserver.Stub {
        public void packageInstalled(String packageName, int returnCode) {
            try {
                mObserver.intalled(packageName, returnCode);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static boolean CheckValdate(Bundle bundle,Context mContext){
        return false;
    }
}
