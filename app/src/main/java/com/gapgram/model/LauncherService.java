package com.gapgram.model;

import com.gapgram.GameService;

public interface LauncherService {

    public void onResult(GameService gameInterface);
    public void onFail(String ErrorMessage);

}
