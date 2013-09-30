package edu.masterjava.spring.tarea03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.masterjava.spring.tarea03.dao.UsuarioDao;
import edu.masterjava.spring.tarea03.entity.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("usuario", "command", new Usuario());
	}

	@RequestMapping(value = "/addUsuario", method = RequestMethod.POST)
	public String addUsuario(
			@ModelAttribute("CU053_Spring_03_01") Usuario usuario,
			ModelMap model) {
		
		
		usuarioDao.saveUsuario(usuario);
		
		List<Usuario> usuarios = usuarioDao.getUsuarios();
		
		model.addAttribute("usuarios", usuarios);
		
		model.addAttribute("nombre", usuario.getNombre());
		model.addAttribute("password", usuario.getPassword());
		model.addAttribute("id", usuario.getId());

		return "result";
	}
}