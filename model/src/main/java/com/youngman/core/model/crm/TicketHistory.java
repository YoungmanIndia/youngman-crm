package com.youngman.core.model.crm;

import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
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
@Table(name = "TICKET_HISTORY")
public class TicketHistory extends YoungmanEntity<Long, TicketHistory> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "ASSIGN_TO")
    private User assignTo;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "DUEDATE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
