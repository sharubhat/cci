package hackerrank.object_modeling;

import hackerrank.object_modeling.fan.Fan;
import hackerrank.object_modeling.fan.TableFan;
import hackerrank.object_modeling.remotes.Remote;

/**
 * Created by sharath on 9/19/15.
 */
public class User {
    public static void main(String[] args) {
        Fan fan = new TableFan();
        Remote tableFanRemote = fan.getRemote();

        tableFanRemote.getPowerButton().press();
        tableFanRemote.getOscillationButton().press();
    }
}
