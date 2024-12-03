package com.parking.parkinglot1.ejb;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.entities.Car;
import com.parking.parkinglot1.entities.User;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
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

    public void createCar(String licensePlate, String parkingSpot, Long userId){
        LOG.info("createCar");

        Car car = new Car();
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setUser(user);

        entityManager.persist(car);
    }

    public void deleteCarsByIds(Collection<Long> carIds){
        LOG.info("deleteCarsByIds");

        for(Long carId : carIds){
            Car car = entityManager.find(Car.class, carId);
            entityManager.remove(car);
        }
    }

    public void updateCar(Long carId, String licensePlate, String parkingSpot, Long userId){
        LOG.info("Update car");
        Car car = entityManager.find(Car.class, carId);
        car.setLicensePlate(licensePlate);
        car.setParkingSpot(parkingSpot);

        User oldUser = car.getUser();
        oldUser.getCars().remove(car);

        User user = entityManager.find(User.class, userId);
        user.getCars().add(car);
        car.setUser(user);
    }

    private List<CarDto> copyCarsToDto(List<Car> cars){
        List<CarDto> carDtoList = new ArrayList<>();
        for(Car car : cars){
            CarDto carDtoEntry = new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUser().getName());
            carDtoList.add(carDtoEntry);
        }
        return carDtoList;
    }

    public CarDto findCarById(Long carId) {
        Car car = entityManager.find(Car.class, carId);
        return new CarDto(car.getId(), car.getLicensePlate(), car.getParkingSpot(), car.getUser().getName());
    }
}
