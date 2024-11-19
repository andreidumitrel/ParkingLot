package com.parking.parkinglot1.ejb;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.entities.Car;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<CarDto> findAllCars(){
        LOG.info("findAllCars");
        try{
            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto(cars);
        }catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars){
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car car : cars){
            CarDto carDtoEntry = new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUser().getName());
            carDtoList.add(carDtoEntry);
        }
        return carDtoList;
    }
}
