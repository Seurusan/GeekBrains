package ru.spring.hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.spring.prev.Order;
import ru.spring.prev.OrderRepository;

@Controller
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("order", new Order());
        return "orders-add";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String add(Order order) {
        repository.add(order);
        return "orders";
    }
}
