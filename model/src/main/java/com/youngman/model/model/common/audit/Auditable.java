package com.youngman.model.model.common.audit;

public interface Auditable {
	
	AuditSection getAuditSection();
	
	void setAuditSection(AuditSection audit);
}
