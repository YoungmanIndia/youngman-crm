package com.youngman.core.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.SalesManagerEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "USERS", uniqueConstraints=
@UniqueConstraint(columnNames = {"EMAIL"}))
public class User extends SalesManagerEntity<Long, User> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID", unique=true, nullable=false)
    @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "USER_SEQ_NEXT_VAL")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Column(name="NAME", nullable=false)
    private String name;

    @Column(name="EMAIL", nullable=false)
    private String email;

    @Column(name="PHONE", length = 10)
    @Size(min = 10, max = 10)
    private String phone;

    @JsonIgnore
    @Column(name="PASSWORD", length=60, nullable=false)
    private String password;

    @Column(name="ACTIVE")
    private boolean active = true;

    @Column(name="IS_VERIFIED")
    private boolean isVerified = true;

    @Embedded
    private AuditSection auditSection = new AuditSection();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_ACCESS")
    private Date lastAccess;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOGIN_ACCESS")
    private Date loginTime;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public AuditSection getAuditSection() {
        return auditSection;
    }

    @Override
    public void setAuditSection(AuditSection audit) {
        auditSection = audit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
