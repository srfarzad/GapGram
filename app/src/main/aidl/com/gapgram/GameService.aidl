// GameService.aidl
package com.gapgram;
import com.gapgram.RequestCallback;
// Declare any non-default types here with import statements

interface GameService {

       void newMatch(String params);
       void canAcceptMatch(String params,RequestCallback callback);
       void startApp(String params);

}
