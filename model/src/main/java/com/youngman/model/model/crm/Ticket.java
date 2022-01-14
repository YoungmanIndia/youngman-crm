package com.youngman.model.model.crm;

import com.youngman.model.enums.*;
import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "TICKET")
public class Ticket extends YoungmanEntity<Long, Ticket> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ASSIGN_TO")
    private User assignTo;

    @OneToOne
    @JoinColumn(name = "CREATED_BY")
    private User createdBy;

    @Column(name = "CASE_TYPE")
    private CaseType caseType;

    @Column(name = "CASE_REMARKS")
    private String caseRemarks;

    @Column(name = "CASE_DUEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date caseDueDate;

    @Column(name = "RESOLVED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedOn;

    @Column(name = "STATUS")
    private Status status = Status.ACTIVE;

    @Column(name = "PRIORITY")
    private Priority priority;

    @Column(name = "TYPE")
    private Type type;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
