package hello.controller;

import hello.model.Clientes;
import hello.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by rebeca on 08/02/2019.
 */

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;
    private String title="Cadastro de clientes";

    @GetMapping
    public ModelAndView listar(){
        ModelAndView modelAndView=new ModelAndView("clientes");
        modelAndView.addObject("title", title);
        modelAndView.addObject("lista_clientes", clientesRepository.findAll());
        return modelAndView;
    }


    @GetMapping("/novo")
    public ModelAndView novo(Clientes cliente){
        ModelAndView modelAndView=new ModelAndView("dados_cliente");
        cliente.setDatacadastro(new Date());
        modelAndView.addObject("title", title);
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView salvar(@Valid Clientes cliente, BindingResult bindingResult){
        ModelAndView modelAndView=new ModelAndView("dados_cliente");
        cliente.setDatacadastro(new Date());

        if(bindingResult.hasErrors()){
            modelAndView.addObject("erros", bindingResult.getAllErrors());
            modelAndView.addObject("cliente", cliente);
        }
        else{
            modelAndView.addObject("cliente", clientesRepository.save(cliente));
            modelAndView.addObject("mensagem","Cadastro salvo com sucesso");
        }

        modelAndView.addObject("title", title);

        return modelAndView;
    }

    @GetMapping("/{codigo}")
    public ModelAndView selecionar(@PathVariable Integer codigo){
        ModelAndView modelAndView=new ModelAndView("dados_cliente");
        modelAndView.addObject("title", title);
        modelAndView.addObject("cliente", clientesRepository.findById(codigo));
        return modelAndView;
    }



}
