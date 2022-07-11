package com.example.onetomany;

import org.springframework.data.repository.CrudRepository;

public interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
}
