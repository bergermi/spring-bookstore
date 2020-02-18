package com.wildcodeschool.spring.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wildcodeschool.spring.bookstore.entity.carpool.Car;
import com.wildcodeschool.spring.bookstore.repository.CarRepository;

@Controller
public class CarController {

	private final CarRepository carRepository;

	public CarController(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@GetMapping("/cars")
	public String getAll(Model model) {
		model.addAttribute("cars", carRepository.findAll());
		return "car/get_all";
	}

	@PostMapping("/car/upsert")
	public String upsert(Car car) {
		carRepository.save(car);
		return "redirect:car/get_all";
	}

	@GetMapping("/car/{id}/delete")
	public String delete(@PathVariable Long id) {
		carRepository.deleteById(id);
		return "redirect:car/get_all";
	}

}
