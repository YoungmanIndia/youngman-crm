package com.youngman.core.model.crm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngman.core.enums.Status;
import com.youngman.core.model.common.CredentialsReset;
import com.youngman.core.model.common.Group;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.common.Role;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "USERS", uniqueConstraints=
@UniqueConstraint(columnNames = {"EMAIL"}))
public class User extends YoungmanEntity<Long, User> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="USER_NAME", nullable=false)
    private String username;

    @Column(name="EMAIL", nullable=false)
    private String email;

    @Column(name="PHONE", length = 10)
    @Size(min = 10, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinTable(name = "USER_GROUP", joinColumns = {
            @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }
            ,
            inverseJoinColumns = { @JoinColumn(name = "GROUP_ID",
                    nullable = false, updatable = false) }
    )
    @Cascade({
            org.hibernate.annotations.CascadeType.DETACH,
            org.hibernate.annotations.CascadeType.LOCK,
            org.hibernate.annotations.CascadeType.REFRESH,
            org.hibernate.annotations.CascadeType.REPLICATE

    })
    private List<Group> groups = new ArrayList<>();

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

    @Embedded
    private CredentialsReset credentialsResetRequest = null;

    public User(String userName,String password, String email) {
        this.username = userName;
        this.password = password;
        this.email = email;
    }

    public Boolean isActive() {
        return Status.ACTIVE.getStatus().equals(this.status.getStatus());
    }
}
