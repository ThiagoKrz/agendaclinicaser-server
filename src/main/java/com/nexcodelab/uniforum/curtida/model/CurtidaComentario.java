package com.nexcodelab.uniforum.curtida.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Inheritance
@NoArgsConstructor
public class CurtidaComentario extends Curtida { }
