package com.example.manytomany;

import org.springframework.data.repository.CrudRepository;

interface ClientOrderRepository extends CrudRepository<ClientOrder, Long> {
}
