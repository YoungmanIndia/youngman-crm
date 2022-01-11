package com.youngman.core.model.customerportal;

import com.youngman.core.enums.CreditRating;
import com.youngman.core.enums.Status;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.crm.User;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "CUSTOMER")
public class Customer extends YoungmanEntity<Long, Customer> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "COMPANY_NAME",length = 100, nullable = false)
    @NotEmpty
    private String companyName;

    @Column(name = "PAN_NO", length = 10)
    @NotEmpty
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
    private String panNo;

    @Column(name = "SAP_REF_NO")
    @NotEmpty
    private String sapRefNo;

    @OneToOne
    @JoinColumn(name = "PAM")
    private User pam;

    @OneToOne
    @JoinColumn(name = "AR")
    private User ar;

    @Embedded
    private AuditSection auditSection = new AuditSection();

    @Column(name = "CREDIT_RATING")
    private CreditRating creditRating = CreditRating.C_RATING;

    @OneToMany
    private List<BusinessType> businessTypes;

    @Column(name = "CREDIT_LIMIT")
    @NotNull
    private BigDecimal creditLimit = BigDecimal.ZERO;

    @Column(name = "CREDIT_DAYS")
    private Integer creditDays = 0;

    @Column(name = "STATUS")
    private Status status = Status.ACTIVE;

    @Column(name = "OUTSTANDING")
    private BigDecimal outstanding = BigDecimal.ZERO;

}
