package com.youngman.core.model.common;

import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "ROLE")
public class Role extends YoungmanEntity<Long, Role> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    private List<Permission> permissions;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
