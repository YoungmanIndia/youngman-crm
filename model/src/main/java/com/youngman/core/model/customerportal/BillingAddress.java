package com.youngman.core.model.customerportal;

import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "BILLING_ADDRESS")
public class BillingAddress extends YoungmanEntity<Long, BillingAddress> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long customerId;

    @Column(name = "GST")
    @NotEmpty
    private String gst;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE")
    private Integer pincode;

    @Column(name = "STATE")
    private String state;

    @Column(name = "STATUS")
    private String status;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
