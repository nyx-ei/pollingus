package com.nyxei.pollingus.repositories;

import com.nyxei.pollingus.models.question.Proposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropositionRepository extends CrudRepository<Proposition, Long> {
}
