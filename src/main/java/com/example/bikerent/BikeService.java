package com.example.bikerent;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {
    final private BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }
    @Transactional
    public void add(BikeDto newBike) {
        Bike bike = new Bike(newBike.getId(), newBike.getModel(), newBike.getSerialNo(), newBike.getHourPrice(), newBike.getDayPrice());
        bikeRepository.save(bike);
    }
    @Transactional
    public void deleteById (Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }
    @Transactional
    public double rentForHours(String serialNo, int hours, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().plusHours(hours);
        double hourPrice = updateBike(serialNo, borrowerId, dateOfReturn).getHourPrice();
        return hourPrice*hours;
    }
    @Transactional
    public double rentForDay(String serialNo, String borrowerId) {
        LocalDateTime dateOfReturn = LocalDateTime.now().withHour(23).withMinute(59);
        return updateBike(serialNo, borrowerId, dateOfReturn).getDayPrice();
    }
    @Transactional
    public void returnBike(String serialNo) {
        updateBike(serialNo, null, null);
    }
    private Bike updateBike(String serialNo, String borrowerId, LocalDateTime dateOfReturn) {
        Bike bike = bikeRepository.findBySerialNoIgnoreCase(serialNo).orElseThrow(BikeNotFoundException::new);
        bike.setDateOfReturn(dateOfReturn);
        bike.setBorrowerId(borrowerId);
        return bike;
    }

    public int countBorrowedBikes() {
        return bikeRepository.countAllByBorrowerIdIsNotNull();
    }

    public List<BikeDto> findAllAvailableBikes () {
        return bikeRepository.findAllByBorrowerIdIsNullOrderByDayPriceAsc()
                .stream().map(bike -> new BikeDto(
                        bike.getId(),
                        bike.getModel(),
                        bike.getSerialNo(),
                        bike.getHourPrice(),
                        bike.getDayPrice()
                )).collect(Collectors.toList());
    }
}
