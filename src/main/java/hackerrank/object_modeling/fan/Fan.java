package hackerrank.object_modeling.fan;

import hackerrank.object_modeling.remotes.Remote;

/**
 * Created by sharath on 9/19/15.
 */
public interface Fan {
    void togglePower();
    void toggleOscillation();
    void changeSpeed();
    void increaseTimer();

    Remote getRemote();
}
