package com.youngman.model.model.crm;

import com.youngman.model.model.common.audit.AuditListener;
import com.youngman.model.model.common.audit.AuditSection;
import com.youngman.model.model.common.audit.Auditable;
import com.youngman.model.model.customerportal.Contact;
import com.youngman.model.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "TICKET_CONTACTS")
public class TicketContacts extends YoungmanEntity<Long, TicketContacts> implements Auditable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private Contact contact;

    @Embedded
    private AuditSection auditSection = new AuditSection();

}
