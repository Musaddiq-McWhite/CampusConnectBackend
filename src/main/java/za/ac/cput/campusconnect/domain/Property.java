package za.ac.cput.campusconnect.domain;
import jakarta.persistence.*;

import java.util.Objects;
/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Entity
public class Property {
    @Id
    private String propertyID;
    private String propertyOwner;
    private String propertyName;
    private String propertyAddress;
    private int maleRoom;
    private int femaleRoom;
    protected Property(){

    }
    private Property(Builder builder){
        this.propertyID = builder.propertyID;
        this.propertyOwner = builder.propertyOwner;
        this.propertyName = builder.propertyName;
        this.propertyAddress = builder.propertyAddress;
        this.maleRoom = builder.maleRoom;
        this.femaleRoom = builder.femaleRoom;

    }

    public String getPropertyID() {
        return propertyID;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public int getMaleRoom() {
        return maleRoom;
    }

    public int getFemaleRoom() {
        return femaleRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return maleRoom == property.maleRoom && femaleRoom == property.femaleRoom && Objects.equals(propertyID, property.propertyID) && Objects.equals(propertyOwner, property.propertyOwner) && Objects.equals(propertyName, property.propertyName) && Objects.equals(propertyAddress, property.propertyAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyID, propertyOwner, propertyName, propertyAddress, maleRoom, femaleRoom);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyID='" + propertyID + '\'' +
                ", propertyOwner='" + propertyOwner + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                ", maleRoom=" + maleRoom +
                ", femaleRoom=" + femaleRoom +
                '}';
    }
    public static class Builder{
        private String propertyID;
        private String propertyOwner;
        private String propertyName;
        private String propertyAddress;
        private int maleRoom;
        private int femaleRoom;

        public Builder setPropertyID(String propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setPropertyOwner(String propertyOwner) {
            this.propertyOwner = propertyOwner;
            return this;
        }

        public Builder setPropertyName(String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder setPropertyAddress(String propertyAddress) {
            this.propertyAddress = propertyAddress;
            return this;
        }

        public Builder setMaleRoom(int maleRoom) {
            this.maleRoom = maleRoom;
            return this;
        }

        public Builder setFemaleRoom(int femaleRoom) {
            this.femaleRoom = femaleRoom;
            return this;
        }
        public Builder copy(Property property){
            this.propertyID = property.propertyID;
            this.propertyOwner = property.propertyOwner;
            this.propertyName = property.propertyName;
            this.propertyAddress = property.propertyAddress;
            this.maleRoom = property.maleRoom;
            this.femaleRoom = property.femaleRoom;
            return  this;
        }
        public Property build() {
            return new Property(this);
        }
    }

}
