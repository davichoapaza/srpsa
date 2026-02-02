package bo.gob.dgac.rbs.organizacion.service;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.IndicadorDto;
import bo.gob.dgac.rbs.organizacion.dto.MetaDto;
import bo.gob.dgac.rbs.organizacion.dto.ObjetivosDto;
import bo.gob.dgac.rbs.organizacion.dto.ObjetivosRequestDto;
import bo.gob.dgac.rbs.organizacion.modelo.Indicador;
import bo.gob.dgac.rbs.organizacion.modelo.Metas;
import bo.gob.dgac.rbs.organizacion.modelo.Objetivos;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamPeriodicidad;
import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoIndicador;
import bo.gob.dgac.rbs.organizacion.repository.IndicadorRepository;
import bo.gob.dgac.rbs.organizacion.repository.MetasRepository;
import bo.gob.dgac.rbs.organizacion.repository.ObjetivosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ObjetivosService {

    
    private final ObjetivosRepository objetivosRepository;
    private final MetasRepository metasService;
    private final IndicadorRepository indicadorServide;
    public void guardar(ObjetivosRequestDto dto) {
    	
    	Organizacion org= new Organizacion();
    	org.setId(dto.organizacionId);
    	
    	for(ObjetivosDto oDto: dto.objetivos) {
    		Objetivos obj= new Objetivos();
    		
    		obj.setNombre(oDto.nombre);
    		obj.setDescripcion(oDto.descripcion);
    		obj.setOrganizacion(org);
    		objetivosRepository.save(obj);
    		
    		if(oDto.metas!=null) {
    		for(MetaDto mDto : oDto.metas) {
    			Metas meta = new Metas();
    			meta.setNombre(mDto.getNombre());
    			meta.setDescripcion(mDto.getDescripcion());
    			meta.setObjetivos(obj);
    			metasService.save(meta);
    			if(mDto.indicadores!=null) {
    				for(IndicadorDto iDto: mDto.indicadores) {
    				 Indicador ind= new Indicador();
    				 ind.setNombre(iDto.nombre);
    				 ParamTipoIndicador pti= new ParamTipoIndicador();
    				 pti.setId(iDto.TipoIndicadorId);
    				 ind.setTipoIndicador(pti);
    				 ParamPeriodicidad per= new ParamPeriodicidad();
    				 per.setId(iDto.periodicidadId);
    				 ind.setPeriodicidad(per); 
    				 ind.setMetas(meta);
    				 ind.setFormulaIndicador(iDto.formula);
    				 ind.setNivelAlertaUno(iDto.nivelAlerta1);
    				 ind.setNivelAlertaDos(iDto.nivelAlerta2);
    				 ind.setNivelAlertaTres(iDto.nivelAlerta3);
    				 indicadorServide.save(ind);
    				}
    			}
    		}	
   		}
    	}
    }	
}
