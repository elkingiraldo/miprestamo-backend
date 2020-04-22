package com.miprestamo.apps.miprestamoapi.services;

import java.util.List;

import com.miprestamo.apps.miprestamoapi.dtos.BankDTO;

/**
 * Interface for handling services related to banks
 * 
 * @author elkin.giraldo
 *
 */
public interface IBankService {

	/**
	 * This method will call all classes and methods required to build the correct
	 * answer with the list of banks DTO.
	 * 
	 * @return {@link List<BankDTO>} a list with the banks found in DB
	 */
	public List<BankDTO> retrieveAllBanks();

}
