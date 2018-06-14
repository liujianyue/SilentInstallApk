LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-subdir-java-files)

LOCAL_SRC_FILES += \
        src/cn/kt/silentinstallPoll/ISilentInstallManager.aidl \
        src/cn/kt/silentinstallPoll/ISilentInstallObserver.aidl \
        src/cn/kt/silentinstallPoll/ISilentUnInstallManager.aidl \
        src/cn/kt/silentinstallPoll/ISilentUnInstallObserver.aidl \
        src/cn/kt/silentinstallPoll/IBinderPool.aidl
        

LOCAL_STATIC_JAVA_LIBRARIES += android-support-v4

LOCAL_PACKAGE_NAME := MessiSilentInstalls
LOCAL_CERTIFICATE := platform

LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)

