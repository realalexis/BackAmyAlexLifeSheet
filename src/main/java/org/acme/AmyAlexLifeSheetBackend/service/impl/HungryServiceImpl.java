package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.HungryDto;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.HungryMapper;
import org.acme.AmyAlexLifeSheetBackend.entity.Hungry;
import org.acme.AmyAlexLifeSheetBackend.repository.HungryRepository;
import org.acme.AmyAlexLifeSheetBackend.service.HungryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HungryServiceImpl implements HungryService {
    private HungryRepository hungryRepository;
    @Override
    public HungryDto createHungry(HungryDto hungryDto) {
        Hungry hungry = HungryMapper.mapToHungry(hungryDto);
        Hungry savedHungry = hungryRepository.save(hungry);
        return HungryMapper.mapToHungryDto(savedHungry);
    }

    @Override
    public HungryDto getHungryById(Long hungryId) {
        Hungry hungry = hungryRepository.findById(hungryId)
                .orElseThrow(() -> new ResourceNotFound("Hungry does not exist with given id : " + hungryId));
        return HungryMapper.mapToHungryDto(hungry);

    }

    @Override
    public List<HungryDto> getHungryAll() {
        List<Hungry> hungry =  hungryRepository.findAll();
        return hungry.stream().map(HungryMapper::mapToHungryDto)
                .collect(Collectors.toList());
    }

    @Override
    public HungryDto updateHungry(long hungryId, HungryDto updateHungry) {
        Hungry hungry = hungryRepository.findById(hungryId).orElseThrow(
                () -> new ResourceNotFound("Hungry does not exists with given id: " + hungryId)
        );
        hungry.setDay(updateHungry.getDay());
        hungry.setMonth(updateHungry.getMonth());
        hungry.setKey(updateHungry.getKey());

         Hungry  updateHungryObj = hungryRepository.save(hungry);


        return HungryMapper.mapToHungryDto(updateHungryObj);
    }

    @Override
    public void deleteHungry(Long hungryId) {
            Hungry hungry = hungryRepository.findById(hungryId).orElseThrow(
                    () -> new ResourceNotFound("Hungry does not exists with given id: " + hungryId)
            );

            hungryRepository.deleteById(hungryId);
        }
    }
