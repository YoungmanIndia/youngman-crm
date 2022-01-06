package com.youngman.core.model.crm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngman.core.enums.Status;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.common.Role;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "USERS", uniqueConstraints=
@UniqueConstraint(columnNames = {"EMAIL"}))
public class Users extends YoungmanEntity<Long, Users> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="EMAIL", nullable=false)
    private String email;

    @Column(name="PHONE", length = 10)
    @Size(min = 10, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @JsonIgnore
    @Column(name="PASSWORD", length=60, nullable=false)
    private String password;

    @Column(name="STATUS")
    private Status status = Status.ACTIVE;

    @Column(name="IS_VERIFIED")
    private boolean isVerified = true;

    @OneToMany
    private List<Role> roles;

    @Embedded
    private AuditSection auditSection = new AuditSection();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_ACCESS")
    private Date lastAccess;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOGIN_ACCESS")
    private Date loginTime;
}
