package sdp_final4;

public class WestState extends State {
    public WestState(LawnMower lawnMower) {
        super(lawnMower);
    }

    @Override
    public void move() {
        lawnMower.setColumn(lawnMower.getColumn() - 1);
        if (lawnMower.getColumn() < 0) {
            lawnMower.setState(new SouthWestState(lawnMower));
        }
    }
}
