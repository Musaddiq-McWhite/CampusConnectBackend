package za.ac.cput.campusconnect.domain;

import java.util.Objects;

public class Business {
    private String businessID;
    private String BusinessName;
    private Contact contact;
    private String description;

    protected Business(){

    }
    private Business(Builder builder){
        this.businessID = builder.businessID;
        this.BusinessName = builder.BusinessName;
        this.contact = builder.contact;
        this.description = builder.description;

    }

    public String getBusinessID() {
        return businessID;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public Contact getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(businessID, business.businessID) && Objects.equals(BusinessName, business.BusinessName) && Objects.equals(contact, business.contact) && Objects.equals(description, business.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessID, BusinessName, contact, description);
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessID='" + businessID + '\'' +
                ", BusinessName='" + BusinessName + '\'' +
                ", contact=" + contact +
                ", description='" + description + '\'' +
                '}';
    }
    public static class Builder{
        private String businessID;
        private String BusinessName;
        private Contact contact;
        private String description;


        public Builder setBusinessID(String businessID) {
            this.businessID = businessID;
            return this;
        }

        public Builder setBusinessName(String businessName) {
            BusinessName = businessName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Business business){
            this.businessID = business.businessID;
            this.BusinessName = business.BusinessName;
            this.contact= business.contact;
            this.description = business.description;
            return this ;

        }
        public Business build() {
            return new Business(this);
        }
    }
}
