package mdx.gsd.data.service.impl;

import mdx.gsd.dao.RoleDAO;
import mdx.gsd.data.model.Role;
import mdx.gsd.data.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        this.roleDAO.addRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        this.roleDAO.updateRole(role);
    }

    @Override
    @Transactional
    public Role getRoleByID(Integer id) {
        return this.roleDAO.getRoleByID(id);
    }

    @Override
    @Transactional
    public List<Role> listAllRole() {
        return this.roleDAO.listAllRole();
    }

    @Override
    @Transactional
    public void removeRole(Integer id) {
        this.roleDAO.removeRole(id);
    }
}
