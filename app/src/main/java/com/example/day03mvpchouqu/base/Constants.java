package com.example.day03mvpchouqu.base;

import java.io.File;

public interface Constants {
    //开发状态
    boolean isDebug = true;

    //网络缓存的地址
    String PATH_DATA = BaseApp.baseApp.getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
}
