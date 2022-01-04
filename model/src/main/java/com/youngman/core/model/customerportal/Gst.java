package com.youngman.core.model.customerportal;

import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.SalesManagerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "GST")
public class Gst extends SalesManagerEntity<Long, Gst> implements Auditable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    @NotNull
    private Long customerId;

    @Column(name = "GSTN")
    private String gstn;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
