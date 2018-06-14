package cn.messi.silentinstallPoll;

import android.os.Bundle;

interface IBinderPool {

    /**
     * @param binderCode, the unique token of specific Binder<br/>
     * @return specific Binder who's token is binderCode.
     */
    IBinder queryBinder(int binderCode,in Bundle bundle);
}