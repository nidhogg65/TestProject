package com.nidhogg.studyspringproject.domain.repository.account;

import com.nidhogg.studyspringproject.domain.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
