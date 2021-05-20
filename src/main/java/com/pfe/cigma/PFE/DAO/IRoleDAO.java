package com.pfe.cigma.PFE.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;

@Repository
public interface IRoleDAO extends PagingAndSortingRepository<Role,Integer> {
 Page<Role> findAllByRoleNameContaining(String name,Pageable p);
 
 Role findByRoleName(String name);
}
