package hackerrank.object_modeling.remotes;

import hackerrank.object_modeling.buttons.OscillationButton;
import hackerrank.object_modeling.buttons.PowerButton;
import hackerrank.object_modeling.buttons.SpeedButton;
import hackerrank.object_modeling.buttons.TimerButton;
import hackerrank.object_modeling.fan.Fan;

/**
 * Created by sharath on 9/19/15.
 */
public class Remote {
    private PowerButton powerButton;
    private SpeedButton speedButton;
    private TimerButton timerButton;
    private OscillationButton oscillationButton;

    public Remote(Fan fan) {
        this.powerButton = new PowerButton(fan);
        this.speedButton = new SpeedButton(fan);
        this.oscillationButton = new OscillationButton(fan);
        this.timerButton = new TimerButton(fan);
    }

    public PowerButton getPowerButton() {
        return powerButton;
    }

    public SpeedButton getSpeedButton() {
        return speedButton;
    }

    public TimerButton getTimerButton() {
        return timerButton;
    }

    public OscillationButton getOscillationButton() {
        return oscillationButton;
    }
}
