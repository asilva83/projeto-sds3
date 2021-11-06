package com.devsuperior.dsvendas.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
    
	@Autowired
	private SaleRepository repository;

    public Page<SaleDTO> FindAll(Pageable pageable) {
		Page<Sale> result =repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
    
    @Transactional
    public List<SaleSumDTO> amountGroupedBySeller(){
        return	repository.amountGroupedBySeller();
    }
    
    @Transactional
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return	repository.successGroupedBySeller();
    }
}