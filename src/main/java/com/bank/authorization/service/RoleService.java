package com.bank.authorization.service;

import com.bank.authorization.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> listRoles();

    Role saveRole(Role role);
}
