package com.example.bootcamp.domain.api.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.api.ICapacityServicePort;
import com.example.bootcamp.domain.model.Capacity;
import com.example.bootcamp.domain.spi.ICapacityPersistencePort;
import com.example.bootcamp.domain.util.DomainConstants;

public class CapacityUseCase implements ICapacityServicePort {

    private final ICapacityPersistencePort icapacityPersistencePort;

    

    public CapacityUseCase(ICapacityPersistencePort icapacityPersistencePort) {
        this.icapacityPersistencePort = icapacityPersistencePort;
    }

    @Override
    public Page<Capacity> getAllCapacity(Pageable pageable, Integer technologiesCount) {
       
        return icapacityPersistencePort.getAllCapacity(pageable , technologiesCount);
    }

    @Override
    public Long saveCapacity(Capacity capacity) {
        if (!capacity.isValid()) {
            throw new DomainConstants.TechnologyException(DomainConstants.MAX_MIN_TECHNOLOGY);
        }
        
        if (!capacity.areIdsUnique()) {
            throw new DomainConstants.TechnologyException(DomainConstants.REPETIED_ID_TECHNOLOGY);
            
        }

        return icapacityPersistencePort.saveCapacity(capacity);
    }

    

}
