package ewu.ducanh.packageConsoleApp.main.classes;

import ewu.ducanh.packageConsoleApp.utils.packageUtil;

import static ewu.ducanh.packageConsoleApp.utils.packageUtil.isValidTrackingNumber;
import static ewu.ducanh.packageConsoleApp.utils.packageUtil.isValidWeight;

public class Letter extends Package {
    private static double MAX_WEIGHT = 28.0d;
    private static double MAX_LENGTH_WIDTH = 18.0d;

    public Letter() {
        this.weight = 0.00d;
        this.trackingNumber = "0";
    }

    public Letter( final String _trackingNumber, final Double _weight ) {
        if (_trackingNumber == null || _weight == null) {
            throw new NullPointerException("Null references from one or both parameters");
        } else if ( !isValidTrackingNumber(this.getClass().getSimpleName(), _trackingNumber) || !isValidWeight(_weight) ) {
            throw new IllegalArgumentException("One or both parameters is invalid");
        }

        this.trackingNumber = _trackingNumber;
        this.weight = _weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString() + "\n");



        return sb.toString();
    }

    @Override
    public boolean isOverweight() {
        return packageUtil.isOverweight(this.weight, MAX_WEIGHT);
    }

    @Override
    public boolean isOversize() {
        boolean checkLength = packageUtil.isOversize(this.length, MAX_LENGTH_WIDTH);
        boolean checkWidth = packageUtil.isOversize(this.width, MAX_LENGTH_WIDTH);
        return checkLength || checkWidth;
    }
}
