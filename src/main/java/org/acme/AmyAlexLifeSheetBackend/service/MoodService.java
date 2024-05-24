package org.acme.AmyAlexLifeSheetBackend.service;

import org.acme.AmyAlexLifeSheetBackend.dto.MoodDto;

import java.util.List;

public interface MoodService  {
    List<MoodDto> getMoodsByParams(Integer year, Integer month, Integer week, Integer day);
}
