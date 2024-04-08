package com.example.bootcamp.domain.api.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.api.IBootcampServicePort;
import com.example.bootcamp.domain.model.Bootcamp;
import com.example.bootcamp.domain.spi.IBootcampPersistencePort;
import com.example.bootcamp.domain.util.DomainConstants;

public class BootcampUseCase implements IBootcampServicePort {

    private final IBootcampPersistencePort bootcampPersistencePort;

    

    public BootcampUseCase(IBootcampPersistencePort bootcampPersistencePort) {
        this.bootcampPersistencePort = bootcampPersistencePort;
    }

    @Override
    public Page<Bootcamp> getAllBootcamp(Pageable pageable, Integer capacitiesCount) {
        
        return bootcampPersistencePort.getAllBootcamp(pageable,capacitiesCount);
    }

    @Override
    public Long saveBootcamp(Bootcamp bootcamp) {
        if (!bootcamp.isValid()) {
            throw new DomainConstants.CapacityException(DomainConstants.MAX_MIN_CAPACITY);
            
        }
        if (!bootcamp.areIdsUnique()) {
            
            throw new DomainConstants.CapacityException(DomainConstants.REPETIED_ID_CAPACITY);
        }
        return bootcampPersistencePort.saveBootcamp(bootcamp);
    }

    

}
