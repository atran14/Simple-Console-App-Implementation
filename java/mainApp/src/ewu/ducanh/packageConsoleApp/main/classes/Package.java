package ewu.ducanh.packageConsoleApp.main.classes;

public abstract class Package implements Comparable<Package>{
    protected String trackingNumber;
    protected Double weight;
    protected Double length, width;

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

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder("");

        str.append("Package type: " + this.getClass().getSimpleName() + "\n");
        str.append("Tracking number: " + this.trackingNumber + "\n");
        str.append("Weight: " + this.weight + "\n");
        str.append("Length: " + this.length + " | Width: " + this.width);

        return str.toString();
    }

    @Override
    public boolean equals( final Object that ) {
        if ( this == that ) return true;
        if ( that == null ) return false;
        if (!(that instanceof Package)) return false;

        Package obj = (Package) that;
        boolean b1 = this.getClass().getSimpleName().equals(obj.getClass().getSimpleName());
        boolean b2 = this.weight.equals(obj.weight);
        return b1 && b2;
    }

    @Override
    public int compareTo( final Package that ) {
        int c1 = (this.getClass().getSimpleName()).compareTo(that.getClass().getSimpleName());
        if ( c1 == 0 ) {
            return this.weight.compareTo(that.weight);
        }
        return c1;
    }

    public abstract boolean isOverweight();

    public abstract boolean isOversize();
}