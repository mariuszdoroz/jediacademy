package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.repository.StatisticRepository;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }
}
