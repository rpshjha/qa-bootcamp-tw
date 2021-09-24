package com.rpshjha.qabootcamp.designpattern;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 5:15 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class CreateServiceOrder {

    public static final Builder builder = new Builder();

    private String customerID;
    private String orderNumber;
    private String orderRefNumber;
    private String circleID;
    private String locationId;

    public CreateServiceOrder(Builder builder) {
        this.customerID = builder.customerID;
        this.orderNumber = builder.orderNumber;
        this.orderRefNumber = builder.orderRefNumber;
        this.circleID = builder.circleID;
        this.locationId = builder.locationID;
    }

    public static class Builder {

        private Builder() {
        }

        private String customerID;
        private String orderNumber;
        private String orderRefNumber;
        private String circleID;
        private String locationID;

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setOrderRefNumber(String orderRefNumber) {
            this.orderRefNumber = orderRefNumber;
            return this;
        }

        public Builder setCircleID(String circleID) {
            this.circleID = circleID;
            return this;
        }

        public Builder setLocationID(String locationID) {
            this.locationID = locationID;
            return this;
        }

        public CreateServiceOrder build() {
            return new CreateServiceOrder(this);
        }

    }

    @Override
    public String toString() {
        return "CreateServiceOrder{" +
                "customerID='" + customerID + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderRefNumber='" + orderRefNumber + '\'' +
                ", circleID='" + circleID + '\'' +
                ", locationId='" + locationId + '\'' +
                '}';
    }
}


