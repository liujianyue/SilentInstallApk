package cn.messi.silentinstallPoll;

import cn.messi.silentinstallPoll.ISilentInstallObserver;

interface ISilentInstallManager {
	void installPackageByPath(String apkFilePath,ISilentInstallObserver observer);
	void setInstallObserver(ISilentInstallObserver observer);
}  