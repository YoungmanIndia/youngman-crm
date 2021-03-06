package com.youngman.model.model.customerportal;

import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "BUSINESS_TYPE")
public class BusinessType extends YoungmanEntity<Long, BusinessType> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "TYPE", nullable = false)
    private com.youngman.model.enums.BusinessType type;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
