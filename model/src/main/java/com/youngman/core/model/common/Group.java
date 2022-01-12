package com.youngman.core.model.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngman.core.enums.GroupType;
import com.youngman.core.model.common.audit.AuditListener;
import com.youngman.core.model.common.audit.AuditSection;
import com.youngman.core.model.common.audit.Auditable;
import com.youngman.core.model.generic.YoungmanEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(value = AuditListener.class)
@Table(name = "GROUPS", indexes = {
		@Index(name = "SM_GROUP_GROUP_TYPE", columnList = "GROUP_TYPE") })
public class Group extends YoungmanEntity<Integer, Group> implements Auditable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "GROUP_TYPE")
	@Enumerated(value = EnumType.STRING)
	private GroupType groupType;

	@NotEmpty
	@Column(name = "GROUP_NAME", unique = true)
	private String groupName;


	@JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
        @JoinTable(name = "PERMISSION_GROUP",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID")
        )
	private Set<Permission> permissions = new HashSet<>();

	@Embedded
	private AuditSection auditSection = new AuditSection();



}
