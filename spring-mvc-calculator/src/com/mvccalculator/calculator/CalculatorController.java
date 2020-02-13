package com.mvccalculator.calculator;

import java.util.List;
import java.util.Scanner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class CalculatorController {
	
	CalculatorService service;
	
//	@RequestMapping("/calculation")
//	public Calculator calculation(@RequestParam(value = "string") String str) {
//		ExpressionParser n = new ExpressionParser();
//		List<String> expression = n.parse(str);
//		calculator.setResult(service.calc(expression));
//			return calculator;
//	}	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("calculator", new Calculator());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("calculator")
	Calculator theCalculator, BindingResult theBindingResult) {
		
	ExpressionParser n = new ExpressionParser();
	List<String> expression = n.parse(theCalculator.getInput());
	theCalculator.setResult(service.calc(expression));
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
		
		return "customer-form";
		}
	}


}
