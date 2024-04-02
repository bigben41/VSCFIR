package VSSB.BACKEND.repository;

import org.springframework.data.repository.CrudRepository;

import VSSB.BACKEND.data.transaction.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer>{
    
}
