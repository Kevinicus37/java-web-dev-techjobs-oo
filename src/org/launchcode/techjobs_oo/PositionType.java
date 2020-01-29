package org.launchcode.techjobs_oo;

import java.util.Objects;

public class PositionType extends JobField{
    public PositionType(String aValue) {
        super(aValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType that = (PositionType) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
