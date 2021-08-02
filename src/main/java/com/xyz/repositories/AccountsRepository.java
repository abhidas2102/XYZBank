package com.xyz.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xyz.beans.Account;

@Repository
public interface AccountsRepository extends CrudRepository<Account, String> {

}
