package ewu.ducanh.packageConsoleApp.main.classes;

public abstract class Package implements Comparable<Package>{
    protected String trackingNumber;
    protected double weight;
    protected double length, width;
    protected boolean overweight, oversize;

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setTrackingNumber(String trackingNumber) {
        if ( trackingNumber != null ) {
            this.trackingNumber = trackingNumber;
        } else {
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public void setWeight(Double weight) {
        if ( weight < 0 ) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public void setLength(Double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
    }

    public void setWidth(Double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("");

        str.append("Package type: " + this.getClass().getSimpleName() + "\n");
        str.append("Tracking number: " + this.trackingNumber + "\n");
        str.append("Weight: " + this.weight + "\n");
        str.append("Length: " + this.length + " | Width: " + this.width);
        str.append("Status: ");
        if ( !this.overweight && !this.oversize ) { str.append("Can be loaded"); }
        else if (this.overweight && this.oversize) { str.append("Overweight & Oversize - Cannot be loaded"); }
        else if (this.overweight) { str.append("Overweight - Cannot be loaded"); }
        else { str.append("Oversize - Cannot be loaded"); }

        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (Double.compare(aPackage.weight, weight) != 0) return false;
        if (Double.compare(aPackage.length, length) != 0) return false;
        if (Double.compare(aPackage.width, width) != 0) return false;
        if (overweight != aPackage.overweight) return false;
        if (oversize != aPackage.oversize) return false;
        return trackingNumber.equals(aPackage.trackingNumber);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = trackingNumber.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (overweight ? 1 : 0);
        result = 31 * result + (oversize ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo( final Package that ) {
        int c1 = (this.getClass().getSimpleName()).compareTo(that.getClass().getSimpleName());
        if ( c1 == 0 ) {
            return (new Double(this.weight)).compareTo(that.weight);
        }
        return c1;
    }

    public abstract boolean isOverweight();

    public abstract boolean isOversize();
}