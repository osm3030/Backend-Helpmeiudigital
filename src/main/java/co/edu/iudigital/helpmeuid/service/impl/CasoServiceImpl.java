package co.edu.iudigital.helpmeuid.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import co.edu.iudigital.helpmeuid.dto.CasoDto;
import co.edu.iudigital.helpmeuid.exception.ErrorDto;
import co.edu.iudigital.helpmeuid.exception.NotFoundException;
import co.edu.iudigital.helpmeuid.exception.RestException;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.repository.ICasoRepository;
import co.edu.iudigital.helpmeuid.service.iface.ICasoService;
import co.edu.iudigital.helpmeuid.util.ConstUtil;

@Service
public class CasoServiceImpl implements ICasoService{

    @Autowired
    private ICasoRepository casoRepository;

    @Override
    public List<CasoDto> findAll() throws RestException {
        List<Caso> casos =  casoRepository.findAll();
        if(casos.isEmpty() || casos.size() <= 0) {
            throw new NotFoundException(ErrorDto.getErrorDto(HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ConstUtil.MESSAGE_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
        }

        List<CasoDto> casosDto = new ArrayList<>();
        for(Caso caso: casos) {
            CasoDto casoDto = new CasoDto();
            casoDto.setId(caso.getId());
            casoDto.setFechaHora(caso.getFechaHora());
            casoDto.setLatitud(caso.getLatitud());
            casoDto.setLongitud(caso.getLongitud());
            casoDto.setAltitud(caso.getAltitud());
            casoDto.setVisible(caso.getVisible());
            casoDto.setDescripcion(caso.getDescripcion());
            casoDto.setUrlMap(caso.getUrlMap());
            casoDto.setRmiUrl(caso.getRmiUrl());
            casoDto.setUsuarioId(caso.getUsuario().getId());
            casoDto.setNombre(caso.getUsuario().getNombre());
            casoDto.setImage(caso.getUsuario().getImage());
            casosDto.add(casoDto);
        }
        return casosDto;
    }}
