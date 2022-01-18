package com.youngman.model.model.customerportal;

import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "BILLING_ADDRESS")
public class BillingAddress extends YoungmanEntity<Long, BillingAddress> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name="GST_ID")
    private Gstn gst;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE")
    @Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$")
    private Integer pincode;

    @Column(name = "STATE")
    private String state;

    @Column(name = "STATUS")
    private String status;

    @Embedded
    private AuditSection auditSection = new AuditSection();

    private BillingAddress(BillingAddressBuilder builder) {
        this.id = builder.id;
        this.customer = builder.customer;
        this.gst = builder.gst;
        this.address = builder.address;
        this.city = builder.city;
        this.pincode = builder.pincode;
        this.state = builder.state;
        this.status = builder.status;
    }


    public static class BillingAddressBuilder {
        private Long id;
        private Customer customer;
        private Gstn gst;
        private String address;
        private String city;
        private Integer pincode;
        private String state;
        private String status;

        public BillingAddressBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public BillingAddressBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public BillingAddressBuilder setGst(Gstn gst) {
            this.gst = gst;
            return this;
        }

        public BillingAddressBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public BillingAddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public BillingAddressBuilder setPincode(Integer pincode) {
            this.pincode = pincode;
            return this;
        }

        public BillingAddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public BillingAddressBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public BillingAddress build() {
            return  new BillingAddress(this);
        }
    }
}
