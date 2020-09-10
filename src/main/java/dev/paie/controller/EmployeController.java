package dev.paie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.dto.EmployeDto;
import dev.paie.entite.Employe;
import dev.paie.service.EmployeService;
import dev.paie.utils.logger.LoggerUtils;


@RestController
@RequestMapping("/paieapp")
public class EmployeController {
	@Autowired
	EmployeService employeService;
	
	@PostMapping("/insertemploye")
	public ResponseEntity<?> insert(@RequestBody @Valid EmployeDto employeDto, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			Employe employe = this.employeService.creerEmploye(employeDto.getMatricule(), 
															   employeDto.getIdProfil(), 
															   employeDto.getIdEntreprise(), 
															   employeDto.getIdGrade());
			System.out.println("EEEE " + employe);
			return ResponseEntity.ok(employe);
		} else {
			
			return ResponseEntity.badRequest().body("Tout les champs sont obligatoires");
		}
	}
}
