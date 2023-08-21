package com.nyxei.pollingus.repositories;

import com.nyxei.pollingus.models.question.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
