package cn.messi.silentinstallUtil;

import java.io.File;

import PackageParser.Package;
import android.util.Log;
import android.content.pm.PackageParser;
import android.content.pm.PackageParser.PackageParserException

public class SilentInstallUtil {
	private static final String TAG = "SilentInstallUtil";
	
    public static PackageParser.Package getPackageInfo(File sourceFile) {
        PackageParser.Package pkg = null;
        try{
            PackageParser packageParser = new PackageParser();
            pkg = packageParser.parsePackage(sourceFile, 0);

            packageParser = null;
        }catch(PackageParserException e){
            Log.d(TAG,"PackageParserException happens");
        }
        return pkg;
    }
}
