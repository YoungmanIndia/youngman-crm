package com.youngman.model.model.customerportal;

import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@EntityListeners(value = AuditListener.class)
@Table(name = "GSTN")
public class Gstn extends YoungmanEntity<Long, Gstn> implements Auditable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Column(name = "GSTN")
    private String gstn;

    @OneToMany
    private List<BillingAddress> billingAddresses = new ArrayList<>();

    @Embedded
    private AuditSection auditSection = new AuditSection();

    public Gstn() {
    }

    private Gstn(GstnBuilder builder) {
        this.id = builder.id;
        this.customer = builder.customer;
        this.gstn = gstn;
    }

    public static class GstnBuilder {
        private Long id;
        private Customer customer;
        private String gstn;
        List<BillingAddress> billingAddresses = new ArrayList<>();

        public GstnBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public GstnBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public GstnBuilder setGstn(String gstn) {
            this.gstn = gstn;
            return this;
        }

        public GstnBuilder setBillingAddresses(List<BillingAddress> billingAddresses) {
            this.billingAddresses = billingAddresses;
            return this;
        }

        public Gstn build() {
            return  new Gstn(this);
        }
    }
}
