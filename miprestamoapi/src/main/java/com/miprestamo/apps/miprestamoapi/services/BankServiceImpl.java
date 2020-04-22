package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miprestamo.apps.miprestamoapi.dtos.BankDTO;
import com.miprestamo.apps.miprestamoapi.entities.Bank;
import com.miprestamo.apps.miprestamoapi.repositories.BankRepository;
import com.miprestamo.apps.miprestamoapi.services.converters.BankConverterService;

/**
 * Service implementation for handling all bank services
 * 
 * @author elkin.giraldo
 *
 */
@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private BankConverterService bankConverterService;

	@Override
	public List<BankDTO> retrieveAllBanks() {
		final List<Bank> allIDs = bankRepository.findAll();
		return bankConverterService.toDtos(allIDs);
	}

}
