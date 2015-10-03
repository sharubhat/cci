package hackerrank.object_modeling.fan;

import hackerrank.object_modeling.remotes.Remote;

/**
 * Created by sharath on 9/19/15.
 */
public class TableFan implements Fan {

    private boolean power;
    private boolean oscillation;
    private Speeds speed;

    private Remote remote;

    private static final int MAX = 8;
    private int time;

    private enum Speeds {
        HIGH, MEDIUM, LOW, ZERO
    }

    @Override
    public void togglePower() {
        power = !power;
    }

    @Override
    public void toggleOscillation() {
        if(power)
            oscillation = !oscillation;
    }

    @Override
    public void changeSpeed() {
        if(power) {
            switch (speed) {
                case ZERO: {
                    speed = Speeds.HIGH;
                    break;
                }
                case HIGH: {
                    speed = Speeds.MEDIUM;
                    break;
                }
                case MEDIUM: {
                    speed = Speeds.LOW;
                    break;
                }
                case LOW: {
                    speed = Speeds.ZERO;
                    break;
                }
                default:
                    speed = Speeds.ZERO;
            }
        }
    }

    @Override
    public void increaseTimer() {
        if(power && this.time < 8 ) {
            this.time++;
        }
    }

    @Override
    public Remote getRemote() {
        if(this.remote == null)
            this.remote = new Remote(this);
        return this.remote;
    }
}
