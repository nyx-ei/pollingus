package com.nyxei.pollingus.repositories;

import com.nyxei.pollingus.models.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}
