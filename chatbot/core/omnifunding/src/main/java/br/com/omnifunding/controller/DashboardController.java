package br.com.omnifunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnifunding.model.DashboardByCount;
import br.com.omnifunding.model.DashboardByValue;
import br.com.omnifunding.model.Donate;
import br.com.omnifunding.model.Risk;
import br.com.omnifunding.repository.DashboardByCountRepository;
import br.com.omnifunding.repository.DashboardByValueRepository;
import br.com.omnifunding.repository.DonateRepository;
import br.com.omnifunding.repository.RiskRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	RiskRepository riskRepository;

	@Autowired
	DashboardByValueRepository dashboardByRepository;

	@Autowired
	DashboardByCountRepository dashboardByCountRepository;

	@Autowired
	private DonateRepository donateRepository;

	@GetMapping("risk")
	public List<Risk> search() {
		return riskRepository.findAll().subList(0, 200);
	}

	@GetMapping("donate")
	public List<Donate> donates() {
		return donateRepository.findAll();
	}

	@GetMapping("graph")
	public List<DashboardByValue> graph1() {
		return dashboardByRepository.findAll();
	}

	@GetMapping("graph2")
	public List<DashboardByCount> graph2() {
		return dashboardByCountRepository.findAll();
	}
}
