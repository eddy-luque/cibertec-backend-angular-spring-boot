package com.prestamos.pe.controller;

import com.prestamos.pe.enums.EstadoPrestamo;
import com.prestamos.pe.helper.Helper;
import com.prestamos.pe.model.dto.PrestamoDto;
import com.prestamos.pe.model.entity.PrestamoComentarioEntity;
import com.prestamos.pe.model.entity.PrestamoEntity;
import com.prestamos.pe.security.user.User;
import com.prestamos.pe.service.PrestamoObservacionService;
import com.prestamos.pe.service.PrestamoService;
import com.prestamos.pe.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.constraints.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/prestamo")
public class PrestamoController {
    private final Logger LOG = LoggerFactory.getLogger(PrestamoController.class);

    @Autowired
    private UserDetailsService userDetailsService;
    private final PrestamoService prestamoService;
    private final PrestamoObservacionService prestamoObservacionService;
    private final UsuarioService usuarioService;


    public PrestamoController(PrestamoService prestamoService, PrestamoObservacionService prestamoObservacionService, UsuarioService usuarioService) {
        this.prestamoService = prestamoService;
        this.prestamoObservacionService = prestamoObservacionService;
        this.usuarioService = usuarioService;
    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrestamoDto>> listarTodos(Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());
        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")))) {

            Integer idUsuario = usuarioService.obtenerUsuarioPorCorreo(authentication.getName()).getId();
            var lista = prestamoService.listarTodos(idUsuario);
            LOG.info("Usuario: " + authentication.getName() + " | Lista de prestamos");
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else if (details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            var lista = prestamoService.listarTodos(0);
            LOG.info("Usuario: " + authentication.getName() + " | Lista de prestamos");
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
        LOG.error("Usuario: " + authentication.getName() + " | Lista no permitido");
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(value = "guardar", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<String> registrar(@RequestBody PrestamoEntity prestamo, Authentication authentication) {
    public ResponseEntity<String> registrar(@RequestBody Map<String, String> prestamo, Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());

        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN")))) {
            PrestamoEntity pres = new PrestamoEntity();
            // User usuario = usuarioService.obtenerUsuarioPorCorreo(authentication.getName());

            System.out.println("HERE!!!!!!");

            User usuario = usuarioService.obtenerUsuarioPorId(Integer.valueOf(prestamo.get("userId")));


            pres.setCuotas(Integer.parseInt(prestamo.get("cuotas")));
            pres.setMonto(Double.parseDouble(prestamo.get("monto")));
            pres.setInteres(Helper.calcularInteres(Integer.parseInt(prestamo.get("cuotas"))));
            pres.setUsuario(usuario);
            pres.setFechaprestamo(new Date());
            prestamoService.Registrar(pres);
            LOG.info("Usuario: " + authentication.getName() + " | Prestamo creado");
            // return new ResponseEntity<>("Prestamo creado", HttpStatus.);
            return new ResponseEntity<>("Prestamo creado", HttpStatus.OK);
        } else {
            LOG.info("Usuario: " + authentication.getName() + " | Prestamo creación NO permitida");
            return new ResponseEntity<>("Acción no permitida", HttpStatus.EXPECTATION_FAILED);
        }

    }


    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping(value = "observar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> observar(@RequestBody Map<String, String> request, Authentication authentication) {
        UserDetails details = userDetailsService.loadUserByUsername(authentication.getName());

        if (details != null && (details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("USER")))) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            PrestamoComentarioEntity prestamoComentario = prestamoObservacionService.getPrestamoObservado(Integer.parseInt(request.get("idprestamo")));
            Optional<PrestamoEntity> prestamoEntity = prestamoService.obtenerUno(Integer.parseInt(request.get("idprestamo")));
            if (prestamoComentario == null) {
                PrestamoComentarioEntity comentarioEntity = new PrestamoComentarioEntity();
                comentarioEntity.setEstado(EstadoPrestamo.valueOf(request.get("estado")));
                comentarioEntity.setComentario(request.get("comentario"));
                comentarioEntity.setFecha(new Date());
                comentarioEntity.setPrestamo(prestamoEntity.get());
                prestamoObservacionService.observarPrestamo(comentarioEntity);
                LOG.info("Usuario: " + authentication.getName() + " | Obs prestamo registrado");
                return new ResponseEntity<>("Observación registrado", HttpStatus.CREATED);
            } else {
                LOG.info("Usuario: " + authentication.getName() + " | Error al registrar obs");
                return new ResponseEntity<>("No fue posible registrar", HttpStatus.NO_CONTENT);
            }
        } else {
            LOG.info("Usuario: " + authentication.getName() + " | Registro obs no permitida");
            return new ResponseEntity<>("Acción no permitida", HttpStatus.LOCKED);
        }


    }
}
