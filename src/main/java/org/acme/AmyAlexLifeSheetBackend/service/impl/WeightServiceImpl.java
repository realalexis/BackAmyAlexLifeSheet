package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.exception.ResourceNotFound;
import org.acme.AmyAlexLifeSheetBackend.mapper.WeightMapper;
import org.acme.AmyAlexLifeSheetBackend.entity.Weight;
import org.acme.AmyAlexLifeSheetBackend.repository.WeightRepository;
import org.acme.AmyAlexLifeSheetBackend.service.WeightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeightServiceImpl implements WeightService {
    private WeightRepository weightRepository;
    @Override
    public WeightDto createWeight(WeightDto weightDto) {
        Weight weight = WeightMapper.mapToWeight(weightDto);
        Weight savedWeight = weightRepository.save(weight);
        return WeightMapper.mapToWeightDto(savedWeight);
    }

    @Override
    public WeightDto getWeightById(Long weightId) {
        Weight weight = weightRepository.findById(weightId)
                .orElseThrow(() -> new ResourceNotFound("Weight does not exist with given id : " + weightId));
        return WeightMapper.mapToWeightDto(weight);

    }

    @Override
    public List<WeightDto> getWeightAll() {
        List<Weight> weight =  weightRepository.findAll();
        return weight.stream().map(WeightMapper::mapToWeightDto)
                .collect(Collectors.toList());
    }

    @Override
    public WeightDto updateWeight(long weightId, WeightDto updateWeight) {
        return null;
    }

//    @Override
//    public WeightDto updateWeight(long weightId, WeightDto updateWeight) {
//        Weight weight = weightRepository.findById(weightId).orElseThrow(
//                () -> new ResourceNotFound("Weight does not exists with given id: " + weightId)
//        );
//        weight.setDay(updateWeight.getDay());
//        weight.setMonth(updateWeight.getMonth());
//        weight.setYear(updateWeight.getYear());
//        weight.setWeight(updateWeight.getWeight());
//
//         Weight updateWeightObj = weightRepository.save(weight);
//
//
//        return WeightMapper.mapToWeightDto(updateWeightObj);
//    }

    @Override
    public void deleteWeight(Long weightId) {
            Weight weight = weightRepository.findById(weightId).orElseThrow(
                    () -> new ResourceNotFound("Weight does not exists with given id: " + weightId)
            );

            weightRepository.deleteById(weightId);
        }
    }
