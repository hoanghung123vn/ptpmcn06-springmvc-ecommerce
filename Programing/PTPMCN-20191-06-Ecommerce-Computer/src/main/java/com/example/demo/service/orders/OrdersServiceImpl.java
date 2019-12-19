package com.example.demo.service.orders;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.config.Const;
import com.example.demo.dao.OrdersRepository;
import com.example.demo.entity.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(int id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public List<Orders> findByStatus(int status) {
        return ordersRepository.findByStatus(status);

    }

    @Override
    public long countOrderInDay() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();      
        Date start = new Date(end.getTime() - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return ordersRepository.countByCreatingDateBetweenAndStatusNot(start, end, Const.DESTROYED);
    }

    @Override
    public long countOrderInWeek() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        Date start = new Date(end.getTime() - (calendar.get(Calendar.DAY_OF_WEEK) - 1) * 24 * 60 * 60 * 1000
                - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return ordersRepository.countByCreatingDateBetweenAndStatusNot(start, end, Const.DESTROYED);
    }

    @Override
    public long countOrderInMonth() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        Date start = new Date(end.getTime() - (calendar.get(Calendar.DAY_OF_MONTH) - 1) * 24 * 60 * 60 * 1000
                - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return ordersRepository.countByCreatingDateBetweenAndStatusNot(start, end, Const.DESTROYED);
    }

    @Override
    public long countOrderInYear() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date start = calendar.getTime();
        return ordersRepository.countByCreatingDateBetweenAndStatusNot(start, end, Const.DESTROYED);
    }

    @Override
    public long sumPriceOrdersInDay() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();      
        Date start = new Date(end.getTime() - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return sumPriceOrders(end, start);
    }

    @Override
    public long sumPriceOrdersInWeek() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        Date start = new Date(end.getTime() - (calendar.get(Calendar.DAY_OF_WEEK) - 1) * 24 * 60 * 60 * 1000
                - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return sumPriceOrders(end, start);
    }

    @Override
    public long sumPriceOrdersInMonth() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        Date start = new Date(end.getTime() - (calendar.get(Calendar.DAY_OF_MONTH) - 1) * 24 * 60 * 60 * 1000
                - calendar.get(Calendar.HOUR_OF_DAY) * 60 * 60 * 1000 - calendar.get(Calendar.MINUTE) * 60 * 1000);
        return sumPriceOrders(end, start);
    }

    @Override
    public long sumPriceOrdersInYear() {
        Calendar calendar = Calendar.getInstance();
        Date end = new Date();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date start = calendar.getTime();
        return sumPriceOrders(end, start);
    }

    private long sumPriceOrders(Date end, Date start) {
        List<Orders> orders = ordersRepository.findByCreatingDateBetweenAndStatusNot(start, end, Const.DESTROYED);
        long sum = 0;
        for (Orders order : orders) {
            sum += order.getTotal();
        }
        return sum;
    }

}
