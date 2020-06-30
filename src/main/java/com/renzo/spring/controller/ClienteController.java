package com.renzo.spring.controller;

import com.renzo.spring.model.Cliente;
import com.renzo.spring.model.TipoCliente;
import com.renzo.spring.service.IClienteService;
import com.renzo.spring.service.IDistritoService;
import com.renzo.spring.service.ITipoClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IDistritoService distritoService;

    @Autowired
    private ITipoClienteService tipoClienteService;

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("list", clienteService.getAll());
        return "index";
    }

    @GetMapping("/save/{id}")
    public String getSave(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {


        model.addAttribute("listaDistrito", distritoService.getAll());
        model.addAttribute("listaTipo", tipoClienteService.getAll());

        if (id != null && id != 0) {
            model.addAttribute("h2Text","Editar Cliente");

            Cliente editCliente = clienteService.get(id);

            editCliente.setEdit(true);

            model.addAttribute("cliente", editCliente);
        } else {
            model.addAttribute("h2Text","Nuevo Cliente");
            model.addAttribute("cliente", new Cliente());
        }

        return "save";

    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable("id") Integer id, Model model, RedirectAttributes attributes) {
        attributes.addFlashAttribute("info", "Cliente borrado con éxito!");
        clienteService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String postSave(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes attributes) {

        if (result.hasErrors()) {

            model.addAttribute("listaDistrito", distritoService.getAll());
            model.addAttribute("listaTipo", tipoClienteService.getAll());
            return "save";
        }

        if(cliente.isEdit()){
            attributes.addFlashAttribute("info", "Cliente Editado con éxito!");
        }else{
            attributes.addFlashAttribute("success", "Cliente guardado con éxito!");
        }
        clienteService.save(cliente);
        return "redirect:/";
    }

}
