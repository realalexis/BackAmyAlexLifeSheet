package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.SportDto;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.SportMapper;
import org.acme.AmyAlexLifeSheetBackend.entity.Sport;
import org.acme.AmyAlexLifeSheetBackend.repository.SportRepository;
import org.acme.AmyAlexLifeSheetBackend.service.SportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SportServiceImpl implements SportService {
    private SportRepository SportRepository;
    @Override
    public SportDto createSport(SportDto sportDto) {
        Sport sport = SportMapper.mapToSport(sportDto);
        Sport savedSport = SportRepository.save(sport);
        return SportMapper.mapToSportDto(savedSport);
    }

    @Override
    public SportDto getSportById(Long sportId) {
        Sport sport = SportRepository.findById(sportId)
                .orElseThrow(() -> new ResourceNotFound("Sport does not exist with given id : " + sportId));
        return SportMapper.mapToSportDto(sport);

    }

    @Override
    public List<SportDto> getSportAll() {
        List<Sport> sport =  SportRepository.findAll();
        return sport.stream().map(SportMapper::mapToSportDto)
                .collect(Collectors.toList());
    }

    @Override
    public SportDto updateSport(long sportId, SportDto updateSport) {
        return null;
    }

    @Override
    public List<SportDto> getSportByYear(int sportYear) {
        List<Sport> year = SportRepository.findByYear(sportYear);
        return year.stream().map(SportMapper::mapToSportDto)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteSport(Long sportId) {
        Sport sport = SportRepository.findById(sportId).orElseThrow(
                () -> new ResourceNotFound("Sport does not exists with given id: " + sportId)
        );

        SportRepository.deleteById(sportId);
    }
}
