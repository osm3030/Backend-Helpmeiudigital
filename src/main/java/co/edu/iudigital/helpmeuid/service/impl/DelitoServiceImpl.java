package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.DelitoDto;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.exception.ErrorDto;
import co.edu.iudigital.helpmeuid.exception.NotFoundException;
import co.edu.iudigital.helpmeuid.exception.RestException;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.service.iface.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.iudigital.helpmeuid.util.ConstUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class DelitoServiceImpl implements IDelitoService {
    @Autowired
    private IDelitoRepository delitoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DelitoDto> findAll() throws RestException{
        List<Delito> delitos = delitoRepository.findAll();
        if(delitos == null) {
            throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        }
        List<DelitoDto> delitosDto = new ArrayList<>();
        for(Delito delito: delitos) {
            DelitoDto delitoDto = new DelitoDto();
            delitoDto.setId(delito.getId());
            delitoDto.setNombre(delito.getNombre());
            delitosDto.add(delitoDto);
        }
        //TODO: usuariosDto
        return delitosDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Delito findById(Long id) throws RestException{
        return delitoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Delito save(Delito delito) throws RestException{
        return delitoRepository.save(delito);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        delitoRepository.deleteById(id);
    }

}
