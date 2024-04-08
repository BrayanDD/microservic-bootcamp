package com.example.bootcamp.adapters.driven.jpa.mysql.adapter;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildSave;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.VersionAlreadyExistException;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.VersionEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.example.bootcamp.domain.model.Version;
import com.example.bootcamp.domain.spi.IVersionPersistencePort;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VersionJpaApadter implements IVersionPersistencePort {
    
    private final VersionEntityMapper versionEntityMapper;
    private final IVersionRepository versionRepository;
    
    @Override
    public Page<Version> getAllVersions(Pageable pageable,Long maxCoup,LocalDate fechStar,Long idBootcamp) {
  
        Page<VersionEntity> versionEntityPage; 
        if (maxCoup != null && fechStar != null) {
           
            versionEntityPage = versionRepository.findAllByMaxCapacityAndStartDate(maxCoup, fechStar, pageable);
        } else if (maxCoup != null) {
          
            versionEntityPage =versionRepository.findAllByMaxCapacity(maxCoup, pageable);
        } else if (fechStar != null) {
            
            versionEntityPage =versionRepository.findAllByStartDate(fechStar, pageable);
        } else if (idBootcamp != null) {

            versionEntityPage = versionRepository.findByBootcampId(idBootcamp, pageable);
        } 
        else {
            
            versionEntityPage = versionRepository.findAll(pageable);
        }

        if (versionEntityPage.isEmpty()) {
            throw new NoDataFoundException();
        }
        
        return versionEntityMapper.toVersionList(versionEntityPage);
    }

    @Override
    public Long saveVersion(Version version) {
        Optional<VersionEntity> existingVersion = versionRepository.findByBootcampIdAndVersion(version.getIdBootcamp(), version.getVersion());

        if (existingVersion.isPresent()) {
        
            throw new VersionAlreadyExistException();
        }

        VersionEntity versionEntity = versionEntityMapper.toEntity(version);
        if (versionEntity.equals(null)) {
            throw new FaildSave();
            
        }
        VersionEntity versionSave = versionRepository.save(versionEntity);

        return versionSave.getId();
    }
    

}
