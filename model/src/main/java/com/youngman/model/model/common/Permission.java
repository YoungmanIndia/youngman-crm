package com.youngman.model.model.common;

import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "permissions")
    private List<Group> groups = new ArrayList<>();

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
