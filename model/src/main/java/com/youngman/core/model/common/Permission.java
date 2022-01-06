package com.youngman.core.model.common;

import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "PERMISSION")
public class Permission extends YoungmanEntity<Long, Permission> implements Auditable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "PERMISSION_NAME", nullable = false)
    private String permissionName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}