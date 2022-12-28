package com.mjubilee.communitiessapims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mjubilee.communitiessapims.model.CommunityGroup;

public interface GroupRepository extends JpaRepository<CommunityGroup, Long> {

}
