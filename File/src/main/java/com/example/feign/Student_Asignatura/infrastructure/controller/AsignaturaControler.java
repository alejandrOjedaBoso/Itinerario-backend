package com.example.feign.Student_Asignatura.infrastructure.controller;

import com.example.feign.Student_Asignatura.aplication.port.AddAsignaturaPort;
import com.example.feign.Student_Asignatura.aplication.port.DeleteAsignaturaPort;
import com.example.feign.Student_Asignatura.aplication.port.GetAsignaturaPort;
import com.example.feign.Student_Asignatura.aplication.port.UpdateAsignaturaPort;
import com.example.feign.Student_Asignatura.infrastructure.controller.dto.input.AsignaturaInputDTO;
import com.example.feign.Student_Asignatura.infrastructure.controller.dto.output.AsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaControler {
    @Autowired
    AddAsignaturaPort addAsignaturaPort;
    @Autowired
    DeleteAsignaturaPort deleteAsignaturaPort;
    @Autowired
    UpdateAsignaturaPort updateAsignaturaPort;
    @Autowired
    GetAsignaturaPort getAsignaturaPort;

    @PostMapping("/add")
    public AsignaturaOutputDTO addAsignatura(@RequestBody AsignaturaInputDTO asignaturaInputDTO){
        return addAsignaturaPort.addAsignatura(asignaturaInputDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteAsginatura(@PathVariable int id) throws Exception {
        deleteAsignaturaPort.deleteAsignatura(id);
    }
    @PutMapping("/update/{id}")
    public AsignaturaOutputDTO asignarturaOutputDTO(@PathVariable int id, @RequestBody AsignaturaInputDTO asignaturaInputDTO) throws Exception {
        return updateAsignaturaPort.updateAsignatura(id,asignaturaInputDTO);
    }

    @GetMapping("/get/{id}")
    public AsignaturaOutputDTO getAsignatura(@PathVariable int id) throws Exception {
        return getAsignaturaPort.getAsignatura(id);
    }
    @GetMapping("/get/student/{id}")
    public List<AsignaturaOutputDTO> getAsignaturaStudent(@PathVariable int id) throws Exception {
        return getAsignaturaPort.getAsignaturaStudent(id);
    }
}
