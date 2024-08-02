package com.bank.authorization.service;

import com.bank.authorization.model.Audit;
import com.bank.authorization.model.User;

public interface AuditService {

    Audit auditDelete(User user);

    Audit auditGetAll(User user);

    Audit auditGet(User user);
}
