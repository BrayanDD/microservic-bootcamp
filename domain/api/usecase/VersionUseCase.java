package com.example.bootcamp.domain.api.usecase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.api.IVersionServicePort;
import com.example.bootcamp.domain.model.Version;
import com.example.bootcamp.domain.spi.IVersionPersistencePort;
import com.example.bootcamp.domain.util.DomainConstants;

import java.time.LocalDate;

public class VersionUseCase implements IVersionServicePort{

    private final IVersionPersistencePort versionPersistencePort;

    public VersionUseCase(IVersionPersistencePort versionPersistencePort) {
        this.versionPersistencePort = versionPersistencePort;
    }

    @Override
    public Page<Version> getAllVersions(Pageable pageable,Long maxCoup,LocalDate fechStar, Long idBootcamp) {
        
        return versionPersistencePort.getAllVersions(pageable,maxCoup,fechStar,idBootcamp);
    }

    @Override
    public Long saveVersion(Version version) {
       if (!version.isValid()) {
          throw new DomainConstants.VersionException(DomainConstants.END_DATE_BEFORE_START_DATE);
        
       }
        return versionPersistencePort.saveVersion(version);
    }
    

}
