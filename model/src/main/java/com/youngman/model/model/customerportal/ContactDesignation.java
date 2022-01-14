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

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "CONTACT_DESIGNATION", uniqueConstraints =
@UniqueConstraint(columnNames = {}))
public class ContactDesignation extends YoungmanEntity<Long, ContactDesignation> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "CONTACT_ID")
    @NotEmpty
    private Long contactId;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "GST")
    private String gst;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
