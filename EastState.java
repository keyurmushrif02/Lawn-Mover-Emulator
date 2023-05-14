package sdp_final4;

public class EastState extends State {
    public EastState(LawnMower lawnMower) {
        super(lawnMower);
    }

    @Override
    public void move() {
        lawnMower.setColumn(lawnMower.getColumn() + 1);
        if (lawnMower.getColumn() >= lawnMower.getNumCols()) {
            lawnMower.setState(new SouthEastState(lawnMower));
            lawnMower.setRow(lawnMower.getRow() + 1);  // move down one row
            lawnMower.setColumn(lawnMower.getNumCols() - 1);  // move to the rightmost column
        }
    }
}