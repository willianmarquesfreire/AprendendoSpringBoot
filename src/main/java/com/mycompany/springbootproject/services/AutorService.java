package com.mycompany.springbootproject.services;

import com.mycompany.springbootproject.domain.Autor;
import com.mycompany.springbootproject.repository.AutorRepository;
import org.springframework.stereotype.Service;

@Service
public class AutorService extends DefaultService<AutorRepository, Autor> {

}
