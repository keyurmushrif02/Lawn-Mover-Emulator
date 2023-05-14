package sdp_final4;

public abstract class State {
    protected LawnMower lawnMower;

    public State(LawnMower lawnMower) {
        this.lawnMower = lawnMower;
    }

    public abstract void move();
}
