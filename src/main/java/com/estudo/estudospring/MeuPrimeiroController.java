package com.estudo.estudospring;

import com.estudo.estudospring.di.service.AtivacaoClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class MeuPrimeiroController {

    private AtivacaoClienteService ativacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService ativacaoClienteService) {
        System.out.println("MeuPrimeiroController");
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/clients")
    public List<Client> clients() {
        List<Client> clientes = new ArrayList<>();
        var client1 = new Client("Maria", "maria@gmail.com", "99999");
        var client2 = new Client("João", "joao@gmail.com", "77777");
        clientes.add(client1);
        clientes.add(client2);

        return clientes;
    }

    @GetMapping(value = "/clients2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> clients2() {
        List<Client> clientes = new ArrayList<>();
        var client1 = new Client("Maria", "maria@gmail.com", "99999");
        var client2 = new Client("João", "joao@gmail.com", "77777");
        clientes.add(client1);
        clientes.add(client2);
//        return ResponseEntity.status(HttpStatus.OK).body(clientes);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/clients2", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<List<Client>> clients3() {
        List<Client> clientes = new ArrayList<>();
        var client1 = new Client("Maria", "maria@gmail.com", "99999");
        var client2 = new Client("João", "joao@gmail.com", "77777");
        clientes.add(client1);
        clientes.add(client2);
//        return ResponseEntity.status(HttpStatus.OK).body(clientes);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/clients/{testId}")
    public ResponseEntity<Client> clientById(@PathVariable("testId") Long id) throws Exception {
        if(id == 1) {
            var client1 = new Client("Maria", "maria@gmail.com", "99999");
            return ResponseEntity.ok(client1);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/client")
    public ResponseEntity<Client> salvar(@RequestBody Client client) {
        var client1 = new Client(client.getNome(), client.getEmail(), client.getTelefone());
        return ResponseEntity.status(HttpStatus.CREATED).body(client1);
    }

    @GetMapping("/clients/ativar")
    @ResponseBody
    public String hello() {
        Client joao = new Client("João", "joao@xyz.com", "3499998888");

        ativacaoClienteService.ativar(joao);

        return "Cliente Ativado!";
    }
}
