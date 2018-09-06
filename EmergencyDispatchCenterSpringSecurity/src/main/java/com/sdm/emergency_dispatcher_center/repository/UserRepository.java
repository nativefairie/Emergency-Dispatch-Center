package com.sdm.emergency_dispatcher_center.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sdm.emergency_dispatcher_center.domain.Dispatcher;
import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    public void deleteAllByUserName(User user);

    public void deleteUserById(long id);

    public EmergencyUnit findEmergencyUnitById(long emergencyUnitId);

    public Dispatcher findDispatcherById(long id);

    public User findUserByEmail(String email);

    public User findUserById(long id);

    public List<User> findAll();

    Optional<User> findUserByUserName(String username);
}
