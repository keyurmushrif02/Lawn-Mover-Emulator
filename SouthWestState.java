package sdp_final4;

public class SouthWestState extends State {
    public SouthWestState(LawnMower lawnMower) {
        super(lawnMower);
    }

    @Override
    public void move() {
        lawnMower.setRow(lawnMower.getRow() + 1);
        if (lawnMower.getRow() >= lawnMower.getNumRows()) {
            lawnMower.setState(new EastState(lawnMower));
        } else {
            lawnMower.setState(new WestState(lawnMower));
        }
    }
}
