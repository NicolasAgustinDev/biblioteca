package com.example.library.mapper;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.Loan;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-30T19:50:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanResponseDTO toDto(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponseDTO loanResponseDTO = new LoanResponseDTO();

        return loanResponseDTO;
    }

    @Override
    public Loan toEntity(LoanRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Loan loan = new Loan();

        return loan;
    }
}
