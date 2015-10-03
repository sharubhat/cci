package hackerrank.object_modeling.buttons;

import hackerrank.object_modeling.fan.Fan;

/**
 * Created by sharath on 9/19/15.
 */
public class TimerButton implements Button {
    private Fan fan;

    public TimerButton(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void press() {
        fan.increaseTimer();
    }
}
