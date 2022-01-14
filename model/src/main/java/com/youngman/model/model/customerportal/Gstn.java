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

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "GSTN")
public class Gstn extends YoungmanEntity<Long, Gstn> implements Auditable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CUSTOMER_ID")
    @NotNull
    private Long customerId;

    @Column(name = "GSTN")
    private String gstn;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
