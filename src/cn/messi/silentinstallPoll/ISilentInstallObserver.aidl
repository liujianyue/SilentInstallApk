package cn.messi.silentinstallPoll;

interface ISilentInstallObserver {
	void intalled(String packageName,int resultCode);
}  