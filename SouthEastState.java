package sdp_final4;

public class SouthEastState extends State {
    public SouthEastState(LawnMower lawnMower) {
        super(lawnMower);
    }

    @Override
    public void move() {
        lawnMower.setRow(lawnMower.getRow() + 1);
        if (lawnMower.getRow() >= lawnMower.getNumRows()) {
            lawnMower.setState(new WestState(lawnMower));
        } else {
            lawnMower.setState(new EastState(lawnMower));
        }
    }
}
