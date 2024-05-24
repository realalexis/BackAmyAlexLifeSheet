package org.acme.AmyAlexLifeSheetBackend.service.impl;

import lombok.AllArgsConstructor;
import org.acme.AmyAlexLifeSheetBackend.dto.WeightDto;
import org.acme.AmyAlexLifeSheetBackend.entity.Weight;
import org.acme.AmyAlexLifeSheetBackend.mapper.WeightMapper;
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
    public List<WeightDto> getWeightByParams(Integer year, Integer month, Integer week, Integer day) {
        List<Weight> weight;
        //Construire la requête en fonction des paramètres fournis
        if (year != null && month != null && week != null && day != null) {
            // Si toutes les valeurs sont fournies, recherche par jour
            weight = weightRepository.findByYearAndMonthAndWeekAndDay(year, month, week, day);
        } else if (year != null && month != null && week != null) {
            // Si year, month et week sont fournis, recherche par semaine
            weight = weightRepository.findByYearAndMonthAndWeek(year, month, week);
        } else if (year != null && month != null) {
            // Si year et month sont fournis, recherche par mois
            weight = weightRepository.findByYearAndMonth(year, month);
        } else if (year != null) {
            // Si year est fourni, recherche par année
            weight = weightRepository.findByYear(year);
        } else {
            // Si aucun paramètre n'est fourni, retourner toutes les données (non filtrées)
            weight = weightRepository.findAll();
        }
        return weight.stream()
                .map(WeightMapper::mapToWeightDto)
                .collect(Collectors.toList());
    }
}
