package com.ejercicio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ejercicio.model.Automovil;

@Mapper()
public interface AutomovilMapper {
    @Insert("INSERT INTO AUTOMOVIL (MARCA, MODELO, ANIOFABRICACION) VALUES (#{marca}, #{modelo}, #{anioFabricacion})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void ingresaAutomovil(Automovil Automovil);

    @Select("SELECT * FROM AUTOMOVIL")
    public List<Automovil> consultaAutomoviles();

    @Update("UPDATE AUTOMOVIL set MARCA=#{marca}, MODELO=#{modelo}, ANIOFABRICACION=#{anioFabricacion} where id=#{id}")
    public void actualizaAutomovil(Automovil Automovil);

    @Delete("delete from AUTOMOVIL where id=#{id}")
    public void eliminaAutomovil(Integer id);

    @Select("SELECT * FROM AUTOMOVIL WHERE id = #{id}")
    public Automovil consultaAutomovil(int id);
}




