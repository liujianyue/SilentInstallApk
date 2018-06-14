package cn.messi.silentinstallPoll;

import cn.messi.silentinstallPoll.ISilentUnInstallObserver;

interface ISilentUnInstallManager {
        void silentUninstallApk(String packageName,ISilentUnInstallObserver observer);
		void setUninstallObserver(ISilentUnInstallObserver observer);
}  
