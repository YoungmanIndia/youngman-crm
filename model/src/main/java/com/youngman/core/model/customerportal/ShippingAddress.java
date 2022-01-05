package com.youngman.core.model.customerportal;

import com.youngman.core.enums.Status;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "SHIPPING_ADDRESS")
public class ShippingAddress extends YoungmanEntity<Long, ShippingAddress> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    @NotNull
    private Long customerId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE")
    private Integer pincode;

    @Column(name = "STATE")
    private String state;

    @Column(name = "STATUS")
    private Status status = Status.ACTIVE;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
