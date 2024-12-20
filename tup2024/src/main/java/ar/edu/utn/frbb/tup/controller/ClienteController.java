package ar.edu.utn.frbb.tup.controller;

import ar.edu.utn.frbb.tup.controller.dto.ClienteDto;
import ar.edu.utn.frbb.tup.controller.validator.ClienteValidator;
import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.exception.CampoVacioException;
import ar.edu.utn.frbb.tup.model.exception.TipoPersonaErroneoException;
import ar.edu.utn.frbb.tup.model.exception.clientesException.ClienteAlreadyExistsException;
import ar.edu.utn.frbb.tup.model.exception.clientesException.ClienteMenorDeEdadException;
import ar.edu.utn.frbb.tup.model.exception.clientesException.ClienteNotFoundException;
import ar.edu.utn.frbb.tup.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteValidator clienteValidator;

    @PostMapping
    public Cliente crearCliente(@RequestBody ClienteDto clienteDto) 
            throws TipoPersonaErroneoException, ClienteMenorDeEdadException, ClienteAlreadyExistsException, CampoVacioException {
        clienteValidator.validate(clienteDto);
        return clienteService.darDeAltaCliente(clienteDto);
    }

    @GetMapping("/all")
    public List<Cliente> buscarTodosLosClientes() {
        return clienteService.buscarTodosLosClientes();
    }

    @GetMapping("/{dni}")
    public Cliente buscarClientePorDni(@PathVariable long dni) 
            throws ClienteNotFoundException {
        return clienteService.buscarClientePorDni(dni);
    }
}