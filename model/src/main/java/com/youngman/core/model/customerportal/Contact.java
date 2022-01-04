package com.youngman.core.model.customerportal;

import com.youngman.core.enums.Status;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.SalesManagerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "CONTACT", uniqueConstraints=
@UniqueConstraint(columnNames = {"EMAIL"}))
public class Contact extends SalesManagerEntity<Long, Contact> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    @Email
    private String email;

    @Column(name="PHONE", length = 10)
    @Size(min = 10, max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @Column(name = "STATUS")
    private Status status = Status.ACTIVE;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Embedded
    private AuditSection auditSection = new AuditSection();
}
