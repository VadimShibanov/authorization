package com.bank.authorization.service;

import com.bank.authorization.model.Role;
import com.bank.authorization.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

}
